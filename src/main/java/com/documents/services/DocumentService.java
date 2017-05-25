package com.documents.services;

import java.util.List;

import com.documents.models.Document;

/**
 * Created by pc on 5/7/2017.
 */
public interface DocumentService extends CrudService<Document> {

    List<Document> findDocumentHistory(String id);
}
