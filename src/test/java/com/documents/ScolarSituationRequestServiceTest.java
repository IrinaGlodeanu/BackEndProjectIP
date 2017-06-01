package com.documents;

import com.documents.models.DiplomaDocumentRequest;
import com.documents.models.ScolarSituationDocument;
import com.documents.models.Student;
import com.documents.repositories.ScolarSituationRequestRepository;
import com.documents.services.ScolarSituationRequestServiceImpl;
import com.documents.services.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Ecaterina Mihaela on 25.05.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ScolarSituationRequestServiceTest {
    @Mock
    ScolarSituationRequestRepository scolarSituationRequestRepository;

    @InjectMocks
    private ScolarSituationRequestServiceImpl scolarSituationRequestService= new ScolarSituationRequestServiceImpl();

    @Test
    public void scolarSituationDocument_save_should_return_true()
    {
        //expectd objects
        ScolarSituationDocument scolarSituationDocumentToSave = new ScolarSituationDocument();
        Long id = (long) 3;
        String documentName = "DocName";
        String studentName = "Student";
        Integer currentYear = 2107;
        Integer yearOfStudy = 2;
        String hasBroughtReceipt = "yes";

        ScolarSituationDocument scolarSituationDocumentAfterSave = new ScolarSituationDocument();

        scolarSituationDocumentToSave.setId(id);
        scolarSituationDocumentToSave.setDocumentName(documentName);
        scolarSituationDocumentToSave.setStudentName(studentName);
        scolarSituationDocumentToSave.setCurrentYear(currentYear);
        scolarSituationDocumentToSave.setYearOfStudy(yearOfStudy);
        scolarSituationDocumentToSave.setHasBroughtReceipt(hasBroughtReceipt);

        when(scolarSituationRequestService.save(any(ScolarSituationDocument.class))).thenReturn(scolarSituationDocumentToSave);


        scolarSituationDocumentAfterSave = scolarSituationRequestService.save(scolarSituationDocumentToSave);

        assertNotNull(scolarSituationDocumentAfterSave);
        assertEquals(id, scolarSituationDocumentAfterSave.getId());
        assertEquals(documentName, scolarSituationDocumentAfterSave.getDocumentName());
        assertEquals(studentName, scolarSituationDocumentAfterSave.getStudentName());
        assertEquals(currentYear, scolarSituationDocumentAfterSave.getCurrentYear());
        assertEquals(yearOfStudy, scolarSituationDocumentAfterSave.getYearOfStudy());
        assertEquals(hasBroughtReceipt, scolarSituationDocumentAfterSave.getHasBroughtReceipt());
        //
    }



    @Test
    public void scolarSituationDocument_deleteById_should_return_true() {
        Long id = (long) 3;


        ScolarSituationDocument scolarSituationDocumentToDelete = new ScolarSituationDocument();
        scolarSituationDocumentToDelete.setId(id);

        scolarSituationRequestService.delete(scolarSituationDocumentToDelete.getId());

        verify(scolarSituationRequestRepository).delete(scolarSituationDocumentToDelete.getId());

    }

    @Test
    public void scolarSituationDocument_findById_should_return_true() {
        ScolarSituationDocument scolarSituationDocumentAfterFind = new ScolarSituationDocument();

        Long id = (long) 3;

        scolarSituationDocumentAfterFind.setId(id);

        when(scolarSituationRequestService.findById(id)).thenReturn(scolarSituationDocumentAfterFind);

        ScolarSituationDocument newScolarSituationDocument = scolarSituationRequestService.findById(id);

        assertNotNull(newScolarSituationDocument);
        assertEquals(id, newScolarSituationDocument.getId());

    }

}
