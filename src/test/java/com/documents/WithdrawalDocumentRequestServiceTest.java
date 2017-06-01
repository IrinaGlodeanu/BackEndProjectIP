package com.documents;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.documents.models.WithdrawalDocumentRequest;
import com.documents.repositories.WithdrawalDocumentRequestRepository;
import com.documents.services.WithdrawalDocumentRequestService;
import com.documents.services.WithdrawalDocumentRequestServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class WithdrawalDocumentRequestServiceTest {

    @Mock
    private WithdrawalDocumentRequestRepository withdrawalDocumentRequestRepository;

    @InjectMocks
    private WithdrawalDocumentRequestServiceImpl withdrawalDocumentRequestServiceImpl = new WithdrawalDocumentRequestServiceImpl();

    @Before
    public void initializedMockito() {
        MockitoAnnotations.initMocks(this);
    }

    public void setup (WithdrawalDocumentRequest withdrawalDocumentRequestToSet) {
        withdrawalDocumentRequestToSet.setId((long)3);
        withdrawalDocumentRequestToSet.setDocumentName("DocName");
        withdrawalDocumentRequestToSet.setStudentId((long)34);
        withdrawalDocumentRequestToSet.setSeries("1234");
        withdrawalDocumentRequestToSet.setApproveReason("reason");
        withdrawalDocumentRequestToSet.setDate("01.06.2017");
        withdrawalDocumentRequestToSet.setNumberBAC((long) 1234);
        withdrawalDocumentRequestToSet.setNumberIDCard((long) 12345);
        withdrawalDocumentRequestToSet.setSeriesBAC("1234");
        withdrawalDocumentRequestToSet.setSignature("signature");
        withdrawalDocumentRequestToSet.setNumberSheet((long) 1234);
        withdrawalDocumentRequestToSet.setStudyYear((long) 2);
        withdrawalDocumentRequestToSet.setUniversityYear((long)2);
        withdrawalDocumentRequestToSet.setTypeOfCourses("IP");
    }

    @Test
    public void behavioural_withdrawalDocumentRequest_save_should_return_true() throws Exception {

        //Act
        WithdrawalDocumentRequest withdrawalDocumentRequestAfterSave = new WithdrawalDocumentRequest();
        WithdrawalDocumentRequest withdrawalDocumentRequestToSave = new WithdrawalDocumentRequest();

        setup(withdrawalDocumentRequestToSave);

        when(withdrawalDocumentRequestRepository.save(any(WithdrawalDocumentRequest.class))).thenReturn(withdrawalDocumentRequestToSave);

        withdrawalDocumentRequestAfterSave = withdrawalDocumentRequestServiceImpl.save(withdrawalDocumentRequestToSave);

        //Assert
        assertNotNull(withdrawalDocumentRequestAfterSave);
    }

    @Test
    public void functionality_withdrawalDocumentRequest_save_should_return_withdrawalDocumentRequest() throws Exception {

        //Act
        WithdrawalDocumentRequest withdrawalDocumentRequestAfterSave = new WithdrawalDocumentRequest();

        setup(withdrawalDocumentRequestAfterSave);

        when(withdrawalDocumentRequestRepository.save(any(WithdrawalDocumentRequest.class))).thenReturn(withdrawalDocumentRequestAfterSave);

        WithdrawalDocumentRequest savedWithdrawalDocumentRequest = withdrawalDocumentRequestServiceImpl.save(withdrawalDocumentRequestAfterSave);

        //Assert
        assertEquals(Long.valueOf(3), savedWithdrawalDocumentRequest.getId());
        assertEquals("DocName", savedWithdrawalDocumentRequest.getDocumentName());
        assertEquals(Long.valueOf(34), savedWithdrawalDocumentRequest.getStudentId());
        assertEquals("1234", savedWithdrawalDocumentRequest.getSeries());
        assertEquals(Long.valueOf(12345), savedWithdrawalDocumentRequest.getNumberIDCard());
        assertEquals(Long.valueOf(2), savedWithdrawalDocumentRequest.getStudyYear());
        assertEquals(Long.valueOf(2), savedWithdrawalDocumentRequest.getUniversityYear());
        assertEquals("IP", savedWithdrawalDocumentRequest.getTypeOfCourses());
        assertEquals("reason", savedWithdrawalDocumentRequest.getApproveReason());
        assertEquals("01.06.2017", savedWithdrawalDocumentRequest.getDate());
        assertEquals("signature", savedWithdrawalDocumentRequest.getSignature());
        assertEquals("1234", savedWithdrawalDocumentRequest.getSeriesBAC());
        assertEquals(Long.valueOf(1234), savedWithdrawalDocumentRequest.getNumberBAC());
        assertEquals(Long.valueOf(1234), savedWithdrawalDocumentRequest.getNumberSheet());
    }

    @Test
    public void behavioural_withdrawalDocumentRequest_findById_should_return_true() throws Exception {

        //Act
        WithdrawalDocumentRequest withdrawalDocumentRequestToFind = new WithdrawalDocumentRequest();

        when(withdrawalDocumentRequestRepository.findOne(any(long.class))).thenReturn(withdrawalDocumentRequestToFind);

        withdrawalDocumentRequestToFind = withdrawalDocumentRequestServiceImpl.findById((long) 123);

        //Assert
        Assert.assertNotNull(withdrawalDocumentRequestToFind);
    }

    @Test
    public void behavioural_withdrawalDocumentRequest_deleteById_should_return_true() throws Exception {

        //Act
        WithdrawalDocumentRequest withdrawalDocumentRequest = new WithdrawalDocumentRequest();

        withdrawalDocumentRequest.setId((long) 3);

        withdrawalDocumentRequestServiceImpl.delete(withdrawalDocumentRequest.getId());

        WithdrawalDocumentRequest foundWithdrawalDocumentRegistrationForm = withdrawalDocumentRequestServiceImpl.findById((long) 3);

        //Assert
        assertNull(foundWithdrawalDocumentRegistrationForm);

    }

    @Test
    public void functionality_withdrawalDocumentRequest_deleteById_should_delete_withdrawalDocument() throws Exception {

        //Act
        WithdrawalDocumentRequest withdrawalDocumentRequest = new WithdrawalDocumentRequest();

        withdrawalDocumentRequestServiceImpl.delete(withdrawalDocumentRequest.getId());

        //Assert
        verify(withdrawalDocumentRequestRepository).delete(withdrawalDocumentRequest.getId());

    }

    @Test
    public void behavioural_withdrawalDocumentRequest_findAll_should_return_true() throws Exception {

        //Act
        List<WithdrawalDocumentRequest> withdrawalDocumentRequests = new ArrayList<>();

        WithdrawalDocumentRequest withdrawalDocumentRequest = new WithdrawalDocumentRequest();

        setup(withdrawalDocumentRequest);

        when(withdrawalDocumentRequestRepository.findAll()).thenReturn(withdrawalDocumentRequests);

        withdrawalDocumentRequests.add(withdrawalDocumentRequest);

        List<WithdrawalDocumentRequest> foundForms;
        foundForms = withdrawalDocumentRequestServiceImpl.findAll();

        //Assert
        Assert.assertNotNull(foundForms);

    }

    @Test
    public void functionality_withdrawalDocumentRequest_findAll_should_return_list_of_withdrawalDocumentRequest() throws Exception {

        //Act
        List<WithdrawalDocumentRequest> withdrawalDocumentRequests = new ArrayList<>();

        WithdrawalDocumentRequest withdrawalDocumentRequest = new WithdrawalDocumentRequest();

        setup(withdrawalDocumentRequest);

        when(withdrawalDocumentRequestRepository.findAll()).thenReturn(withdrawalDocumentRequests);

        withdrawalDocumentRequests.add(withdrawalDocumentRequest);

        List<WithdrawalDocumentRequest> foundForms;
        foundForms = withdrawalDocumentRequestServiceImpl.findAll();

        assertEquals(withdrawalDocumentRequests.get(0).getId(), foundForms.get(0).getId());
        assertEquals(withdrawalDocumentRequests.get(0).getDocumentName(), foundForms.get(0).getDocumentName());
        assertEquals(withdrawalDocumentRequests.get(0).getStudentId(), foundForms.get(0).getStudentId());
        assertEquals(withdrawalDocumentRequests.get(0).getSeries(), foundForms.get(0).getSeries());
        assertEquals(withdrawalDocumentRequests.get(0).getNumberIDCard(), foundForms.get(0).getNumberIDCard());
        assertEquals(withdrawalDocumentRequests.get(0).getStudyYear(), foundForms.get(0).getStudyYear());
        assertEquals(withdrawalDocumentRequests.get(0).getUniversityYear(), foundForms.get(0).getUniversityYear());
        assertEquals(withdrawalDocumentRequests.get(0).getTypeOfCourses(), foundForms.get(0).getTypeOfCourses());
        assertEquals(withdrawalDocumentRequests.get(0).getApproveReason(), foundForms.get(0).getApproveReason());
        assertEquals(withdrawalDocumentRequests.get(0).getDate(), foundForms.get(0).getDate());
        assertEquals(withdrawalDocumentRequests.get(0).getSignature(), foundForms.get(0).getSignature());
        assertEquals(withdrawalDocumentRequests.get(0).getSeriesBAC(), foundForms.get(0).getSeriesBAC());
        assertEquals(withdrawalDocumentRequests.get(0).getNumberBAC(), foundForms.get(0).getNumberBAC());
        assertEquals(withdrawalDocumentRequests.get(0).getNumberSheet(), foundForms.get(0).getNumberSheet());

    }

}
