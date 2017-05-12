package com.documents.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.documents.models.Request;

/**
 * @author Elena Hardon
 * @date 4/27/17.
 */

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {
}
