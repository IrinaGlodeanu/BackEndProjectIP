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

import com.documents.models.Document;
import com.documents.repositories.DocumentRepository;
import com.documents.services.DocumentServiceImpl;

/**
 * Created by pc on 5/26/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class DocumentTest {

    @Mock
    DocumentRepository documentRepository;

    @InjectMocks
    private DocumentServiceImpl documentService = new DocumentServiceImpl();

    //to
    @Test
    public void document_save_should_return_true() {

        Document documentToSave = new Document();
        Long id = (long) 3;
        String documentName = "DocName";
        String valabilityInDays = "2";

        Document diplomaDocumentRequestAfterSave = new Document();

        documentToSave.setId(id);
        documentToSave.setDocumentName(documentName);
        documentToSave.setValabilityInDays(valabilityInDays);


        when(documentService.save(any(Document.class))).thenReturn(documentToSave);


        diplomaDocumentRequestAfterSave = documentService.save(documentToSave);

        assertNotNull(diplomaDocumentRequestAfterSave);
        assertEquals(id, diplomaDocumentRequestAfterSave.getId());
        assertEquals(documentName, diplomaDocumentRequestAfterSave.getDocumentName());
        assertEquals(valabilityInDays, diplomaDocumentRequestAfterSave.getValabilityInDays());

    }


    @Test
    public void document_deleteById_should_return_true() {
        Long id = (long) 3;

        Document DocumentToDelete = new Document();
        DocumentToDelete.setId(id);

        documentService.delete(DocumentToDelete.getId());

        verify(documentRepository).delete(DocumentToDelete.getId());

    }


    @Test
    public void document_findById_should_return_true() {
        Document documentAfterFind = new Document();

        Long id = (long) 3;

        documentAfterFind.setId(id);

        when(documentService.findById(id)).thenReturn(documentAfterFind);

        Document newDiplomaRequest = documentService.findById(id);

        assertNotNull(newDiplomaRequest);
        assertEquals(id, newDiplomaRequest.getId());

    }


}
