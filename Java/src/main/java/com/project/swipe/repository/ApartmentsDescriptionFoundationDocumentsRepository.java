package com.project.swipe.repository;

import com.project.swipe.model.ApartmentsDescriptionFoundationDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apartments-description-foundation-documents", path = "apartments-description-foundation-documents")
public interface ApartmentsDescriptionFoundationDocumentsRepository extends JpaRepository<ApartmentsDescriptionFoundationDocuments, Integer> {

}
