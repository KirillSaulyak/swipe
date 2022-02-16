package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "residential_complex_ads", schema = "swipe", catalog = "")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAd")
public class ResidentialComplexAds {
    private int idAd;
    private boolean enabled;
    private ResidentialComplexes residentialComplexesByIdResidentialComplex;

    public ResidentialComplexAds() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ad", nullable = false)
    public int getIdAd() {
        return idAd;
    }

    public void setIdAd(int idAd) {
        this.idAd = idAd;
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
        ResidentialComplexAds that = (ResidentialComplexAds) o;
        return idAd == that.idAd && enabled == that.enabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAd, enabled);
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
