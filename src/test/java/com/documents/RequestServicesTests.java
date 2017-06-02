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

import com.documents.models.Request;
import com.documents.repositories.RequestRepository;
import com.documents.services.RequestServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RequestServicesTests {

    //Arrange
    @Mock
    private RequestRepository requestRepository;

    @InjectMocks
    private RequestServiceImpl requestServiceImpl = new RequestServiceImpl();

    @Before
    public void initializeMockito() {
        MockitoAnnotations.initMocks(this);
    }


    public void setup(Request requestToSet) {

        requestToSet.setId((long) 3);
        requestToSet.setDocumentId((long) 56);
        requestToSet.setStudentId((long) 3435);
    }

    @Test
    public void behavioural_request_save_should_return_true() throws Exception {

        //Act
        Request requestAfterSave = new Request();
        Request requestToSave = new Request();

        setup(requestToSave);

        when(requestRepository.save(any(Request.class))).thenReturn(requestAfterSave);

        requestAfterSave = requestServiceImpl.save(requestToSave);

        //Assert
        assertNotNull(requestAfterSave);
    }

    @Test
    public void functionality_request_save_should_return_request() throws Exception {

        //Act
        Request requestAfterSave = new Request();

        setup(requestAfterSave);

        when(requestRepository.save(any(Request.class))).thenReturn(requestAfterSave);

        Request savedRequest = requestServiceImpl.save(requestAfterSave);

        //Assert
        assertEquals(Long.valueOf(3), savedRequest.getId());
        assertEquals(Long.valueOf(56), savedRequest.getDocumentId());
        assertEquals(Long.valueOf(3435), savedRequest.getStudentId());

    }

    @Test
    public void behavioural_request_findById_should_return_true() throws Exception {

        //Act
        Request requestToFind = new Request();

        when(requestRepository.findOne(any(long.class))).thenReturn(requestToFind);

        requestToFind = requestServiceImpl.findById((long) 123);

        //Assert
        assertNotNull(requestToFind);
    }

    @Test
    public void functionality_request_findById_should_return_request() throws Exception {

        //Act
        Request requestToFind = new Request();

        setup(requestToFind);

        when(requestRepository.findOne(any(long.class))).thenReturn(requestToFind);

        Request foundRequest = requestServiceImpl.findById((long) 3);

        //Assert
        assertEquals(Long.valueOf(3), foundRequest.getId());
        assertEquals(Long.valueOf(56), foundRequest.getDocumentId());
        assertEquals(Long.valueOf(3435), foundRequest.getStudentId());

    }

    @Test
    public void behavioural_request_deleteById_should_return_true() throws Exception {

        //Act
        Request request = new Request();

        request.setId((long) 3);

        requestServiceImpl.delete(request.getId());

        Request foundRequest = requestServiceImpl.findById((long) 3);

        //Assert
        assertNull(foundRequest);

    }


    @Test
    public void functionality_request_deleteById_should_delete_request() throws Exception {

        //Act
        Request request = new Request();

        requestServiceImpl.delete(request.getId());

        //Assert
        verify(requestRepository).delete(request.getId());

    }

    @Test
    public void behavioural_request_findAll_should_return_true() throws Exception {

        //Act
        List<Request> requests = new ArrayList<>();

        Request request = new Request();

        setup(request);

        when(requestRepository.findAll()).thenReturn(requests);

        requests.add(request);

        List<Request> foundRequests;
        foundRequests = requestServiceImpl.findAll();

        //Assert
        assertNotNull(foundRequests);

    }

    @Test
    public void functionality_request_findAll_should_return_list_of_request() throws Exception {

        //Act
        List<Request> requests = new ArrayList<>();

        Request request = new Request();

        setup(request);

        when(requestRepository.findAll()).thenReturn(requests);

        requests.add(request);

        List<Request> foundRequests;
        foundRequests = requestServiceImpl.findAll();

        //Assert
        assertEquals(requests.get(0).getId(), foundRequests.get(0).getId());
        assertEquals(requests.get(0).getDocumentId(), foundRequests.get(0).getDocumentId());
        assertEquals(requests.get(0).getStudentId(), foundRequests.get(0).getStudentId());

    }

}