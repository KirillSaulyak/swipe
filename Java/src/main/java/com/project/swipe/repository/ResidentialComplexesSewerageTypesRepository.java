package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexesSewerageTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-sewerage-types", path = "residential-complexes-sewerage-types")
public interface ResidentialComplexesSewerageTypesRepository extends JpaRepository<ResidentialComplexesSewerageTypes, Integer> {

}
