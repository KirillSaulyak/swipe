package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexConstructionTechnology")
@Table(name = "residential_complexes_construction_technologies", schema = "swipe", catalog = "")
public class ResidentialComplexesConstructionTechnologies {
    private int idResidentialComplexConstructionTechnology;
    private String name;
    private Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexConstructionTechnology;

    public ResidentialComplexesConstructionTechnologies() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_construction_technology", nullable = false)
    public int getIdResidentialComplexConstructionTechnology() {
        return idResidentialComplexConstructionTechnology;
    }

    public void setIdResidentialComplexConstructionTechnology(int idResidentialComplexConstructionTechnology) {
        this.idResidentialComplexConstructionTechnology = idResidentialComplexConstructionTechnology;
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
        ResidentialComplexesConstructionTechnologies that = (ResidentialComplexesConstructionTechnologies) o;
        return idResidentialComplexConstructionTechnology == that.idResidentialComplexConstructionTechnology && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexConstructionTechnology, name);
    }


    @OneToMany(mappedBy = "residentialComplexesConstructionTechnologiesByIdResidentialComplexConstructionTechnology")
    public Collection<ResidentialComplexesDescriptions> getResidentialComplexesDescriptionsByIdResidentialComplexConstructionTechnology() {
        return residentialComplexesDescriptionsByIdResidentialComplexConstructionTechnology;
    }

    public void setResidentialComplexesDescriptionsByIdResidentialComplexConstructionTechnology(Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexConstructionTechnology) {
        this.residentialComplexesDescriptionsByIdResidentialComplexConstructionTechnology = residentialComplexesDescriptionsByIdResidentialComplexConstructionTechnology;
    }
}
