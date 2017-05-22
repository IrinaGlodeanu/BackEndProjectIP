package com.documents.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.InterruptionRequestDocument;
import com.documents.repositories.InterruptionRequestDocumentRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

/**
 * Created by Simona on 11-May-17.
 */
@Service
public class InterruptionRequestDocumentServiceImpl implements InterruptionRequestDocumentService, Composable {

    @Autowired
    private InterruptionRequestDocumentRepository interruptionRequestDocumentRepository;

    @Override
    public InterruptionRequestDocument save(InterruptionRequestDocument entity) {
        return this.interruptionRequestDocumentRepository.save(entity);

    }

    @Override
    public InterruptionRequestDocument findById(Long id) {
        return this.interruptionRequestDocumentRepository.findOne(id);
    }

    @Override
    public List<InterruptionRequestDocument> findAll() {
        List<InterruptionRequestDocument> interruptionRequestDocuments = new ArrayList<>();
        for (InterruptionRequestDocument interruptionRequestDocument : this.interruptionRequestDocumentRepository.findAll()) {
            interruptionRequestDocuments.add(interruptionRequestDocument);
        }
        return interruptionRequestDocuments;
    }

    @Override
    public void delete(Long id) {
        this.interruptionRequestDocumentRepository.delete(id);
    }

    @Override
    public void createPdf() throws IOException, DocumentException {

        BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\documentsAdditionalText.json"));
        List<String> jsonKeys = new ArrayList<>();
        String jsonString;
        Paragraph emptyLines;


        jsonString = PdfUtility.initiliazeJson(br);


        JSONObject obj = new JSONObject(jsonString);
        jsonKeys.add(obj.getJSONObject("interruption_request").getString("introduction"));
        jsonKeys.add(obj.getJSONObject("interruption_request").getString("text1"));
        jsonKeys.add(obj.getJSONObject("interruption_request").getString("text2"));
        jsonKeys.add(obj.getJSONObject("interruption_request").getString("text3"));
        jsonKeys.add(obj.getJSONObject("interruption_request").getString("text4"));
        jsonKeys.add(obj.getJSONObject("interruption_request").getString("text5"));
        jsonKeys.add(obj.getJSONObject("interruption_request").getString("text6"));
        jsonKeys.add(obj.getJSONObject("interruption_request").getString("text7"));
        jsonKeys.add(obj.getJSONObject("interruption_request").getString("text8"));
        jsonKeys.add(obj.getJSONObject("interruption_request").getString("final"));


        // Generate the document with the content extracted from Json
        Document document = PdfUtility.initializeDocument();
        PdfUtility.addTitle(document, jsonKeys.get(0));


        emptyLines = PdfUtility.addEmptyLine(4);
        document.add(emptyLines);

        String firstStringParagraph = PdfUtility.concatenateString(jsonKeys.get(1), jsonKeys.get(2),
                jsonKeys.get(3), jsonKeys.get(4),  jsonKeys.get(5),  jsonKeys.get(6), jsonKeys.get(7));
        Paragraph firstParagraph = new Paragraph(firstStringParagraph, PdfUtility.catFont);

        document.add(firstParagraph);

        String secondStringParagraph = PdfUtility.concatenateString(jsonKeys.get(8));
        Paragraph secondParagraph = new Paragraph(secondStringParagraph, PdfUtility.catFont);

        document.add(secondParagraph);

        PdfUtility.addEmptyLine(11);
        document.add(emptyLines);
        PdfUtility.addFooter(document, jsonKeys.get(9));

        PdfUtility.finalizeDocument(document);
    }
}
