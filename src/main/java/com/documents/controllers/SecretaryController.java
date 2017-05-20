package com.documents.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.documents.models.LoginData;
import com.documents.models.Secretary;
import com.documents.services.SecretaryService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/secretary")
public class SecretaryController {

    @Autowired
    private SecretaryService secretaryService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Secretary> searchSecretaryById(@PathVariable Long id) {
        Secretary secretary = secretaryService.findById(id);
        if (secretary != null) {
            return new ResponseEntity<Secretary>(secretary, HttpStatus.OK);
        } else {
            return new ResponseEntity<Secretary>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a specific secretary from database
     *
     * @param id of the secretary you want to delete it
     *
     * @return - a status if the student with that id was delete it or not
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Secretary> deleteSecretary(@PathVariable Long id) {
        Secretary secretary = secretaryService.findById(id);
        if (secretary != null) {
            secretaryService.delete(id);
        } else {
            return new ResponseEntity<Secretary>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Secretary>(HttpStatus.OK);
    }

    /**
     * Insert a new secretary into the database
     *
     * @param newSecretary - a new Secretary object that you want to insert into the database
     *
     * @return - the newSecretary inserted plus a status if was successfully inserted
     */

    @RequestMapping(value = "/secretary", method = RequestMethod.POST)
    public ResponseEntity<Secretary> createSecretary(@RequestBody Secretary newSecretary) {
        Secretary savedSecretary = secretaryService.save(newSecretary);
        return new ResponseEntity<Secretary>(savedSecretary, HttpStatus.CREATED);
    }

    /**
     * Update a secretary data(change his information in database)
     *
     * @param secretary - a new Secretary Object
     * @param id - the id of the secretary where you want to insert new data
     *  You save into the database the changed secretary object
     * @return return a status if was successfully updated
     */

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Secretary> updateSecretary(@RequestBody Secretary secretary, @PathVariable Long id) {
        if (!id.equals(secretary.getId())) {
            return new ResponseEntity<Secretary>(HttpStatus.BAD_REQUEST);
        }
        Secretary newSecretary = secretaryService.save(secretary);
        return new ResponseEntity<Secretary>(newSecretary, HttpStatus.OK);
    }

    /**
     * Get a Secretary object if we find the webmail and password in the database(Login purpose)
     * We call the function getSecretary from SecretaryServiceImpl
     * @return Secretary Object
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Secretary> getIdForLogin(@RequestBody LoginData loginData) {
        Secretary secretary = secretaryService.getSecretary(loginData);
        if (!secretary.equals(null)) {
            secretary.setPassword(null);
            return new ResponseEntity<>(secretary, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }


}
