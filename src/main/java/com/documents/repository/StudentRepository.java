package com.documents.repository;

import com.documents.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Elena Hardon
 * @date 4/27/17.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
