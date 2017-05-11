package com.documents.services;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

public interface Composable {

    void createPdf() throws IOException, DocumentException;
}
