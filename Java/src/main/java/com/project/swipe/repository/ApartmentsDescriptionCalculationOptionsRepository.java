package com.project.swipe.repository;

import com.project.swipe.model.ApartmentsDescriptionCalculationOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apartments-description-calculation-options", path = "apartments-description-calculation-options")
public interface ApartmentsDescriptionCalculationOptionsRepository extends JpaRepository<ApartmentsDescriptionCalculationOptions, Integer> {

}
