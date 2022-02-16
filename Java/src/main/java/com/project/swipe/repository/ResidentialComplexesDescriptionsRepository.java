package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexesDescriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-descriptions", path = "residential-complexes-descriptions")
public interface ResidentialComplexesDescriptionsRepository extends JpaRepository<ResidentialComplexesDescriptions, Integer> {


}
