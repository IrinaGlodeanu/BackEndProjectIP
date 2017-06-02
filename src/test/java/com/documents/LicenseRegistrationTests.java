package com.documents;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.documents.services.PdfUtility;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.documents.models.LicenseRegistrationForm;
import com.documents.repositories.LicenseRegistrationFormRepository;
import com.documents.services.LicenseRegistrationFormServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LicenseRegistrationTests {


    //Arrange
    @Mock
    private LicenseRegistrationFormRepository licenseRegistrationFormRepository;

    @InjectMocks
    private LicenseRegistrationFormServiceImpl licenseRegistrationFormServiceImpl = new LicenseRegistrationFormServiceImpl();

    @Before
    public void initializeMockito() {
        MockitoAnnotations.initMocks(this);
    }


    public void setup(LicenseRegistrationForm licenseRegistrationFormToSet) {

        licenseRegistrationFormToSet.setId((long) 3);
        licenseRegistrationFormToSet.setDocumentName("Document_Name");
        licenseRegistrationFormToSet.setStudentName("Student_Name");
        licenseRegistrationFormToSet.setMantricolNumber("123412123123");
        licenseRegistrationFormToSet.setGraduationYear(2018);
        licenseRegistrationFormToSet.setDateReceiptLinguisticCompetence("12-June-2015");
        licenseRegistrationFormToSet.setPaymentReceiptLinguisticCompetence(300);
        licenseRegistrationFormToSet.setDateReceiptRedoExam("14-August-2016");
        licenseRegistrationFormToSet.setPaymentReceiptRedoExam(300);

    }

    @Test
    public void behavioural_licenseRequest_save_should_return_true() throws Exception {

        //Act
        LicenseRegistrationForm licenseRegistrationFormAfterSave = new LicenseRegistrationForm();
        LicenseRegistrationForm licenseRegistrationFormToSave = new LicenseRegistrationForm();

        setup(licenseRegistrationFormToSave);

        when(licenseRegistrationFormRepository.save(any(LicenseRegistrationForm.class))).thenReturn(licenseRegistrationFormAfterSave);

        licenseRegistrationFormAfterSave = licenseRegistrationFormServiceImpl.save(licenseRegistrationFormToSave);

        //Assert
        assertNotNull(licenseRegistrationFormAfterSave);
    }

    @Test
    public void functionality_licenseRequest_save_should_return_licenseRequest() throws Exception {

        //Act
        LicenseRegistrationForm licenseRegistrationFormAfterSave = new LicenseRegistrationForm();

        setup(licenseRegistrationFormAfterSave);

        when(licenseRegistrationFormRepository.save(any(LicenseRegistrationForm.class))).thenReturn(licenseRegistrationFormAfterSave);

        LicenseRegistrationForm savedLicenseRegForm = licenseRegistrationFormServiceImpl.save(licenseRegistrationFormAfterSave);

        //Assert
        assertEquals(Long.valueOf(3), savedLicenseRegForm.getId());
        assertEquals("Document_Name", savedLicenseRegForm.getDocumentName());
        assertEquals("Student_Name", savedLicenseRegForm.getStudentName());
        assertEquals("123412123123", savedLicenseRegForm.getMantricolNumber());
        assertEquals(Integer.valueOf(2018), savedLicenseRegForm.getGraduationYear());
        assertEquals("12-June-2015", savedLicenseRegForm.getDateReceiptLinguisticCompetence());
        assertEquals(Integer.valueOf(300), savedLicenseRegForm.getPaymentReceiptLinguisticCompetence());
        assertEquals("14-August-2016", savedLicenseRegForm.getDateReceiptRedoExam());
        assertEquals(Integer.valueOf(300), savedLicenseRegForm.getPaymentReceiptRedoExam());

    }

    @Test
    public void behavioural_licenseRequest_findById_should_return_true() throws Exception {

        //Act
        LicenseRegistrationForm licenseRegistrationFormToFind = new LicenseRegistrationForm();

        when(licenseRegistrationFormRepository.findOne(any(long.class))).thenReturn(licenseRegistrationFormToFind);

        licenseRegistrationFormToFind = licenseRegistrationFormServiceImpl.findById((long) 123);

        //Assert
        assertNotNull(licenseRegistrationFormToFind);
    }

    @Test
    public void functionality_licenseRequest_findById_should_return_licenseRequest() throws Exception {

        //Act
        LicenseRegistrationForm licenseRegistrationFormToFind = new LicenseRegistrationForm();

        setup(licenseRegistrationFormToFind);

        when(licenseRegistrationFormRepository.findOne(any(long.class))).thenReturn(licenseRegistrationFormToFind);

        LicenseRegistrationForm foundLicenseRegForm = licenseRegistrationFormServiceImpl.findById((long) 3);

        //Assert
        assertEquals(Long.valueOf(3), foundLicenseRegForm.getId());
        assertEquals("Document_Name", foundLicenseRegForm.getDocumentName());
        assertEquals("Student_Name", foundLicenseRegForm.getStudentName());
        assertEquals("123412123123", foundLicenseRegForm.getMantricolNumber());
        assertEquals(Integer.valueOf(2018), foundLicenseRegForm.getGraduationYear());
        assertEquals("12-June-2015", foundLicenseRegForm.getDateReceiptLinguisticCompetence());
        assertEquals(Integer.valueOf(300), foundLicenseRegForm.getPaymentReceiptLinguisticCompetence());
        assertEquals("14-August-2016", foundLicenseRegForm.getDateReceiptRedoExam());
        assertEquals(Integer.valueOf(300), foundLicenseRegForm.getPaymentReceiptRedoExam());

    }

    @Test
    public void behavioural_licenseRequest_deleteById_should_return_true() throws Exception {

        //Act
        LicenseRegistrationForm licenseRegistrationForm = new LicenseRegistrationForm();

        licenseRegistrationForm.setId((long) 3);

        licenseRegistrationFormServiceImpl.delete(licenseRegistrationForm.getId());

        LicenseRegistrationForm foundLicenseRegistrationForm = licenseRegistrationFormServiceImpl.findById((long) 3);

        //Assert
        assertNull(foundLicenseRegistrationForm);

    }


    @Test
    public void functionality_licenseRequest_deleteById_should_delete_licenseRequest() throws Exception {

        //Act
        LicenseRegistrationForm licenseRegistrationForm = new LicenseRegistrationForm();

        licenseRegistrationFormServiceImpl.delete(licenseRegistrationForm.getId());

        //Assert
        verify(licenseRegistrationFormRepository).delete(licenseRegistrationForm.getId());

    }

    @Test
    public void behavioural_licenseRequest_findAll_should_return_true() throws Exception {

        //Act
        List<LicenseRegistrationForm> licenseRegistrationForms = new ArrayList<>();

        LicenseRegistrationForm licenseRegistrationForm = new LicenseRegistrationForm();

        setup(licenseRegistrationForm);

        when(licenseRegistrationFormRepository.findAll()).thenReturn(licenseRegistrationForms);

        licenseRegistrationForms.add(licenseRegistrationForm);

        List<LicenseRegistrationForm> foundForms;
        foundForms = licenseRegistrationFormServiceImpl.findAll();

        //Assert
        assertNotNull(foundForms);

    }

    @Test
    public void functionality_licenseRequest_findAll_should_return_list_of_licenseRequest() throws Exception {

        //Act
        List<LicenseRegistrationForm> licenseRegistrationForms = new ArrayList<>();

        LicenseRegistrationForm licenseRegistrationForm = new LicenseRegistrationForm();

        setup(licenseRegistrationForm);

        when(licenseRegistrationFormRepository.findAll()).thenReturn(licenseRegistrationForms);

        licenseRegistrationForms.add(licenseRegistrationForm);

        List<LicenseRegistrationForm> foundForms;
        foundForms = licenseRegistrationFormServiceImpl.findAll();

        //Assert
        assertEquals(licenseRegistrationForms.get(0).getId(), foundForms.get(0).getId());
        assertEquals(licenseRegistrationForms.get(0).getDocumentName(), foundForms.get(0).getDocumentName());
        assertEquals(licenseRegistrationForms.get(0).getStudentName(), foundForms.get(0).getStudentName());
        assertEquals(licenseRegistrationForms.get(0).getMantricolNumber(), foundForms.get(0).getMantricolNumber());
        assertEquals(licenseRegistrationForms.get(0).getGraduationYear(), foundForms.get(0).getGraduationYear());
        assertEquals(licenseRegistrationForms.get(0).getDateReceiptLinguisticCompetence(), foundForms.get(0).getDateReceiptLinguisticCompetence());
        assertEquals(licenseRegistrationForms.get(0).getPaymentReceiptLinguisticCompetence(), foundForms.get(0).getPaymentReceiptLinguisticCompetence());
        assertEquals(licenseRegistrationForms.get(0).getDateReceiptRedoExam(), foundForms.get(0).getDateReceiptRedoExam());
        assertEquals(licenseRegistrationForms.get(0).getPaymentReceiptRedoExam(), foundForms.get(0).getPaymentReceiptRedoExam());

    }

    @Test
    public void behavioural_create_pdf() throws Exception {

        List<String> infoList = new ArrayList<>();
        infoList.add("Ciofu Vlad");
        infoList.add("118932 Salveaza-l acum");
        infoList.add("2018");
        infoList.add("3 ");
        infoList.add("");
        infoList.add("10 Ianuarie");
        infoList.add("$$$");
        infoList.add("");
        infoList.add("");
        infoList.add(" Program anti anti plagiere");
        infoList.add(" Cine ma primeste");
        infoList.add("10-06-2018");

        licenseRegistrationFormServiceImpl.createPdf(infoList, "src\\main\\resources\\test.pdf");

        assertEquals(true, new File("src\\main\\resources\\test.pdf").exists());
    }

    @Test
    public void functionality_create_pdf() throws Exception {

        List<String> infoList = new ArrayList<>();
        infoList.add("Ciofu Vlad");
        infoList.add("118932 Salveaza-l acum");
        infoList.add("2018");
        infoList.add("3 ");
        infoList.add("");
        infoList.add("10 Ianuarie");
        infoList.add("$$$");
        infoList.add("");
        infoList.add("");
        infoList.add(" Program anti anti plagiere");
        infoList.add(" Cine ma primeste");
        infoList.add("10-06-2018");

        String pdfPath = "src\\main\\resources\\test.pdf";
        String jsonPath = "src\\main\\resources\\documentsAdditionalText.json";

        licenseRegistrationFormServiceImpl.createPdf(infoList, pdfPath);

        PdfReader pdfReader = new PdfReader(pdfPath);
        String content = PdfTextExtractor.getTextFromPage( pdfReader, 1 );
        pdfReader.close();

        JSONObject obj = new JSONObject(PdfUtility.initiliazeJson(new BufferedReader(new FileReader(jsonPath))));

        String testString = obj.getJSONObject("license_register_request").getString("head1");
        testString += obj.getJSONObject("license_register_request").getString("head2");
        testString += obj.getJSONObject("license_register_request").getString("head3");
        testString += obj.getJSONObject("license_register_request").getString("head4");
        testString += obj.getJSONObject("license_register_request").getString("introduction");
        testString += obj.getJSONObject("license_register_request").getString("text1") + infoList.get(0);
        testString += obj.getJSONObject("license_register_request").getString("text2") + infoList.get(1);
        testString += obj.getJSONObject("license_register_request").getString("text3") + infoList.get(2);
        testString += obj.getJSONObject("license_register_request").getString("text4") + infoList.get(3);
        testString += obj.getJSONObject("license_register_request").getString("text5") + infoList.get(4);
        testString += obj.getJSONObject("license_register_request").getString("text6") + infoList.get(5);
        testString += obj.getJSONObject("license_register_request").getString("text7") + infoList.get(6);
        testString += obj.getJSONObject("license_register_request").getString("text8") + infoList.get(7);
        testString += obj.getJSONObject("license_register_request").getString("text9") + infoList.get(8);
        testString += obj.getJSONObject("license_register_request").getString("text10") + infoList.get(9);
        testString += obj.getJSONObject("license_register_request").getString("text11") + infoList.get(10);
        testString += obj.getJSONObject("license_register_request").getString("text12") + infoList.get(11);
        testString += obj.getJSONObject("license_register_request").getString("text13");

        testString = testString.replace(" ", "");
        testString = testString.replace("\n", "");
        testString = testString.replace("\t", "");

        content = content.replace(" ", "");
        content = content.replace("\n", "");
        content = content.replace("\t", "");

        assertEquals(testString, content);
    }

}


