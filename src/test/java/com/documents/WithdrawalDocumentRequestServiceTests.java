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

import com.documents.models.WithdrawalDocumentRequest;
import com.documents.repositories.WithdrawalDocumentRequestRepository;
import com.documents.services.WithdrawalDocumentRequestServiceImpl;

/**
 * Created by pc on 5/25/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class WithdrawalDocumentRequestServiceTests {

    @Mock
    WithdrawalDocumentRequestRepository withdrawalDocumentRequestRepository;

    @InjectMocks
    private WithdrawalDocumentRequestServiceImpl withdrawalDocumentRequestService = new WithdrawalDocumentRequestServiceImpl();


    @Test
    public void withdrawalDocumentRequest_save_should_return_true() {

        WithdrawalDocumentRequest withdrawalDocumentRequestToSave = new WithdrawalDocumentRequest();
        Long id = (long) 3;
        String documentName = "DocName";
        String studentName = "Student";
        String series = "1234";
        int numberIDCard = 12345;
        int studyYear = 201772;
        int universityYear = 3;
        String typeOfCourses = "POO";
        String approveReason = "winter break";
        String date = "05.05.2017";
        String signature = "signature";
        String seriesBAC = "seriesBAC";
        int numberBAC = 11111;
        int numberSheet = 1111;

        WithdrawalDocumentRequest withdrawalDocumentRequestAfterSave = new WithdrawalDocumentRequest();

        withdrawalDocumentRequestToSave.setId(id);
        withdrawalDocumentRequestToSave.setDocumentName(documentName);
        withdrawalDocumentRequestToSave.setStudentName(studentName);
        withdrawalDocumentRequestToSave.setSeries(series);
        withdrawalDocumentRequestToSave.setApproveReason(approveReason);
        withdrawalDocumentRequestToSave.setDate(date);
        withdrawalDocumentRequestToSave.setNumberBAC(numberBAC);
        withdrawalDocumentRequestToSave.setNumberIDCard(numberIDCard);
        withdrawalDocumentRequestToSave.setSeriesBAC(seriesBAC);
        withdrawalDocumentRequestToSave.setSignature(signature);
        withdrawalDocumentRequestToSave.setNumberSheet(numberSheet);
        withdrawalDocumentRequestToSave.setStudyYear(studyYear);
        withdrawalDocumentRequestToSave.setUniversityYear(universityYear);
        withdrawalDocumentRequestToSave.setTypeOfCourses(typeOfCourses);

        when(withdrawalDocumentRequestService.save(any(WithdrawalDocumentRequest.class))).thenReturn(withdrawalDocumentRequestToSave);


        withdrawalDocumentRequestAfterSave = withdrawalDocumentRequestService.save(withdrawalDocumentRequestToSave);

        assertNotNull(withdrawalDocumentRequestAfterSave);
        assertEquals(id, withdrawalDocumentRequestAfterSave.getId());
        assertEquals(documentName, withdrawalDocumentRequestAfterSave.getDocumentName());
        assertEquals(studentName, withdrawalDocumentRequestAfterSave.getStudentName());
        assertEquals(series, withdrawalDocumentRequestAfterSave.getSeries());
        assertEquals(numberIDCard, withdrawalDocumentRequestAfterSave.getNumberIDCard());
        assertEquals(studyYear, withdrawalDocumentRequestAfterSave.getStudyYear());
        assertEquals(universityYear, withdrawalDocumentRequestAfterSave.getUniversityYear());
        assertEquals(typeOfCourses, withdrawalDocumentRequestAfterSave.getTypeOfCourses());
        assertEquals(approveReason, withdrawalDocumentRequestAfterSave.getApproveReason());
        assertEquals(date, withdrawalDocumentRequestAfterSave.getDate());
        assertEquals(signature, withdrawalDocumentRequestAfterSave.getSignature());
        assertEquals(seriesBAC, withdrawalDocumentRequestAfterSave.getSeriesBAC());
        assertEquals(numberBAC, withdrawalDocumentRequestAfterSave.getNumberBAC());
        assertEquals(numberSheet, withdrawalDocumentRequestAfterSave.getNumberSheet());
    }

    @Test
    public void withdrawalDocumentRequest_deleteById_should_return_true() {
        Long id = (long) 3;


        WithdrawalDocumentRequest withdrawalDocumentRequestToDelete = new WithdrawalDocumentRequest();
        withdrawalDocumentRequestToDelete.setId(id);

        withdrawalDocumentRequestService.delete(withdrawalDocumentRequestToDelete.getId());

        verify(withdrawalDocumentRequestRepository).delete(withdrawalDocumentRequestToDelete.getId());

    }


    @Test
    public void withdrawalDocumentRequest_findById_should_return_true() {
        WithdrawalDocumentRequest withdrawalDocumentRequestAfterFind = new WithdrawalDocumentRequest();

        Long id = (long) 3;

        withdrawalDocumentRequestAfterFind.setId(id);

        when(withdrawalDocumentRequestService.findById(id)).thenReturn(withdrawalDocumentRequestAfterFind);

        WithdrawalDocumentRequest newWithdrawalRequest = withdrawalDocumentRequestService.findById(id);

        assertNotNull(newWithdrawalRequest);
        assertEquals(id, newWithdrawalRequest.getId());

    }


}
