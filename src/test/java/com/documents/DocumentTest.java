package com.documents;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.documents.models.Document;
import com.documents.repositories.DocumentRepository;
import com.documents.services.DocumentServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class DocumentTest {

    @Mock
    DocumentRepository documentRepository;
    @PersistenceContext
    private EntityManager entityManager;
    @InjectMocks
    private DocumentServiceImpl documentService = new DocumentServiceImpl();

    @Before
    public void initializeMockito() {
        MockitoAnnotations.initMocks(this);
    }

    public void setup(Document document) {

        document.setId((long) 3);
        document.setDocumentName("Document_Name");
        document.setValabilityInDays("7");

    }


    @Test
    public void behavioural_document_save_should_return_true() {
        //Act
        Document documentToSave = new Document();
        Document documentAfterSave;

        setup(documentToSave);

        when(documentService.save(any(Document.class))).thenReturn(documentToSave);

        documentAfterSave = documentService.save(documentToSave);

        //Assert
        assertNotNull(documentAfterSave);
    }

    @Test
    public void functionality_document_save_should_return_documentRequest() {
        //Act
        Document documentToSave = new Document();
        Document documentAfterSave;

        setup(documentToSave);

        when(documentService.save(any(Document.class))).thenReturn(documentToSave);

        documentAfterSave = documentService.save(documentToSave);

        //Assert
        assertEquals(Long.valueOf(3), documentAfterSave.getId());
        assertEquals("Document_Name", documentAfterSave.getDocumentName());
        assertEquals("7", documentAfterSave.getValabilityInDays());
    }

    @Test
    public void behavioural_document_findById_should_return_true() throws Exception {
        //Act
        Document document = new Document();

        when(documentRepository.findOne(any(long.class))).thenReturn(document);
        document = documentService.findById((long) 3);

        //Assert
        assertNotNull(document);
    }

    @Test
    public void functionality_document_findById_should_return_documentRequest() throws Exception {
        //Act
        Document documentToFind = new Document();
        Document foundedDocument;

        setup(documentToFind);

        when(documentRepository.findOne(any(long.class))).thenReturn(documentToFind);

        foundedDocument = documentService.findById((long) 3);

        //Assert
        assertEquals(Long.valueOf(3), foundedDocument.getId());
        assertEquals("Document_Name", foundedDocument.getDocumentName());
        assertEquals("7", foundedDocument.getValabilityInDays());
    }

    @Test
    public void behavioural_document_deleteById_should_return_true() throws Exception {
        //Act
        Document documentToFind = new Document();

        documentToFind.setId((long) 3);
        documentService.delete(documentToFind.getId());

        Document documentAfterDelete = documentService.findById((long) 3);

        //Assert
        assertNull(documentAfterDelete);
    }

    @Test
    public void functionality_document_deleteById_should_delete_documentRequest() throws Exception {
        //Act
        Document documentToDelete = new Document();

        documentService.delete(documentToDelete.getId());

        //Assert
        verify(documentRepository).delete(documentToDelete.getId());
    }

    @Test
    public void behavioural_document_findAll_should_return_true() throws Exception {
        //Act
        List<Document> documentListRequests = new ArrayList<>();
        Document documentToAdd = new Document();

        setup(documentToAdd);

        when(documentRepository.findAll()).thenReturn(documentListRequests);

        documentListRequests.add(documentToAdd);

        List<Document> foundedDocumentList;
        foundedDocumentList = documentService.findAll();

        //Assert
        assertNotNull(foundedDocumentList);

    }

    @Test
    public void functionality_document_findAll_should_return_list_of_documentRequests() throws Exception {
        //Act
        List<Document> documentListRequests = new ArrayList<>();
        Document documentToAdd = new Document();

        setup(documentToAdd);

        when(documentRepository.findAll()).thenReturn(documentListRequests);

        documentListRequests.add(documentToAdd);

        List<Document> foundedDocumentList;
        foundedDocumentList = documentService.findAll();

        //Assert
        assertEquals(documentListRequests.get(0).getId(), foundedDocumentList.get(0).getId());
        assertEquals(documentListRequests.get(0).getDocumentName(), foundedDocumentList.get(0).getDocumentName());
        assertEquals(documentListRequests.get(0).getValabilityInDays(), foundedDocumentList.get(0).getValabilityInDays());
    }


    /*@Test
    public void test_getStudentList() throws Exception {
        List<Student> results = new ArrayList<>();
        String query="SELECT * FROM STUDENT s \n" +
                "\" +\n" +
                "                        \"    join request r on r.student_id = s.id\\n\" +\n" +
                "                        \"    join document d on d.id = r.document_id\\n\" +\n" +
                "                        \"    where d.id=";
        String id="1";
        Query mockedQuery=mock(Query.class);
        when(entityManager.createNativeQuery(query+id,Student.class)).thenReturn(mockedQuery);

        when(mockedQuery.getResultList()).thenReturn(results);
        results=mockedQuery.getResultList();
        System.out.print(results);
        assertNotNull(results.get(0));
    }*/
}
