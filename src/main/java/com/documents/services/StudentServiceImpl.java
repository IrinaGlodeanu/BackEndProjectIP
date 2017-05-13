package com.documents.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.Student;
import com.documents.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

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


    @Override
    public Student getStudent(String webmail, String password) {
        return studentRepository.findByWebmailAndPassword(webmail, password);
    }
}
