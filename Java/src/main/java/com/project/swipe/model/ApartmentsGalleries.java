package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idApartmentGallery")
@Table(name = "apartments_galleries", schema = "swipe", catalog = "")
public class ApartmentsGalleries {
    private int idApartmentGallery;
    private String pathToImage;
    private Apartments apartmentsByIdApartment;

    public ApartmentsGalleries() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment_gallery", nullable = false)
    public int getIdApartmentGallery() {
        return idApartmentGallery;
    }

    public void setIdApartmentGallery(int idApartmentGallery) {
        this.idApartmentGallery = idApartmentGallery;
    }

    @Basic
    @Column(name = "path_to_image", nullable = false, length = 255)
    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentsGalleries that = (ApartmentsGalleries) o;
        return idApartmentGallery == that.idApartmentGallery && Objects.equals(pathToImage, that.pathToImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartmentGallery, pathToImage);
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_apartment", referencedColumnName = "id_apartment", nullable = false)
    public Apartments getApartmentsByIdApartment() {
        return apartmentsByIdApartment;
    }

    public void setApartmentsByIdApartment(Apartments apartmentsByIdApartment) {
        this.apartmentsByIdApartment = apartmentsByIdApartment;
    }
}
