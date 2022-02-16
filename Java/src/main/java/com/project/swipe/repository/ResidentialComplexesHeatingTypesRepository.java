package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexesHeatingTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-heating-types", path = "residential-complexes-heating-types")
public interface ResidentialComplexesHeatingTypesRepository extends JpaRepository<ResidentialComplexesHeatingTypes, Integer> {

}
