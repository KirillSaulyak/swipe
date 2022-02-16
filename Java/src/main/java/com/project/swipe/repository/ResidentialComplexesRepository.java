package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "residential-complexes", path = "residential-complexes")
public interface ResidentialComplexesRepository extends JpaRepository<ResidentialComplexes, Integer> {

}
