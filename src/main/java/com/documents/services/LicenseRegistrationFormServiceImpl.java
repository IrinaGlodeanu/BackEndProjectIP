package com.documents.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.LicenseRegistrationForm;
import com.documents.repositories.LicenseRegistrationFormRepository;

/**
 * Created by pc on 5/12/2017.
 */

@Service
public class LicenseRegistrationFormServiceImpl implements LicenseRegistrationFormService {


    @Autowired
    private LicenseRegistrationFormRepository licenseRegFromRepository;

    @Override
    public LicenseRegistrationForm save(LicenseRegistrationForm entity) {
        return this.licenseRegFromRepository.save(entity);
    }

    @Override
    public LicenseRegistrationForm findById(Long id) {
        return this.licenseRegFromRepository.findOne(id);
    }

    @Override
    public List<LicenseRegistrationForm> findAll() {
        List<LicenseRegistrationForm> forms = new ArrayList<>();
        for (LicenseRegistrationForm form : this.licenseRegFromRepository.findAll()) {
            forms.add(form);
        }
        return forms;
    }

    @Override
    public void delete(Long id) {
        this.licenseRegFromRepository.delete(id);
    }
}
