package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexesAreaTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-area-types", path = "residential-complexes-area-types")
public interface ResidentialComplexesAreaTypesRepository extends JpaRepository<ResidentialComplexesAreaTypes, Integer> {

}
