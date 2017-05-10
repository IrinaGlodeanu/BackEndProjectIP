package com.documents.services;

import com.documents.models.Secretary;
import com.documents.repositories.SecretaryRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiana&Ecaterina on 07.05.2017.
 */
public class SecretaryServiceImpl implements SecretaryService {
    @Autowired
    private SecretaryRepository secretaryRepository;

    @Override
    public Secretary save(Secretary entity) {
        return this.secretaryRepository.save(entity);
    }

    @Override
    public Secretary findById(Long id) {
        return this.secretaryRepository.findOne(id);
    }

    @Override
    public List<Secretary> findAll() {
        List<Secretary> secretaries = new ArrayList<>();
        for (Secretary secretary : this.secretaryRepository.findAll()) {
            secretaries.add(secretary);
        }
        return secretaries;
    }

    @Override
    public void delete(Long id) {
        this.secretaryRepository.delete(id);
    }


}
