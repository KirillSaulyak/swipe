package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idApartmentDescriptionLayout")
@Table(name = "apartments_description_layouts", schema = "swipe", catalog = "")
public class ApartmentsDescriptionLayouts {
    private int idApartmentDescriptionLayout;
    private String name;
    private Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionLayout;

    public ApartmentsDescriptionLayouts() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment_description_layout", nullable = false)
    public int getIdApartmentDescriptionLayout() {
        return idApartmentDescriptionLayout;
    }

    public void setIdApartmentDescriptionLayout(int idApartmentDescriptionLayout) {
        this.idApartmentDescriptionLayout = idApartmentDescriptionLayout;
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
        ApartmentsDescriptionLayouts that = (ApartmentsDescriptionLayouts) o;
        return idApartmentDescriptionLayout == that.idApartmentDescriptionLayout && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartmentDescriptionLayout, name);
    }


    @OneToMany(mappedBy = "apartmentsDescriptionLayoutsByIdApartmentDescriptionLayout")
    public Collection<ApartmentsDescription> getApartmentsDescriptionsByIdApartmentDescriptionLayout() {
        return apartmentsDescriptionsByIdApartmentDescriptionLayout;
    }

    public void setApartmentsDescriptionsByIdApartmentDescriptionLayout(Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionLayout) {
        this.apartmentsDescriptionsByIdApartmentDescriptionLayout = apartmentsDescriptionsByIdApartmentDescriptionLayout;
    }
}
