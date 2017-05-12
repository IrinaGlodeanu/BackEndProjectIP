package com.documents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.documents.models.InterruptionRequestDocument;
import com.documents.services.InterruptionRequestDocumentService;

/**
 * Created by AlenaHa on 12.05.2017.
 */
@RestController
@RequestMapping(value = "/interruption")
public class InterruptionRequestDocumentController {

    @Autowired
    InterruptionRequestDocumentService interruptionService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<InterruptionRequestDocument> getRequestbyId(@PathVariable Long id) {
        InterruptionRequestDocument requestDocument = interruptionService.findById(id);
        if (requestDocument != null) {
            return new ResponseEntity<InterruptionRequestDocument>(requestDocument, HttpStatus.OK);
        } else {
            return new ResponseEntity<InterruptionRequestDocument>(HttpStatus.NO_CONTENT);
        }
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<InterruptionRequestDocument>> getAllInterruptionRequest() {
        List<InterruptionRequestDocument> interruptionDocumentList = interruptionService.findAll();
        return new ResponseEntity<List<InterruptionRequestDocument>>(interruptionDocumentList, HttpStatus.OK);
    }
}
