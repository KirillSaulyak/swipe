package com.project.swipe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.swipe.fileManager.FileManager;
import com.project.swipe.model.ResidentialComplexes;
import com.project.swipe.model.ResidentialComplexesFiles;
import com.project.swipe.service.service.ResidentialComplexesFilesService;
import com.project.swipe.service.service.ResidentialComplexesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(authorities = "USER_DEVELOPER")
class RestControllerResidentialComplexesFilesTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ResidentialComplexesFilesService residentialComplexesFilesService;
    @MockBean
    private FileManager fileManager;
    @MockBean
    private ResidentialComplexesService residentialComplexesService;

    private ResidentialComplexesFiles residentialComplexesFilesBefore;
    private ResidentialComplexesFiles residentialComplexesFilesAfter;
    private ResidentialComplexesFiles residentialComplexesFilesWithId;
    private ResidentialComplexes residentialComplexes;

    public ResidentialComplexesFiles residentialComplexesFilesFactory() {
        return new ResidentialComplexesFiles();
    }

    public ResidentialComplexes residentialComplexesFactory() {
        return new ResidentialComplexes();
    }

    @BeforeEach
    public void initializationsTheSameObjects() {
        residentialComplexesFilesBefore = residentialComplexesFilesFactory();

        residentialComplexesFilesAfter = residentialComplexesFilesFactory();
        residentialComplexesFilesAfter.setIdResidentialComplexFile(1);
        residentialComplexesFilesAfter.setPathToFile("pathToFile");

        residentialComplexesFilesWithId = residentialComplexesFilesFactory();
        residentialComplexesFilesWithId.setIdResidentialComplexFile(1);
        residentialComplexesFilesWithId.setPathToFile("pathToFile");

        residentialComplexes = residentialComplexesFactory();
        residentialComplexes.setIdResidentialComplex(1);

    }

    @BeforeEach
    public void mockingTheSameMethods() {
        doNothing().when(residentialComplexesFilesService).deleteById(any());
        when(residentialComplexesService.findById(Mockito.any())).thenReturn(residentialComplexes);
        when(residentialComplexesFilesService.findById(any())).thenReturn(residentialComplexesFilesWithId);
        when(fileManager.uploadFile(any(), any())).thenReturn(Paths.get("pathToFile"));
        when(fileManager.deleteFile(any())).thenReturn(true);
        when(residentialComplexesFilesService.save(any())).thenReturn(residentialComplexesFilesAfter);
    }

    @Test
    void getResidentialComplexesFiles() throws Exception {
        ResidentialComplexesFiles residentialComplexesFiles1 = residentialComplexesFilesFactory();
        residentialComplexesFiles1.setIdResidentialComplexFile(1);

        ResidentialComplexesFiles residentialComplexesFiles2 = residentialComplexesFilesFactory();
        residentialComplexesFiles2.setIdResidentialComplexFile(2);

        when(residentialComplexesFilesService.findAll()).thenReturn(List.of(residentialComplexesFiles1, residentialComplexesFiles2));

        mockMvc.perform(MockMvcRequestBuilders.get("/residential-complexes-files"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[1].idResidentialComplexFile", is(2)));
    }

    @Test
    void getPersonalAccountById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/residential-complexes-files/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idResidentialComplexFile", is(1)));
    }

    @Test
    void postResidentialComplexesFiles() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.multipart("/residential-complexes-files")
                .file("file", "file".getBytes(StandardCharsets.UTF_8))
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .param("idResidentialComplex", objectMapper.writeValueAsString(residentialComplexesFilesBefore.getIdResidentialComplexFile())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("pathToFile", is("pathToFile")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void putResidentialComplexesFiles() throws Exception {
        MockMultipartHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/residential-complexes-files/1");
        builder.with((request -> {
            request.setMethod("PUT");
            return request;
        }));

        mockMvc.perform(builder
                .file("file", "file".getBytes(StandardCharsets.UTF_8))
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .param("file", objectMapper.writeValueAsString(residentialComplexesFilesBefore)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("pathToFile", is("pathToFile")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deleteResidentialComplexesFiles() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/residential-complexes-files/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("was deleted idResidentialComplexFile = 1"));
    }
}