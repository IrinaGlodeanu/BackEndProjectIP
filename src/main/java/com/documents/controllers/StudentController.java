package com.documents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.documents.models.LoginData;
import com.documents.models.Student;
import com.documents.services.StudentService;

@RestController
@RequestMapping(value = "/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Get a specific student with a specific id
     *
     * @param id of the student you want searched
     *
     * @return the student with that particular id (if exists in the database)
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
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
     * @return a List with all the students that are in the database
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> all = studentService.findAll();
        return new ResponseEntity<List<Student>>(all, HttpStatus.OK);
    }

    /**
     * Delete a specific student from database
     *
     * @param id of the student you want to delete it
     *
     * @return - a status if the student with that id was delete it or not
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
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
     * @param newStudent - a new Student object that you want to insert into the database
     *
     * @return - the newStudent inserted plus a status if was successfully inserted
     */

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@RequestBody Student newStudent) {
        Student savedStudent = studentService.save(newStudent);
        return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
    }

    /**
     * Update a student data(change his information in database)
     *
     * @param student - a new Student Object
     * @param id      - the id of the student where you want to insert new data
     *                You save into the database the changed student object
     *
     * @return return a status if was successfully updated
     */

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long id) {
        if (!id.equals(student.getId())) {
            return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
        }
        Student newStudent = studentService.save(student);
        return new ResponseEntity<Student>(newStudent, HttpStatus.OK);
    }

    /**
     * Get a student object if we find the webmail and password in the database(Login purpose)
     * @return Student Object
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Student> getIdForLogin(@RequestBody LoginData loginData) {
        Student student = studentService.getStudent(loginData);
        if (!student.equals(null)) {
            student.setPassword(null);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }
        return new ResponseEntity<Student>(HttpStatus.UNAUTHORIZED);
    }

}
