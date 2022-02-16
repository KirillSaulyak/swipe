package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idApartmentDescriptionNumberOfRoom")
@Table(name = "apartments_description_number_of_rooms", schema = "swipe", catalog = "")
public class ApartmentsDescriptionNumberOfRooms {
    private int idApartmentDescriptionNumberOfRoom;
    private String name;
    private Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionNumberOfRoom;

    public ApartmentsDescriptionNumberOfRooms() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment_description_number_of_room", nullable = false)
    public int getIdApartmentDescriptionNumberOfRoom() {
        return idApartmentDescriptionNumberOfRoom;
    }

    public void setIdApartmentDescriptionNumberOfRoom(int idApartmentDescriptionNumberOfRoom) {
        this.idApartmentDescriptionNumberOfRoom = idApartmentDescriptionNumberOfRoom;
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
        ApartmentsDescriptionNumberOfRooms that = (ApartmentsDescriptionNumberOfRooms) o;
        return idApartmentDescriptionNumberOfRoom == that.idApartmentDescriptionNumberOfRoom && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartmentDescriptionNumberOfRoom, name);
    }


    @OneToMany(mappedBy = "apartmentsDescriptionNumberOfRoomsByIdApartmentDescriptionNumberOfRoom")
    public Collection<ApartmentsDescription> getApartmentsDescriptionsByIdApartmentDescriptionNumberOfRoom() {
        return apartmentsDescriptionsByIdApartmentDescriptionNumberOfRoom;
    }

    public void setApartmentsDescriptionsByIdApartmentDescriptionNumberOfRoom(Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionNumberOfRoom) {
        this.apartmentsDescriptionsByIdApartmentDescriptionNumberOfRoom = apartmentsDescriptionsByIdApartmentDescriptionNumberOfRoom;
    }
}
