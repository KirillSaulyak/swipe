package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idApartmentDescriptionAgentCommission")
@Table(name = "apartments_description_agent_commissions", schema = "swipe", catalog = "")
public class ApartmentsDescriptionAgentCommissions {
    private int idApartmentDescriptionAgentCommission;
    private String name;
    private Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionAgentCommission;

    public ApartmentsDescriptionAgentCommissions() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment_description_agent_commission", nullable = false)
    public int getIdApartmentDescriptionAgentCommission() {
        return idApartmentDescriptionAgentCommission;
    }

    public void setIdApartmentDescriptionAgentCommission(int idApartmentDescriptionAgentCommission) {
        this.idApartmentDescriptionAgentCommission = idApartmentDescriptionAgentCommission;
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
        ApartmentsDescriptionAgentCommissions that = (ApartmentsDescriptionAgentCommissions) o;
        return idApartmentDescriptionAgentCommission == that.idApartmentDescriptionAgentCommission && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartmentDescriptionAgentCommission, name);
    }


    @OneToMany(mappedBy = "apartmentsDescriptionAgentCommissionsByIdApartmentDescriptionAgentCommission")
    public Collection<ApartmentsDescription> getApartmentsDescriptionsByIdApartmentDescriptionAgentCommission() {
        return apartmentsDescriptionsByIdApartmentDescriptionAgentCommission;
    }

    public void setApartmentsDescriptionsByIdApartmentDescriptionAgentCommission(Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionAgentCommission) {
        this.apartmentsDescriptionsByIdApartmentDescriptionAgentCommission = apartmentsDescriptionsByIdApartmentDescriptionAgentCommission;
    }
}
