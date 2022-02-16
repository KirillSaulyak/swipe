package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idApartmentDescription")
@Table(name = "apartments_description", schema = "swipe", catalog = "")
public class ApartmentsDescription {
    private int idApartmentDescription;
    private Collection<Apartments> apartmentsByIdApartmentDescription;
    private ApartmentsDescriptionFoundationDocuments apartmentsDescriptionFoundationDocumentsByIdApartmentDescriptionFoundationDocument;
    private ApartmentsDescriptionAppointments apartmentsDescriptionAppointmentsByIdApartmentDescriptionAppointment;
    private ApartmentsDescriptionNumberOfRooms apartmentsDescriptionNumberOfRoomsByIdApartmentDescriptionNumberOfRoom;
    private ApartmentsDescriptionCalculationOptions apartmentsDescriptionCalculationOptionsByIdApartmentDescriptionCalculationOption;
    private ApartmentsDescriptionLayouts apartmentsDescriptionLayoutsByIdApartmentDescriptionLayout;
    private ApartmentsDescriptionLivingConditions apartmentsDescriptionLivingConditionsByIdApartmentDescriptionLivingCondition;
    private ApartmentsDescriptionBalconies apartmentsDescriptionBalconiesByIdApartmentDescriptionBalcony;
    private ApartmentsDescriptionAgentCommissions apartmentsDescriptionAgentCommissionsByIdApartmentDescriptionAgentCommission;
    private ApartmentsDescriptionWaysOfCommunication apartmentsDescriptionWaysOfCommunicationByIdApartmentDescriptionWayOfCommunication;

    public ApartmentsDescription() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment_description", nullable = false)
    public int getIdApartmentDescription() {
        return idApartmentDescription;
    }

