package com.documents.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.DiplomaDocumentRequest;
import com.documents.repositories.DiplomaDocumentRequestRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

@Service
public class DiplomaDocumentRequestServiceImpl implements DiplomaDocumentRequestService, Composable {
    @Autowired
    DiplomaDocumentRequestRepository diplomaDocumentRequestRepository;

    @Override
    public DiplomaDocumentRequest save(DiplomaDocumentRequest entity) {
        return this.diplomaDocumentRequestRepository.save(entity);
    }

    @Override
    public DiplomaDocumentRequest findById(Long id) {
        return this.diplomaDocumentRequestRepository.findOne(id);
    }

    @Override
    public List<DiplomaDocumentRequest> findAll() {
        List<DiplomaDocumentRequest> diplomaDocumentRequests = new ArrayList<>();
        for (DiplomaDocumentRequest diplomaDocumentRequestt : this.diplomaDocumentRequestRepository.findAll()) {
            diplomaDocumentRequests.add(diplomaDocumentRequestt);
        }
        return diplomaDocumentRequests;
    }

    @Override
    public void delete(Long id) {
        this.diplomaDocumentRequestRepository.delete(id);
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
        jsonKeys.add(obj.getJSONObject("diploma_request").getString("introduction"));
        jsonKeys.add(obj.getJSONObject("diploma_request").getString("text1"));
        jsonKeys.add(obj.getJSONObject("diploma_request").getString("text2"));
        jsonKeys.add(obj.getJSONObject("diploma_request").getString("text3"));
        jsonKeys.add(obj.getJSONObject("diploma_request").getString("text4"));
        jsonKeys.add(obj.getJSONObject("diploma_request").getString("final"));


        /**
         * Generate the document with the content extracted from Json
         */
        Document document = PdfUtility.initializeDocument();
        PdfUtility.addTitle(document, jsonKeys.get(0));


        emptyLines = PdfUtility.addEmptyLine(10);
        document.add(emptyLines);

        String s = PdfUtility.concatenateString(jsonKeys.get(1), jsonKeys.get(2),
                jsonKeys.get(3), jsonKeys.get(4));
        Paragraph paragraph = new Paragraph(s, PdfUtility.catFont);

        document.add(paragraph);

        PdfUtility.addEmptyLine(7);
        document.add(emptyLines);
        PdfUtility.addFooter(document, jsonKeys.get(5));

        PdfUtility.finalizeDocument(document);


    }


}
