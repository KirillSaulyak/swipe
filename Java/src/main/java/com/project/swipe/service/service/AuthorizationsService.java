package com.project.swipe.service.service;

import com.project.swipe.model.Authorizations;

public interface AuthorizationsService {
    Authorizations findByLogin(String login);

    Authorizations save(Authorizations authorization);

    Authorizations findByLoginAndPassword(String login, String password);

    Authorizations findByJwtRefreshToken(String jwtRefreshToken);
}
