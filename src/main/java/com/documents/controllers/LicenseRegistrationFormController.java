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

import com.documents.models.LicenseRegistrationForm;
import com.documents.services.LicenseRegistrationFormService;

/**
 * Created by pc on 5/12/2017.
 */
@RestController
@RequestMapping(value = "/license")
public class LicenseRegistrationFormController {

    @Autowired
    private LicenseRegistrationFormService licenseRegistrationFormServiceService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<LicenseRegistrationForm> searchLicenseRegistrationFormById(@PathVariable Long id) {
        LicenseRegistrationForm licenseRegistrationFormService = licenseRegistrationFormServiceService.findById(id);
        if (licenseRegistrationFormService != null) {
            return new ResponseEntity<LicenseRegistrationForm>(licenseRegistrationFormService, HttpStatus.OK);
        } else {
            return new ResponseEntity<LicenseRegistrationForm>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<LicenseRegistrationForm>> getAllLicenseRegistrationForms() {
        List<LicenseRegistrationForm> all = licenseRegistrationFormServiceService.findAll();
        return new ResponseEntity<List<LicenseRegistrationForm>>(all, HttpStatus.OK);
    }

    /**
     * @param id
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<LicenseRegistrationForm> deleteLicenseRegistrationForm(@PathVariable Long id) {
        LicenseRegistrationForm licenseRegistrationForm = licenseRegistrationFormServiceService.findById(id);
        if (licenseRegistrationForm != null) {
            licenseRegistrationFormServiceService.delete(id);
        } else {
            return new ResponseEntity<LicenseRegistrationForm>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<LicenseRegistrationForm>(HttpStatus.OK);
    }


    @RequestMapping(value = "/LicenseRegistrationForm", method = RequestMethod.POST)
    public ResponseEntity<LicenseRegistrationForm> createLicenseRegistrationForm(@RequestBody LicenseRegistrationForm newLicenseRegistrationForm) {
        LicenseRegistrationForm savedLicenseRegistrationForm = licenseRegistrationFormServiceService.save(newLicenseRegistrationForm);
        return new ResponseEntity<LicenseRegistrationForm>(savedLicenseRegistrationForm, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<LicenseRegistrationForm> updateLicenseRegistrationForm(@RequestBody LicenseRegistrationForm licenseForm, @PathVariable Long id) {
        if (!id.equals(licenseForm.getId())) {
            return new ResponseEntity<LicenseRegistrationForm>(HttpStatus.BAD_REQUEST);
        }
        LicenseRegistrationForm newForm = licenseRegistrationFormServiceService.save(licenseForm);
        return new ResponseEntity<LicenseRegistrationForm>(newForm, HttpStatus.OK);
    }
}
