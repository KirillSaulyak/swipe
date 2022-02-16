package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idApartmentDescriptionWayOfCommunication")
@Table(name = "apartments_description_ways_of_communication", schema = "swipe", catalog = "")
public class ApartmentsDescriptionWaysOfCommunication {
    private int idApartmentDescriptionWayOfCommunication;
    private String name;
    private Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionWayOfCommunication;

    public ApartmentsDescriptionWaysOfCommunication() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment_description_way_of_communication", nullable = false)
    public int getIdApartmentDescriptionWayOfCommunication() {
        return idApartmentDescriptionWayOfCommunication;
    }

    public void setIdApartmentDescriptionWayOfCommunication(int idApartmentDescriptionWayOfCommunication) {
        this.idApartmentDescriptionWayOfCommunication = idApartmentDescriptionWayOfCommunication;
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
        ApartmentsDescriptionWaysOfCommunication that = (ApartmentsDescriptionWaysOfCommunication) o;
        return idApartmentDescriptionWayOfCommunication == that.idApartmentDescriptionWayOfCommunication && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartmentDescriptionWayOfCommunication, name);
    }


    @OneToMany(mappedBy = "apartmentsDescriptionWaysOfCommunicationByIdApartmentDescriptionWayOfCommunication")
    public Collection<ApartmentsDescription> getApartmentsDescriptionsByIdApartmentDescriptionWayOfCommunication() {
        return apartmentsDescriptionsByIdApartmentDescriptionWayOfCommunication;
    }

    public void setApartmentsDescriptionsByIdApartmentDescriptionWayOfCommunication(Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionWayOfCommunication) {
        this.apartmentsDescriptionsByIdApartmentDescriptionWayOfCommunication = apartmentsDescriptionsByIdApartmentDescriptionWayOfCommunication;
    }
}
