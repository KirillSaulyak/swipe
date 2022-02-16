package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexAreaType")
@Table(name = "residential_complexes_area_types", schema = "swipe", catalog = "")
public class ResidentialComplexesAreaTypes {
    private int idResidentialComplexAreaType;
    private String name;
    private Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexAreaType;

    public ResidentialComplexesAreaTypes() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_area_type", nullable = false)
    public int getIdResidentialComplexAreaType() {
        return idResidentialComplexAreaType;
    }

    public void setIdResidentialComplexAreaType(int idResidentialComplexAreaType) {
        this.idResidentialComplexAreaType = idResidentialComplexAreaType;
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
        ResidentialComplexesAreaTypes that = (ResidentialComplexesAreaTypes) o;
        return idResidentialComplexAreaType == that.idResidentialComplexAreaType && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexAreaType, name);
    }


    @OneToMany(mappedBy = "residentialComplexesAreaTypesByIdResidentialComplexAreaType")
    public Collection<ResidentialComplexesDescriptions> getResidentialComplexesDescriptionsByIdResidentialComplexAreaType() {
        return residentialComplexesDescriptionsByIdResidentialComplexAreaType;
    }

    public void setResidentialComplexesDescriptionsByIdResidentialComplexAreaType(Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexAreaType) {
        this.residentialComplexesDescriptionsByIdResidentialComplexAreaType = residentialComplexesDescriptionsByIdResidentialComplexAreaType;
    }
}
