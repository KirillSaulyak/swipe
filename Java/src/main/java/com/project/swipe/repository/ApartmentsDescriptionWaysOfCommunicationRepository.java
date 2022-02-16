package com.project.swipe.repository;

import com.project.swipe.model.ApartmentsDescriptionWaysOfCommunication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apartments-description-ways-of-communication", path = "apartments-description-ways-of-communication")
public interface ApartmentsDescriptionWaysOfCommunicationRepository extends JpaRepository<ApartmentsDescriptionWaysOfCommunication, Integer> {

}
