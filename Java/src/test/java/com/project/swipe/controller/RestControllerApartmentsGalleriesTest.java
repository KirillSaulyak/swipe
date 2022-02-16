package com.project.swipe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.swipe.fileManager.FileManager;
import com.project.swipe.model.Apartments;
import com.project.swipe.model.ApartmentsGalleries;
import com.project.swipe.service.service.ApartmentsGalleriesService;
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
class RestControllerApartmentsGalleriesTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ApartmentsGalleriesService apartmentsGalleriesService;
    @MockBean
    private FileManager fileManager;
    @MockBean
    private ApartmentsService apartmentsService;

    private ApartmentsGalleries apartmentsGalleriesBefore;
    private ApartmentsGalleries apartmentsGalleriesAfter;
    private ApartmentsGalleries apartmentsGalleriesWithId;
    private Apartments apartmentsWithId;

    public ApartmentsGalleries apartmentsGalleriesFactory() {
        return new ApartmentsGalleries();
    }

    public Apartments apartmentsFactory() {
        return new Apartments();
    }

    @BeforeEach
    public void initializationsTheSameObjects() {
        apartmentsGalleriesBefore = apartmentsGalleriesFactory();

        apartmentsGalleriesAfter = apartmentsGalleriesFactory();
        apartmentsGalleriesAfter.setIdApartmentGallery(1);
        apartmentsGalleriesAfter.setPathToImage("pathToPhoto");

        apartmentsGalleriesWithId = apartmentsGalleriesFactory();
        apartmentsGalleriesWithId.setIdApartmentGallery(1);
        apartmentsGalleriesWithId.setPathToImage("pathToPhoto");

        apartmentsWithId = apartmentsFactory();
        apartmentsWithId.setIdApartment(1);

    }

    @BeforeEach
    public void mockingTheSameMethods() {
        apartmentsGalleriesBefore = apartmentsGalleriesFactory();

        doNothing().when(apartmentsGalleriesService).deleteById(any());
        when(apartmentsService.findById(Mockito.any())).thenReturn(apartmentsWithId);
        when(apartmentsGalleriesService.findById(any())).thenReturn(apartmentsGalleriesWithId);
        when(fileManager.uploadFile(any(), any())).thenReturn(Paths.get("pathToPhoto"));
        when(fileManager.deleteFile(any())).thenReturn(true);
        when(apartmentsGalleriesService.save(any())).thenReturn(apartmentsGalleriesAfter);
    }

    @Test
    void getApartmentsGalleries() throws Exception {
        ApartmentsGalleries apartmentsGalleries1 = apartmentsGalleriesFactory();
        apartmentsGalleries1.setIdApartmentGallery(1);

        ApartmentsGalleries apartmentsGalleries2 = apartmentsGalleriesFactory();
        apartmentsGalleries2.setIdApartmentGallery(2);

        when(apartmentsGalleriesService.findAll()).thenReturn(List.of(apartmentsGalleries1, apartmentsGalleries2));

        mockMvc.perform(MockMvcRequestBuilders.get("/apartments-galleries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[1].idApartmentGallery", is(2)));
    }

    @Test
    void getApartmentsById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/apartments-galleries/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idApartmentGallery", is(1)));
    }

    @Test
    void postApartmentsGalleries() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.multipart("/apartments-galleries")
                .file("photo", "file".getBytes(StandardCharsets.UTF_8))
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .param("idApartments", objectMapper.writeValueAsString(apartmentsGalleriesBefore.getIdApartmentGallery())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("pathToImage", is("pathToPhoto")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void putApartmentsGalleries() throws Exception {
        MockMultipartHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/apartments-galleries/1");
        builder.with((request -> {
            request.setMethod("PUT");
            return request;
        }));

        mockMvc.perform(builder
                .file("photo", "file".getBytes(StandardCharsets.UTF_8))
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .param("apartments-galleries", objectMapper.writeValueAsString(apartmentsGalleriesBefore)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("pathToImage", is("pathToPhoto")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deleteApartmentsGalleries() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/apartments-galleries/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("was deleted idApartmentsGallery = 1"));
    }
}