package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idApartmentDescriptionCalculationOption")
@Table(name = "apartments_description_calculation_options", schema = "swipe", catalog = "")
public class ApartmentsDescriptionCalculationOptions {
    private int idApartmentDescriptionCalculationOption;
    private String name;
    private Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionCalculationOption;

    public ApartmentsDescriptionCalculationOptions() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment_description_calculation_option", nullable = false)
    public int getIdApartmentDescriptionCalculationOption() {
        return idApartmentDescriptionCalculationOption;
    }

    public void setIdApartmentDescriptionCalculationOption(int idApartmentDescriptionCalculationOption) {
        this.idApartmentDescriptionCalculationOption = idApartmentDescriptionCalculationOption;
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
        ApartmentsDescriptionCalculationOptions that = (ApartmentsDescriptionCalculationOptions) o;
        return idApartmentDescriptionCalculationOption == that.idApartmentDescriptionCalculationOption && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartmentDescriptionCalculationOption, name);
    }


    @OneToMany(mappedBy = "apartmentsDescriptionCalculationOptionsByIdApartmentDescriptionCalculationOption")
    public Collection<ApartmentsDescription> getApartmentsDescriptionsByIdApartmentDescriptionCalculationOption() {
        return apartmentsDescriptionsByIdApartmentDescriptionCalculationOption;
    }

    public void setApartmentsDescriptionsByIdApartmentDescriptionCalculationOption(Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionCalculationOption) {
        this.apartmentsDescriptionsByIdApartmentDescriptionCalculationOption = apartmentsDescriptionsByIdApartmentDescriptionCalculationOption;
    }
}
