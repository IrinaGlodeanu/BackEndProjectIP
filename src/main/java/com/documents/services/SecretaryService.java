package com.documents.services;


import com.documents.models.LoginData;
import com.documents.models.Secretary;

/**
 * Created by Georgiana&Ecaterina on 07.05.2017.
 */
public interface SecretaryService extends CrudService<Secretary> {

    Secretary getSecretary(LoginData student);
}
