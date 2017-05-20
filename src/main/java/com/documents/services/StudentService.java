package com.documents.services;

import com.documents.models.LoginData;
import com.documents.models.Student;

public interface StudentService extends CrudService<Student> {

    /**
     * Function that will be implemented in StudentServieImpl
     *
     * @param student
     *
     * @return
     */
    Student getStudent(LoginData student);
}