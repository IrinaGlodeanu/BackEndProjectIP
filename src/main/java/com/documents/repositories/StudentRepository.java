package com.documents.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.documents.models.Student;


/**
 * @author Elena Hardon
 * @date 4/27/17.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    /**
     * Query that search the webmail and the password(for login)
     *
     * @param webmail
     * @param password
     *
     * @return Student Object
     */
    Student findByWebmailAndPassword(String webmail, String password);

}
