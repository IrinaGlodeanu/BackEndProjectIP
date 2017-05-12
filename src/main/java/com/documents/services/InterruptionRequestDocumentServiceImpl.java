package com.documents.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.InterruptionRequestDocument;
import com.documents.repositories.InterruptionRequestDocumentRepository;

/**
 * Created by Simona on 11-May-17.
 */
@Service
public class InterruptionRequestDocumentServiceImpl implements InterruptionRequestDocumentService {

    @Autowired
    private InterruptionRequestDocumentRepository interruptionRequestDocumentRepository;

    @Override
    public InterruptionRequestDocument save(InterruptionRequestDocument entity) {
        return this.interruptionRequestDocumentRepository.save(entity);

    }

    @Override
    public InterruptionRequestDocument findById(Long id) {
        return this.interruptionRequestDocumentRepository.findOne(id);
    }

    @Override
    public List<InterruptionRequestDocument> findAll() {
        List<InterruptionRequestDocument> interruptionRequestDocuments = new ArrayList<>();
        for (InterruptionRequestDocument interruptionRequestDocument : this.interruptionRequestDocumentRepository.findAll()) {
            interruptionRequestDocuments.add(interruptionRequestDocument);
        }
        return interruptionRequestDocuments;
    }

    @Override
    public void delete(Long id) {
        this.interruptionRequestDocumentRepository.delete(id);
    }

}
