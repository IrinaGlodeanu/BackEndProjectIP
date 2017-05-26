package com.documents;

import com.documents.models.Request;
import com.documents.repositories.RequestRepository;
import com.documents.services.RequestServiceImpl;
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
public class RequestServicesTests {

    @Mock
    private RequestRepository requestRepository;

    @InjectMocks
    private RequestServiceImpl requestService = new RequestServiceImpl();

    @Before
    public void initializeMockito() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void request_save_should_return_true() throws Exception {
        Request requestToSave = new Request();
        Long id = (long) 3;
        Long studentId = (long) 123;
        Long documentId = (long) 10;
        Request requestAfterSave = new Request();

        requestToSave.setId(id);
        requestToSave.setStudentId(studentId);
        requestToSave.setDocumentId(documentId);

        when(requestService.save(any(Request.class))).thenReturn(requestToSave);

        requestAfterSave = requestService.save(requestToSave);
        assertNotNull(requestAfterSave);
        assertEquals(id, requestAfterSave.getId());
        assertEquals(studentId, requestAfterSave.getStudentId());
        assertEquals(documentId, requestAfterSave.getDocumentId());
    }

    @Test
    public void request_findById_should_return_true() throws Exception {
        Request requestToSave = new Request();
        long userId = (long) 123;
        requestToSave.setId(userId);
        when(requestService.findById(any(long.class))).thenReturn(requestToSave);
        Request requestAfterSave = requestService.findById(requestToSave.getId());
        long userIdAfter = requestAfterSave.getId();
        assertNotNull(requestAfterSave);
        assertEquals(userId, userIdAfter);
    }

    @Test
    public void request_deleteById_should_return_true() throws Exception {
        Request request = new Request();
        long userId = 3;
        request.setId(userId);
        requestService.delete(request.getId());
        verify(requestRepository).delete(request.getId());

    }

  /*  @Test
    public void licenseRequest_findAll_should_return_true() throws Exception {
        List<LicenseRegistrationForm> forms = new ArrayList<>();
        LicenseRegistrationForm licenseRegistrationForm =new LicenseRegistrationForm();
        forms.add(licenseRegistrationForm);
        Mockito.when(licenseRegistrationFormServiceImpl.findAll()).thenReturn(forms);
        licenseRegistrationFormServiceImpl.findAll();
        assertNotNull(forms);
    }
 */
}