    public void setIdApartmentDescription(int idApartmentDescription) {
        this.idApartmentDescription = idApartmentDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentsDescription that = (ApartmentsDescription) o;
        return idApartmentDescription == that.idApartmentDescription;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartmentDescription);
    }


    @OneToMany(mappedBy = "apartmentsDescriptionByIdApartmentDescription")
    public Collection<Apartments> getApartmentsByIdApartmentDescription() {
        return apartmentsByIdApartmentDescription;
    }

    public void setApartmentsByIdApartmentDescription(Collection<Apartments> apartmentsByIdApartmentDescription) {
        this.apartmentsByIdApartmentDescription = apartmentsByIdApartmentDescription;
    }


    @ManyToOne
    @JoinColumn(name = "id_apartment_description_foundation_document", referencedColumnName = "id_apartment_description_foundation_document", nullable = false)
    public ApartmentsDescriptionFoundationDocuments getApartmentsDescriptionFoundationDocumentsByIdApartmentDescriptionFoundationDocument() {
        return apartmentsDescriptionFoundationDocumentsByIdApartmentDescriptionFoundationDocument;
    }

    public void setApartmentsDescriptionFoundationDocumentsByIdApartmentDescriptionFoundationDocument(ApartmentsDescriptionFoundationDocuments apartmentsDescriptionFoundationDocumentsByIdApartmentDescriptionFoundationDocument) {
        this.apartmentsDescriptionFoundationDocumentsByIdApartmentDescriptionFoundationDocument = apartmentsDescriptionFoundationDocumentsByIdApartmentDescriptionFoundationDocument;
    }


    @ManyToOne
    @JoinColumn(name = "id_apartment_description_appointment", referencedColumnName = "id_apartment_description_appointment", nullable = false)
    public ApartmentsDescriptionAppointments getApartmentsDescriptionAppointmentsByIdApartmentDescriptionAppointment() {
        return apartmentsDescriptionAppointmentsByIdApartmentDescriptionAppointment;
    }

    public void setApartmentsDescriptionAppointmentsByIdApartmentDescriptionAppointment(ApartmentsDescriptionAppointments apartmentsDescriptionAppointmentsByIdApartmentDescriptionAppointment) {
        this.apartmentsDescriptionAppointmentsByIdApartmentDescriptionAppointment = apartmentsDescriptionAppointmentsByIdApartmentDescriptionAppointment;
    }


    @ManyToOne
    @JoinColumn(name = "id_apartment_description_number_of_room", referencedColumnName = "id_apartment_description_number_of_room", nullable = false)
    public ApartmentsDescriptionNumberOfRooms getApartmentsDescriptionNumberOfRoomsByIdApartmentDescriptionNumberOfRoom() {
        return apartmentsDescriptionNumberOfRoomsByIdApartmentDescriptionNumberOfRoom;
    }

    public void setApartmentsDescriptionNumberOfRoomsByIdApartmentDescriptionNumberOfRoom(ApartmentsDescriptionNumberOfRooms apartmentsDescriptionNumberOfRoomsByIdApartmentDescriptionNumberOfRoom) {
        this.apartmentsDescriptionNumberOfRoomsByIdApartmentDescriptionNumberOfRoom = apartmentsDescriptionNumberOfRoomsByIdApartmentDescriptionNumberOfRoom;
    }


    @ManyToOne
    @JoinColumn(name = "id_apartment_description_calculation_option", referencedColumnName = "id_apartment_description_calculation_option", nullable = false)
    public ApartmentsDescriptionCalculationOptions getApartmentsDescriptionCalculationOptionsByIdApartmentDescriptionCalculationOption() {
        return apartmentsDescriptionCalculationOptionsByIdApartmentDescriptionCalculationOption;
    }

    public void setApartmentsDescriptionCalculationOptionsByIdApartmentDescriptionCalculationOption(ApartmentsDescriptionCalculationOptions apartmentsDescriptionCalculationOptionsByIdApartmentDescriptionCalculationOption) {
        this.apartmentsDescriptionCalculationOptionsByIdApartmentDescriptionCalculationOption = apartmentsDescriptionCalculationOptionsByIdApartmentDescriptionCalculationOption;
    }


    @ManyToOne
    @JoinColumn(name = "id_apartment_description_layout", referencedColumnName = "id_apartment_description_layout", nullable = false)
    public ApartmentsDescriptionLayouts getApartmentsDescriptionLayoutsByIdApartmentDescriptionLayout() {
        return apartmentsDescriptionLayoutsByIdApartmentDescriptionLayout;
    }

    public void setApartmentsDescriptionLayoutsByIdApartmentDescriptionLayout(ApartmentsDescriptionLayouts apartmentsDescriptionLayoutsByIdApartmentDescriptionLayout) {
        this.apartmentsDescriptionLayoutsByIdApartmentDescriptionLayout = apartmentsDescriptionLayoutsByIdApartmentDescriptionLayout;
    }


    @ManyToOne
    @JoinColumn(name = "id_apartment_description_living_condition", referencedColumnName = "id_apartment_description_living_condition", nullable = false)
    public ApartmentsDescriptionLivingConditions getApartmentsDescriptionLivingConditionsByIdApartmentDescriptionLivingCondition() {
        return apartmentsDescriptionLivingConditionsByIdApartmentDescriptionLivingCondition;
    }

    public void setApartmentsDescriptionLivingConditionsByIdApartmentDescriptionLivingCondition(ApartmentsDescriptionLivingConditions apartmentsDescriptionLivingConditionsByIdApartmentDescriptionLivingCondition) {
        this.apartmentsDescriptionLivingConditionsByIdApartmentDescriptionLivingCondition = apartmentsDescriptionLivingConditionsByIdApartmentDescriptionLivingCondition;
    }


    @ManyToOne
    @JoinColumn(name = "id_apartment_description_balcony", referencedColumnName = "id_apartment_description_balcony", nullable = false)
    public ApartmentsDescriptionBalconies getApartmentsDescriptionBalconiesByIdApartmentDescriptionBalcony() {
        return apartmentsDescriptionBalconiesByIdApartmentDescriptionBalcony;
    }

    public void setApartmentsDescriptionBalconiesByIdApartmentDescriptionBalcony(ApartmentsDescriptionBalconies apartmentsDescriptionBalconiesByIdApartmentDescriptionBalcony) {
        this.apartmentsDescriptionBalconiesByIdApartmentDescriptionBalcony = apartmentsDescriptionBalconiesByIdApartmentDescriptionBalcony;
    }


    @ManyToOne
    @JoinColumn(name = "id_apartment_description_agent_commission", referencedColumnName = "id_apartment_description_agent_commission", nullable = false)
    public ApartmentsDescriptionAgentCommissions getApartmentsDescriptionAgentCommissionsByIdApartmentDescriptionAgentCommission() {
        return apartmentsDescriptionAgentCommissionsByIdApartmentDescriptionAgentCommission;
    }

    public void setApartmentsDescriptionAgentCommissionsByIdApartmentDescriptionAgentCommission(ApartmentsDescriptionAgentCommissions apartmentsDescriptionAgentCommissionsByIdApartmentDescriptionAgentCommission) {
        this.apartmentsDescriptionAgentCommissionsByIdApartmentDescriptionAgentCommission = apartmentsDescriptionAgentCommissionsByIdApartmentDescriptionAgentCommission;
    }


    @ManyToOne
    @JoinColumn(name = "id_apartment_description_way_of_communication", referencedColumnName = "id_apartment_description_way_of_communication", nullable = false)
    public ApartmentsDescriptionWaysOfCommunication getApartmentsDescriptionWaysOfCommunicationByIdApartmentDescriptionWayOfCommunication() {
        return apartmentsDescriptionWaysOfCommunicationByIdApartmentDescriptionWayOfCommunication;
    }

    public void setApartmentsDescriptionWaysOfCommunicationByIdApartmentDescriptionWayOfCommunication(ApartmentsDescriptionWaysOfCommunication apartmentsDescriptionWaysOfCommunicationByIdApartmentDescriptionWayOfCommunication) {
        this.apartmentsDescriptionWaysOfCommunicationByIdApartmentDescriptionWayOfCommunication = apartmentsDescriptionWaysOfCommunicationByIdApartmentDescriptionWayOfCommunication;
    }
}
