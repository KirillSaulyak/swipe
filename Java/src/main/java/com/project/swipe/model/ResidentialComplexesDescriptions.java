package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexDescription")
@Table(name = "residential_complexes_descriptions", schema = "swipe", catalog = "")
public class ResidentialComplexesDescriptions {
    private int idResidentialComplexDescription;
    private int distanceToSea;
    private int ceilingHeight;
    private Collection<ResidentialComplexes> residentialComplexesByIdResidentialComplexDescription;
    private ResidentialComplexesStatuses residentialComplexesStatusesByIdResidentialComplexStatus;
    private ResidentialComplexesTypesHouses residentialComplexesTypesHousesByIdResidentialComplexTypeHouse;
    private ResidentialComplexesClasses residentialComplexesClassesByIdResidentialComplexClasses;
    private ResidentialComplexesConstructionTechnologies residentialComplexesConstructionTechnologiesByIdResidentialComplexConstructionTechnology;
    private ResidentialComplexesAreaTypes residentialComplexesAreaTypesByIdResidentialComplexAreaType;
    private ResidentialComplexesCommunalPayments residentialComplexesCommunalPaymentsByIdResidentialComplexCommunalPayment;
    private ResidentialComplexesGasTypes residentialComplexesGasTypesByIdResidentialComplexGasType;
    private ResidentialComplexesHeatingTypes residentialComplexesHeatingTypesByIdResidentialComplexHeatingType;
    private ResidentialComplexesSewerageTypes residentialComplexesSewerageTypesByIdResidentialComplexSewerageType;
    private ResidentialComplexesWaterSupplyTypes residentialComplexesWaterSupplyTypesByIdResidentialComplexWaterSupplyType;

    public ResidentialComplexesDescriptions() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_description", nullable = false)
    public int getIdResidentialComplexDescription() {
        return idResidentialComplexDescription;
    }

    public void setIdResidentialComplexDescription(int idResidentialComplexDescription) {
        this.idResidentialComplexDescription = idResidentialComplexDescription;
    }

    @Basic
    @Column(name = "distance_to_sea", nullable = false)
    public int getDistanceToSea() {
        return distanceToSea;
    }

    public void setDistanceToSea(int distanceToSea) {
        this.distanceToSea = distanceToSea;
    }

    @Basic
    @Column(name = "ceiling_height", nullable = false)
    public int getCeilingHeight() {
        return ceilingHeight;
    }

