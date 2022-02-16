package com.project.swipe.repository;

import com.project.swipe.model.ApartmentsGalleries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apartments-galleries", path = "apartments-galleries")
public interface ApartmentsGalleriesRepository extends JpaRepository<ApartmentsGalleries, Integer> {

}
