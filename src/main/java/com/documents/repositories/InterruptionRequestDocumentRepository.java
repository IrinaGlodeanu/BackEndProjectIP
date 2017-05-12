package com.documents.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.documents.models.InterruptionRequestDocument;

/**
 * Created by Simona on 11-May-17.
 */

@Repository
public interface InterruptionRequestDocumentRepository extends CrudRepository<InterruptionRequestDocument, Long> {
}
