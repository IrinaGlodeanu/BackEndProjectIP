package com.documents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.documents.models.DiplomaDocumentRequest;
import com.documents.services.DiplomaDocumentRequestService;

@Controller
@RequestMapping(value = "/diploma")
public class DiplomaDocumentRequestController {
    @Autowired
    DiplomaDocumentRequestService diplomaDocumentRequestService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DiplomaDocumentRequest> searchDocById(@PathVariable Long id) {
        DiplomaDocumentRequest document = diplomaDocumentRequestService.findById(id);
        if (document != null) {
            return new ResponseEntity<DiplomaDocumentRequest>(document, HttpStatus.OK);
        } else {
            return new ResponseEntity<DiplomaDocumentRequest>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<DiplomaDocumentRequest>> getAllDocs() {
        List<DiplomaDocumentRequest> all = diplomaDocumentRequestService.findAll();
        return new ResponseEntity<List<DiplomaDocumentRequest>>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DiplomaDocumentRequest> deleteDoc(@PathVariable Long id) {
        DiplomaDocumentRequest document = diplomaDocumentRequestService.findById(id);
        if (document != null) {
            diplomaDocumentRequestService.delete(id);
        } else {
            return new ResponseEntity<DiplomaDocumentRequest>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<DiplomaDocumentRequest>(HttpStatus.OK);
    }

    @RequestMapping(value = "/document", method = RequestMethod.POST)
    public ResponseEntity<DiplomaDocumentRequest> createDocument(@RequestBody DiplomaDocumentRequest newDoc) {
        DiplomaDocumentRequest savedStudent = diplomaDocumentRequestService.save(newDoc);
        return new ResponseEntity<DiplomaDocumentRequest>(savedStudent, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DiplomaDocumentRequest> updateDocument(@RequestBody DiplomaDocumentRequest student, @PathVariable Long id) {
        if (!id.equals(student.getId())) {
            return new ResponseEntity<DiplomaDocumentRequest>(HttpStatus.BAD_REQUEST);
        }
        DiplomaDocumentRequest newDoc = diplomaDocumentRequestService.save(student);
        return new ResponseEntity<DiplomaDocumentRequest>(newDoc, HttpStatus.OK);
    }
}
