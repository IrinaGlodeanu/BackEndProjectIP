package com.documents;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.documents.models.Student;
import com.documents.repositories.StudentRepository;
import com.documents.services.StudentServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {


    //Arrange
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

    @Before
    public void initializeMockito() {
        MockitoAnnotations.initMocks(this);
    }


    public void setup(Student student) {

        student.setId((long) 3);
        student.setMantricolNumber("123412123123");
        student.setFirstName("FirstName");
        student.setLastName("LastName");
        student.setCnp((long) 91781379);
        student.setIdentityCardId("MX687632");
        student.setFatherInitial("F.I.");
        student.setAddress("The whole Address");
        student.setWebmail("FirstName.LastName@info.uaic.ro");
        student.setBirthDate("12-June-2015");
        student.setPassword("pass");

    }

    @Test
    public void behavioural_student_save_should_return_true() throws Exception {

        //Act
        Student studentAfterSave = new Student();
        Student studentToSave = new Student();

        setup(studentToSave);

        when(studentRepository.save(any(Student.class))).thenReturn(studentAfterSave);

        studentAfterSave = studentServiceImpl.save(studentToSave);

        //Assert
        assertNotNull(studentAfterSave);
    }

    @Test
    public void functionality_student_save_should_return_student() throws Exception {

        //Act
        Student studentAfterSave = new Student();

        setup(studentAfterSave);

        when(studentRepository.save(any(Student.class))).thenReturn(studentAfterSave);

        Student savedStudent = studentServiceImpl.save(studentAfterSave);

        //Assert
        assertEquals(Long.valueOf(3), savedStudent.getId());
        assertEquals("123412123123", savedStudent.getMantricolNumber());
        assertEquals("FirstName", savedStudent.getFirstName());
        assertEquals("LastName", savedStudent.getLastName());
        assertEquals(Long.valueOf(91781379), savedStudent.getCnp());
        assertEquals("MX687632", savedStudent.getIdentityCardId());
        assertEquals("F.I.", savedStudent.getFatherInitial());
        assertEquals("The whole Address", savedStudent.getAddress());
        assertEquals("FirstName.LastName@info.uaic.ro", savedStudent.getWebmail());
        assertEquals("12-June-2015", savedStudent.getBirthDate());
        assertEquals("pass", savedStudent.getPassword());

    }

    @Test
    public void behavioural_student_findById_should_return_true() throws Exception {

        //Act
        Student studentToFind = new Student();

        when(studentRepository.findOne(any(long.class))).thenReturn(studentToFind);

        studentToFind = studentServiceImpl.findById((long) 123);

        //Assert
        assertNotNull(studentToFind);
    }

    @Test
    public void functionality_student_findById_should_return_student() throws Exception {

        //Act
        Student studentToFind = new Student();

        setup(studentToFind);

        when(studentRepository.findOne(any(long.class))).thenReturn(studentToFind);

        Student foundStudent = studentServiceImpl.findById((long) 3);

        //Assert
        assertEquals(Long.valueOf(3), foundStudent.getId());
        assertEquals("123412123123", foundStudent.getMantricolNumber());
        assertEquals("FirstName", foundStudent.getFirstName());
        assertEquals("LastName", foundStudent.getLastName());
        assertEquals(Long.valueOf(91781379), foundStudent.getCnp());
        assertEquals("MX687632", foundStudent.getIdentityCardId());
        assertEquals("F.I.", foundStudent.getFatherInitial());
        assertEquals("The whole Address", foundStudent.getAddress());
        assertEquals("FirstName.LastName@info.uaic.ro", foundStudent.getWebmail());
        assertEquals("12-June-2015", foundStudent.getBirthDate());
        assertEquals("pass", foundStudent.getPassword());

    }

    @Test
    public void behavioural_student_deleteById_should_return_true() throws Exception {

        //Act
        Student student = new Student();

        student.setId((long) 3);

        studentServiceImpl.delete(student.getId());

        Student foundStudentToDelete = studentServiceImpl.findById((long) 3);

        //Assert
        assertNull(foundStudentToDelete);

    }


    @Test
    public void functionality_student_deleteById_should_delete_student() throws Exception {

        //Act
        Student student = new Student();

        studentServiceImpl.delete(student.getId());

        //Assert
        verify(studentRepository).delete(student.getId());

    }

    @Test
    public void behavioural_licenseRequest_findAll_should_return_true() throws Exception {

        //Act
        List<Student> students = new ArrayList<>();

        Student student = new Student();

        setup(student);

        when(studentRepository.findAll()).thenReturn(students);

        students.add(student);

        List<Student> foundStudents;
        foundStudents = studentServiceImpl.findAll();

        //Assert
        assertNotNull(foundStudents);

    }

    @Test
    public void functionality_licenseRequest_findAll_should_return_list_of_licenseRequest() throws Exception {

        //Act
        List<Student> students = new ArrayList<>();

        Student student = new Student();

        setup(student);

        when(studentRepository.findAll()).thenReturn(students);

        students.add(student);

        List<Student> foundStudents;
        foundStudents = studentServiceImpl.findAll();

        //Assert
        assertEquals(students.get(0).getId(), foundStudents.get(0).getId());
        assertEquals(students.get(0).getMantricolNumber(), foundStudents.get(0).getMantricolNumber());
        assertEquals(students.get(0).getFirstName(), foundStudents.get(0).getFirstName());
        assertEquals(students.get(0).getLastName(), foundStudents.get(0).getLastName());
        assertEquals(students.get(0).getCnp(), foundStudents.get(0).getCnp());
        assertEquals(students.get(0).getIdentityCardId(), foundStudents.get(0).getIdentityCardId());
        assertEquals(students.get(0).getFatherInitial(), foundStudents.get(0).getFatherInitial());
        assertEquals(students.get(0).getAddress(), foundStudents.get(0).getAddress());
        assertEquals(students.get(0).getWebmail(), foundStudents.get(0).getWebmail());
        assertEquals(students.get(0).getBirthDate(), foundStudents.get(0).getBirthDate());
        assertEquals(students.get(0).getPassword(), foundStudents.get(0).getPassword());

    }

}
