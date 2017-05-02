package com.documents.controllers;

import com.documents.models.Student;
import com.documents.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Elena Hardon
 * @date 5/2/17.
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> searchStudentById(@PathVariable Long id) {
        Student student = studentService.findById(id);
        if (student != null) {
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }
}
