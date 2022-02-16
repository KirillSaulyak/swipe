package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexesCommunalPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-communal-payments", path = "residential-complexes-communal-payments")
public interface ResidentialComplexesCommunalPaymentsRepository extends JpaRepository<ResidentialComplexesCommunalPayments, Integer> {

}
