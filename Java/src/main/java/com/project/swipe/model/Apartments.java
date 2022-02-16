package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idApartment")
public class Apartments {
    private int idApartment;
    private double price;
    private double size;
    private Collection<ApartmentAds> apartmentAdsByIdApartment;
    private RealEstateTypes realEstateTypesByIdRealEstateType;
    private AccountTypePrivatePersons accountTypePrivatePersonsByIdAccountTypePrivatePerson;
    private ApartmentsDescription apartmentsDescriptionByIdApartmentDescription;
    private ResidentialComplexes residentialComplexesByIdResidentialComplex;
    private ApartmentsBuildings apartmentsBuildingsByIdApartmentBuilding;
    private Collection<ApartmentsGalleries> apartmentsGalleriesByIdApartment;

    public Apartments() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment", nullable = false)
    public int getIdApartment() {
        return idApartment;
    }

    public void setIdApartment(int idApartment) {
        this.idApartment = idApartment;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "size", nullable = false, precision = 0)
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartments that = (Apartments) o;
        return idApartment == that.idApartment && Double.compare(that.price, price) == 0 && Double.compare(that.size, size) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartment, price, size);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "apartmentsByIdApartment")
    public Collection<ApartmentAds> getApartmentAdsByIdApartment() {
        return apartmentAdsByIdApartment;
    }

    public void setApartmentAdsByIdApartment(Collection<ApartmentAds> apartmentAdsByIdApartment) {
        this.apartmentAdsByIdApartment = apartmentAdsByIdApartment;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_real_estate_type", referencedColumnName = "id_real_estate_type", nullable = false)
    public RealEstateTypes getRealEstateTypesByIdRealEstateType() {
        return realEstateTypesByIdRealEstateType;
    }

    public void setRealEstateTypesByIdRealEstateType(RealEstateTypes realEstateTypesByIdRealEstateType) {
        this.realEstateTypesByIdRealEstateType = realEstateTypesByIdRealEstateType;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_account_type_private_person", referencedColumnName = "id_account_type_private_person")
    public AccountTypePrivatePersons getAccountTypePrivatePersonsByIdAccountTypePrivatePerson() {
        return accountTypePrivatePersonsByIdAccountTypePrivatePerson;
    }

    public void setAccountTypePrivatePersonsByIdAccountTypePrivatePerson(AccountTypePrivatePersons accountTypePrivatePersonsByIdAccountTypePrivatePerson) {
        this.accountTypePrivatePersonsByIdAccountTypePrivatePerson = accountTypePrivatePersonsByIdAccountTypePrivatePerson;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_apartment_description", referencedColumnName = "id_apartment_description", nullable = false)
    public ApartmentsDescription getApartmentsDescriptionByIdApartmentDescription() {
        return apartmentsDescriptionByIdApartmentDescription;
    }

    public void setApartmentsDescriptionByIdApartmentDescription(ApartmentsDescription apartmentsDescriptionByIdApartmentDescription) {
        this.apartmentsDescriptionByIdApartmentDescription = apartmentsDescriptionByIdApartmentDescription;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_apartment_building", referencedColumnName = "id_apartment_building", nullable = false)
    public ApartmentsBuildings getApartmentsBuildingsByIdApartmentBuilding() {
        return apartmentsBuildingsByIdApartmentBuilding;
    }

    public void setApartmentsBuildingsByIdApartmentBuilding(ApartmentsBuildings apartmentsBuildingsByIdApartmentBuilding) {
        this.apartmentsBuildingsByIdApartmentBuilding = apartmentsBuildingsByIdApartmentBuilding;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "apartmentsByIdApartment")
    public Collection<ApartmentsGalleries> getApartmentsGalleriesByIdApartment() {
        return apartmentsGalleriesByIdApartment;
    }

    public void setApartmentsGalleriesByIdApartment(Collection<ApartmentsGalleries> apartmentsGalleriesByIdApartment) {
        this.apartmentsGalleriesByIdApartment = apartmentsGalleriesByIdApartment;
    }
}
