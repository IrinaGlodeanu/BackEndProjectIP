package com.documents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.documents.models.WithdrawalDocumentRequest;
import com.documents.services.WithdrawalDocumentRequestService;

/**
 * Created by Cami on 2017-05-11.
 */
@RestController
@RequestMapping(value = "/withdrawalDocumentRequest")
public class WithdrawalDocumentRequestController {
    @Autowired
    private WithdrawalDocumentRequestService withdrawalDocumentRequestService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<WithdrawalDocumentRequest> searchWithdrawalDocumentRequestById(@PathVariable Long id) {
        WithdrawalDocumentRequest withdrawalDocumentRequest = withdrawalDocumentRequestService.findById(id);
        if (withdrawalDocumentRequest != null) {
            return new ResponseEntity<WithdrawalDocumentRequest>(withdrawalDocumentRequest, HttpStatus.OK);
        } else {
            return new ResponseEntity<WithdrawalDocumentRequest>(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<WithdrawalDocumentRequest>> getAllWithdrawalDocumentRequests() {
        List<WithdrawalDocumentRequest> all = withdrawalDocumentRequestService.findAll();
        return new ResponseEntity<List<WithdrawalDocumentRequest>>(all, HttpStatus.OK);
    }

   
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<WithdrawalDocumentRequest> deleteWithdrawalDocumentRequest(@PathVariable Long id) {
        WithdrawalDocumentRequest withdrawalDocumentRequest = withdrawalDocumentRequestService.findById(id);
        if (withdrawalDocumentRequest != null) {
            withdrawalDocumentRequestService.delete(id);
        } else {
            return new ResponseEntity<WithdrawalDocumentRequest>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<WithdrawalDocumentRequest>(HttpStatus.OK);
    }


    @RequestMapping(value = "/withdrawalDocumentRequest", method = RequestMethod.POST)
    public ResponseEntity<WithdrawalDocumentRequest> createWithdrawalDocumentRequest(@RequestBody WithdrawalDocumentRequest newWithdrawalDocumentRequest) {
        WithdrawalDocumentRequest savedWithdrawalDocumentRequest = withdrawalDocumentRequestService.save(newWithdrawalDocumentRequest);
        return new ResponseEntity<WithdrawalDocumentRequest>(savedWithdrawalDocumentRequest, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<WithdrawalDocumentRequest> updateWithdrawalDocumentRequest(@RequestBody WithdrawalDocumentRequest withdrawalDocumentRequest, @PathVariable Long id) {
        if (!id.equals(withdrawalDocumentRequest.getId())) {
            return new ResponseEntity<WithdrawalDocumentRequest>(HttpStatus.BAD_REQUEST);
        }
        WithdrawalDocumentRequest newWithdrawalDocumentRequest = withdrawalDocumentRequestService.save(withdrawalDocumentRequest);
        return new ResponseEntity<WithdrawalDocumentRequest>(newWithdrawalDocumentRequest, HttpStatus.OK);
    }

}
