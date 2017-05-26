package com.documents;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.documents.models.Student;
import com.documents.repositories.StudentRepository;
import com.documents.services.StudentServiceImpl;

/**
 * Created by pc on 5/26/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService = new StudentServiceImpl();

    //to
    @Test
    public void student_save_should_return_true() {

        Student studentToSave = new Student();
        Long id = (long) 3;
        String matricol_nr = "S34Fnks88888";
        String first_name = "FirstName";
        String lastName = "LastName";
        Long cnp = (long) 29837645;
        String identityCardId = "MZ654763";
        String fatherInitial = "A";
        String address = "strada Dreptatii";
        String webmail = "webmail";
        String birthDate = "08.05.1996";
        String password = "password";


        Student studentAfterSave = new Student();

        studentToSave.setId(id);
        studentToSave.setMantricolNumber(matricol_nr);
        studentToSave.setFirstName(first_name);
        studentToSave.setLastName(lastName);
        studentToSave.setCnp(cnp);
        studentToSave.setIdentityCardId(identityCardId);
        studentToSave.setFatherInitial(fatherInitial);
        studentToSave.setWebmail(webmail);
        studentToSave.setBirthDate(birthDate);
        studentToSave.setPassword(password);


        when(studentService.save(any(Student.class))).thenReturn(studentToSave);


        studentAfterSave = studentService.save(studentToSave);

        assertNotNull(studentAfterSave);
        assertEquals(id, studentAfterSave.getId());
        assertEquals(matricol_nr, studentAfterSave.getMantricolNumber());
        assertEquals(first_name, studentAfterSave.getFirstName());
        assertEquals(lastName, studentAfterSave.getLastName());
        assertEquals(cnp, studentAfterSave.getCnp());
        assertEquals(identityCardId, studentAfterSave.getIdentityCardId());
        assertEquals(fatherInitial, studentAfterSave.getFatherInitial());
        assertEquals(webmail, studentAfterSave.getWebmail());
        assertEquals(birthDate, studentAfterSave.getBirthDate());
        assertEquals(password, studentAfterSave.getPassword());


    }


    @Test
    public void student_deleteById_should_return_true() {
        Long id = (long) 3;

        Student studentToDelete = new Student();
        studentToDelete.setId(id);

        studentService.delete(studentToDelete.getId());

        verify(studentRepository).delete(studentToDelete.getId());

    }


    @Test
    public void student_findById_should_return_true() {
        Student studentAfterFind = new Student();

        Long id = (long) 3;

        studentAfterFind.setId(id);

        when(studentService.findById(id)).thenReturn(studentAfterFind);

        Student newStudent = studentService.findById(id);

        assertNotNull(newStudent);
        assertEquals(id, newStudent.getId());

    }


}
