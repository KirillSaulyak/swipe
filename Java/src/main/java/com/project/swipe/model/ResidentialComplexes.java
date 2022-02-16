package com.project.swipe.model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "residential_complexes", schema = "swipe", catalog = "")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplex")
public class ResidentialComplexes {
    private int idResidentialComplex;
    private String name;
    private String address;
    private String coordinatesForMap;
    private Collection<Apartments> apartmentsByIdResidentialComplex;
    private Collection<ResidentialComplexAds> residentialComplexAdsByIdResidentialComplex;
    private RealEstateTypes realEstateTypesByIdRealEstateType;
    private AccountTypeDevelopers accountTypeDevelopersByIdAccountTypeDeveloper;
    private ResidentialComplexesSalesDepartments residentialComplexesSalesDepartmentsByIdResidentialComplexSalesDepartment;
    private ResidentialComplexesDescriptions residentialComplexesDescriptionsByIdResidentialComplexDescription;
    private Collection<ResidentialComplexesFiles> residentialComplexesFilesByIdResidentialComplex;
    private Collection<ResidentialComplexesGalleries> residentialComplexesGalleriesByIdResidentialComplex;
    private Collection<ResidentialComplexesNews> residentialComplexesNewsByIdResidentialComplex;

    public ResidentialComplexes() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex", nullable = false)
    public int getIdResidentialComplex() {
        return idResidentialComplex;
    }

    public void setIdResidentialComplex(int idResidentialComplex) {
        this.idResidentialComplex = idResidentialComplex;
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
    @Column(name = "address", nullable = false, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "coordinates_for_map", nullable = false, length = 255)
    public String getCoordinatesForMap() {
        return coordinatesForMap;
    }

    public void setCoordinatesForMap(String coordinatesForMap) {
        this.coordinatesForMap = coordinatesForMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResidentialComplexes that = (ResidentialComplexes) o;
        return idResidentialComplex == that.idResidentialComplex && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(coordinatesForMap, that.coordinatesForMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplex, name, address, coordinatesForMap);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "residentialComplexesByIdResidentialComplex")
    public Collection<Apartments> getApartmentsByIdResidentialComplex() {
        return apartmentsByIdResidentialComplex;
    }

    public void setApartmentsByIdResidentialComplex(Collection<Apartments> apartmentsByIdResidentialComplex) {
        this.apartmentsByIdResidentialComplex = apartmentsByIdResidentialComplex;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "residentialComplexesByIdResidentialComplex")
    public Collection<ResidentialComplexAds> getResidentialComplexAdsByIdResidentialComplex() {
        return residentialComplexAdsByIdResidentialComplex;
    }

    public void setResidentialComplexAdsByIdResidentialComplex(Collection<ResidentialComplexAds> residentialComplexAdsByIdResidentialComplex) {
        this.residentialComplexAdsByIdResidentialComplex = residentialComplexAdsByIdResidentialComplex;
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
    @JoinColumn(name = "id_account_type_developer", referencedColumnName = "id_account_type_developer", nullable = false)
    public AccountTypeDevelopers getAccountTypeDevelopersByIdAccountTypeDeveloper() {
        return accountTypeDevelopersByIdAccountTypeDeveloper;
    }

    public void setAccountTypeDevelopersByIdAccountTypeDeveloper(AccountTypeDevelopers accountTypeDevelopersByIdAccountTypeDeveloper) {
        this.accountTypeDevelopersByIdAccountTypeDeveloper = accountTypeDevelopersByIdAccountTypeDeveloper;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_residential_complex_sales_department", referencedColumnName = "id_residential_complex_sales_department", nullable = false)
    public ResidentialComplexesSalesDepartments getResidentialComplexesSalesDepartmentsByIdResidentialComplexSalesDepartment() {
        return residentialComplexesSalesDepartmentsByIdResidentialComplexSalesDepartment;
    }

    public void setResidentialComplexesSalesDepartmentsByIdResidentialComplexSalesDepartment(ResidentialComplexesSalesDepartments residentialComplexesSalesDepartmentsByIdResidentialComplexSalesDepartment) {
        this.residentialComplexesSalesDepartmentsByIdResidentialComplexSalesDepartment = residentialComplexesSalesDepartmentsByIdResidentialComplexSalesDepartment;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_residential_complex_description", referencedColumnName = "id_residential_complex_description", nullable = false)
    public ResidentialComplexesDescriptions getResidentialComplexesDescriptionsByIdResidentialComplexDescription() {
        return residentialComplexesDescriptionsByIdResidentialComplexDescription;
    }

    public void setResidentialComplexesDescriptionsByIdResidentialComplexDescription(ResidentialComplexesDescriptions residentialComplexesDescriptionsByIdResidentialComplexDescription) {
        this.residentialComplexesDescriptionsByIdResidentialComplexDescription = residentialComplexesDescriptionsByIdResidentialComplexDescription;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "residentialComplexesByIdResidentialComplex")
    public Collection<ResidentialComplexesFiles> getResidentialComplexesFilesByIdResidentialComplex() {
        return residentialComplexesFilesByIdResidentialComplex;
    }

    public void setResidentialComplexesFilesByIdResidentialComplex(Collection<ResidentialComplexesFiles> residentialComplexesFilesByIdResidentialComplex) {
        this.residentialComplexesFilesByIdResidentialComplex = residentialComplexesFilesByIdResidentialComplex;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "residentialComplexesByIdResidentialComplex")
    public Collection<ResidentialComplexesGalleries> getResidentialComplexesGalleriesByIdResidentialComplex() {
        return residentialComplexesGalleriesByIdResidentialComplex;
    }

    public void setResidentialComplexesGalleriesByIdResidentialComplex(Collection<ResidentialComplexesGalleries> residentialComplexesGalleriesByIdResidentialComplex) {
        this.residentialComplexesGalleriesByIdResidentialComplex = residentialComplexesGalleriesByIdResidentialComplex;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "residentialComplexesByIdResidentialComplex")
    public Collection<ResidentialComplexesNews> getResidentialComplexesNewsByIdResidentialComplex() {
        return residentialComplexesNewsByIdResidentialComplex;
    }

    public void setResidentialComplexesNewsByIdResidentialComplex(Collection<ResidentialComplexesNews> residentialComplexesNewsByIdResidentialComplex) {
        this.residentialComplexesNewsByIdResidentialComplex = residentialComplexesNewsByIdResidentialComplex;
    }
}
