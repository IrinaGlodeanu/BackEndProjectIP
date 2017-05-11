package com.documents.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.DiplomaDocumentRequest;
import com.documents.repositories.DiplomaDocumentRequestRepository;

@Service
public class DiplomaDocumentRequestServiceImpl implements DiplomaDocumentRequestService {
    @Autowired
    DiplomaDocumentRequestRepository diplomaDocumentRequestRepository;

    @Override
    public DiplomaDocumentRequest save(DiplomaDocumentRequest entity) {
        return this.diplomaDocumentRequestRepository.save(entity);
    }

    @Override
    public DiplomaDocumentRequest findById(Long id) {
        return this.diplomaDocumentRequestRepository.findOne(id);
    }

    @Override
    public List<DiplomaDocumentRequest> findAll() {
        List<DiplomaDocumentRequest> diplomaDocumentRequests = new ArrayList<>();
        for (DiplomaDocumentRequest diplomaDocumentRequestt : this.diplomaDocumentRequestRepository.findAll()) {
            diplomaDocumentRequests.add(diplomaDocumentRequestt);
        }
        return diplomaDocumentRequests;
    }

    @Override
    public void delete(Long id) {
        this.diplomaDocumentRequestRepository.delete(id);
    }
}
