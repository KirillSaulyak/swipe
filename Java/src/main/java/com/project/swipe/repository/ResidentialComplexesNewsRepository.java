package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexesNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-news", path = "residential-complexes-news")
public interface ResidentialComplexesNewsRepository extends JpaRepository<ResidentialComplexesNews, Integer> {

}
