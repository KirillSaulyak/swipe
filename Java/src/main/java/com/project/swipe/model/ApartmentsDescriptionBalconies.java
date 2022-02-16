package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idApartmentDescriptionBalcony")
@Table(name = "apartments_description_balconies", schema = "swipe", catalog = "")
public class ApartmentsDescriptionBalconies {
    private int idApartmentDescriptionBalcony;
    private String name;
    private Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionBalcony;

    public ApartmentsDescriptionBalconies() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment_description_balcony", nullable = false)
    public int getIdApartmentDescriptionBalcony() {
        return idApartmentDescriptionBalcony;
    }

    public void setIdApartmentDescriptionBalcony(int idApartmentDescriptionBalcony) {
        this.idApartmentDescriptionBalcony = idApartmentDescriptionBalcony;
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
        ApartmentsDescriptionBalconies that = (ApartmentsDescriptionBalconies) o;
        return idApartmentDescriptionBalcony == that.idApartmentDescriptionBalcony && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartmentDescriptionBalcony, name);
    }


    @OneToMany(mappedBy = "apartmentsDescriptionBalconiesByIdApartmentDescriptionBalcony")
    public Collection<ApartmentsDescription> getApartmentsDescriptionsByIdApartmentDescriptionBalcony() {
        return apartmentsDescriptionsByIdApartmentDescriptionBalcony;
    }

    public void setApartmentsDescriptionsByIdApartmentDescriptionBalcony(Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionBalcony) {
        this.apartmentsDescriptionsByIdApartmentDescriptionBalcony = apartmentsDescriptionsByIdApartmentDescriptionBalcony;
    }
}
