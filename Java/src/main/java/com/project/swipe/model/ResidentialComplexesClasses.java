package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexClasses")
@Table(name = "residential_complexes_classes", schema = "swipe", catalog = "")
public class ResidentialComplexesClasses {
    private int idResidentialComplexClasses;
    private String name;
    private Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexClasses;

    public ResidentialComplexesClasses() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_classes", nullable = false)
    public int getIdResidentialComplexClasses() {
        return idResidentialComplexClasses;
    }

    public void setIdResidentialComplexClasses(int idResidentialComplexClasses) {
        this.idResidentialComplexClasses = idResidentialComplexClasses;
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
        ResidentialComplexesClasses that = (ResidentialComplexesClasses) o;
        return idResidentialComplexClasses == that.idResidentialComplexClasses && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexClasses, name);
    }


    @OneToMany(mappedBy = "residentialComplexesClassesByIdResidentialComplexClasses")
    public Collection<ResidentialComplexesDescriptions> getResidentialComplexesDescriptionsByIdResidentialComplexClasses() {
        return residentialComplexesDescriptionsByIdResidentialComplexClasses;
    }

    public void setResidentialComplexesDescriptionsByIdResidentialComplexClasses(Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexClasses) {
        this.residentialComplexesDescriptionsByIdResidentialComplexClasses = residentialComplexesDescriptionsByIdResidentialComplexClasses;
    }
}
