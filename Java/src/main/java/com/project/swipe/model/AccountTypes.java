package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "account_types", schema = "swipe", catalog = "")
public class AccountTypes {
    private int idAccountType;
    private String name;
    private Collection<AccountTypeAdmins> accountTypeAdminsByIdAccountType;
    private Collection<AccountTypeDevelopers> accountTypeDevelopersByIdAccountType;
    private Collection<AccountTypePrivatePersons> accountTypePrivatePersonsByIdAccountType;
    private Collection<PersonalAccounts> personalAccountsByIdAccountType;

    public AccountTypes() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account_type", nullable = false)
    public int getIdAccountType() {
        return idAccountType;
    }

    public void setIdAccountType(int idAccountType) {
        this.idAccountType = idAccountType;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypes that = (AccountTypes) o;
        return idAccountType == that.idAccountType && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccountType, name);
    }


    @OneToMany(mappedBy = "accountTypesByIdAccountType")
    public Collection<AccountTypeAdmins> getAccountTypeAdminsByIdAccountType() {
        return accountTypeAdminsByIdAccountType;
    }

    public void setAccountTypeAdminsByIdAccountType(Collection<AccountTypeAdmins> accountTypeAdminsByIdAccountType) {
        this.accountTypeAdminsByIdAccountType = accountTypeAdminsByIdAccountType;
    }


    @OneToMany(mappedBy = "accountTypesByIdAccountType")
    public Collection<AccountTypeDevelopers> getAccountTypeDevelopersByIdAccountType() {
        return accountTypeDevelopersByIdAccountType;
    }

    public void setAccountTypeDevelopersByIdAccountType(Collection<AccountTypeDevelopers> accountTypeDevelopersByIdAccountType) {
        this.accountTypeDevelopersByIdAccountType = accountTypeDevelopersByIdAccountType;
    }


    @OneToMany(mappedBy = "accountTypesByIdAccountType")
    public Collection<AccountTypePrivatePersons> getAccountTypePrivatePersonsByIdAccountType() {
        return accountTypePrivatePersonsByIdAccountType;
    }

    public void setAccountTypePrivatePersonsByIdAccountType(Collection<AccountTypePrivatePersons> accountTypePrivatePersonsByIdAccountType) {
        this.accountTypePrivatePersonsByIdAccountType = accountTypePrivatePersonsByIdAccountType;
    }


    @OneToMany(mappedBy = "accountTypesByIdAccountType")
    public Collection<PersonalAccounts> getPersonalAccountsByIdAccountType() {
        return personalAccountsByIdAccountType;
    }

    public void setPersonalAccountsByIdAccountType(Collection<PersonalAccounts> personalAccountsByIdAccountType) {
        this.personalAccountsByIdAccountType = personalAccountsByIdAccountType;
    }
}
