package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexFile")
@Table(name = "residential_complexes_files", schema = "swipe", catalog = "")
public class ResidentialComplexesFiles {
    private int idResidentialComplexFile;
    private String pathToFile;
    private ResidentialComplexes residentialComplexesByIdResidentialComplex;

    public ResidentialComplexesFiles() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_file", nullable = false)
    public int getIdResidentialComplexFile() {
        return idResidentialComplexFile;
    }

    public void setIdResidentialComplexFile(int idResidentialComplexFile) {
        this.idResidentialComplexFile = idResidentialComplexFile;
    }

    @Basic
    @Column(name = "path_to_file", nullable = false, length = 255)
    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResidentialComplexesFiles that = (ResidentialComplexesFiles) o;
        return idResidentialComplexFile == that.idResidentialComplexFile && Objects.equals(pathToFile, that.pathToFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexFile, pathToFile);
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
