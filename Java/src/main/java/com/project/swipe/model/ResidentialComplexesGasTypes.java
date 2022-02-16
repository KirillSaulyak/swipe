package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexGasType")
@Table(name = "residential_complexes_gas_types", schema = "swipe", catalog = "")
public class ResidentialComplexesGasTypes {
    private int idResidentialComplexGasType;
    private String name;
    private Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexGasType;

    public ResidentialComplexesGasTypes() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_gas_type", nullable = false)
    public int getIdResidentialComplexGasType() {
        return idResidentialComplexGasType;
    }

    public void setIdResidentialComplexGasType(int idResidentialComplexGasType) {
        this.idResidentialComplexGasType = idResidentialComplexGasType;
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
        ResidentialComplexesGasTypes that = (ResidentialComplexesGasTypes) o;
        return idResidentialComplexGasType == that.idResidentialComplexGasType && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexGasType, name);
    }


    @OneToMany(mappedBy = "residentialComplexesGasTypesByIdResidentialComplexGasType")
    public Collection<ResidentialComplexesDescriptions> getResidentialComplexesDescriptionsByIdResidentialComplexGasType() {
        return residentialComplexesDescriptionsByIdResidentialComplexGasType;
    }

    public void setResidentialComplexesDescriptionsByIdResidentialComplexGasType(Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexGasType) {
        this.residentialComplexesDescriptionsByIdResidentialComplexGasType = residentialComplexesDescriptionsByIdResidentialComplexGasType;
    }
}
