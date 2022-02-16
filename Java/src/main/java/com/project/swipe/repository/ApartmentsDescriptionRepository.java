package com.project.swipe.repository;

import com.project.swipe.model.ApartmentsDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apartments-description", path = "apartments-description")
public interface ApartmentsDescriptionRepository extends JpaRepository<ApartmentsDescription, Integer> {
}
