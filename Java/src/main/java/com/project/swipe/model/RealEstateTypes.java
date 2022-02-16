package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idRealEstateType")
@Table(name = "real_estate_types", schema = "swipe", catalog = "")
public class RealEstateTypes {
    private int idRealEstateType;
    private String name;
    private Collection<Apartments> apartmentsByIdRealEstateType;
    private Collection<ResidentialComplexes> residentialComplexesByIdRealEstateType;

    public RealEstateTypes() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_real_estate_type", nullable = false)
    public int getIdRealEstateType() {
        return idRealEstateType;
    }

    public void setIdRealEstateType(int idRealEstateType) {
        this.idRealEstateType = idRealEstateType;
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
        RealEstateTypes that = (RealEstateTypes) o;
        return idRealEstateType == that.idRealEstateType && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRealEstateType, name);
    }


    @OneToMany(mappedBy = "realEstateTypesByIdRealEstateType")
    public Collection<Apartments> getApartmentsByIdRealEstateType() {
        return apartmentsByIdRealEstateType;
    }

    public void setApartmentsByIdRealEstateType(Collection<Apartments> apartmentsByIdRealEstateType) {
        this.apartmentsByIdRealEstateType = apartmentsByIdRealEstateType;
    }


    @OneToMany(mappedBy = "realEstateTypesByIdRealEstateType")
    public Collection<ResidentialComplexes> getResidentialComplexesByIdRealEstateType() {
        return residentialComplexesByIdRealEstateType;
    }

    public void setResidentialComplexesByIdRealEstateType(Collection<ResidentialComplexes> residentialComplexesByIdRealEstateType) {
        this.residentialComplexesByIdRealEstateType = residentialComplexesByIdRealEstateType;
    }
}
