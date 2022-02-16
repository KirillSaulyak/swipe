package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idAuthorization")
@Table(name = "authorizations", schema = "swipe", catalog = "")
public class Authorizations {
    private int idAuthorization;
    private String login;
    private String password;
    private boolean enabled;
    private PersonalAccounts personalAccountsByIdAuthorization;
    private String jwtRefreshSecret;
    private String jwtRefresh;

    public Authorizations() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_authorization", nullable = false)
    public int getIdAuthorization() {
        return idAuthorization;
    }

    public void setIdAuthorization(int idAuthorization) {
        this.idAuthorization = idAuthorization;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 100)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "enabled", nullable = false)
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Authorizations)) return false;
        Authorizations that = (Authorizations) o;
        return idAuthorization == that.idAuthorization && enabled == that.enabled && login.equals(that.login) && password.equals(that.password) && personalAccountsByIdAuthorization.equals(that.personalAccountsByIdAuthorization) && Objects.equals(jwtRefreshSecret, that.jwtRefreshSecret) && Objects.equals(jwtRefresh, that.jwtRefresh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAuthorization, login, password, enabled, personalAccountsByIdAuthorization, jwtRefreshSecret, jwtRefresh);
    }


    @OneToOne(mappedBy = "authorizationsByIdAuthorization")
    public PersonalAccounts getPersonalAccountsByIdAuthorization() {
        return personalAccountsByIdAuthorization;
    }

    public void setPersonalAccountsByIdAuthorization(PersonalAccounts personalAccountsByIdAuthorization) {
        this.personalAccountsByIdAuthorization = personalAccountsByIdAuthorization;
    }

    @Basic
    @Column(name = "jwt_refresh_secret", nullable = true, length = -1)
    public String getJwtRefreshSecret() {
        return jwtRefreshSecret;
    }

    public void setJwtRefreshSecret(String jwtRefreshSecret) {
        this.jwtRefreshSecret = jwtRefreshSecret;
    }

    @Basic
    @Column(name = "jwt_refresh", nullable = true, length = -1)
    public String getJwtRefresh() {
        return jwtRefresh;
    }

    public void setJwtRefresh(String jwtRefresh) {
        this.jwtRefresh = jwtRefresh;
    }
}
