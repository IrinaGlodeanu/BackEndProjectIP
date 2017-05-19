package com.documents.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.LoginData;
import com.documents.models.Secretary;
import com.documents.repositories.SecretaryRepository;

/**
 * @author Georgiana&Ecaterina 
 * @date 07.05.2017.
 */
@Service
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


    @Override
    public Secretary getSecretary(LoginData secretary) {
        return secretaryRepository.findByWebmailAndPassword(secretary.getEmail(), secretary.getPassword());
    }
}
