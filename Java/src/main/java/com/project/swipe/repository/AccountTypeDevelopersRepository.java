package com.project.swipe.repository;

import com.project.swipe.model.AccountTypeDevelopers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "account-type-developers", path = "account-type-developers")
public interface AccountTypeDevelopersRepository extends JpaRepository<AccountTypeDevelopers, Integer> {


}
