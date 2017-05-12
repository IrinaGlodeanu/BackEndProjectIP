package com.documents.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.documents.models.TransportRequestDocument;

/**
 * Created by Simona on 12-May-17.
 */
@Repository
public interface TransportRequestDocumentRepository extends CrudRepository<TransportRequestDocument, Long> {
}