    public void setCeilingHeight(int ceilingHeight) {
        this.ceilingHeight = ceilingHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResidentialComplexesDescriptions that = (ResidentialComplexesDescriptions) o;
        return idResidentialComplexDescription == that.idResidentialComplexDescription && distanceToSea == that.distanceToSea && ceilingHeight == that.ceilingHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexDescription, distanceToSea, ceilingHeight);
    }


    @OneToMany(mappedBy = "residentialComplexesDescriptionsByIdResidentialComplexDescription")
    public Collection<ResidentialComplexes> getResidentialComplexesByIdResidentialComplexDescription() {
        return residentialComplexesByIdResidentialComplexDescription;
    }

    public void setResidentialComplexesByIdResidentialComplexDescription(Collection<ResidentialComplexes> residentialComplexesByIdResidentialComplexDescription) {
        this.residentialComplexesByIdResidentialComplexDescription = residentialComplexesByIdResidentialComplexDescription;
    }


    @ManyToOne
    @JoinColumn(name = "id_residential_complex_status", referencedColumnName = "id_residential_complex_status", nullable = false)
    public ResidentialComplexesStatuses getResidentialComplexesStatusesByIdResidentialComplexStatus() {
        return residentialComplexesStatusesByIdResidentialComplexStatus;
    }

    public void setResidentialComplexesStatusesByIdResidentialComplexStatus(ResidentialComplexesStatuses residentialComplexesStatusesByIdResidentialComplexStatus) {
        this.residentialComplexesStatusesByIdResidentialComplexStatus = residentialComplexesStatusesByIdResidentialComplexStatus;
    }


    @ManyToOne
    @JoinColumn(name = "id_residential_complex_type_house", referencedColumnName = "id_residential_complex_type_house", nullable = false)
    public ResidentialComplexesTypesHouses getResidentialComplexesTypesHousesByIdResidentialComplexTypeHouse() {
        return residentialComplexesTypesHousesByIdResidentialComplexTypeHouse;
    }

    public void setResidentialComplexesTypesHousesByIdResidentialComplexTypeHouse(ResidentialComplexesTypesHouses residentialComplexesTypesHousesByIdResidentialComplexTypeHouse) {
        this.residentialComplexesTypesHousesByIdResidentialComplexTypeHouse = residentialComplexesTypesHousesByIdResidentialComplexTypeHouse;
    }


    @ManyToOne
    @JoinColumn(name = "id_residential_complex_classes", referencedColumnName = "id_residential_complex_classes", nullable = false)
    public ResidentialComplexesClasses getResidentialComplexesClassesByIdResidentialComplexClasses() {
        return residentialComplexesClassesByIdResidentialComplexClasses;
    }

    public void setResidentialComplexesClassesByIdResidentialComplexClasses(ResidentialComplexesClasses residentialComplexesClassesByIdResidentialComplexClasses) {
        this.residentialComplexesClassesByIdResidentialComplexClasses = residentialComplexesClassesByIdResidentialComplexClasses;
    }


    @ManyToOne
    @JoinColumn(name = "id_residential_complex_construction_technology", referencedColumnName = "id_residential_complex_construction_technology", nullable = false)
    public ResidentialComplexesConstructionTechnologies getResidentialComplexesConstructionTechnologiesByIdResidentialComplexConstructionTechnology() {
        return residentialComplexesConstructionTechnologiesByIdResidentialComplexConstructionTechnology;
    }

    public void setResidentialComplexesConstructionTechnologiesByIdResidentialComplexConstructionTechnology(ResidentialComplexesConstructionTechnologies residentialComplexesConstructionTechnologiesByIdResidentialComplexConstructionTechnology) {
        this.residentialComplexesConstructionTechnologiesByIdResidentialComplexConstructionTechnology = residentialComplexesConstructionTechnologiesByIdResidentialComplexConstructionTechnology;
    }


    @ManyToOne
    @JoinColumn(name = "id_residential_complex_area_type", referencedColumnName = "id_residential_complex_area_type", nullable = false)
    public ResidentialComplexesAreaTypes getResidentialComplexesAreaTypesByIdResidentialComplexAreaType() {
        return residentialComplexesAreaTypesByIdResidentialComplexAreaType;
    }

    public void setResidentialComplexesAreaTypesByIdResidentialComplexAreaType(ResidentialComplexesAreaTypes residentialComplexesAreaTypesByIdResidentialComplexAreaType) {
        this.residentialComplexesAreaTypesByIdResidentialComplexAreaType = residentialComplexesAreaTypesByIdResidentialComplexAreaType;
    }


    @ManyToOne
    @JoinColumn(name = "id_residential_complex_communal_payment", referencedColumnName = "id_residential_complex_communal_payment", nullable = false)
    public ResidentialComplexesCommunalPayments getResidentialComplexesCommunalPaymentsByIdResidentialComplexCommunalPayment() {
        return residentialComplexesCommunalPaymentsByIdResidentialComplexCommunalPayment;
    }

    public void setResidentialComplexesCommunalPaymentsByIdResidentialComplexCommunalPayment(ResidentialComplexesCommunalPayments residentialComplexesCommunalPaymentsByIdResidentialComplexCommunalPayment) {
        this.residentialComplexesCommunalPaymentsByIdResidentialComplexCommunalPayment = residentialComplexesCommunalPaymentsByIdResidentialComplexCommunalPayment;
    }


    @ManyToOne
    @JoinColumn(name = "id_residential_complex_gas_type", referencedColumnName = "id_residential_complex_gas_type", nullable = false)
    public ResidentialComplexesGasTypes getResidentialComplexesGasTypesByIdResidentialComplexGasType() {
        return residentialComplexesGasTypesByIdResidentialComplexGasType;
    }

    public void setResidentialComplexesGasTypesByIdResidentialComplexGasType(ResidentialComplexesGasTypes residentialComplexesGasTypesByIdResidentialComplexGasType) {
        this.residentialComplexesGasTypesByIdResidentialComplexGasType = residentialComplexesGasTypesByIdResidentialComplexGasType;
    }


    @ManyToOne
    @JoinColumn(name = "id_residential_complex_heating_type", referencedColumnName = "id_residential_complex_heating_type", nullable = false)
    public ResidentialComplexesHeatingTypes getResidentialComplexesHeatingTypesByIdResidentialComplexHeatingType() {
        return residentialComplexesHeatingTypesByIdResidentialComplexHeatingType;
    }

    public void setResidentialComplexesHeatingTypesByIdResidentialComplexHeatingType(ResidentialComplexesHeatingTypes residentialComplexesHeatingTypesByIdResidentialComplexHeatingType) {
        this.residentialComplexesHeatingTypesByIdResidentialComplexHeatingType = residentialComplexesHeatingTypesByIdResidentialComplexHeatingType;
    }


    @ManyToOne
    @JoinColumn(name = "id_residential_complex_sewerage_type", referencedColumnName = "id_residential_complex_sewerage_type", nullable = false)
    public ResidentialComplexesSewerageTypes getResidentialComplexesSewerageTypesByIdResidentialComplexSewerageType() {
        return residentialComplexesSewerageTypesByIdResidentialComplexSewerageType;
    }

    public void setResidentialComplexesSewerageTypesByIdResidentialComplexSewerageType(ResidentialComplexesSewerageTypes residentialComplexesSewerageTypesByIdResidentialComplexSewerageType) {
        this.residentialComplexesSewerageTypesByIdResidentialComplexSewerageType = residentialComplexesSewerageTypesByIdResidentialComplexSewerageType;
    }


    @ManyToOne
    @JoinColumn(name = "id_residential_complex_water_supply_type", referencedColumnName = "id_residential_complex_water_supply_type", nullable = false)
    public ResidentialComplexesWaterSupplyTypes getResidentialComplexesWaterSupplyTypesByIdResidentialComplexWaterSupplyType() {
        return residentialComplexesWaterSupplyTypesByIdResidentialComplexWaterSupplyType;
    }

    public void setResidentialComplexesWaterSupplyTypesByIdResidentialComplexWaterSupplyType(ResidentialComplexesWaterSupplyTypes residentialComplexesWaterSupplyTypesByIdResidentialComplexWaterSupplyType) {
        this.residentialComplexesWaterSupplyTypesByIdResidentialComplexWaterSupplyType = residentialComplexesWaterSupplyTypesByIdResidentialComplexWaterSupplyType;
    }
}
