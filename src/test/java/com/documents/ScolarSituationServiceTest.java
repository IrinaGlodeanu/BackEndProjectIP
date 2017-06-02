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

import com.documents.models.ScolarSituationDocument;
import com.documents.repositories.ScolarSituationRequestRepository;
import com.documents.services.ScolarSituationRequestServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class ScolarSituationServiceTest {

    //Arrange
    @Mock
    private ScolarSituationRequestRepository scolarSituationRequestRepository;

    @InjectMocks
    private ScolarSituationRequestServiceImpl scolarSituationRequestServiceImpl = new ScolarSituationRequestServiceImpl();

    @Before
    public void initializeMockito() {
        MockitoAnnotations.initMocks(this);
    }


    public void setup(ScolarSituationDocument scolarSituationDocumentToSet) {

        scolarSituationDocumentToSet.setId((long) 3);
        scolarSituationDocumentToSet.setDocumentName("Document_Name");
        scolarSituationDocumentToSet.setStudentName("Student_Name");
        scolarSituationDocumentToSet.setCurrentYear(2017);
        scolarSituationDocumentToSet.setYearOfStudy(2);
        scolarSituationDocumentToSet.setHasBroughtReceipt("Yes");

    }

    @Test
    public void behavioural_scolarSituationDocumentRequest_save_should_return_true() throws Exception {

        //Act
        ScolarSituationDocument scolarSituationDocumentAfterSave = new ScolarSituationDocument();
        ScolarSituationDocument scolarSituationDocumentToSave = new ScolarSituationDocument();

        setup(scolarSituationDocumentToSave);

        when(scolarSituationRequestRepository.save(any(ScolarSituationDocument.class))).thenReturn(scolarSituationDocumentAfterSave);

        scolarSituationDocumentAfterSave = scolarSituationRequestServiceImpl.save(scolarSituationDocumentToSave);

        //Assert
        assertNotNull(scolarSituationDocumentAfterSave);
    }

    @Test
    public void functionality_scolarSituationDocumentRequest_save_should_return_scolarSituationDocumentRequest() throws Exception {

        //Act
        ScolarSituationDocument scolarSituationDocumentAfterSave = new ScolarSituationDocument();

        setup(scolarSituationDocumentAfterSave);

        when(scolarSituationRequestRepository.save(any(ScolarSituationDocument.class))).thenReturn(scolarSituationDocumentAfterSave);

        ScolarSituationDocument savedScolarSituationDoc = scolarSituationRequestServiceImpl.save(scolarSituationDocumentAfterSave);

        //Assert
        assertEquals(Long.valueOf(3), savedScolarSituationDoc.getId());
        assertEquals("Document_Name", savedScolarSituationDoc.getDocumentName());
        assertEquals("Student_Name", savedScolarSituationDoc.getStudentName());
        assertEquals(Integer.valueOf(2017), savedScolarSituationDoc.getCurrentYear());
        assertEquals(Integer.valueOf(2), savedScolarSituationDoc.getYearOfStudy());
        assertEquals("Yes", savedScolarSituationDoc.getHasBroughtReceipt());

    }

    @Test
    public void behavioural_scolarSituationDocumentRequest_findById_should_return_true() throws Exception {

        //Act
        ScolarSituationDocument scoalrSituationDocumentToFind = new ScolarSituationDocument();

        when(scolarSituationRequestRepository.findOne(any(long.class))).thenReturn(scoalrSituationDocumentToFind);

        scoalrSituationDocumentToFind = scolarSituationRequestServiceImpl.findById((long) 123);

        //Assert
        assertNotNull(scoalrSituationDocumentToFind);
    }

    @Test
    public void functionality_scolarSituationDocumentRequest_findById_should_return_scolarSituationDocumentRequest() throws Exception {

        //Act
        ScolarSituationDocument scolarSituationDocumentToFind = new ScolarSituationDocument();

        setup(scolarSituationDocumentToFind);

        when(scolarSituationRequestRepository.findOne(any(long.class))).thenReturn(scolarSituationDocumentToFind);

        ScolarSituationDocument foundScolarSitDoc = scolarSituationRequestServiceImpl.findById((long) 3);

        //Assert
        assertEquals(Long.valueOf(3), foundScolarSitDoc.getId());
        assertEquals("Document_Name", foundScolarSitDoc.getDocumentName());
        assertEquals("Student_Name", foundScolarSitDoc.getStudentName());
        assertEquals(Integer.valueOf(2017), foundScolarSitDoc.getCurrentYear());
        assertEquals(Integer.valueOf(2), foundScolarSitDoc.getYearOfStudy());
        assertEquals("Yes", foundScolarSitDoc.getHasBroughtReceipt());

    }

    @Test
    public void behavioural_scolarSituationDocumentRequest_deleteById_should_return_true() throws Exception {

        //Act
        ScolarSituationDocument scolarSituationDocument = new ScolarSituationDocument();

        scolarSituationDocument.setId((long) 3);

        scolarSituationRequestServiceImpl.delete(scolarSituationDocument.getId());

        ScolarSituationDocument foundedScolarSituationDocument = scolarSituationRequestServiceImpl.findById((long) 3);

        //Assert
        assertNull(foundedScolarSituationDocument);

    }


    @Test
    public void functionality_scolarSituationDocumentRequest_deleteById_should_delete_scolarSituationDocumentRequest() throws Exception {

        //Act
        ScolarSituationDocument scolarSituationDocument = new ScolarSituationDocument();

        scolarSituationRequestServiceImpl.delete(scolarSituationDocument.getId());

        //Assert
        verify(scolarSituationRequestRepository).delete(scolarSituationDocument.getId());

    }

    @Test
    public void behavioural_scolarSituationDocumentRequest_findAll_should_return_true() throws Exception {

        //Act
        List<ScolarSituationDocument> scolarSituationDocuments = new ArrayList<>();

        ScolarSituationDocument scolarSituationDocument = new ScolarSituationDocument();

        setup(scolarSituationDocument);

        when(scolarSituationRequestRepository.findAll()).thenReturn(scolarSituationDocuments);

        scolarSituationDocuments.add(scolarSituationDocument);

        List<ScolarSituationDocument> foundedScolarSituationDocuments;
        foundedScolarSituationDocuments = scolarSituationRequestServiceImpl.findAll();

        //Assert
        assertNotNull(foundedScolarSituationDocuments);

    }

    @Test
    public void functionality_scolarSituationDocumentRequest_findAll_should_return_list_of_scolarSituationDocumentRequest() throws Exception {

        //Act
        List<ScolarSituationDocument> scolarSituationDocuments = new ArrayList<>();

        ScolarSituationDocument scolarSituationDocument = new ScolarSituationDocument();

        setup(scolarSituationDocument);

        when(scolarSituationRequestRepository.findAll()).thenReturn(scolarSituationDocuments);

        scolarSituationDocuments.add(scolarSituationDocument);

        List<ScolarSituationDocument> foundedScolarSituationDocuments;
        foundedScolarSituationDocuments = scolarSituationRequestServiceImpl.findAll();

        //Assert
        assertEquals(scolarSituationDocuments.get(0).getId(), foundedScolarSituationDocuments.get(0).getId());
        assertEquals(scolarSituationDocuments.get(0).getDocumentName(), foundedScolarSituationDocuments.get(0).getDocumentName());
        assertEquals(scolarSituationDocuments.get(0).getStudentName(), foundedScolarSituationDocuments.get(0).getStudentName());
        assertEquals(scolarSituationDocuments.get(0).getCurrentYear(), foundedScolarSituationDocuments.get(0).getCurrentYear());
        assertEquals(scolarSituationDocuments.get(0).getYearOfStudy(), foundedScolarSituationDocuments.get(0).getYearOfStudy());
        assertEquals(scolarSituationDocuments.get(0).getHasBroughtReceipt(), foundedScolarSituationDocuments.get(0).getHasBroughtReceipt());

    }
}
