package com.documents.services;

import com.documents.models.LicenseRegistrationForm;
import com.documents.repositories.LicenseRegistrationFormRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 5/12/2017.
 */

@Service
public class LicenseRegistrationFormServiceImpl implements LicenseRegistrationFormService, Composable {


    @Autowired
    private LicenseRegistrationFormRepository licenseRegFromRepository;

    @Override
    public LicenseRegistrationForm save(LicenseRegistrationForm entity) {
        return this.licenseRegFromRepository.save(entity);
    }

    @Override
    public LicenseRegistrationForm findById(Long id) {
        return this.licenseRegFromRepository.findOne(id);
    }

    @Override
    public List<LicenseRegistrationForm> findAll() {
        List<LicenseRegistrationForm> forms = new ArrayList<>();
        for (LicenseRegistrationForm form : this.licenseRegFromRepository.findAll()) {
            forms.add(form);
        }
        return forms;
    }

    @Override
    public void delete(Long id) {
        this.licenseRegFromRepository.delete(id);
    }

    @Override
    public void createPdf(List<String> infoList) throws IOException, DocumentException {
        /**
         * We insert here the path where we can find the JSON
         */

        BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\documentsAdditionalText.json"));
        List<String> jsonKeys = new ArrayList<>();
        String jsonString;
        Paragraph emptyLines;


        jsonString = PdfUtility.initiliazeJson(br);


        JSONObject obj = new JSONObject(jsonString);
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("head1"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("head2"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("head3"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("head4"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("introduction"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("text1"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("text2"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("text3"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("text4"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("text5"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("text6"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("text7"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("text8"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("text9"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("text10"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("text11"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("text12"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("text13"));
        jsonKeys.add(obj.getJSONObject("license_register_request").getString("final"));


        /**
         * Generate the document with the content extracted from Json
         */
        Document document = PdfUtility.initializeDocument();

        String paragraphElem = PdfUtility.concatenateString(jsonKeys.get(0), jsonKeys.get(1));
        Paragraph paragraph = new Paragraph(paragraphElem, PdfUtility.catFont);
        document.add(paragraph);

        paragraphElem = PdfUtility.concatenateString(jsonKeys.get(2));
        paragraph = new Paragraph(paragraphElem, PdfUtility.catFont);
        document.add(paragraph);

        paragraphElem = PdfUtility.concatenateString(jsonKeys.get(3));
        paragraph = new Paragraph(paragraphElem, PdfUtility.catFont);
        document.add(paragraph);

        emptyLines = PdfUtility.addEmptyLine(3);
        document.add(emptyLines);

        PdfUtility.addTitle(document, jsonKeys.get(4));

        emptyLines = PdfUtility.addEmptyLine(2);
        document.add(emptyLines);

        paragraphElem = PdfUtility.concatenateString(jsonKeys.get(5));
        paragraph = new Paragraph(paragraphElem, PdfUtility.catFont);
        document.add(paragraph);

        paragraphElem = PdfUtility.concatenateString(jsonKeys.get(6));
        paragraph = new Paragraph(paragraphElem, PdfUtility.catFont);
        document.add(paragraph);

        paragraphElem = PdfUtility.concatenateString(jsonKeys.get(7));
        paragraph = new Paragraph(paragraphElem, PdfUtility.catFont);
        document.add(paragraph);

        paragraphElem = PdfUtility.concatenateString(jsonKeys.get(8), jsonKeys.get(9));
        paragraph = new Paragraph(paragraphElem, PdfUtility.catFont);
        document.add(paragraph);

        paragraphElem = PdfUtility.concatenateString(jsonKeys.get(10), jsonKeys.get(11));
        paragraph = new Paragraph(paragraphElem, PdfUtility.catFont);
        document.add(paragraph);

        paragraphElem = PdfUtility.concatenateString(jsonKeys.get(12), jsonKeys.get(13));
        paragraph = new Paragraph(paragraphElem, PdfUtility.catFont);
        document.add(paragraph);

        PdfUtility.addEmptyLine(7);
        document.add(emptyLines);
        document.add(emptyLines);

        paragraphElem = PdfUtility.concatenateString(jsonKeys.get(14));
        paragraph = new Paragraph(paragraphElem, PdfUtility.catFont);
        document.add(paragraph);

        PdfUtility.addEmptyLine(3);
        document.add(emptyLines);

        paragraphElem = PdfUtility.concatenateString(jsonKeys.get(15));
        paragraph = new Paragraph(paragraphElem, PdfUtility.catFont);
        document.add(paragraph);

        PdfUtility.addEmptyLine(7);
        document.add(emptyLines);
        document.add(emptyLines);
        document.add(emptyLines);

        paragraphElem = PdfUtility.concatenateString(jsonKeys.get(16), jsonKeys.get(17));
        paragraph = new Paragraph(paragraphElem, PdfUtility.catFont);
        document.add(paragraph);

        PdfUtility.addEmptyLine(7);
        document.add(emptyLines);
        document.add(emptyLines);

        PdfUtility.addFooter(document, jsonKeys.get(18));

        PdfUtility.finalizeDocument(document);

    }
}
