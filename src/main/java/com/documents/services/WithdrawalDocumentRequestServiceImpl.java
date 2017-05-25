package com.documents.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documents.models.WithdrawalDocumentRequest;
import com.documents.repositories.WithdrawalDocumentRequestRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

@Service
public class WithdrawalDocumentRequestServiceImpl implements WithdrawalDocumentRequestService, Composable{
    @Autowired
    private WithdrawalDocumentRequestRepository withdrawalDocumentRequestRepository;

    @Override
    public WithdrawalDocumentRequest save(WithdrawalDocumentRequest entity) {
        return this.withdrawalDocumentRequestRepository.save(entity);
    }

    @Override
    public WithdrawalDocumentRequest findById(Long id) {
        return this.withdrawalDocumentRequestRepository.findOne(id);
    }

    @Override
    public List<WithdrawalDocumentRequest> findAll() {
        List<WithdrawalDocumentRequest> withdrawalDocumentRequests = new ArrayList<>();
        for (WithdrawalDocumentRequest withdrawalDocumentRequest : this.withdrawalDocumentRequestRepository.findAll()) {
            withdrawalDocumentRequests.add(withdrawalDocumentRequest);
        }
        return withdrawalDocumentRequests;    }

    @Override
    public void delete(Long id) {
        this.withdrawalDocumentRequestRepository.delete(id);
    }

    @Override
    public void createPdf(List<String> infoList, String filePath) throws IOException, DocumentException {


        BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\documentsAdditionalText.json"));
        List<String> jsonKeys = new ArrayList<>();
        String jsonString;
        Paragraph emptyLines;

        jsonString = PdfUtility.initiliazeJson(br);

        JSONObject obj = new JSONObject(jsonString);
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("introduction"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text1"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text2"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text3"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text4"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text5"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text6"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text7"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("final"));


        Document document = PdfUtility.initializeDocument(filePath);
        PdfUtility.addTitle(document, jsonKeys.get(0));


        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);

        String firstStringParagraph = PdfUtility.concatenateString(jsonKeys.get(1), jsonKeys.get(2),
                jsonKeys.get(3), jsonKeys.get(4), jsonKeys.get(5), jsonKeys.get(6), jsonKeys.get(7));
        Paragraph paragraph = new Paragraph(firstStringParagraph, PdfUtility.catFont);

        document.add(paragraph);

        PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        PdfUtility.addFooter(document, jsonKeys.get(8));


        PdfUtility.addEmptyLine(10);
        document.add(emptyLines);

        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("introduction2"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text10"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text11"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text12"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text13"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text14"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text15"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("fina16"));



        PdfUtility.addTitle(document, jsonKeys.get(9));


        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);

        firstStringParagraph = PdfUtility.concatenateString(jsonKeys.get(10), jsonKeys.get(11),
                jsonKeys.get(12), jsonKeys.get(13), jsonKeys.get(14), jsonKeys.get(15));
        paragraph = new Paragraph(firstStringParagraph, PdfUtility.catFont);

        document.add(paragraph);

        PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        PdfUtility.addFooter(document, jsonKeys.get(16));

        PdfUtility.addEmptyLine(10);
        document.add(emptyLines);

        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text17"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text18"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text19"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text20"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text21"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text22"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text23"));


        emptyLines = PdfUtility.addEmptyLine(3);
        document.add(emptyLines);
        firstStringParagraph = jsonKeys.get(17);
        paragraph = new Paragraph(firstStringParagraph, PdfUtility.catFont);
        document.add(paragraph);

        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        firstStringParagraph = jsonKeys.get(18);
        paragraph = new Paragraph(firstStringParagraph, PdfUtility.catFont);
        document.add(paragraph);

        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        firstStringParagraph = jsonKeys.get(19);
        paragraph = new Paragraph(firstStringParagraph, PdfUtility.catFont);
        document.add(paragraph);

        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        firstStringParagraph = jsonKeys.get(20);
        paragraph = new Paragraph(firstStringParagraph, PdfUtility.catFont);
        document.add(paragraph);

        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        firstStringParagraph = jsonKeys.get(21);
        paragraph = new Paragraph(firstStringParagraph, PdfUtility.catFont);
        document.add(paragraph);

        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        firstStringParagraph = jsonKeys.get(22);
        paragraph = new Paragraph(firstStringParagraph, PdfUtility.catFont);
        document.add(paragraph);

        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        firstStringParagraph = jsonKeys.get(23);
        paragraph = new Paragraph(firstStringParagraph, PdfUtility.catFont);
        document.add(paragraph);


        PdfUtility.finalizeDocument(document);

    }

}
