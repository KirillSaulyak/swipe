package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexSewerageType")
@Table(name = "residential_complexes_sewerage_types", schema = "swipe", catalog = "")
public class ResidentialComplexesSewerageTypes {
    private int idResidentialComplexSewerageType;
    private String name;
    private Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexSewerageType;

    public ResidentialComplexesSewerageTypes() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_sewerage_type", nullable = false)
    public int getIdResidentialComplexSewerageType() {
        return idResidentialComplexSewerageType;
    }

    public void setIdResidentialComplexSewerageType(int idResidentialComplexSewerageType) {
        this.idResidentialComplexSewerageType = idResidentialComplexSewerageType;
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
        ResidentialComplexesSewerageTypes that = (ResidentialComplexesSewerageTypes) o;
        return idResidentialComplexSewerageType == that.idResidentialComplexSewerageType && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexSewerageType, name);
    }


    @OneToMany(mappedBy = "residentialComplexesSewerageTypesByIdResidentialComplexSewerageType")
    public Collection<ResidentialComplexesDescriptions> getResidentialComplexesDescriptionsByIdResidentialComplexSewerageType() {
        return residentialComplexesDescriptionsByIdResidentialComplexSewerageType;
    }

    public void setResidentialComplexesDescriptionsByIdResidentialComplexSewerageType(Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexSewerageType) {
        this.residentialComplexesDescriptionsByIdResidentialComplexSewerageType = residentialComplexesDescriptionsByIdResidentialComplexSewerageType;
    }
}
