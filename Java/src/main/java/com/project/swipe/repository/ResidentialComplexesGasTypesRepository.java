package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexesGasTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-gas-types", path = "residential-complexes-gas-types")
public interface ResidentialComplexesGasTypesRepository extends JpaRepository<ResidentialComplexesGasTypes, Integer> {

}
