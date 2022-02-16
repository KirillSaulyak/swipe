package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexWaterSupplyType")
@Table(name = "residential_complexes_water_supply_types", schema = "swipe", catalog = "")
public class ResidentialComplexesWaterSupplyTypes {
    private int idResidentialComplexWaterSupplyType;
    private String name;
    private Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexWaterSupplyType;

    public ResidentialComplexesWaterSupplyTypes() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_water_supply_type", nullable = false)
    public int getIdResidentialComplexWaterSupplyType() {
        return idResidentialComplexWaterSupplyType;
    }

    public void setIdResidentialComplexWaterSupplyType(int idResidentialComplexWaterSupplyType) {
        this.idResidentialComplexWaterSupplyType = idResidentialComplexWaterSupplyType;
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
        ResidentialComplexesWaterSupplyTypes that = (ResidentialComplexesWaterSupplyTypes) o;
        return idResidentialComplexWaterSupplyType == that.idResidentialComplexWaterSupplyType && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexWaterSupplyType, name);
    }


    @OneToMany(mappedBy = "residentialComplexesWaterSupplyTypesByIdResidentialComplexWaterSupplyType")
    public Collection<ResidentialComplexesDescriptions> getResidentialComplexesDescriptionsByIdResidentialComplexWaterSupplyType() {
        return residentialComplexesDescriptionsByIdResidentialComplexWaterSupplyType;
    }

    public void setResidentialComplexesDescriptionsByIdResidentialComplexWaterSupplyType(Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexWaterSupplyType) {
        this.residentialComplexesDescriptionsByIdResidentialComplexWaterSupplyType = residentialComplexesDescriptionsByIdResidentialComplexWaterSupplyType;
    }
}
