package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexTypeHouse")
@Table(name = "residential_complexes_types_houses", schema = "swipe", catalog = "")
public class ResidentialComplexesTypesHouses {
    private int idResidentialComplexTypeHouse;
    private String name;
    private Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexTypeHouse;

    public ResidentialComplexesTypesHouses() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_type_house", nullable = false)
    public int getIdResidentialComplexTypeHouse() {
        return idResidentialComplexTypeHouse;
    }

    public void setIdResidentialComplexTypeHouse(int idResidentialComplexTypeHouse) {
        this.idResidentialComplexTypeHouse = idResidentialComplexTypeHouse;
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
        ResidentialComplexesTypesHouses that = (ResidentialComplexesTypesHouses) o;
        return idResidentialComplexTypeHouse == that.idResidentialComplexTypeHouse && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexTypeHouse, name);
    }


    @OneToMany(mappedBy = "residentialComplexesTypesHousesByIdResidentialComplexTypeHouse")
    public Collection<ResidentialComplexesDescriptions> getResidentialComplexesDescriptionsByIdResidentialComplexTypeHouse() {
        return residentialComplexesDescriptionsByIdResidentialComplexTypeHouse;
    }

    public void setResidentialComplexesDescriptionsByIdResidentialComplexTypeHouse(Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexTypeHouse) {
        this.residentialComplexesDescriptionsByIdResidentialComplexTypeHouse = residentialComplexesDescriptionsByIdResidentialComplexTypeHouse;
    }
}
