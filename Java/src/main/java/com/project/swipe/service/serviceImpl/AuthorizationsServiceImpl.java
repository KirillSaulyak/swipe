package com.project.swipe.service.serviceImpl;

import com.project.swipe.model.Authorizations;
import com.project.swipe.repository.AuthorizationsRepository;
import com.project.swipe.service.service.AuthorizationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationsServiceImpl implements AuthorizationsService {
    @Autowired
    private AuthorizationsRepository authorizationsRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authorizations findByLogin(String login) {
        return authorizationsRepository.findByLogin(login);
    }

    @Override
    public Authorizations save(Authorizations authorization) {
        return authorizationsRepository.save(authorization);
    }

    @Override
    public Authorizations findByLoginAndPassword(String login, String password) {
        Authorizations authorizations = findByLogin(login);
        if (authorizations != null && passwordEncoder.matches(password, authorizations.getPassword())) {
            return authorizations;
        }
        return null;
    }

    @Override
    public Authorizations findByJwtRefreshToken(String jwtRefreshToken) {
        return authorizationsRepository.findByJwtRefresh(jwtRefreshToken);
    }
}
