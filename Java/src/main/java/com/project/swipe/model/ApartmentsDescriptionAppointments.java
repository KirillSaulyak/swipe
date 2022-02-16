package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idApartmentDescriptionAppointment")
@Table(name = "apartments_description_appointments", schema = "swipe", catalog = "")
public class ApartmentsDescriptionAppointments {
    private int idApartmentDescriptionAppointment;
    private String name;
    private Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionAppointment;

    public ApartmentsDescriptionAppointments() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment_description_appointment", nullable = false)
    public int getIdApartmentDescriptionAppointment() {
        return idApartmentDescriptionAppointment;
    }

    public void setIdApartmentDescriptionAppointment(int idApartmentDescriptionAppointment) {
        this.idApartmentDescriptionAppointment = idApartmentDescriptionAppointment;
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
        ApartmentsDescriptionAppointments that = (ApartmentsDescriptionAppointments) o;
        return idApartmentDescriptionAppointment == that.idApartmentDescriptionAppointment && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartmentDescriptionAppointment, name);
    }


    @OneToMany(mappedBy = "apartmentsDescriptionAppointmentsByIdApartmentDescriptionAppointment")
    public Collection<ApartmentsDescription> getApartmentsDescriptionsByIdApartmentDescriptionAppointment() {
        return apartmentsDescriptionsByIdApartmentDescriptionAppointment;
    }

    public void setApartmentsDescriptionsByIdApartmentDescriptionAppointment(Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionAppointment) {
        this.apartmentsDescriptionsByIdApartmentDescriptionAppointment = apartmentsDescriptionsByIdApartmentDescriptionAppointment;
    }
}
