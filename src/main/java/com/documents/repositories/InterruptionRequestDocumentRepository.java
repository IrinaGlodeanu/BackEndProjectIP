package com.documents.repositories;

import org.springframework.data.repository.CrudRepository;

import com.documents.models.Request;
import org.springframework.stereotype.Repository;

/**
 * Created by Simona on 11-May-17.
 */

@Repository
public interface InterruptionRequestDocumentRepository extends CrudRepository<Request, Long> {
}
