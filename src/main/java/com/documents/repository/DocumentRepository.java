package com.documents.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.documents.models.Document;

/**
 * @author Elena Hardon
 * @date 4/27/17.
 */
@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {
}
