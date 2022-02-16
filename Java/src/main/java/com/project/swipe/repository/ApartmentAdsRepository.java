package com.project.swipe.repository;

import com.project.swipe.model.ApartmentAds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apartment-ads", path = "apartment-ads")
public interface ApartmentAdsRepository extends JpaRepository<ApartmentAds, Integer> {
}
