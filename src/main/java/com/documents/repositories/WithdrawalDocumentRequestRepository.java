package com.documents.repositories;

import org.springframework.data.repository.CrudRepository;

import com.documents.models.WithdrawalDocumentRequest;

/**
 * Created by Cami on 2017-05-11.
 */
public interface WithdrawalDocumentRequestRepository extends CrudRepository<WithdrawalDocumentRequest, Long>{

    /**
     * Get the withdrawal document by student Id
     */

    WithdrawalDocumentRequest findByStudentId(Long id);
}

