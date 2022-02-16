package com.project.swipe.repository;

import com.project.swipe.model.ApartmentsDescriptionLayouts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apartments-description-layouts", path = "apartments-description-layouts")
public interface ApartmentsDescriptionLayoutsRepository extends JpaRepository<ApartmentsDescriptionLayouts, Integer> {

}
