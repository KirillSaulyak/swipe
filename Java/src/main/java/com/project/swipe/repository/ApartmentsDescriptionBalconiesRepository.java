package com.project.swipe.repository;

import com.project.swipe.model.ApartmentsDescriptionBalconies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apartments-description-balconies", path = "apartments-description-balconies")
public interface ApartmentsDescriptionBalconiesRepository extends JpaRepository<ApartmentsDescriptionBalconies, Integer> {

}
