package com.project.swipe.repository;

import com.project.swipe.model.Agents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "agents", path = "agents")
public interface AgentsRepository extends JpaRepository<Agents, Integer> {

}

