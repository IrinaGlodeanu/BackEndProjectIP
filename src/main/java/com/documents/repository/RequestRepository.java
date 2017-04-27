package com.documents.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Elena Hardon
 * @date 4/27/17.
 */

@Repository
public interface RequestRepository extends CrudRepository<RequestRepository, Long> {
}
