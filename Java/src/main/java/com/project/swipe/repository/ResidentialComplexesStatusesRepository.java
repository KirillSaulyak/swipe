package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexesStatuses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-statuses", path = "residential-complexes-statuses")
public interface ResidentialComplexesStatusesRepository extends JpaRepository<ResidentialComplexesStatuses, Integer> {

}
