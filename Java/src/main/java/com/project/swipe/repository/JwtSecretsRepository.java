package com.project.swipe.repository;

import com.project.swipe.model.JwtSecrets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JwtSecretsRepository extends JpaRepository<JwtSecrets, Integer> {
    @Query(value = "SELECT * FROM jwt_secrets ORDER BY id_jwt_secret LIMIT 1", nativeQuery = true)
    JwtSecrets findFirstByIdJwtSecret();
}
