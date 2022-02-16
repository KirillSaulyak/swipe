package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idApartmentDescriptionFoundationDocument")
@Table(name = "apartments_description_foundation_documents", schema = "swipe", catalog = "")
public class ApartmentsDescriptionFoundationDocuments {
    private int idApartmentDescriptionFoundationDocument;
    private String name;
    private Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionFoundationDocument;

    public ApartmentsDescriptionFoundationDocuments() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment_description_foundation_document", nullable = false)
    public int getIdApartmentDescriptionFoundationDocument() {
        return idApartmentDescriptionFoundationDocument;
    }

    public void setIdApartmentDescriptionFoundationDocument(int idApartmentDescriptionFoundationDocument) {
        this.idApartmentDescriptionFoundationDocument = idApartmentDescriptionFoundationDocument;
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
        ApartmentsDescriptionFoundationDocuments that = (ApartmentsDescriptionFoundationDocuments) o;
        return idApartmentDescriptionFoundationDocument == that.idApartmentDescriptionFoundationDocument && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartmentDescriptionFoundationDocument, name);
    }


    @OneToMany(mappedBy = "apartmentsDescriptionFoundationDocumentsByIdApartmentDescriptionFoundationDocument")
    public Collection<ApartmentsDescription> getApartmentsDescriptionsByIdApartmentDescriptionFoundationDocument() {
        return apartmentsDescriptionsByIdApartmentDescriptionFoundationDocument;
    }

    public void setApartmentsDescriptionsByIdApartmentDescriptionFoundationDocument(Collection<ApartmentsDescription> apartmentsDescriptionsByIdApartmentDescriptionFoundationDocument) {
        this.apartmentsDescriptionsByIdApartmentDescriptionFoundationDocument = apartmentsDescriptionsByIdApartmentDescriptionFoundationDocument;
    }
}
