package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexesTypesHouses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-types-houses", path = "residential-complexes-types-houses")
public interface ResidentialComplexesTypesHousesRepository extends JpaRepository<ResidentialComplexesTypesHouses, Integer> {

}
