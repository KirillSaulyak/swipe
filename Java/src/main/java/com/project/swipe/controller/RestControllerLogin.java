package com.project.swipe.controller;

import com.project.swipe.config.jwt.JwtProvider;
import com.project.swipe.model.Authorizations;
import com.project.swipe.service.service.AuthorizationsService;
import com.project.swipe.service.service.EmailService;
import com.project.swipe.service.service.JwtSecretsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class RestControllerLogin {
    @Autowired
    private EmailService emailService;
    @Autowired
    private AuthorizationsService authorizationsService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private JwtSecretsService jwtSecretsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registration")
    public String registration(@RequestBody Authorizations login) {
        Integer randomPassword = ThreadLocalRandom.current().nextInt(1000, 9999);
        Authorizations authorization = login;
        authorization.setPassword(passwordEncoder.encode(randomPassword.toString()));
        authorization.setEnabled(true);
        authorizationsService.save(authorization);

        return "account created";
    }

    @PostMapping("/check-login")
    public String checkLogin(@RequestBody String login) {
        Authorizations authorization = authorizationsService.findByLogin(login);
        if (authorization != null && authorization.isEnabled()) {
            Integer randomPassword = ThreadLocalRandom.current().nextInt(1000, 9999);
            authorization.setPassword(passwordEncoder.encode(Integer.toString(randomPassword)));
            authorizationsService.save(authorization);
            emailService.sendSimpleMessage(authorization.getLogin(), "Пароль для входа", randomPassword.toString());
            return login;
        }
        return "can`t find such account";
    }

    @PostMapping("/check-jwt-refresh-token")
    public Map<String, String> checkJwtRefreshToken(@RequestBody String jwtRefreshToken) {
        Authorizations user = authorizationsService.findByJwtRefreshToken(jwtRefreshToken);
        if (user != null) {
            if (jwtProvider.validateToken(user.getJwtRefresh(), user.getJwtRefreshSecret())) {
                user.setJwtRefreshSecret(UUID.randomUUID().toString());
                user = authorizationsService.save(user);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("AccessToken", jwtProvider.generateToken(user.getLogin(), jwtSecretsService.findFirst().getJwtSecret()));
                tokens.put("RefreshToken", user.getJwtRefresh());
                return tokens;
            }
        }
        return null;
    }

    @PostMapping("/check-password")
    public Map<String, String> checkPassword(@RequestBody Authorizations authorizations) {
        Authorizations user = authorizationsService.findByLoginAndPassword(authorizations.getLogin(), authorizations.getPassword());
        if (user != null) {
            Map<String, String> tokens = new HashMap<>();
            user.setJwtRefreshSecret(UUID.randomUUID().toString());
            user.setJwtRefresh(jwtProvider.generateRefreshToken(user.getLogin(), user.getJwtRefreshSecret()));
            user = authorizationsService.save(user);
            tokens.put("AccessToken", jwtProvider.generateToken(user.getLogin(), jwtSecretsService.findFirst().getJwtSecret()));
            tokens.put("RefreshToken", user.getJwtRefresh());
            return tokens;
        }
        return null;
    }
}
