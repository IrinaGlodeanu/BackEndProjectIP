package com.documents.repositories;

import com.documents.models.Secretary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Elena Hardon
 * @date 4/27/17.
 */
@Repository
public interface SecretaryRepository extends CrudRepository<Secretary, Long> {
}
