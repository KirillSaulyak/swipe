package com.project.swipe.repository;

import com.project.swipe.model.ResidentialComplexesSalesDepartments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "residential-complexes-sales-departments", path = "residential-complexes-sales-departments")
public interface ResidentialComplexesSalesDepartmentsRepository extends JpaRepository<ResidentialComplexesSalesDepartments, Integer> {

}
