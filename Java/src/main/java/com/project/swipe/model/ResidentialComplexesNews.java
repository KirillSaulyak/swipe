package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexNews")
@Table(name = "residential_complexes_news", schema = "swipe", catalog = "")
public class ResidentialComplexesNews {
    private int idResidentialComplexNews;
    private String name;
    private String description;
    private Date creationDate;
    private ResidentialComplexes residentialComplexesByIdResidentialComplex;

    public ResidentialComplexesNews() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_news", nullable = false)
    public int getIdResidentialComplexNews() {
        return idResidentialComplexNews;
    }

    public void setIdResidentialComplexNews(int idResidentialComplexNews) {
        this.idResidentialComplexNews = idResidentialComplexNews;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "creation_date", nullable = false)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResidentialComplexesNews that = (ResidentialComplexesNews) o;
        return idResidentialComplexNews == that.idResidentialComplexNews && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexNews, name, description, creationDate);
    }


    @ManyToOne
    @JoinColumn(name = "id_residential_complex", referencedColumnName = "id_residential_complex", nullable = false)
    public ResidentialComplexes getResidentialComplexesByIdResidentialComplex() {
        return residentialComplexesByIdResidentialComplex;
    }

    public void setResidentialComplexesByIdResidentialComplex(ResidentialComplexes residentialComplexesByIdResidentialComplex) {
        this.residentialComplexesByIdResidentialComplex = residentialComplexesByIdResidentialComplex;
    }
}
