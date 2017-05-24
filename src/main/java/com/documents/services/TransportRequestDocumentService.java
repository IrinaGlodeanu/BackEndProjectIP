package com.documents.services;

import java.util.List;

import com.documents.models.Student;
import com.documents.models.TransportRequestDocument;


public interface TransportRequestDocumentService extends CrudService<TransportRequestDocument> {
    List<Student> getStudentListForTransport();
}

