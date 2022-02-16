package com.project.swipe.repository;

import com.project.swipe.model.AccountTypeAdmins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "account-type-admins", path = "account-type-admins")
public interface AccountTypeAdminsRepository extends JpaRepository<AccountTypeAdmins, Integer> {
}
