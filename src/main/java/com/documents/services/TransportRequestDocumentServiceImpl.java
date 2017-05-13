package com.documents.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.TransportRequestDocument;
import com.documents.repositories.TransportRequestDocumentRepository;

/**
 * Created by Ecaterina Mihaela on 13-May-17.
 */
@Service
public class TransportRequestDocumentServiceImpl implements TransportRequestDocumentService, Composable {

    @Autowired
    private TransportRequestDocumentRepository transportRequestDocumentRepository;

    @Override
    public TransportRequestDocument save(TransportRequestDocument entity) {
        return this.transportRequestDocumentRepository.save(entity);

    }

    @Override
    public TransportRequestDocument findById(Long id) {
        return this.transportRequestDocumentRepository.findOne(id);
    }

    @Override
    public List<TransportRequestDocument> findAll() {
        List<TransportRequestDocument> transportRequestDocuments = new ArrayList<>();
        for (TransportRequestDocument transportRequestDocument : this.transportRequestDocumentRepository.findAll()) {
            transportRequestDocuments.add(transportRequestDocument);
        }
        return transportRequestDocuments;
    }

    @Override
    public void delete(Long id) {
        this.transportRequestDocumentRepository.delete(id);
    }

    @Override
    public void createPdf() throws IOException, DocumentException {


        /**
         * We insert here the path where we can find the JSON
         */

        BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\documentsAdditionalText.json"));
        List<String> jsonKeys = new ArrayList<>();
        String jsonString;
        Paragraph emptyLines;


        jsonString = PdfUtility.initiliazeJson(br);


        JSONObject obj = new JSONObject(jsonString);
        jsonKeys.add(obj.getJSONObject("transport_request").getString("introduction"));
        jsonKeys.add(obj.getJSONObject("transport_request").getString("text1"));
        jsonKeys.add(obj.getJSONObject("transport_request").getString("text2"));
        jsonKeys.add(obj.getJSONObject("transport_request").getString("text3"));
        jsonKeys.add(obj.getJSONObject("transport_request").getString("text4"));
        jsonKeys.add(obj.getJSONObject("transport_request").getString("text5"));
        jsonKeys.add(obj.getJSONObject("transport_request").getString("final1"));
        jsonKeys.add(obj.getJSONObject("transport_request").getString("final2"));
        jsonKeys.add(obj.getJSONObject("transport_request").getString("subsol1"));
        jsonKeys.add(obj.getJSONObject("transport_request").getString("subsol2"));
        jsonKeys.add(obj.getJSONObject("transport_request").getString("subsol3"));

        /**
         * Generate the document with the content extracted from Json
         */
        Document document = PdfUtility.initializeDocument();
        PdfUtility.addTitle(document, jsonKeys.get(0));


        emptyLines = PdfUtility.addEmptyLine(2);
        document.add(emptyLines);
        String s = PdfUtility.concatenateString(jsonKeys.get(1), jsonKeys.get(2),
                jsonKeys.get(3), jsonKeys.get(4));
        Paragraph paragraph = new Paragraph(s, PdfUtility.catFont);
        document.add(paragraph);

        emptyLines = PdfUtility.addEmptyLine(1);
        document.add(emptyLines);
        String s1 = PdfUtility.concatenateString(jsonKeys.get(5));
        Paragraph paragraph1 = new Paragraph(s1, PdfUtility.catFont);
        document.add(paragraph1);

        emptyLines = PdfUtility.addEmptyLine(2);
        document.add(emptyLines);
        String s2 = PdfUtility.concatenateString(jsonKeys.get(6));
        Paragraph paragraph2 = new Paragraph(s2, PdfUtility.catFont);
        document.add(paragraph2);

        emptyLines = PdfUtility.addEmptyLine(1);
        document.add(emptyLines);
        String s3 = PdfUtility.concatenateString(jsonKeys.get(7));
        Paragraph paragraph3 = new Paragraph(s3, PdfUtility.catFont);
        document.add(paragraph3);

        emptyLines = PdfUtility.addEmptyLine(8);
        document.add(emptyLines);
        String s4 = PdfUtility.concatenateString(jsonKeys.get(8));
        Paragraph paragraph4 = new Paragraph(s4, PdfUtility.catFont);
        document.add(paragraph4);

        emptyLines = PdfUtility.addEmptyLine(1);
        document.add(emptyLines);
        String s5 = PdfUtility.concatenateString(jsonKeys.get(9));
        Paragraph paragraph5 = new Paragraph(s5, PdfUtility.catFont);
        document.add(paragraph5);

        emptyLines = PdfUtility.addEmptyLine(1);
        document.add(emptyLines);
        String s6 = PdfUtility.concatenateString(jsonKeys.get(10));
        Paragraph paragraph6 = new Paragraph(s6, PdfUtility.catFont);
        document.add(paragraph6);


        PdfUtility.finalizeDocument(document);


    }
}
