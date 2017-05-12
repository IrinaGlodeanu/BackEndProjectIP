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

import com.documents.models.InterruptionRequestDocument;
import com.documents.services.InterruptionRequestDocumentService;

/**
 * Created by AlenaHa && Irinaaaa on 12.05.2017.
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


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<InterruptionRequestDocument> deleteInterruptionRequest(@PathVariable Long id) {
        InterruptionRequestDocument requestDocument = interruptionService.findById(id);
        if (requestDocument != null) {
            interruptionService.delete(id);
        } else {
            return new ResponseEntity<InterruptionRequestDocument>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<InterruptionRequestDocument>(HttpStatus.OK);
    }


    @RequestMapping(value = "/interruption", method = RequestMethod.POST)
    public ResponseEntity<InterruptionRequestDocument> createInterruptionRequest(@RequestBody InterruptionRequestDocument newStudent) {
        InterruptionRequestDocument savedRequestDocument = interruptionService.save(newStudent);
        return new ResponseEntity<InterruptionRequestDocument>(savedRequestDocument, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<InterruptionRequestDocument> updateInterruptionRequest(@RequestBody InterruptionRequestDocument interruptionRequest, @PathVariable Long id) {
        if (!id.equals(interruptionRequest.getId())) {
            return new ResponseEntity<InterruptionRequestDocument>(HttpStatus.BAD_REQUEST);
        }
        InterruptionRequestDocument newStudent = interruptionService.save(interruptionRequest);
        return new ResponseEntity<InterruptionRequestDocument>(newStudent, HttpStatus.OK);
    }
}

