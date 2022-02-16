package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexCommunalPayment")
@Table(name = "residential_complexes_communal_payments", schema = "swipe", catalog = "")
public class ResidentialComplexesCommunalPayments {
    private int idResidentialComplexCommunalPayment;
    private String name;
    private Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexCommunalPayment;

    public ResidentialComplexesCommunalPayments() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_communal_payment", nullable = false)
    public int getIdResidentialComplexCommunalPayment() {
        return idResidentialComplexCommunalPayment;
    }

    public void setIdResidentialComplexCommunalPayment(int idResidentialComplexCommunalPayment) {
        this.idResidentialComplexCommunalPayment = idResidentialComplexCommunalPayment;
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
        ResidentialComplexesCommunalPayments that = (ResidentialComplexesCommunalPayments) o;
        return idResidentialComplexCommunalPayment == that.idResidentialComplexCommunalPayment && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexCommunalPayment, name);
    }


    @OneToMany(mappedBy = "residentialComplexesCommunalPaymentsByIdResidentialComplexCommunalPayment")
    public Collection<ResidentialComplexesDescriptions> getResidentialComplexesDescriptionsByIdResidentialComplexCommunalPayment() {
        return residentialComplexesDescriptionsByIdResidentialComplexCommunalPayment;
    }

    public void setResidentialComplexesDescriptionsByIdResidentialComplexCommunalPayment(Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexCommunalPayment) {
        this.residentialComplexesDescriptionsByIdResidentialComplexCommunalPayment = residentialComplexesDescriptionsByIdResidentialComplexCommunalPayment;
    }
}
