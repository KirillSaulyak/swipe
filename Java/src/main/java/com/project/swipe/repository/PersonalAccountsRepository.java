package com.project.swipe.repository;

import com.project.swipe.model.PersonalAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "personal-accounts", path = "personal-accounts")
public interface PersonalAccountsRepository extends JpaRepository<PersonalAccounts, Integer> {
}
