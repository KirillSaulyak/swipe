package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexesClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-classes", path = "residential-complexes-classes")
public interface ResidentialComplexesClassesRepository extends JpaRepository<ResidentialComplexesClasses, Integer> {

}
