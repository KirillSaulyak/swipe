package com.project.swipe.repository;

import com.project.swipe.model.Apartments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apartments", path = "apartments")
public interface ApartmentsRepository extends JpaRepository<Apartments, Integer> {
}
