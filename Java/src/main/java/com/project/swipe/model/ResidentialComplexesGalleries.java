package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexGallery")
@Table(name = "residential_complexes_galleries", schema = "swipe", catalog = "")
public class ResidentialComplexesGalleries {
    private int idResidentialComplexGallery;
    private String pathToImage;
    private ResidentialComplexes residentialComplexesByIdResidentialComplex;

    public ResidentialComplexesGalleries() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_gallery", nullable = false)
    public int getIdResidentialComplexGallery() {
        return idResidentialComplexGallery;
    }

    public void setIdResidentialComplexGallery(int idResidentialComplexGallery) {
        this.idResidentialComplexGallery = idResidentialComplexGallery;
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
        ResidentialComplexesGalleries that = (ResidentialComplexesGalleries) o;
        return idResidentialComplexGallery == that.idResidentialComplexGallery && Objects.equals(pathToImage, that.pathToImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexGallery, pathToImage);
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_residential_complex", referencedColumnName = "id_residential_complex", nullable = false)
    public ResidentialComplexes getResidentialComplexesByIdResidentialComplex() {
        return residentialComplexesByIdResidentialComplex;
    }

    public void setResidentialComplexesByIdResidentialComplex(ResidentialComplexes residentialComplexesByIdResidentialComplex) {
        this.residentialComplexesByIdResidentialComplex = residentialComplexesByIdResidentialComplex;
    }
}
