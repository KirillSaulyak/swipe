package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexStatus")
@Table(name = "residential_complexes_statuses", schema = "swipe", catalog = "")
public class ResidentialComplexesStatuses {
    private int idResidentialComplexStatus;
    private String name;
    private Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexStatus;

    public ResidentialComplexesStatuses() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_status", nullable = false)
    public int getIdResidentialComplexStatus() {
        return idResidentialComplexStatus;
    }

    public void setIdResidentialComplexStatus(int idResidentialComplexStatus) {
        this.idResidentialComplexStatus = idResidentialComplexStatus;
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
        ResidentialComplexesStatuses that = (ResidentialComplexesStatuses) o;
        return idResidentialComplexStatus == that.idResidentialComplexStatus && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexStatus, name);
    }


    @OneToMany(mappedBy = "residentialComplexesStatusesByIdResidentialComplexStatus")
    public Collection<ResidentialComplexesDescriptions> getResidentialComplexesDescriptionsByIdResidentialComplexStatus() {
        return residentialComplexesDescriptionsByIdResidentialComplexStatus;
    }

    public void setResidentialComplexesDescriptionsByIdResidentialComplexStatus(Collection<ResidentialComplexesDescriptions> residentialComplexesDescriptionsByIdResidentialComplexStatus) {
        this.residentialComplexesDescriptionsByIdResidentialComplexStatus = residentialComplexesDescriptionsByIdResidentialComplexStatus;
    }
}
