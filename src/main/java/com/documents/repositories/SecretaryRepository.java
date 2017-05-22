package com.documents.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.documents.models.Secretary;

/**
 * @author Elena Hardon
 * @date 4/27/17.
 */
@Repository
public interface SecretaryRepository extends CrudRepository<Secretary, Long> {

    /**
     * Query that search the webmail and the password(for login)
     *
     * @param webmail
     * @param password
     *
     * @return Secretary Object
     */
    Secretary findByWebmailAndPassword(String webmail, String password);
}
