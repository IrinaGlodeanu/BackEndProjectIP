package com.documents.services;

import com.documents.models.Student;

public interface StudentService extends CrudService<Student> {

    Student getStudent(String webmail, String password);
}