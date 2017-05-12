package com.documents.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.documents.models.LicenseRegistrationForm;

/**
 * Created by pc on 5/12/2017.
 */
@Repository
public interface LicenseRegistrationFormRepository extends CrudRepository<LicenseRegistrationForm, Long> {
}