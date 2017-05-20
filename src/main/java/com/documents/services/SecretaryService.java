package com.documents.services;


import com.documents.models.LoginData;
import com.documents.models.Secretary;

public interface SecretaryService extends CrudService<Secretary> {

    /**
     * Function that calls the query from SecretaryRepository
     *
     * @param student
     *
     * @return
     */
    Secretary getSecretary(LoginData student);
}
