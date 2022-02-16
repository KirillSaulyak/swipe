package com.project.swipe.repository;

import com.project.swipe.model.ApartmentsBuildings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apartments-buildings", path = "apartments-buildings")
public interface ApartmentsBuildingsRepository extends JpaRepository<ApartmentsBuildings, Integer> {

}
