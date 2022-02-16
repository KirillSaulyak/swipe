package com.project.swipe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.swipe.config.jwt.JwtProvider;
import com.project.swipe.model.Authorizations;
import com.project.swipe.model.JwtSecrets;
import com.project.swipe.service.service.AuthorizationsService;
import com.project.swipe.service.service.EmailService;
import com.project.swipe.service.service.JwtSecretsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(authorities = "ADMIN")
class RestControllerLoginTest {

    @MockBean
    private EmailService emailService;
    @MockBean
    private AuthorizationsService authorizationsService;
    @MockBean
    private JwtProvider jwtProvider;
    @MockBean
    private JwtSecretsService jwtSecretsService;
    @MockBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Authorizations user;

    private Authorizations newUser;

    private JwtSecrets jwtSecrets;

    private String userPassword;

    private String accessToken;

    public Authorizations authorizationsFactory() {
        return new Authorizations();
    }

    @BeforeEach
    public void initializationsTheSameObjects() {
        accessToken = "JWT";

        userPassword = "userPassword";

        user = authorizationsFactory();
        user.setIdAuthorization(1);
        user.setLogin("userLogin");
        user.setPassword(userPassword);
        user.setEnabled(true);

        jwtSecrets = new JwtSecrets();
        jwtSecrets.setIdJwtSecret(1);
        jwtSecrets.setJwtSecret("jwtSecrets");

        newUser = authorizationsFactory();
        newUser.setIdAuthorization(1);
    }

    @BeforeEach
    public void mockingTheSameMethods() {
        when(authorizationsService.findByLoginAndPassword(any(), any())).thenReturn(user);
        when(authorizationsService.save(any())).thenReturn(user);
        when(authorizationsService.findByLogin(any())).thenReturn(user);
        when(authorizationsService.findByJwtRefreshToken(any())).thenReturn(user);

        when(jwtSecretsService.findFirst()).thenReturn(jwtSecrets);
        when(jwtProvider.generateToken(any(), any())).thenReturn(accessToken);
        when(jwtProvider.generateRefreshToken(any(), any())).thenReturn("JWTRefresh");
        when(jwtProvider.validateToken(any(), any())).thenReturn(true);
        when(passwordEncoder.encode(any())).thenReturn(user.getPassword());
        doNothing().when(emailService).sendSimpleMessage(any(), any(), any());
    }

    @Test
    void registration() throws Exception {
        mockMvc.perform(post("/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(content().string("account created"));
    }

    @Test
    void checkLogin() throws Exception {
        mockMvc.perform(post("/check-login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("login"))
                .andExpect(content().string("login"));
    }

    @Test
    void checkJwtRefreshToken() throws Exception {
        user.setJwtRefresh("JWTRefresh");
        mockMvc.perform(post("/check-jwt-refresh-token")
                .contentType(MediaType.APPLICATION_JSON)
                .content(user.getJwtRefresh()))
                .andExpect(jsonPath("$.RefreshToken", is(user.getJwtRefresh())))
                .andExpect(jsonPath("$.AccessToken", is(accessToken)));
    }

    @Test
    void checkPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/check-password")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(jsonPath("$.AccessToken", is(accessToken)));
    }
}