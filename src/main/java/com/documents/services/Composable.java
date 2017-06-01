package com.documents.services;

import java.io.IOException;
import java.util.List;

import com.itextpdf.text.DocumentException;

public interface Composable {

    void createPdf(List<String> infoList, String filePath) throws IOException, DocumentException;
}
