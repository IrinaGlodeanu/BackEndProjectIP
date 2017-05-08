package com.documents.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.Document;
import com.documents.repositories.DocumentRepository;


/**
 * Created by pc on 5/7/2017.
 */
@Service
public class DocumentServiceImpl implements DocumentService {


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
}
