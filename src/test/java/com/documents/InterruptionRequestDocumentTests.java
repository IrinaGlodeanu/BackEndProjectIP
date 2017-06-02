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

import com.documents.models.InterruptionRequestDocument;
import com.documents.repositories.InterruptionRequestDocumentRepository;
import com.documents.services.InterruptionRequestDocumentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class InterruptionRequestDocumentTests {


    //Arrange
    @Mock
    private InterruptionRequestDocumentRepository interruptionRequestDocumentRepository;

    @InjectMocks
    private InterruptionRequestDocumentServiceImpl interruptionRequestDocumentServiceImpl = new InterruptionRequestDocumentServiceImpl();

    @Before
    public void initializeMockito() {
        MockitoAnnotations.initMocks(this);
    }


    public void setup(InterruptionRequestDocument interruptionRequestDocumentToSet) {

        interruptionRequestDocumentToSet.setId((long) 3);
        interruptionRequestDocumentToSet.setDocumentName("Document_Name");
        interruptionRequestDocumentToSet.setStudentName("Student_Name");
        interruptionRequestDocumentToSet.setCurrentYear(2);
        interruptionRequestDocumentToSet.setYearOfStudy(2017);
        interruptionRequestDocumentToSet.setStartingSemester(2);
        interruptionRequestDocumentToSet.setFromUniversityYear(2018);
        interruptionRequestDocumentToSet.setNumberOfSemesters(2);

    }

    @Test
    public void behavioural_interruptionRequest_save_should_return_true() throws Exception {

        //Act
        InterruptionRequestDocument interruptionRequestDocumentAfterSave = new InterruptionRequestDocument();
        InterruptionRequestDocument interruptionRequestDocumentToSave = new InterruptionRequestDocument();

        setup(interruptionRequestDocumentToSave);

        when(interruptionRequestDocumentRepository.save(any(InterruptionRequestDocument.class))).thenReturn(interruptionRequestDocumentAfterSave);

        interruptionRequestDocumentAfterSave = interruptionRequestDocumentServiceImpl.save(interruptionRequestDocumentToSave);

        //Assert
        assertNotNull(interruptionRequestDocumentAfterSave);
    }

    @Test
    public void functionality_interruptionRequest_save_should_return_interruptionRequest() throws Exception {

        //Act
        InterruptionRequestDocument interruptionRequestDocumentAfterSave = new InterruptionRequestDocument();

        setup(interruptionRequestDocumentAfterSave);

        when(interruptionRequestDocumentRepository.save(any(InterruptionRequestDocument.class))).thenReturn(interruptionRequestDocumentAfterSave);

        InterruptionRequestDocument savedInterruptionRequest = interruptionRequestDocumentServiceImpl.save(interruptionRequestDocumentAfterSave);

        //Assert
        assertEquals(Long.valueOf(3), savedInterruptionRequest.getId());
        assertEquals("Document_Name", savedInterruptionRequest.getDocumentName());
        assertEquals("Student_Name", savedInterruptionRequest.getStudentName());
        assertEquals(Integer.valueOf(2), savedInterruptionRequest.getCurrentYear());
        assertEquals(Integer.valueOf(2017), savedInterruptionRequest.getYearOfStudy());
        assertEquals(Integer.valueOf(2), savedInterruptionRequest.getStartingSemester());
        assertEquals(Integer.valueOf(2018), savedInterruptionRequest.getFromUniversityYear());
        assertEquals(Integer.valueOf(2), savedInterruptionRequest.getNumberOfSemesters());

    }

    @Test
    public void behavioural_interruptionRequest_findById_should_return_true() throws Exception {

        //Act
        InterruptionRequestDocument interruptionRequestDocumentToFind = new InterruptionRequestDocument();

        when(interruptionRequestDocumentRepository.findOne(any(long.class))).thenReturn(interruptionRequestDocumentToFind);

        interruptionRequestDocumentToFind = interruptionRequestDocumentServiceImpl.findById((long) 123);

        //Assert
        assertNotNull(interruptionRequestDocumentToFind);
    }

    @Test
    public void functionality_interruptionRequest_findById_should_return_interruptionRequest() throws Exception {

        //Act
        InterruptionRequestDocument interruptionRequestDocumentToFind = new InterruptionRequestDocument();

        setup(interruptionRequestDocumentToFind);

        when(interruptionRequestDocumentRepository.findOne(any(long.class))).thenReturn(interruptionRequestDocumentToFind);

        InterruptionRequestDocument foundInterruptionRequestDocument = interruptionRequestDocumentServiceImpl.findById((long) 3);

        //Assert
        assertEquals(Long.valueOf(3), foundInterruptionRequestDocument.getId());
        assertEquals("Document_Name", foundInterruptionRequestDocument.getDocumentName());
        assertEquals("Student_Name", foundInterruptionRequestDocument.getStudentName());
        assertEquals(Integer.valueOf(2), foundInterruptionRequestDocument.getCurrentYear());
        assertEquals(Integer.valueOf(2017), foundInterruptionRequestDocument.getYearOfStudy());
        assertEquals(Integer.valueOf(2), foundInterruptionRequestDocument.getStartingSemester());
        assertEquals(Integer.valueOf(2018), foundInterruptionRequestDocument.getFromUniversityYear());
        assertEquals(Integer.valueOf(2), foundInterruptionRequestDocument.getNumberOfSemesters());

    }

    @Test
    public void behavioural_interruptionRequest_deleteById_should_return_true() throws Exception {

        //Act
        InterruptionRequestDocument interruptionRequestDocument = new InterruptionRequestDocument();

        interruptionRequestDocument.setId((long) 3);

        interruptionRequestDocumentServiceImpl.delete(interruptionRequestDocument.getId());

        InterruptionRequestDocument foundInterruptionRequestDocument = interruptionRequestDocumentServiceImpl.findById((long) 3);

        //Assert
        assertNull(foundInterruptionRequestDocument);

    }


    @Test
    public void functionality_interruptionRequest_deleteById_should_delete_interruptionRequest() throws Exception {

        //Act
        InterruptionRequestDocument interruptionRequestDocument = new InterruptionRequestDocument();

        interruptionRequestDocumentServiceImpl.delete(interruptionRequestDocument.getId());

        //Assert
        verify(interruptionRequestDocumentRepository).delete(interruptionRequestDocument.getId());

    }

    @Test
    public void behavioural_interruptionRequest_findAll_should_return_true() throws Exception {

        //Act
        List<InterruptionRequestDocument> interruptionRequestDocuments = new ArrayList<>();

        InterruptionRequestDocument interruptionRequestDocument = new InterruptionRequestDocument();

        setup(interruptionRequestDocument);

        when(interruptionRequestDocumentRepository.findAll()).thenReturn(interruptionRequestDocuments);

        interruptionRequestDocuments.add(interruptionRequestDocument);

        List<InterruptionRequestDocument> foundInterruptionRequests;
        foundInterruptionRequests = interruptionRequestDocumentServiceImpl.findAll();

        //Assert
        assertNotNull(foundInterruptionRequests);

    }

    @Test
    public void functionality_interruptionRequest_findAll_should_return_list_of_interruptionRequest() throws Exception {

        //Act
        List<InterruptionRequestDocument> interruptionRequestDocuments = new ArrayList<>();

        InterruptionRequestDocument interruptionRequestDocument = new InterruptionRequestDocument();

        setup(interruptionRequestDocument);

        when(interruptionRequestDocumentRepository.findAll()).thenReturn(interruptionRequestDocuments);

        interruptionRequestDocuments.add(interruptionRequestDocument);

        List<InterruptionRequestDocument> foundInterruptionRequests;
        foundInterruptionRequests = interruptionRequestDocumentServiceImpl.findAll();

        //Assert
        assertEquals(interruptionRequestDocuments.get(0).getId(), foundInterruptionRequests.get(0).getId());
        assertEquals(interruptionRequestDocuments.get(0).getDocumentName(), foundInterruptionRequests.get(0).getDocumentName());
        assertEquals(interruptionRequestDocuments.get(0).getStudentName(), foundInterruptionRequests.get(0).getStudentName());
        assertEquals(interruptionRequestDocuments.get(0).getCurrentYear(), foundInterruptionRequests.get(0).getCurrentYear());
        assertEquals(interruptionRequestDocuments.get(0).getYearOfStudy(), foundInterruptionRequests.get(0).getYearOfStudy());
        assertEquals(interruptionRequestDocuments.get(0).getStartingSemester(), foundInterruptionRequests.get(0).getStartingSemester());
        assertEquals(interruptionRequestDocuments.get(0).getFromUniversityYear(), foundInterruptionRequests.get(0).getFromUniversityYear());
        assertEquals(interruptionRequestDocuments.get(0).getNumberOfSemesters(), foundInterruptionRequests.get(0).getNumberOfSemesters());

    }

}