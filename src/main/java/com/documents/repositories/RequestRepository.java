package com.documents.repositories;

import com.documents.models.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Elena Hardon
 * @date 4/27/17.
 */

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> { // gresisei aici cand ai pus autocomplete
}
