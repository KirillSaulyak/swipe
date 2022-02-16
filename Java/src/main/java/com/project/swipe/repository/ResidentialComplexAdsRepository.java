package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexAds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "residential-complex-ads", path = "residential-complex-ads")
public interface ResidentialComplexAdsRepository extends JpaRepository<ResidentialComplexAds, Integer> {
}
