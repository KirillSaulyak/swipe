package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexes;
import com.project.swipe.model.ResidentialComplexesGalleries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-galleries", path = "residential-complexes-galleries")
public interface ResidentialComplexesGalleriesRepository extends JpaRepository<ResidentialComplexesGalleries, Integer> {
    List<ResidentialComplexesGalleries> findByResidentialComplexesByIdResidentialComplex(ResidentialComplexes residentialComplexes);
}
