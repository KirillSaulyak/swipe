package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexHeatingType")
@Table(name = "residential_complexes_heating_types", schema = "swipe", catalog = "")
public class ResidentialComplexesHeatingTypes {
    private int idResidentialComplexHeatingType;
    private String name;
    private Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexHeatingType;

    public ResidentialComplexesHeatingTypes() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_heating_type", nullable = false)
    public int getIdResidentialComplexHeatingType() {
        return idResidentialComplexHeatingType;
    }

    public void setIdResidentialComplexHeatingType(int idResidentialComplexHeatingType) {
        this.idResidentialComplexHeatingType = idResidentialComplexHeatingType;
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
        ResidentialComplexesHeatingTypes that = (ResidentialComplexesHeatingTypes) o;
        return idResidentialComplexHeatingType == that.idResidentialComplexHeatingType && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexHeatingType, name);
    }


    @OneToMany(mappedBy = "residentialComplexesHeatingTypesByIdResidentialComplexHeatingType")
    public Collection<ResidentialComplexesDescriptions> getResidentialComplexesDescriptionsByIdResidentialComplexHeatingType() {
        return residentialComplexesDescriptionsByIdResidentialComplexHeatingType;
    }

    public void setResidentialComplexesDescriptionsByIdResidentialComplexHeatingType(Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexHeatingType) {
        this.residentialComplexesDescriptionsByIdResidentialComplexHeatingType = residentialComplexesDescriptionsByIdResidentialComplexHeatingType;
    }
}
