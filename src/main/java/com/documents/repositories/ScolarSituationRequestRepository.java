package com.documents.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.documents.models.ScolarSituationDocument;
import com.documents.models.Student;

@Repository
public interface ScolarSituationRequestRepository extends CrudRepository<ScolarSituationDocument, Long> {

    ScolarSituationDocument findByStudentId(Long id);
}
