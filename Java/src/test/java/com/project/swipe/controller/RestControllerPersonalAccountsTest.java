package com.project.swipe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.swipe.fileManager.FileManager;
import com.project.swipe.model.PersonalAccounts;
import com.project.swipe.service.service.PersonalAccountsService;
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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(authorities = "ADMIN")
class RestControllerPersonalAccountsTest {
    @MockBean
    private PersonalAccountsService personalAccountsService;

    @MockBean
    private FileManager fileManager;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    private PersonalAccounts personalAccountsBefore;

    private PersonalAccounts personalAccountsAfter;

    private PersonalAccounts personalAccountsFindById;

    public PersonalAccounts personalAccountsFactory() {
        return new PersonalAccounts();
    }

    @BeforeEach
    public void initializationsTheSameObjects() {
        personalAccountsBefore = personalAccountsFactory();

        personalAccountsAfter = personalAccountsFactory();
        personalAccountsAfter.setIdPersonalAccount(1);
        personalAccountsAfter.setFirstName("nameeee");
        personalAccountsAfter.setPathToImage("pathToPhoto");

        personalAccountsFindById = personalAccountsFactory();
        personalAccountsFindById.setIdPersonalAccount(1);
        personalAccountsFindById.setFirstName("Alek");
        personalAccountsFindById.setSecondName("Lolekov");
    }

    @BeforeEach
    public void mockingTheSameMethods() {
        doNothing().when(personalAccountsService).deleteById(Mockito.any());
        when(personalAccountsService.findById(personalAccountsFindById.getIdPersonalAccount())).thenReturn(personalAccountsFindById);
        when(fileManager.uploadFile(Mockito.any(), Mockito.any())).thenReturn(Paths.get("pathToPhoto"));
        when(fileManager.deleteFile(Mockito.any())).thenReturn(true);
        when(personalAccountsService.save(Mockito.any())).thenReturn(personalAccountsAfter);
    }

    @Test
    void getPersonalAccounts() throws Exception {
        PersonalAccounts personalAccounts1 = personalAccountsFactory();
        personalAccounts1.setIdPersonalAccount(1);

        PersonalAccounts personalAccounts2 = personalAccountsFactory();
        personalAccounts2.setIdPersonalAccount(2);

        when(personalAccountsService.findAll()).thenReturn(List.of(personalAccounts1, personalAccounts2));

        mockMvc.perform(MockMvcRequestBuilders.get("/personal-accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[1].idPersonalAccount", is(2)));
        //  .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getPersonalAccountById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/personal-accounts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idPersonalAccount", is(1)));
    }

    @Test
    void postPersonalAccounts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.multipart("/personal-accounts")
                .file("photo", "file".getBytes(StandardCharsets.UTF_8))
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .param("personalAccounts", objectMapper.writeValueAsString(personalAccountsBefore)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("pathToImage", is("pathToPhoto")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void putPersonalAccounts() throws Exception {
        MockMultipartHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/personal-accounts/1");
        builder.with((request -> {
            request.setMethod("PUT");
            return request;
        }));

        mockMvc.perform(builder
                .file("photo", "file".getBytes(StandardCharsets.UTF_8))
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .param("personalAccounts", objectMapper.writeValueAsString(personalAccountsBefore)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("pathToImage", is("pathToPhoto")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deletePersonalAccounts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/personal-accounts/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("was deleted idPersonalAccount = 1"));
    }
}