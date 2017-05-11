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

import com.documents.models.Request;
import com.documents.services.RequestService;

/**
 * Created by Cami on 2017-05-11.
 */
@RestController
@RequestMapping(value = "/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    /**
     * Get a specific request with a specific id
     *
     * @param id of the request you want searched
     *
     * @return the request with that particular id (if exists in the database)
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Request> searchRequestById(@PathVariable Long id) {
        Request request = requestService.findById(id);
        if (request != null) {
            return new ResponseEntity<Request>(request, HttpStatus.OK);
        } else {
            return new ResponseEntity<Request>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Return all the requests from database
     *
     * @return a List with all the requests that are in the database
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Request>> getAllRequests() {
        List<Request> all = requestService.findAll();
        return new ResponseEntity<List<Request>>(all, HttpStatus.OK);
    }

    /**
     * Delete a specific request from database
     *
     * @param id of the request you want to delete it
     *
     * @return - a status if the request with that id was delete it or not
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Request> deleteRequest(@PathVariable Long id) {
        Request request = requestService.findById(id);
        if (request != null) {
            requestService.delete(id);
        } else {
            return new ResponseEntity<Request>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Request>(HttpStatus.OK);
    }

    /**
     * Insert a new request into the database
     *
     * @param newRequest - a new Request object that you want to insert into the database
     *
     * @return - the newRequest inserted plus a status if was successfully inserted
     */

    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public ResponseEntity<Request> createRequest(@RequestBody Request newRequest) {
        Request savedRequest = requestService.save(newRequest);
        return new ResponseEntity<Request>(savedRequest, HttpStatus.CREATED);
    }

    /**
     * Update a request data(change his information in database)
     *
     * @param request - a new Request Object
     * @param id - the id of the request where you want to insert new data
     *  You save into the database the changed request object
     * @return return a status if was successfully updated
     */

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Request> updateRequest(@RequestBody Request request, @PathVariable Long id) {
        if (!id.equals(request.getId())) {
            return new ResponseEntity<Request>(HttpStatus.BAD_REQUEST);
        }
        Request newRequest = requestService.save(request);
        return new ResponseEntity<Request>(newRequest, HttpStatus.OK);
    }
}

