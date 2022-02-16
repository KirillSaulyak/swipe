package com.project.swipe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.swipe.fileManager.FileManager;
import com.project.swipe.model.Apartments;
import com.project.swipe.model.ResidentialComplexesGalleries;
import com.project.swipe.service.service.ApartmentsService;
import com.project.swipe.service.service.ResidentialComplexesGalleriesService;
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
class RestControllerResidentialComplexesGalleriesTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ResidentialComplexesGalleriesService residentialComplexesGalleriesService;
    @MockBean
    private FileManager fileManager;
    @MockBean
    private ApartmentsService apartmentsService;

    private ResidentialComplexesGalleries residentialComplexesGalleriesBefore;
    private ResidentialComplexesGalleries residentialComplexesGalleriesAfter;
    private ResidentialComplexesGalleries residentialComplexesGalleriesWithId;
    private Apartments apartmentsWithId;

    public ResidentialComplexesGalleries residentialComplexesGalleriesFactory() {
        return new ResidentialComplexesGalleries();
    }

    public Apartments apartmentsFactory() {
        return new Apartments();
    }

    @BeforeEach
    public void initializationsTheSameObjects() {
        residentialComplexesGalleriesBefore = residentialComplexesGalleriesFactory();

        residentialComplexesGalleriesAfter = residentialComplexesGalleriesFactory();
        residentialComplexesGalleriesAfter.setIdResidentialComplexGallery(1);
        residentialComplexesGalleriesAfter.setPathToImage("pathToImage");

        residentialComplexesGalleriesWithId = residentialComplexesGalleriesFactory();
        residentialComplexesGalleriesWithId.setIdResidentialComplexGallery(1);
        residentialComplexesGalleriesWithId.setPathToImage("pathToImage");

        apartmentsWithId = apartmentsFactory();
        apartmentsWithId.setIdApartment(1);

    }

    @BeforeEach
    public void mockingTheSameMethods() {
        residentialComplexesGalleriesBefore = residentialComplexesGalleriesFactory();

        doNothing().when(residentialComplexesGalleriesService).deleteById(any());
        when(apartmentsService.findById(Mockito.any())).thenReturn(apartmentsWithId);
        when(residentialComplexesGalleriesService.findById(any())).thenReturn(residentialComplexesGalleriesWithId);
        when(fileManager.uploadFile(any(), any())).thenReturn(Paths.get("pathToImage"));
        when(fileManager.deleteFile(any())).thenReturn(true);
        when(residentialComplexesGalleriesService.save(any())).thenReturn(residentialComplexesGalleriesAfter);
    }


    @Test
    void getResidentialComplexesGalleries() throws Exception {
        ResidentialComplexesGalleries apartmentsGalleries1 = residentialComplexesGalleriesFactory();
        apartmentsGalleries1.setIdResidentialComplexGallery(1);

        ResidentialComplexesGalleries apartmentsGalleries2 = residentialComplexesGalleriesFactory();
        apartmentsGalleries2.setIdResidentialComplexGallery(2);

        when(residentialComplexesGalleriesService.findAll()).thenReturn(List.of(apartmentsGalleries1, apartmentsGalleries2));

        mockMvc.perform(MockMvcRequestBuilders.get("/residential-complexes-galleries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[1].idResidentialComplexGallery", is(2)));
    }

    @Test
    void getResidentialComplexesById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/residential-complexes-galleries/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idResidentialComplexGallery", is(1)));
    }

    @Test
    void postResidentialComplexesGalleries() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.multipart("/residential-complexes-galleries")
                .file("image", "file".getBytes(StandardCharsets.UTF_8))
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .param("idResidentialComplex", objectMapper.writeValueAsString(residentialComplexesGalleriesBefore.getIdResidentialComplexGallery())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("pathToImage", is("pathToImage")))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    void putResidentialComplexesGalleries() throws Exception {
        MockMultipartHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/residential-complexes-galleries/1");
        builder.with((request -> {
            request.setMethod("PUT");
            return request;
        }));

        mockMvc.perform(builder
                .file("image", "file".getBytes(StandardCharsets.UTF_8))
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .param("image", objectMapper.writeValueAsString(residentialComplexesGalleriesBefore)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("pathToImage", is("pathToImage")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deleteResidentialComplexesGalleries() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/residential-complexes-galleries/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("was deleted idResidentialComplexGallery = 1"));
    }
}