package com.project.swipe.repository;

import com.project.swipe.model.AccountTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "account-types", path = "account-types")
public interface AccountTypesRepository extends JpaRepository<AccountTypes, Integer> {
}
