package com.project.swipe.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jwt_secrets", schema = "swipe", catalog = "")
public class JwtSecrets {
    private int idJwtSecret;
    private String jwtSecret;

    public JwtSecrets() {
    }

    public JwtSecrets(int idJwtSecret, String jwtSecret) {
        this.idJwtSecret = idJwtSecret;
        this.jwtSecret = jwtSecret;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jwt_secret", nullable = false)
    public int getIdJwtSecret() {
        return idJwtSecret;
    }

    public void setIdJwtSecret(int idJwtSecret) {
        this.idJwtSecret = idJwtSecret;
    }

    @Basic
    @Column(name = "jwt_secret", nullable = false, length = -1)
    public String getJwtSecret() {
        return jwtSecret;
    }

    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JwtSecrets that = (JwtSecrets) o;
        return idJwtSecret == that.idJwtSecret && Objects.equals(jwtSecret, that.jwtSecret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJwtSecret, jwtSecret);
    }
}
