package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account_type_admins", schema = "swipe", catalog = "")
public class AccountTypeAdmins {
    private int idAccountTypeAdmin;
    private AccountTypes accountTypesByIdAccountType;

    public AccountTypeAdmins() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account_type_admin", nullable = false)
    public int getIdAccountTypeAdmin() {
        return idAccountTypeAdmin;
    }

    public void setIdAccountTypeAdmin(int idAccountTypeAdmin) {
        this.idAccountTypeAdmin = idAccountTypeAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeAdmins that = (AccountTypeAdmins) o;
        return idAccountTypeAdmin == that.idAccountTypeAdmin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccountTypeAdmin);
    }


    @ManyToOne
    @JoinColumn(name = "id_account_type", referencedColumnName = "id_account_type", nullable = false)
    public AccountTypes getAccountTypesByIdAccountType() {
        return accountTypesByIdAccountType;
    }

    public void setAccountTypesByIdAccountType(AccountTypes accountTypesByIdAccountType) {
        this.accountTypesByIdAccountType = accountTypesByIdAccountType;
    }
}
