package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idApartmentBuilding")
@Table(name = "apartments_buildings", schema = "swipe", catalog = "")
public class ApartmentsBuildings {
    private int idApartmentBuilding;
    private int numberBuilding;
    private Collection<Apartments> apartmentsByIdApartmentBuilding;

    public ApartmentsBuildings() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment_building", nullable = false)
    public int getIdApartmentBuilding() {
        return idApartmentBuilding;
    }

    public void setIdApartmentBuilding(int idApartmentBuilding) {
        this.idApartmentBuilding = idApartmentBuilding;
    }

    @Basic
    @Column(name = "number_building", nullable = false)
    public int getNumberBuilding() {
        return numberBuilding;
    }

    public void setNumberBuilding(int numberBuilding) {
        this.numberBuilding = numberBuilding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentsBuildings that = (ApartmentsBuildings) o;
        return idApartmentBuilding == that.idApartmentBuilding && numberBuilding == that.numberBuilding;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartmentBuilding, numberBuilding);
    }


    @OneToMany(mappedBy = "apartmentsBuildingsByIdApartmentBuilding")
    public Collection<Apartments> getApartmentsByIdApartmentBuilding() {
        return apartmentsByIdApartmentBuilding;
    }

    public void setApartmentsByIdApartmentBuilding(Collection<Apartments> apartmentsByIdApartmentBuilding) {
        this.apartmentsByIdApartmentBuilding = apartmentsByIdApartmentBuilding;
    }
}
