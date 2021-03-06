package com.documents.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.documents.models.ScolarSituationDocument;

@Repository
public interface ScolarSituationRequestRepository extends CrudRepository<ScolarSituationDocument, Long> {

    ScolarSituationDocument findByStudentId(String id);
}
