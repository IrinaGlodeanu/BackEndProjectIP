package com.documents;

import com.documents.models.LicenseRegistrationForm;
import com.documents.repositories.LicenseRegistrationFormRepository;
import com.documents.services.LicenseRegistrationFormServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LicenseRegistrationTests {

    @Mock
    private LicenseRegistrationFormRepository licenseRegistrationFormRepository;

    @InjectMocks
    private LicenseRegistrationFormServiceImpl licenseRegistrationFormServiceImpl = new LicenseRegistrationFormServiceImpl();

    @Before
    public void initializeMockito() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void licenseRequest_save_should_return_true() throws Exception {
        LicenseRegistrationForm licenseRegistrationFormToSave = new LicenseRegistrationForm();
        Long id = (long) 3;
        String documentName = "Document_Name";
        String studentName = "Student_Name";
        String nrMatricol = "123412123123";
        Integer graduationYear = 2018;
        String dateReceiptLinguisticCompetence = "12-June-2015";
        Integer paymentReceiptLinguisticCompetence = 300;
        String dateReceiptRedoExam = "14-August-2016";
        Integer paymentReceiptRedoExam = 300;
        LicenseRegistrationForm licenseRegistrationFormAfterSave = new LicenseRegistrationForm();

        licenseRegistrationFormAfterSave.setId(id);
        licenseRegistrationFormAfterSave.setDocumentName(documentName);
        licenseRegistrationFormAfterSave.setStudentName(studentName);
        licenseRegistrationFormAfterSave.setMantricolNumber(nrMatricol);
        licenseRegistrationFormAfterSave.setGraduationYear(graduationYear);
        licenseRegistrationFormAfterSave.setDateReceiptLinguisticCompetence(dateReceiptLinguisticCompetence);
        licenseRegistrationFormAfterSave.setPaymentReceiptLinguisticCompetence(paymentReceiptLinguisticCompetence);
        licenseRegistrationFormAfterSave.setDateReceiptRedoExam(dateReceiptRedoExam);
        licenseRegistrationFormAfterSave.setPaymentReceiptRedoExam(paymentReceiptRedoExam);

        when(licenseRegistrationFormServiceImpl.save(any(LicenseRegistrationForm.class))).thenReturn(licenseRegistrationFormAfterSave);

        LicenseRegistrationForm newLicenseRegistration = licenseRegistrationFormServiceImpl.save(licenseRegistrationFormToSave);
        assertNotNull(newLicenseRegistration);
        assertEquals(id, newLicenseRegistration.getId());
        assertEquals(documentName, newLicenseRegistration.getDocumentName());
        assertEquals(studentName, newLicenseRegistration.getStudentName());
        assertEquals(nrMatricol, newLicenseRegistration.getMantricolNumber());
        assertEquals(graduationYear, newLicenseRegistration.getGraduationYear());
        assertEquals(dateReceiptLinguisticCompetence, newLicenseRegistration.getDateReceiptLinguisticCompetence());
        assertEquals(paymentReceiptLinguisticCompetence, newLicenseRegistration.getPaymentReceiptLinguisticCompetence());
        assertEquals(dateReceiptRedoExam, newLicenseRegistration.getDateReceiptRedoExam());
        assertEquals(paymentReceiptRedoExam, newLicenseRegistration.getPaymentReceiptRedoExam());


    }

    @Test
    public void licenseRequest_findById_should_return_true() throws Exception {
        LicenseRegistrationForm licenseRegistrationFormToSave = new LicenseRegistrationForm();
        long userId = (long) 123;
        licenseRegistrationFormToSave.setId(userId);
        when(licenseRegistrationFormServiceImpl.findById(any(long.class))).thenReturn(licenseRegistrationFormToSave);
        LicenseRegistrationForm newLicenseRegistration = licenseRegistrationFormServiceImpl.findById(licenseRegistrationFormToSave.getId());
        long userIdAfter = newLicenseRegistration.getId();
        assertNotNull(newLicenseRegistration);
        assertEquals(userId, userIdAfter);
    }

    @Test
    public void licenseRequest_deleteById_should_return_true() throws Exception {
        LicenseRegistrationForm licenseRegistrationForm = new LicenseRegistrationForm();
        long userId = 3;
        licenseRegistrationForm.setId(userId);
        licenseRegistrationFormServiceImpl.delete(licenseRegistrationForm.getId());
        verify(licenseRegistrationFormRepository).delete(licenseRegistrationForm.getId());

    }

   /* @Test
    public void licenseRequest_findAll_should_return_true() throws Exception {
        List<LicenseRegistrationForm> forms = new ArrayList<>();
        List<LicenseRegistrationForm> frm = new ArrayList<>();
        LicenseRegistrationForm licenseRegistrationForm = new LicenseRegistrationForm();
        forms.add(licenseRegistrationForm);
        Mockito.when(licenseRegistrationFormServiceImpl.findAll()).thenReturn(forms);
        frm = licenseRegistrationFormServiceImpl.findAll();
        assertNotNull(frm);
    }
*/
}
