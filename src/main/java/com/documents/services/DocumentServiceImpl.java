package com.documents.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.Document;
import com.documents.models.Student;
import com.documents.repositories.DocumentRepository;


/**
 * Created by pc on 5/7/2017.
 */
@Service
public class DocumentServiceImpl implements DocumentService {


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Document save(Document entity) {
        return this.documentRepository.save(entity);

    }

    @Override
    public Document findById(Long id) {
        return this.documentRepository.findOne(id);
    }

    @Override
    public List<Document> findAll() {
        List<Document> documents = new ArrayList<>();
        for (Document document : this.documentRepository.findAll()) {
            documents.add(document);
        }
        return documents;
    }

    @Override
    public void delete(Long id) {

        this.documentRepository.delete(id);
    }

    @Override
    public List<Document> findDocumentHistory(String id) {

        Query query = entityManager.createNativeQuery(
                "SELECT r.id, d.document_name FROM STUDENT s \n" +
                        "    join request r on r.student_id = s.id\n" +
                        "    join document d on d.id = r.document_id\n" +
                        "    where s.id = " + id, Document.class  );

        List resultList = query.getResultList();

        return  resultList;
    }
}
