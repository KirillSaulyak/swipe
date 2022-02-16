package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAgent")
public class Agents {
    private int idAgent;
    private String firstName;
    private String secondName;
    private String phoneNumber;
    private Collection<AccountTypePrivatePersons> accountTypePrivatePersonsByIdAgent;
    private String eMail;

    public Agents() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agent", nullable = false)
    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
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
    @Column(name = "phone_number", nullable = false, length = 45)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @OneToMany(mappedBy = "agentsByIdAgent")
    public Collection<AccountTypePrivatePersons> getAccountTypePrivatePersonsByIdAgent() {
        return accountTypePrivatePersonsByIdAgent;
    }

    public void setAccountTypePrivatePersonsByIdAgent(Collection<AccountTypePrivatePersons> accountTypePrivatePersonsByIdAgent) {
        this.accountTypePrivatePersonsByIdAgent = accountTypePrivatePersonsByIdAgent;
    }

    @Basic
    @Column(name = "e_mail", nullable = false, length = 255)
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agents agents = (Agents) o;
        return Objects.equals(eMail, agents.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eMail);
    }
}
