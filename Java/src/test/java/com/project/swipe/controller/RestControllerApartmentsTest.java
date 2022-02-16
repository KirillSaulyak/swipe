package com.project.swipe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.swipe.fileManager.FileManager;
import com.project.swipe.model.Apartments;
import com.project.swipe.model.ApartmentsGalleries;
import com.project.swipe.service.service.ApartmentsService;
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
class RestControllerApartmentsTest {
    @MockBean
    private ApartmentsService apartmentsService;
    @MockBean
    private FileManager fileManager;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private Apartments apartmentsWithId;
    private Apartments apartmentsBeforeSave;

    public Apartments apartmentsFactory() {
        return new Apartments();
    }

    @BeforeEach
    public void initializationsTheSameObjects() {
        ApartmentsGalleries apartmentsGalleries = new ApartmentsGalleries();
        apartmentsGalleries.setPathToImage("path to image");
        apartmentsWithId = apartmentsFactory();
        apartmentsWithId.setIdApartment(1);
        apartmentsWithId.setApartmentsGalleriesByIdApartment(List.of(apartmentsGalleries));

        apartmentsBeforeSave = apartmentsFactory();
        apartmentsBeforeSave.setIdApartment(1);
    }

    @BeforeEach
    public void mockingTheSameMethods() {
        when(fileManager.deleteFile(Mockito.any())).thenReturn(true);
        when(apartmentsService.findById(Mockito.any())).thenReturn(apartmentsWithId);
        when(apartmentsService.save(Mockito.any())).thenReturn(apartmentsBeforeSave);
        doNothing().when(apartmentsService).deleteById(Mockito.any());
    }

    @Test
    void getApartments() throws Exception {
        Apartments apartments1 = apartmentsFactory();
        apartments1.setIdApartment(1);
        Apartments apartments2 = apartmentsFactory();
        apartments2.setIdApartment(2);
        when(apartmentsService.findAll()).thenReturn(List.of(apartments1, apartments2));
        mockMvc.perform(get("/apartments"))
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[0].idApartment", is(1)))
                .andExpect(jsonPath("$[1].idApartment", is(2)));
    }

    @Test
    void getPersonalAccountById() throws Exception {
        mockMvc.perform(get("/apartments/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idApartment", is(1)));
    }

    @Test
    void postApartments() throws Exception {
        mockMvc.perform(post("/apartments").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(apartmentsFactory())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idApartment", is(apartmentsBeforeSave.getIdApartment())));
    }

    @Test
    void putApartments() throws Exception {
        mockMvc.perform(put("/apartments/1").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(apartmentsWithId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idApartment", is(apartmentsBeforeSave.getIdApartment())));
    }

    @Test
    void deleteApartments() throws Exception {
        mockMvc.perform(delete("/apartments/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("was deleted idApartment = " + apartmentsWithId.getIdApartment()));
    }
}