package com.documents.services;

import java.io.IOException;
import java.util.List;

import com.documents.models.Document;
import com.itextpdf.text.DocumentException;

public interface Composable {

    void createPdf(List<String> infoList) throws IOException, DocumentException;
}
