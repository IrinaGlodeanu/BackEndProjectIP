package com.documents.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.ScolarSituationDocument;
import com.documents.repositories.ScolarSituationRequestRepository;

@Service
public class ScolarSituationRequestServiceImpl implements CrudService<ScolarSituationDocument> {

    @Autowired
    ScolarSituationRequestRepository scolarSituationRequestRepository;

    @Override
    public ScolarSituationDocument save(ScolarSituationDocument entity) {
        return this.scolarSituationRequestRepository.save(entity);
    }

    @Override
    public ScolarSituationDocument findById(Long id) {
        return this.scolarSituationRequestRepository.findOne(id);
    }

    @Override
    public List<ScolarSituationDocument> findAll() {
        List<ScolarSituationDocument> scolarSituationDocuments = new ArrayList<>();
        for (ScolarSituationDocument scolarSituationDocument : this.scolarSituationRequestRepository.findAll()) {
            scolarSituationDocuments.add(scolarSituationDocument);
        }
        return scolarSituationDocuments;
    }

    @Override
    public void delete(Long id) {
        this.scolarSituationRequestRepository.delete(id);
    }
}
