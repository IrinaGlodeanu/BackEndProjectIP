package com.documents.service;

import com.documents.entity.Student;
import com.documents.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elena Hardon
 * @date 4/27/17.
 */
public class StudentServiceImpl implements StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student entity) {
        return this.studentRepository.save(entity);
    }

    @Override
    public Student findById(Long id) {
        return this.studentRepository.findOne(id);
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        for (Student student : this.studentRepository.findAll()) {
            students.add(student);
        }
        return students;
    }

    @Override
    public void delete(Long id) {
        this.studentRepository.delete(id);
    }
}
