package com.project.swipe.repository;

import com.project.swipe.model.Authorizations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "authorizations", path = "authorizations")
public interface AuthorizationsRepository extends JpaRepository<Authorizations, Integer> {
    Authorizations findByLogin(String login);

    Authorizations findByJwtRefresh(String jwtRefreshToken);
}
