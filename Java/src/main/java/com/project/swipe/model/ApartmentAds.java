package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "apartment_ads", schema = "swipe", catalog = "")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idApartmentAd")
public class ApartmentAds {
    private int idApartmentAd;
    private boolean enabled;
    private Apartments apartmentsByIdApartment;

    public ApartmentAds() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment_ad", nullable = false)
    public int getIdApartmentAd() {
        return idApartmentAd;
    }

    public void setIdApartmentAd(int idApartmentAd) {
        this.idApartmentAd = idApartmentAd;
    }

    @Basic
    @Column(name = "enabled", nullable = false)
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentAds that = (ApartmentAds) o;
        return idApartmentAd == that.idApartmentAd && enabled == that.enabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartmentAd, enabled);
    }


    @ManyToOne
    @JoinColumn(name = "id_apartment", referencedColumnName = "id_apartment", nullable = false)
    public Apartments getApartmentsByIdApartment() {
        return apartmentsByIdApartment;
    }

    public void setApartmentsByIdApartment(Apartments apartmentsByIdApartment) {
        this.apartmentsByIdApartment = apartmentsByIdApartment;
    }
}
