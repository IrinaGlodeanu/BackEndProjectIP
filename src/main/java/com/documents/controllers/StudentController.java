package com.documents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.documents.models.Student;
import com.documents.services.StudentService;

/**
 * @author Elena Hardon
 * @date 5/2/17.
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Get a specific student with a specific id
     *
     * @param id
     *
     * @return
     */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> searchStudentById(@PathVariable Long id) {
        Student student = studentService.findById(id);
        if (student != null) {
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Return all the students from database
     *
     * @return
     */
    @RequestMapping(value = "/student/all", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> all = studentService.findAll();
        return new ResponseEntity<List<Student>>(all, HttpStatus.OK);
    }

    /**
     * Delete a specific student from database
     *
     * @param id
     *
     * @return
     */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Student student = studentService.findById(id);
        if (student != null) {
            studentService.delete(id);
        } else {
            return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Student>(HttpStatus.OK);
    }

    /**
     * Insert a new student into the database
     *
     * @param newStudent
     *
     * @return
     */

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@RequestBody Student newStudent) {
        Student savedStudent = studentService.save(newStudent);
        return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
    }

    /**
     * Update a student data(change his information in database)
     *
     * @param student
     * @param id
     *
     * @return
     */

    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long id) {
        if (!id.equals(student.getId())) {
            return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
        }
        Student newStudent = studentService.save(student);
        return new ResponseEntity<Student>(newStudent, HttpStatus.OK);
    }
}
