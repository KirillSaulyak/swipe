package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "account_type_private_persons", schema = "swipe", catalog = "")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAccountTypePrivatePerson")
public class AccountTypePrivatePersons {
    private int idAccountTypePrivatePerson;
    private boolean forwardingToAgent;
    private AccountTypes accountTypesByIdAccountType;
    private Agents agentsByIdAgent;
    private Collection<Apartments> apartmentsByIdAccountTypePrivatePerson;

    public AccountTypePrivatePersons() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account_type_private_person", nullable = false)
    public int getIdAccountTypePrivatePerson() {
        return idAccountTypePrivatePerson;
    }

    public void setIdAccountTypePrivatePerson(int idAccountTypePrivatePerson) {
        this.idAccountTypePrivatePerson = idAccountTypePrivatePerson;
    }

    @Basic
    @Column(name = "forwarding_to_agent", nullable = false)
    public boolean isForwardingToAgent() {
        return forwardingToAgent;
    }

    public void setForwardingToAgent(boolean forwardingToAgent) {
        this.forwardingToAgent = forwardingToAgent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypePrivatePersons that = (AccountTypePrivatePersons) o;
        return idAccountTypePrivatePerson == that.idAccountTypePrivatePerson && forwardingToAgent == that.forwardingToAgent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccountTypePrivatePerson, forwardingToAgent);
    }


    @ManyToOne
    @JoinColumn(name = "id_account_type", referencedColumnName = "id_account_type", nullable = false)
    public AccountTypes getAccountTypesByIdAccountType() {
        return accountTypesByIdAccountType;
    }

    public void setAccountTypesByIdAccountType(AccountTypes accountTypesByIdAccountType) {
        this.accountTypesByIdAccountType = accountTypesByIdAccountType;
    }


    @ManyToOne
    @JoinColumn(name = "id_agent", referencedColumnName = "id_agent")
    public Agents getAgentsByIdAgent() {
        return agentsByIdAgent;
    }

    public void setAgentsByIdAgent(Agents agentsByIdAgent) {
        this.agentsByIdAgent = agentsByIdAgent;
    }


    @OneToMany(mappedBy = "accountTypePrivatePersonsByIdAccountTypePrivatePerson")
    public Collection<Apartments> getApartmentsByIdAccountTypePrivatePerson() {
        return apartmentsByIdAccountTypePrivatePerson;
    }

    public void setApartmentsByIdAccountTypePrivatePerson(Collection<Apartments> apartmentsByIdAccountTypePrivatePerson) {
        this.apartmentsByIdAccountTypePrivatePerson = apartmentsByIdAccountTypePrivatePerson;
    }
}
