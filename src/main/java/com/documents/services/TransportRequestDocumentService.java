package com.documents.services;

import java.io.IOException;
import java.util.List;

import com.documents.models.Student;
import com.documents.models.TransportRequestDocument;
import com.itextpdf.text.DocumentException;


public interface TransportRequestDocumentService extends CrudService<TransportRequestDocument> {

    List<Student> getStudentListForTransport();
    void createPdf(List<String> list) throws IOException, DocumentException;
}

