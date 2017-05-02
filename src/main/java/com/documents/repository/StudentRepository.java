package com.documents.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.documents.models.Student;

/**
 * @author Elena Hardon
 * @date 4/27/17.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
