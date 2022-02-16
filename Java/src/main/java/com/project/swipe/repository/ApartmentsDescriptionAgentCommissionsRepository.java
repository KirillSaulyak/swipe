package com.project.swipe.repository;

import com.project.swipe.model.ApartmentsDescriptionAgentCommissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apartments-description-agent-commissions", path = "apartments-description-agent-commissions")
public interface ApartmentsDescriptionAgentCommissionsRepository extends JpaRepository<ApartmentsDescriptionAgentCommissions, Integer> {

}
