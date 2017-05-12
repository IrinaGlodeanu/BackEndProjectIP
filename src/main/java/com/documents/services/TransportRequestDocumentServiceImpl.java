package com.documents.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.TransportRequestDocument;
import com.documents.repositories.TransportRequestDocumentRepository;

/**
 * Created by Simona on 12-May-17.
 */
@Service
public class TransportRequestDocumentServiceImpl implements TransportRequestDocumentService {

    @Autowired
    private TransportRequestDocumentRepository transportRequestDocumentRepository;

    @Override
    public TransportRequestDocument save(TransportRequestDocument entity) {
        return this.transportRequestDocumentRepository.save(entity);

    }

    @Override
    public TransportRequestDocument findById(Long id) {
        return this.transportRequestDocumentRepository.findOne(id);
    }

    @Override
    public List<TransportRequestDocument> findAll() {
        List<TransportRequestDocument> transportRequestDocuments = new ArrayList<>();
        for (TransportRequestDocument transportRequestDocument : this.transportRequestDocumentRepository.findAll()) {
            transportRequestDocuments.add(transportRequestDocument);
        }
        return transportRequestDocuments;
    }

    @Override
    public void delete(Long id) {
        this.transportRequestDocumentRepository.delete(id);
    }
}
