package com.project.swipe.repository;


import com.project.swipe.model.ApartmentsDescriptionAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apartments-description-appointments", path = "apartments-description-appointments")
public interface ApartmentsDescriptionAppointmentsRepository extends JpaRepository<ApartmentsDescriptionAppointments, Integer> {

}
