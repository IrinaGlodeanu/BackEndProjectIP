package com.documents.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.documents.models.DiplomaDocumentRequest;

@Repository
public interface DiplomaDocumentRequestRepository extends CrudRepository<DiplomaDocumentRequest, Long> {
}
