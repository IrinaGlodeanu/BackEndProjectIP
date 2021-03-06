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

import com.documents.models.DiplomaDocumentRequest;
import com.documents.repositories.DiplomaDocumentRequestRepository;
import com.documents.services.DiplomaDocumentRequestServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DiplomaDocumentRequestServiceTest {

    @Mock
    DiplomaDocumentRequestRepository diplomaDocumentRequestRepository;

    @InjectMocks
    private DiplomaDocumentRequestServiceImpl diplomaDocumentRequestService = new DiplomaDocumentRequestServiceImpl();

    @Before
    public void initializeMockito() {
        MockitoAnnotations.initMocks(this);
    }

    public void setup(DiplomaDocumentRequest diplomaDocumentRequest) {
        diplomaDocumentRequest.setId((long) 3);
        diplomaDocumentRequest.setDocumentName("Document_name");
        diplomaDocumentRequest.setStudentName("Student_name");
        diplomaDocumentRequest.setCurrentYear(2015);
        diplomaDocumentRequest.setYearOfStudy(2);
    }

    @Test
    public void behavioural_diplomaRequest_save_should_return_true() throws Exception {

        //Act
        DiplomaDocumentRequest diplomaDocumentRequestAfterSave ;
        DiplomaDocumentRequest diplomaDocumentRequestToSave = new DiplomaDocumentRequest();

        setup(diplomaDocumentRequestToSave);

        when(diplomaDocumentRequestService.save(any(DiplomaDocumentRequest.class))).thenReturn(diplomaDocumentRequestToSave);

        diplomaDocumentRequestAfterSave = diplomaDocumentRequestService.save(diplomaDocumentRequestToSave);

        //Assert
        assertNotNull(diplomaDocumentRequestAfterSave);
    }

    @Test
    public void functionality_diplomaRequest_save_should_return_diplomaRequest() throws Exception {
        //Act
        DiplomaDocumentRequest diplomaDocumentRequestAfterSave ;
        DiplomaDocumentRequest diplomaDocumentRequestToSave = new DiplomaDocumentRequest();

        setup(diplomaDocumentRequestToSave);

        when(diplomaDocumentRequestService.save(any(DiplomaDocumentRequest.class))).thenReturn(diplomaDocumentRequestToSave);

        diplomaDocumentRequestAfterSave=diplomaDocumentRequestService.save(diplomaDocumentRequestToSave);

        //Assert
        assertEquals(Long.valueOf(3),diplomaDocumentRequestAfterSave.getId());
        assertEquals("Document_name",diplomaDocumentRequestAfterSave.getDocumentName());
        assertEquals("Student_name",diplomaDocumentRequestAfterSave.getStudentName());
        assertEquals(Integer.valueOf(2015),diplomaDocumentRequestAfterSave.getCurrentYear());
        assertEquals(Integer.valueOf(2),diplomaDocumentRequestAfterSave.getYearOfStudy());
    }
    @Test
    public void behavioral_diplomaRequest_findById_should_return_true() throws Exception {
        //Act
        DiplomaDocumentRequest diplomaDocumentRequestToFind = new DiplomaDocumentRequest();

        when(diplomaDocumentRequestRepository.findOne(any(long.class))).thenReturn(diplomaDocumentRequestToFind);
        diplomaDocumentRequestToFind = diplomaDocumentRequestService.findById((long) 3);

        //Assert
        assertNotNull(diplomaDocumentRequestToFind);
    }
    @Test
    public void functionality_diplomaRequest_findById_should_return_diplomaRequest() throws Exception  {
        //Act
        DiplomaDocumentRequest foundDiplomaRecForm;
        DiplomaDocumentRequest diplomaDocumentRequestToFind = new DiplomaDocumentRequest();

        setup(diplomaDocumentRequestToFind);

        when(diplomaDocumentRequestRepository.findOne(any(long.class))).thenReturn(diplomaDocumentRequestToFind);

        foundDiplomaRecForm = diplomaDocumentRequestService.findById((long) 3);

        //Assert
        assertEquals(Long.valueOf(3), foundDiplomaRecForm.getId());
        assertEquals("Document_name", foundDiplomaRecForm.getDocumentName());
        assertEquals("Student_name", foundDiplomaRecForm.getStudentName());
        assertEquals(Integer.valueOf(2015), foundDiplomaRecForm.getCurrentYear());
        assertEquals(Integer.valueOf(2), foundDiplomaRecForm.getYearOfStudy());
    }


    @Test
    public void behavioural_diplomaRequest_deleteById_should_return_true() throws Exception  {
        //Act
        DiplomaDocumentRequest foundDiplomaRecForm;
        DiplomaDocumentRequest diplomaDocumentRequestToFind = new DiplomaDocumentRequest();

        diplomaDocumentRequestToFind.setId((long)3);
        diplomaDocumentRequestService.delete(diplomaDocumentRequestToFind.getId());

        foundDiplomaRecForm = diplomaDocumentRequestService.findById((long) 3);

        //Assert
        assertNull(foundDiplomaRecForm);
    }
    @Test
    public void functionality_diplomaRequest_deleteById_should_delete_diplomaRequest() throws Exception {
        //Act
        DiplomaDocumentRequest diplomaDocumentRequest=new DiplomaDocumentRequest();

        diplomaDocumentRequestService.delete(diplomaDocumentRequest.getId());

        //Assert
        verify(diplomaDocumentRequestRepository).delete(diplomaDocumentRequest.getId());
    }

    @Test
    public void behavioural_diplomaRequest_findAll_should_return_true() throws Exception {
        //Act
        List<DiplomaDocumentRequest> diplomaDocumentRequestList = new ArrayList<>();
        DiplomaDocumentRequest diplomaDocumentRequest = new DiplomaDocumentRequest();

        setup(diplomaDocumentRequest);

        when(diplomaDocumentRequestRepository.findAll()).thenReturn(diplomaDocumentRequestList);

        diplomaDocumentRequestList.add(diplomaDocumentRequest);

        List<DiplomaDocumentRequest> foundedList = diplomaDocumentRequestService.findAll();

        //Assert
        assertNotNull(foundedList);
    }

    @Test
    public void functionality_diplomaRequest_findAll_should_return_list_of_diplomaRequests() throws Exception {
        //Act
        List<DiplomaDocumentRequest> diplomaDocumentRequestList = new ArrayList<>();
        DiplomaDocumentRequest diplomaDocumentRequest = new DiplomaDocumentRequest();

        setup(diplomaDocumentRequest);

        when(diplomaDocumentRequestRepository.findAll()).thenReturn(diplomaDocumentRequestList);

        diplomaDocumentRequestList.add(diplomaDocumentRequest);

        List<DiplomaDocumentRequest> foundedList = diplomaDocumentRequestService.findAll();

        //Assert
        assertEquals(diplomaDocumentRequestList.get(0).getId(), foundedList.get(0).getId());
        assertEquals(diplomaDocumentRequestList.get(0).getDocumentName(), foundedList.get(0).getDocumentName());
        assertEquals(diplomaDocumentRequestList.get(0).getStudentName(), foundedList.get(0).getStudentName());
        assertEquals(diplomaDocumentRequestList.get(0).getCurrentYear(), foundedList.get(0).getCurrentYear());
        assertEquals(diplomaDocumentRequestList.get(0).getYearOfStudy(), foundedList.get(0).getYearOfStudy());

    }

}
