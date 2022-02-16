package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "personal_accounts", schema = "swipe", catalog = "")
public class PersonalAccounts {
    private int idPersonalAccount;
    private String firstName;
    private String secondName;
    private String pathToImage;
    private Authorizations authorizationsByIdAuthorization;
    private AccountTypes accountTypesByIdAccountType;

    public PersonalAccounts() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personal_account", nullable = false)
    public int getIdPersonalAccount() {
        return idPersonalAccount;
    }

    public void setIdPersonalAccount(int idPersonalAccount) {
        this.idPersonalAccount = idPersonalAccount;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "second_name", nullable = false, length = 45)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "path_to_image", nullable = true, length = 255)
    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalAccounts that = (PersonalAccounts) o;
        return idPersonalAccount == that.idPersonalAccount && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(pathToImage, that.pathToImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersonalAccount, firstName, secondName, pathToImage);
    }

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_authorization", referencedColumnName = "id_authorization", nullable = false)
    public Authorizations getAuthorizationsByIdAuthorization() {
        return authorizationsByIdAuthorization;
    }

    public void setAuthorizationsByIdAuthorization(Authorizations authorizationsByIdAuthorization) {
        this.authorizationsByIdAuthorization = authorizationsByIdAuthorization;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_account_type", referencedColumnName = "id_account_type", nullable = false)
    public AccountTypes getAccountTypesByIdAccountType() {
        return accountTypesByIdAccountType;
    }

    public void setAccountTypesByIdAccountType(AccountTypes accountTypesByIdAccountType) {
        this.accountTypesByIdAccountType = accountTypesByIdAccountType;
    }
}
