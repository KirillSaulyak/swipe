package com.project.swipe.service.serviceImpl;

import com.project.swipe.model.JwtSecrets;
import com.project.swipe.repository.JwtSecretsRepository;
import com.project.swipe.service.service.JwtSecretsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtSecretsServiceImpl implements JwtSecretsService {
    @Autowired
    private JwtSecretsRepository jwtSecretsRepository;

    @Override
    public JwtSecrets findFirst() {
        return jwtSecretsRepository.findFirstByIdJwtSecret();
    }
}
