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

import com.documents.models.Document;
import com.documents.services.DocumentService;

/**
 * Created by pc on 5/7/2017.
 */

@RestController
@RequestMapping(value = "/document")
public class DocumentController {

    @Autowired
    private DocumentService docsTypeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Document> searchDocById(@PathVariable Long id) {
        Document document = docsTypeService.findById(id);
        if (document != null) {
            return new ResponseEntity<Document>(document, HttpStatus.OK);
        } else {
            return new ResponseEntity<Document>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Document>> getAllDocs() {
        List<Document> all = docsTypeService.findAll();
        return new ResponseEntity<List<Document>>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Document> deleteDoc(@PathVariable Long id) {
        Document document = docsTypeService.findById(id);
        if (document != null) {
            docsTypeService.delete(id);
        } else {
            return new ResponseEntity<Document>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Document>(HttpStatus.OK);
    }

    @RequestMapping(value = "/document", method = RequestMethod.POST)
    public ResponseEntity<Document> createDocument(@RequestBody Document newDoc) {
        Document savedStudent = docsTypeService.save(newDoc);
        return new ResponseEntity<Document>(savedStudent, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Document> updateDocument(@RequestBody Document student, @PathVariable Long id) {
        if (!id.equals(student.getId())) {
            return new ResponseEntity<Document>(HttpStatus.BAD_REQUEST);
        }
        Document newDoc = docsTypeService.save(student);
        return new ResponseEntity<Document>(newDoc, HttpStatus.OK);
    }
}
