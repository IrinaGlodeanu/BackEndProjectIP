package com.documents.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.WithdrawalDocumentRequest;
import com.documents.repositories.WithdrawalDocumentRequestRepository;

/**
 * Created by Cami on 2017-05-11.
 */
@Service
public class WithdrawalDocumentRequestServiceImpl implements WithdrawalDocumentRequestService{
    @Autowired
    private WithdrawalDocumentRequestRepository withdrawalDocumentRequestRepository;

    @Override
    public WithdrawalDocumentRequest save(WithdrawalDocumentRequest entity) {
        return this.withdrawalDocumentRequestRepository.save(entity);
    }

    @Override
    public WithdrawalDocumentRequest findById(Long id) {
        return this.withdrawalDocumentRequestRepository.findOne(id);
    }

    @Override
    public List<WithdrawalDocumentRequest> findAll() {
        List<WithdrawalDocumentRequest> withdrawalDocumentRequests = new ArrayList<>();
        for (WithdrawalDocumentRequest withdrawalDocumentRequest : this.withdrawalDocumentRequestRepository.findAll()) {
            withdrawalDocumentRequests.add(withdrawalDocumentRequest);
        }
        return withdrawalDocumentRequests;    }

    @Override
    public void delete(Long id) {

    }
}
