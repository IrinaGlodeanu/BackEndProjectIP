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

import com.documents.models.DiplomaDocumentRequest;
import com.documents.repositories.DiplomaDocumentRequestRepository;
import com.documents.services.DiplomaDocumentRequestServiceImpl;

/**
 * Created by pc on 5/25/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class DiplomaDocumentRequestServiceTest {

    @Mock
    DiplomaDocumentRequestRepository diplomaDocumentRequestRepository;

    @InjectMocks
    private DiplomaDocumentRequestServiceImpl diplomaDocumentRequestService = new DiplomaDocumentRequestServiceImpl();


    @Test
    public void diplomaDocumentRequest_save_should_return_true() {

        DiplomaDocumentRequest diplomaDocumentRequestToSave = new DiplomaDocumentRequest();
        Long id = (long) 3;
        String documentName = "DocName";
        String studentName = "Student";
        Integer currentYear = 2107;
        Integer yearOfStudy = 2;
        DiplomaDocumentRequest diplomaDocumentRequestAfterSave = new DiplomaDocumentRequest();

        diplomaDocumentRequestToSave.setId(id);
        diplomaDocumentRequestToSave.setDocumentName(documentName);
        diplomaDocumentRequestToSave.setStudentName(studentName);
        diplomaDocumentRequestToSave.setCurrentYear(currentYear);
        diplomaDocumentRequestToSave.setYearOfStudy(yearOfStudy);

        when(diplomaDocumentRequestService.save(any(DiplomaDocumentRequest.class))).thenReturn(diplomaDocumentRequestToSave);


        diplomaDocumentRequestAfterSave = diplomaDocumentRequestService.save(diplomaDocumentRequestToSave);

        assertNotNull(diplomaDocumentRequestAfterSave);
        assertEquals(id, diplomaDocumentRequestAfterSave.getId());
        assertEquals(documentName, diplomaDocumentRequestAfterSave.getDocumentName());
        assertEquals(studentName, diplomaDocumentRequestAfterSave.getStudentName());
        assertEquals(currentYear, diplomaDocumentRequestAfterSave.getCurrentYear());
        assertEquals(yearOfStudy, diplomaDocumentRequestAfterSave.getYearOfStudy());
    }


    @Test
    public void diplomaDocumentRequest_deleteById_should_return_true() {
        Long id = (long) 3;


        DiplomaDocumentRequest diplomaDocumentRequestToDelete = new DiplomaDocumentRequest();
        diplomaDocumentRequestToDelete.setId(id);

        diplomaDocumentRequestService.delete(diplomaDocumentRequestToDelete.getId());

        verify(diplomaDocumentRequestRepository).delete(diplomaDocumentRequestToDelete.getId());

    }


    @Test
    public void diplomaDocumentRequest_findById_should_return_true() {
        DiplomaDocumentRequest diplomaDocumentRequestAfterFind = new DiplomaDocumentRequest();

        Long id = (long) 3;

        diplomaDocumentRequestAfterFind.setId(id);

        when(diplomaDocumentRequestService.findById(id)).thenReturn(diplomaDocumentRequestAfterFind);

        DiplomaDocumentRequest newDiplomaRequest = diplomaDocumentRequestService.findById(id);

        assertNotNull(newDiplomaRequest);
        assertEquals(id, newDiplomaRequest.getId());

    }


//    //not quite right
//    @Test
//    public void diplomaDocumentRequest_findAll_should_return_true()
//    {
//        List<DiplomaDocumentRequest> listOfDiplomaRequests= new ArrayList();
//
//        DiplomaDocumentRequest diplomaDocumentRequestAfterFind = new DiplomaDocumentRequest();
//
//        when(diplomaDocumentRequestService.findAll()).thenReturn(listOfDiplomaRequests);
//
//        listOfDiplomaRequests=diplomaDocumentRequestService.findAll();
//
///*
//        DiplomaDocumentRequest newDiplomaRequest= diplomaDocumentRequestService.findById(id);
//
//        listOfDiplomaRequests.add(newDiplomaRequest);
//*/
//
//
//        Long id;
//
//        for(int i=0; i<listOfDiplomaRequests.size(); i++)
//        {
//            for(DiplomaDocumentRequest diploma: listOfDiplomaRequests) {
//                assertNotNull(diploma);
//                id = diploma.getId();
//                assertEquals(id, listOfDiplomaRequests.get(i).getId());
//            }
//        }
//
//
//    }


}
