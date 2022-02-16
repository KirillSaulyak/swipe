package com.project.swipe.repository;

import com.project.swipe.model.ApartmentsDescriptionLivingConditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apartments-description-living-conditions", path = "apartments-description-living-conditions")
public interface ApartmentsDescriptionLivingConditionsRepository extends JpaRepository<ApartmentsDescriptionLivingConditions, Integer> {

}
