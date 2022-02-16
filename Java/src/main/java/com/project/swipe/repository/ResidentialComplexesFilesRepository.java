package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexes;
import com.project.swipe.model.ResidentialComplexesFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-files", path = "residential-complexes-files")
public interface ResidentialComplexesFilesRepository extends JpaRepository<ResidentialComplexesFiles, Integer> {
    List<ResidentialComplexesFiles> findByResidentialComplexesByIdResidentialComplex(ResidentialComplexes residentialComplexes);
}
