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

/**
 * Created by Cami on 2017-05-11.
 */
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
    public void createPdf() throws IOException, DocumentException {


        BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\documentsAdditionalText.json"));
        List<String> jsonKeys = new ArrayList<>();
        String jsonString;
        Paragraph emptyLines;


        jsonString = PdfUtility.initiliazeJson(br);


        //prima parte
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



        Document document = PdfUtility.initializeDocument();
        PdfUtility.addTitle(document, jsonKeys.get(0));


        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);

        String s = PdfUtility.concatenateString(jsonKeys.get(1), jsonKeys.get(2),
                jsonKeys.get(3), jsonKeys.get(4), jsonKeys.get(5), jsonKeys.get(6), jsonKeys.get(7));
        Paragraph paragraph = new Paragraph(s, PdfUtility.catFont);

        document.add(paragraph);

        PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        PdfUtility.addFooter(document, jsonKeys.get(8));


        PdfUtility.addEmptyLine(10);
        document.add(emptyLines);

        //declaratie
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("introduction2"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text21"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text22"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text23"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text24"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text25"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text26"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("final2"));



        PdfUtility.addTitle(document, jsonKeys.get(9));


        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);

        String s2 = PdfUtility.concatenateString(jsonKeys.get(10), jsonKeys.get(11),
                jsonKeys.get(12), jsonKeys.get(13), jsonKeys.get(14), jsonKeys.get(15));
        Paragraph paragraph2 = new Paragraph(s2, PdfUtility.catFont);

        document.add(paragraph2);

        PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        PdfUtility.addFooter(document, jsonKeys.get(16));

        PdfUtility.addEmptyLine(10);
        document.add(emptyLines);


        //stampile
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text31"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text32"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text33"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text34"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text35"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text36"));
        jsonKeys.add(obj.getJSONObject("withdrawal_document_request").getString("text37"));


        emptyLines = PdfUtility.addEmptyLine(3);
        document.add(emptyLines);
        String s31 =jsonKeys.get(17);
        Paragraph paragraph31 = new Paragraph(s31, PdfUtility.catFont);
        document.add(paragraph31);

        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        String s32 =jsonKeys.get(18);
        Paragraph paragraph32 = new Paragraph(s32, PdfUtility.catFont);
        document.add(paragraph32);

        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        String s33 =jsonKeys.get(19);
        Paragraph paragraph33 = new Paragraph(s33, PdfUtility.catFont);
        document.add(paragraph33);

        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        String s34 =jsonKeys.get(20);
        Paragraph paragraph34 = new Paragraph(s34, PdfUtility.catFont);
        document.add(paragraph34);

        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        String s35 =jsonKeys.get(21);
        Paragraph paragraph35 = new Paragraph(s35, PdfUtility.catFont);
        document.add(paragraph35);

        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        String s36 =jsonKeys.get(22);
        Paragraph paragraph36 = new Paragraph(s36, PdfUtility.catFont);
        document.add(paragraph36);

        emptyLines = PdfUtility.addEmptyLine(5);
        document.add(emptyLines);
        String s37 =jsonKeys.get(23);
        Paragraph paragraph37 = new Paragraph(s37, PdfUtility.catFont);
        document.add(paragraph37);

        PdfUtility.finalizeDocument(document);

    }

    public static void main(String[] args) throws IOException, DocumentException {
        WithdrawalDocumentRequestServiceImpl ceva = new WithdrawalDocumentRequestServiceImpl();
        ceva.createPdf();
    }

}
