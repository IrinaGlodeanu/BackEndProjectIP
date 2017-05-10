package com.documents.controllers;

import com.documents.models.Secretary;
import com.documents.services.SecretaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Georgiana&Ecaterina on 07.05.2017.
 */

@RestController
public class SecretaryController {

    @Autowired
    private SecretaryService studentService;

    @RequestMapping(value = "/secretary/{id}", method = RequestMethod.GET)
    public ResponseEntity<Secretary> searchStudentById(@PathVariable Long id) {
        Secretary secretary = studentService.findById(id);
        if (secretary != null) {
            return new ResponseEntity<Secretary>(secretary, HttpStatus.OK);
        } else {
            return new ResponseEntity<Secretary>(HttpStatus.NOT_FOUND);
        }
    }
}
