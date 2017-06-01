package com.documents;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
        LicenseRegistrationForm licenseRegistrationFormToSave = new LicenseRegistrationForm();

        when(licenseRegistrationFormRepository.findOne(any(long.class))).thenReturn(licenseRegistrationFormToSave);

        licenseRegistrationFormToSave = licenseRegistrationFormServiceImpl.findById((long) 123);

        //Assert
        assertNotNull(licenseRegistrationFormToSave);
    }

    @Test
    public void functionality_licenseRequest_findById_should_return_licenseRequest() throws Exception {

        //Act
        LicenseRegistrationForm licenseRegistrationFormToFind = new LicenseRegistrationForm();

        setup(licenseRegistrationFormToFind);

        when(licenseRegistrationFormRepository.findOne(any(long.class))).thenReturn(licenseRegistrationFormToFind);

        LicenseRegistrationForm findedLicenseRegForm = licenseRegistrationFormServiceImpl.findById((long) 3);

        //Assert
        assertEquals(Long.valueOf(3), findedLicenseRegForm.getId());
        assertEquals("Document_Name", findedLicenseRegForm.getDocumentName());
        assertEquals("Student_Name", findedLicenseRegForm.getStudentName());
        assertEquals("123412123123", findedLicenseRegForm.getMantricolNumber());
        assertEquals(Integer.valueOf(2018), findedLicenseRegForm.getGraduationYear());
        assertEquals("12-June-2015", findedLicenseRegForm.getDateReceiptLinguisticCompetence());
        assertEquals(Integer.valueOf(300), findedLicenseRegForm.getPaymentReceiptLinguisticCompetence());
        assertEquals("14-August-2016", findedLicenseRegForm.getDateReceiptRedoExam());
        assertEquals(Integer.valueOf(300), findedLicenseRegForm.getPaymentReceiptRedoExam());

    }

    @Test
    public void behavioural_licenseRequest_deleteById_should_return_true() throws Exception {

        //Act
        LicenseRegistrationForm licenseRegistrationForm = new LicenseRegistrationForm();

        licenseRegistrationForm.setId((long) 3);

        licenseRegistrationFormServiceImpl.delete(licenseRegistrationForm.getId());

        LicenseRegistrationForm findedLicenseRegistrationForm = licenseRegistrationFormServiceImpl.findById((long) 3);

        //Assert
        assertNull(findedLicenseRegistrationForm);

    }


    @Test
    public void functionality_licenseRequest_deleteById_should_return_delete_licenseRequest() throws Exception {

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

        List<LicenseRegistrationForm> findedForms;
        findedForms = licenseRegistrationFormServiceImpl.findAll();

        //Assert
        assertNotNull(findedForms);

    }

    @Test
    public void functionality_licenseRequest_findAll_should_return_list_of_licenseRequest() throws Exception {

        //Act
        List<LicenseRegistrationForm> licenseRegistrationForms = new ArrayList<>();

        LicenseRegistrationForm licenseRegistrationForm = new LicenseRegistrationForm();

        setup(licenseRegistrationForm);

        when(licenseRegistrationFormRepository.findAll()).thenReturn(licenseRegistrationForms);

        licenseRegistrationForms.add(licenseRegistrationForm);

        List<LicenseRegistrationForm> findedForms;
        findedForms = licenseRegistrationFormServiceImpl.findAll();

        //Assert
        assertEquals(licenseRegistrationForms.get(0).getId(), findedForms.get(0).getId());
        assertEquals(licenseRegistrationForms.get(0).getDocumentName(), findedForms.get(0).getDocumentName());
        assertEquals(licenseRegistrationForms.get(0).getStudentName(), findedForms.get(0).getStudentName());
        assertEquals(licenseRegistrationForms.get(0).getMantricolNumber(), findedForms.get(0).getMantricolNumber());
        assertEquals(licenseRegistrationForms.get(0).getGraduationYear(), findedForms.get(0).getGraduationYear());
        assertEquals(licenseRegistrationForms.get(0).getDateReceiptLinguisticCompetence(), findedForms.get(0).getDateReceiptLinguisticCompetence());
        assertEquals(licenseRegistrationForms.get(0).getPaymentReceiptLinguisticCompetence(), findedForms.get(0).getPaymentReceiptLinguisticCompetence());
        assertEquals(licenseRegistrationForms.get(0).getDateReceiptRedoExam(), findedForms.get(0).getDateReceiptRedoExam());
        assertEquals(licenseRegistrationForms.get(0).getPaymentReceiptRedoExam(), findedForms.get(0).getPaymentReceiptRedoExam());

    }

}


