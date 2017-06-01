package com.documents.services;


import java.io.IOException;
import java.util.List;

import com.documents.models.ScolarSituationDocument;
import com.itextpdf.text.DocumentException;

public interface ScolarSituationRequestService extends CrudService<ScolarSituationDocument> {

    void createPdf(List<String> list, String filePath) throws IOException, DocumentException;
    ScolarSituationDocument getStudentListByScolarSituationDocument(Long id);
}

