package com.documents.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.Request;
import com.documents.repositories.RequestRepository;

/**
 * Created by Cami on 2017-05-11.
 */
@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public Request save(Request entity) {
        return this.requestRepository.save(entity);
    }

    @Override
    public Request findById(Long id) {
        return this.requestRepository.findOne(id);
    }

    @Override
    public List<Request> findAll() {
        List<Request> requests = new ArrayList<>();
        for (Request request : this.requestRepository.findAll()) {
            requests.add(request);
        }
        return requests;
    }

    @Override
    public void delete(Long id) {
        this.requestRepository.delete(id);
    }
}

