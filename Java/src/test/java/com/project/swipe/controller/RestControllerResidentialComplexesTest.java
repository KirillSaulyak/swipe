package com.project.swipe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.swipe.fileManager.FileManager;
import com.project.swipe.model.ResidentialComplexes;
import com.project.swipe.model.ResidentialComplexesGalleries;
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

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(authorities = "USER_DEVELOPER")
class RestControllerResidentialComplexesTest {

    @MockBean
    private ResidentialComplexesService residentialComplexesService;
    @MockBean
    private FileManager fileManager;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private ResidentialComplexes residentialComplexesWithId;
    private ResidentialComplexes residentialComplexesBeforeSave;

    public ResidentialComplexes residentialComplexesFactory() {
        return new ResidentialComplexes();
    }

    @BeforeEach
    public void initializationsTheSameObjects() {
        ResidentialComplexesGalleries residentialComplexesGalleries = new ResidentialComplexesGalleries();
        residentialComplexesGalleries.setPathToImage("path to image");
        residentialComplexesWithId = residentialComplexesFactory();
        residentialComplexesWithId.setIdResidentialComplex(1);
        residentialComplexesWithId.setResidentialComplexesGalleriesByIdResidentialComplex(List.of(residentialComplexesGalleries));

        residentialComplexesBeforeSave = residentialComplexesFactory();
        residentialComplexesBeforeSave.setIdResidentialComplex(1);
    }

    @BeforeEach
    public void mockingTheSameMethods() {
        when(fileManager.deleteFile(Mockito.any())).thenReturn(true);
        when(residentialComplexesService.findById(Mockito.any())).thenReturn(residentialComplexesWithId);
        when(residentialComplexesService.save(Mockito.any())).thenReturn(residentialComplexesBeforeSave);
        doNothing().when(residentialComplexesService).deleteById(Mockito.any());
    }

    @Test
    void getResidentialComplexes() throws Exception {
        ResidentialComplexes residentialComplexes1 = residentialComplexesFactory();
        residentialComplexes1.setIdResidentialComplex(1);
        ResidentialComplexes residentialComplexes2 = residentialComplexesFactory();
        residentialComplexes2.setIdResidentialComplex(2);
        when(residentialComplexesService.findAll()).thenReturn(List.of(residentialComplexes1, residentialComplexes2));
        mockMvc.perform(get("/residential-complexes"))
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[0].idResidentialComplex", is(1)))
                .andExpect(jsonPath("$[1].idResidentialComplex", is(2)));
    }

    @Test
    void getResidentialComplexesById() throws Exception {
        mockMvc.perform(get("/residential-complexes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idResidentialComplex", is(1)));
    }

    @Test
    void postResidentialComplexes() throws Exception {
        mockMvc.perform(post("/residential-complexes").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(residentialComplexesFactory())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idResidentialComplex", is(residentialComplexesBeforeSave.getIdResidentialComplex())));
    }

    @Test
    void putResidentialComplexes() throws Exception {
        mockMvc.perform(put("/residential-complexes/1").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(residentialComplexesWithId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idResidentialComplex", is(residentialComplexesBeforeSave.getIdResidentialComplex())));
    }

    @Test
    void deleteResidentialComplexes() throws Exception {
        mockMvc.perform(delete("/residential-complexes/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("was deleted idResidentialComplex = " + residentialComplexesWithId.getIdResidentialComplex()));
    }
}