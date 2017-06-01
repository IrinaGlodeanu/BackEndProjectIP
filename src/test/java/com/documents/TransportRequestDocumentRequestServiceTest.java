package com.documents;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.reset;
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

import com.documents.models.TransportRequestDocument;
import com.documents.models.WithdrawalDocumentRequest;
import com.documents.repositories.TransportRequestDocumentRepository;
import com.documents.services.TransportRequestDocumentServiceImpl;

/**
 * Created by Cami on 2017-06-01.
 */
@RunWith(MockitoJUnitRunner.class)
public class TransportRequestDocumentRequestServiceTest {

    @Mock
    private TransportRequestDocumentRepository transportRequestDocumentRepository;

    @InjectMocks
    private TransportRequestDocumentServiceImpl transportRequestDocumentServiceImpl = new TransportRequestDocumentServiceImpl();

    @Before
    public void initializeMockito() {
        MockitoAnnotations.initMocks(this);
    }

    public void setup(TransportRequestDocument transportRequestDocumentToSet) {
        transportRequestDocumentToSet.setId((long)23);
        transportRequestDocumentToSet.setDocumentName("Transport");
        transportRequestDocumentToSet.setStudentName("Ionica");
        transportRequestDocumentToSet.setNrSeriesId("1234");
        transportRequestDocumentToSet.setYearOfStudy("2");
    }


    @Test
    public void behavioural_transportRequestDocument_save_should_return_true() throws Exception {

        TransportRequestDocument transportRequestDocumentAfterSave = new TransportRequestDocument();
        TransportRequestDocument transportRequestDocumentToSave = new TransportRequestDocument();

        setup(transportRequestDocumentToSave);

        when(transportRequestDocumentRepository.save(any(TransportRequestDocument.class))).thenReturn(transportRequestDocumentAfterSave);

        transportRequestDocumentAfterSave = transportRequestDocumentServiceImpl.save(transportRequestDocumentToSave);

        assertNotNull(transportRequestDocumentAfterSave);
    }

    @Test
    public void functionality_transportRequest_save_should_return_transportRequest() throws Exception {

        TransportRequestDocument transportRequestDocumentAfterSave = new TransportRequestDocument();

        setup(transportRequestDocumentAfterSave);

        when(transportRequestDocumentRepository.save(any(TransportRequestDocument.class))).thenReturn(transportRequestDocumentAfterSave);

        TransportRequestDocument savedTransportRequestDocument = transportRequestDocumentServiceImpl.save(transportRequestDocumentAfterSave);

        assertEquals(Long.valueOf(23), savedTransportRequestDocument.getId());
        assertEquals("Transport", savedTransportRequestDocument.getDocumentName());
        assertEquals("Ionica", savedTransportRequestDocument.getStudentName());
        assertEquals("1234", savedTransportRequestDocument.getNrSeriesId());
        assertEquals("2", savedTransportRequestDocument.getYearOfStudy());

    }

    @Test
    public void behavioural_transportRequest_findById_should_return_true() throws Exception {

        TransportRequestDocument transportRequestDocumentToSave = new TransportRequestDocument();

        when(transportRequestDocumentRepository.findOne(any(long.class))).thenReturn(transportRequestDocumentToSave);

        transportRequestDocumentToSave = transportRequestDocumentServiceImpl.findById((long) 123);

        assertNotNull(transportRequestDocumentToSave);
    }

    @Test
    public void functionality_transportRequest_findById_should_return_transportRequest() throws Exception {

        TransportRequestDocument transportRequestDocumentToFind = new TransportRequestDocument();

        setup(transportRequestDocumentToFind);

        when(transportRequestDocumentRepository.findOne(any(long.class))).thenReturn(transportRequestDocumentToFind);

        TransportRequestDocument foundTransportRequestDocument = transportRequestDocumentServiceImpl.findById((long) 3);

        assertEquals(Long.valueOf(23), foundTransportRequestDocument.getId());
        assertEquals("Transport", foundTransportRequestDocument.getDocumentName());
        assertEquals("Ionica", foundTransportRequestDocument.getStudentName());
        assertEquals("1234", foundTransportRequestDocument.getNrSeriesId());
        assertEquals("2", foundTransportRequestDocument.getYearOfStudy());

    }

    @Test
    public void behavioural_transportRequest_deleteById_should_return_true() throws Exception {

        //Act
        TransportRequestDocument transportRequestDocument = new TransportRequestDocument();

        transportRequestDocument.setId((long) 3);

        transportRequestDocumentServiceImpl.delete(transportRequestDocument.getId());

        TransportRequestDocument foundTransportRequestDocument = transportRequestDocumentServiceImpl.findById((long) 3);

        assertNull(foundTransportRequestDocument);

    }


    @Test
    public void functionality_transportRequest_deleteById_should_return_delete_transportRequest() throws Exception {

        //Act
        TransportRequestDocument transportRequestDocument = new TransportRequestDocument();

        transportRequestDocumentServiceImpl.delete(transportRequestDocument.getId());

        //Assert
        verify(transportRequestDocumentRepository).delete(transportRequestDocument.getId());

    }

    @Test
    public void behavioural_transportRequest_findAll_should_return_true() throws Exception {

        //Act
        List<TransportRequestDocument> transportRequestDocuments = new ArrayList<>();

        TransportRequestDocument transportRequestDocument = new TransportRequestDocument();

        setup(transportRequestDocument);

        when(transportRequestDocumentRepository.findAll()).thenReturn(transportRequestDocuments);

        transportRequestDocuments.add(transportRequestDocument);

        List<TransportRequestDocument> foundForms;
        foundForms = transportRequestDocumentServiceImpl.findAll();

        //Assert
        assertNotNull(foundForms);

    }

    @Test
    public void functionality_transportRequest_findAll_should_return_list_of_transportRequest() throws Exception {

        List<TransportRequestDocument> transportRequestDocuments = new ArrayList<>();

        TransportRequestDocument transportRequestDocument = new TransportRequestDocument();

        setup(transportRequestDocument);

        when(transportRequestDocumentRepository.findAll()).thenReturn(transportRequestDocuments);

        transportRequestDocuments.add(transportRequestDocument);

        List<TransportRequestDocument> foundForms;
        foundForms = transportRequestDocumentServiceImpl.findAll();

        assertEquals(transportRequestDocuments.get(0).getId(), foundForms.get(0).getId());
        assertEquals(transportRequestDocuments.get(0).getDocumentName(), foundForms.get(0).getDocumentName());
        assertEquals(transportRequestDocuments.get(0).getStudentName(), foundForms.get(0).getStudentName());
        assertEquals(transportRequestDocuments.get(0).getYearOfStudy(), foundForms.get(0).getYearOfStudy());

    }

}
