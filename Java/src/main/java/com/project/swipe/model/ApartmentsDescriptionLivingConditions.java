package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idApartmentDescriptionLivingCondition")
@Table(name = "apartments_description_living_conditions", schema = "swipe", catalog = "")
public class ApartmentsDescriptionLivingConditions {
    private int idApartmentDescriptionLivingCondition;
    private String name;
    private Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionLivingCondition;

    public ApartmentsDescriptionLivingConditions() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment_description_living_condition", nullable = false)
    public int getIdApartmentDescriptionLivingCondition() {
        return idApartmentDescriptionLivingCondition;
    }

    public void setIdApartmentDescriptionLivingCondition(int idApartmentDescriptionLivingCondition) {
        this.idApartmentDescriptionLivingCondition = idApartmentDescriptionLivingCondition;
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
        ApartmentsDescriptionLivingConditions that = (ApartmentsDescriptionLivingConditions) o;
        return idApartmentDescriptionLivingCondition == that.idApartmentDescriptionLivingCondition && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartmentDescriptionLivingCondition, name);
    }


    @OneToMany(mappedBy = "apartmentsDescriptionLivingConditionsByIdApartmentDescriptionLivingCondition")
    public Collection<ApartmentsDescription> getApartmentsDescriptionsByIdApartmentDescriptionLivingCondition() {
        return apartmentsDescriptionsByIdApartmentDescriptionLivingCondition;
    }

    public void setApartmentsDescriptionsByIdApartmentDescriptionLivingCondition(Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionLivingCondition) {
        this.apartmentsDescriptionsByIdApartmentDescriptionLivingCondition = apartmentsDescriptionsByIdApartmentDescriptionLivingCondition;
    }
}
