package com.documents.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.Student;
import com.documents.models.TransportRequestDocument;
import com.documents.repositories.TransportRequestDocumentRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

@Service
public class TransportRequestDocumentServiceImpl implements TransportRequestDocumentService, Composable {

    @PersistenceContext
     private EntityManager entityManager;

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

    public void createPdf(List<String> infoList ) throws IOException, DocumentException {

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
        jsonKeys.add(obj.getJSONObject("transport_request").getString("text1") + infoList.get(0));
        jsonKeys.add(obj.getJSONObject("transport_request").getString("text2") + infoList.get(1));
        jsonKeys.add(obj.getJSONObject("transport_request").getString("text3") + infoList.get(2));
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
        String firstStringParagraph = PdfUtility.concatenateString(jsonKeys.get(1), jsonKeys.get(2),
                jsonKeys.get(3), jsonKeys.get(4));
        Paragraph firstParagraph = new Paragraph(firstStringParagraph, PdfUtility.catFont);
        document.add(firstParagraph);

        emptyLines = PdfUtility.addEmptyLine(1);
        document.add(emptyLines);
        String secondStringParagraph = PdfUtility.concatenateString(jsonKeys.get(5));
        Paragraph secondParagraph = new Paragraph(secondStringParagraph, PdfUtility.catFont);
        document.add(secondParagraph);

        emptyLines = PdfUtility.addEmptyLine(2);
        document.add(emptyLines);
        String thirdStringParagraph = PdfUtility.concatenateString(jsonKeys.get(6));
        Paragraph thirdParagraph = new Paragraph(thirdStringParagraph, PdfUtility.catFont);
        document.add(thirdParagraph);

        emptyLines = PdfUtility.addEmptyLine(1);
        document.add(emptyLines);
        String forthStringParagraph = PdfUtility.concatenateString(jsonKeys.get(7));
        Paragraph forthParagraph = new Paragraph(forthStringParagraph, PdfUtility.catFont);
        document.add(forthParagraph);

        emptyLines = PdfUtility.addEmptyLine(8);
        document.add(emptyLines);
        String fifthStringParagraph = PdfUtility.concatenateString(jsonKeys.get(8));
        Paragraph fifthParagraph = new Paragraph(fifthStringParagraph, PdfUtility.catFont);
        document.add(fifthParagraph);

        emptyLines = PdfUtility.addEmptyLine(1);
        document.add(emptyLines);
        String sixthStringParagraph = PdfUtility.concatenateString(jsonKeys.get(9));
        Paragraph sixthParagraph = new Paragraph(sixthStringParagraph, PdfUtility.catFont);
        document.add(sixthParagraph);

        emptyLines = PdfUtility.addEmptyLine(1);
        document.add(emptyLines);
        String seventhStringParagraph = PdfUtility.concatenateString(jsonKeys.get(10));
        Paragraph seventhParagraph = new Paragraph(seventhStringParagraph, PdfUtility.catFont);
        document.add(seventhParagraph);


        PdfUtility.finalizeDocument(document);


    }


    /**
     * Get all the students that have a transport request
     * @return
     */
    public List<Student> getStudentListForTransport(){
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM STUDENT s \n" +
                        "    join request r on r.student_id = s.id\n" +
                        "    join document d on d.id = r.document_id\n" +
                        "    where d.id = 1;" , Student.class);
        List resultList = query.getResultList();

        return resultList;
    }

}
