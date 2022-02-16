package com.project.swipe.repository;

import com.project.swipe.model.RealEstateTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "real-estate-types", path = "real-estate-types")
public interface RealEstateTypesRepository extends JpaRepository<RealEstateTypes, Integer> {

}
