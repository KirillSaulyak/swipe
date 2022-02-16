package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "account_type_developers", schema = "swipe", catalog = "")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAccountTypeDeveloper")
public class AccountTypeDevelopers {
    private int idAccountTypeDeveloper;
    private AccountTypes accountTypesByIdAccountType;
    private Collection<ResidentialComplexes> residentialComplexesByIdAccountTypeDeveloper;

    public AccountTypeDevelopers() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account_type_developer", nullable = false)
    public int getIdAccountTypeDeveloper() {
        return idAccountTypeDeveloper;
    }

    public void setIdAccountTypeDeveloper(int idAccountTypeDeveloper) {
        this.idAccountTypeDeveloper = idAccountTypeDeveloper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDevelopers that = (AccountTypeDevelopers) o;
        return idAccountTypeDeveloper == that.idAccountTypeDeveloper;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccountTypeDeveloper);
    }


    @ManyToOne
    @JoinColumn(name = "id_account_type", referencedColumnName = "id_account_type", nullable = false)
    public AccountTypes getAccountTypesByIdAccountType() {
        return accountTypesByIdAccountType;
    }

    public void setAccountTypesByIdAccountType(AccountTypes accountTypesByIdAccountType) {
        this.accountTypesByIdAccountType = accountTypesByIdAccountType;
    }


    @OneToMany(mappedBy = "accountTypeDevelopersByIdAccountTypeDeveloper")
    public Collection<ResidentialComplexes> getResidentialComplexesByIdAccountTypeDeveloper() {
        return residentialComplexesByIdAccountTypeDeveloper;
    }

    public void setResidentialComplexesByIdAccountTypeDeveloper(Collection<ResidentialComplexes> residentialComplexesByIdAccountTypeDeveloper) {
        this.residentialComplexesByIdAccountTypeDeveloper = residentialComplexesByIdAccountTypeDeveloper;
    }
}
