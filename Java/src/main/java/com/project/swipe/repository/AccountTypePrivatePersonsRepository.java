package com.project.swipe.repository;

import com.project.swipe.model.AccountTypePrivatePersons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "account-type-private-persons", path = "account-type-private-persons")
public interface AccountTypePrivatePersonsRepository extends JpaRepository<AccountTypePrivatePersons, Integer> {
}
