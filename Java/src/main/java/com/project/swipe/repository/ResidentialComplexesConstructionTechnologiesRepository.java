package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexesConstructionTechnologies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-construction-technologies", path = "residential-complexes-construction-technologies")
public interface ResidentialComplexesConstructionTechnologiesRepository extends JpaRepository<ResidentialComplexesConstructionTechnologies, Integer> {

}
