package com.project.swipe.repository;

import com.project.swipe.model.ApartmentsDescriptionNumberOfRooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apartments-description-number-of-rooms", path = "apartments-description-number-of-rooms")
public interface ApartmentsDescriptionNumberOfRoomsRepository extends JpaRepository<ApartmentsDescriptionNumberOfRooms, Integer> {

}
