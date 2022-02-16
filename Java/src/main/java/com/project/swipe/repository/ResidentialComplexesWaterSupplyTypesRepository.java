package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexesWaterSupplyTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-water-supply-types", path = "residential-complexes-water-supply-types")
public interface ResidentialComplexesWaterSupplyTypesRepository extends JpaRepository<ResidentialComplexesWaterSupplyTypes, Integer> {

}
