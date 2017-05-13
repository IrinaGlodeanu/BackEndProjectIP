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

import com.documents.models.ScolarSituationDocument;
import com.documents.services.ScolarSituationRequestService;

@Controller
@RequestMapping(value = "/scolarSituation")
public class ScolarSituationRequestController {

    @Autowired
    ScolarSituationRequestService scolarSituationRequestService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ScolarSituationDocument> searchDocById(@PathVariable Long id) {
        ScolarSituationDocument document = scolarSituationRequestService.findById(id);
        if (document != null) {
            return new ResponseEntity<ScolarSituationDocument>(document, HttpStatus.OK);
        } else {
            return new ResponseEntity<ScolarSituationDocument>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ScolarSituationDocument>> getAllDocs() {
        List<ScolarSituationDocument> all = scolarSituationRequestService.findAll();
        return new ResponseEntity<List<ScolarSituationDocument>>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ScolarSituationDocument> deleteDoc(@PathVariable Long id) {
        ScolarSituationDocument document = scolarSituationRequestService.findById(id);
        if (document != null) {
            scolarSituationRequestService.delete(id);
        } else {
            return new ResponseEntity<ScolarSituationDocument>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ScolarSituationDocument>(HttpStatus.OK);
    }

    @RequestMapping(value = "/document", method = RequestMethod.POST)
    public ResponseEntity<ScolarSituationDocument> createDocument(@RequestBody ScolarSituationDocument newDoc) {
        ScolarSituationDocument savedStudent = scolarSituationRequestService.save(newDoc);
        return new ResponseEntity<ScolarSituationDocument>(savedStudent, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ScolarSituationDocument> updateDocument(@RequestBody ScolarSituationDocument student, @PathVariable Long id) {
        if (!id.equals(student.getId())) {
            return new ResponseEntity<ScolarSituationDocument>(HttpStatus.BAD_REQUEST);
        }
        ScolarSituationDocument newDoc = scolarSituationRequestService.save(student);
        return new ResponseEntity<ScolarSituationDocument>(newDoc, HttpStatus.OK);
    }


}
