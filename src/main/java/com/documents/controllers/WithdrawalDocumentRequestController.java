package com.documents.controllers;

import static com.documents.controllers.TransportRequestDocumentController.idRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.documents.models.Request;
import com.documents.models.Student;
import com.documents.models.WithdrawalDocumentRequest;
import com.documents.models.WithdrawalInput;
import com.documents.services.RequestService;
import com.documents.services.StudentService;
import com.documents.services.WithdrawalDocumentRequestService;
import com.itextpdf.text.DocumentException;

/**
 * Created by Cami on 2017-05-11.
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/withdrawalDocumentRequest")
public class WithdrawalDocumentRequestController {

    static Long idWithdrawal = Long.valueOf("0");

    @Autowired
    private StudentService studentService;


    @Autowired
    private RequestService requestService;


    @Autowired
    private WithdrawalDocumentRequestService withdrawalDocumentRequestService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<WithdrawalDocumentRequest> searchWithdrawalDocumentRequestById(@PathVariable Long id) {
        WithdrawalDocumentRequest withdrawalDocumentRequest = withdrawalDocumentRequestService.findById(id);
        if (withdrawalDocumentRequest != null) {
            return new ResponseEntity<WithdrawalDocumentRequest>(withdrawalDocumentRequest, HttpStatus.OK);
        } else {
            return new ResponseEntity<WithdrawalDocumentRequest>(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<WithdrawalDocumentRequest>> getAllWithdrawalDocumentRequests() {
        List<WithdrawalDocumentRequest> all = withdrawalDocumentRequestService.findAll();
        return new ResponseEntity<List<WithdrawalDocumentRequest>>(all, HttpStatus.OK);
    }

   
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<WithdrawalDocumentRequest> deleteWithdrawalDocumentRequest(@PathVariable Long id) {
        WithdrawalDocumentRequest withdrawalDocumentRequest = withdrawalDocumentRequestService.findById(id);
        if (withdrawalDocumentRequest != null) {
            withdrawalDocumentRequestService.delete(id);
        } else {
            return new ResponseEntity<WithdrawalDocumentRequest>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<WithdrawalDocumentRequest>(HttpStatus.OK);
    }


    @RequestMapping(value = "/withdrawalDocumentRequest", method = RequestMethod.POST)
    public ResponseEntity<WithdrawalDocumentRequest> createWithdrawalDocumentRequest(@RequestBody WithdrawalDocumentRequest newWithdrawalDocumentRequest) {
        WithdrawalDocumentRequest savedWithdrawalDocumentRequest = withdrawalDocumentRequestService.save(newWithdrawalDocumentRequest);
        return new ResponseEntity<WithdrawalDocumentRequest>(savedWithdrawalDocumentRequest, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<WithdrawalDocumentRequest> updateWithdrawalDocumentRequest(@RequestBody WithdrawalDocumentRequest withdrawalDocumentRequest, @PathVariable Long id) {
        if (!id.equals(withdrawalDocumentRequest.getId())) {
            return new ResponseEntity<WithdrawalDocumentRequest>(HttpStatus.BAD_REQUEST);
        }
        WithdrawalDocumentRequest newWithdrawalDocumentRequest = withdrawalDocumentRequestService.save(withdrawalDocumentRequest);
        return new ResponseEntity<WithdrawalDocumentRequest>(newWithdrawalDocumentRequest, HttpStatus.OK);
    }


    @RequestMapping(value = "/insert/{id}", method = RequestMethod.POST)
    public ResponseEntity<Request> insertTransportRequest(@RequestBody WithdrawalInput withdrawalInput, @PathVariable String id) {
        Student student = this.studentService.findById(Long.parseLong(id));

        if (student.equals(null)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        WithdrawalDocumentRequest withdrawalDocumentRequest = new WithdrawalDocumentRequest();
        withdrawalDocumentRequest.setId(idWithdrawal + 1);
        idWithdrawal = idWithdrawal + 1;
        withdrawalDocumentRequest.setStudentId(student.getId());
        withdrawalDocumentRequest.setSeries(withdrawalInput.getNrSeriesId());

        //anul de stiud
        String yearStudy = withdrawalInput.getCurrentYear();
        withdrawalDocumentRequest.setUniversityYear(Long.valueOf(yearStudy.substring(yearStudy.length() - 1)));

        //anul in care e
        withdrawalDocumentRequest.setStudyYear(Long.valueOf(withdrawalInput.getYearOfStudy()));
        withdrawalDocumentRequest.setTypeOfCourses(withdrawalInput.getCourse());

        this.withdrawalDocumentRequestService.save(withdrawalDocumentRequest);

        Request request = new Request();
        request.setId(idRequest + 1);
        idRequest = idRequest + 1;
        request.setStudentId(student.getId());
        request.setDocumentId(Long.parseLong("2"));
        this.requestService.save(request);

        return new ResponseEntity<Request>(request, HttpStatus.OK);
    }

    /**
     * Generate the document for a particular student with the id received from PathVariable
     * @param id
     * @param response
     * @return - stream of octets ('pdf')
     * @throws IOException
     * @throws DocumentException
     */

    @RequestMapping(value = "/getPdf/{id}/intrerupere.pdf", method = RequestMethod.GET)
    public javax.ws.rs.core.Response getPdf(@PathVariable String id, HttpServletResponse response) throws IOException, DocumentException {

            /* change */
        String fileName = "D:\\transportRequest.pdf";

        Student student = this.studentService.findById(Long.parseLong(id));
        if( student != null){

            List<String> infoList = new ArrayList<String>();
            infoList.add(student.getFirstName() +" "+ student.getLastName() );
            infoList.add(student.getIdentityCardId());
            infoList.add("2");//nr random
            infoList.add("2017");//an univ
            infoList.add("2");
            infoList.add("Ceva");
            infoList.add("Ceva");

            this.withdrawalDocumentRequestService.createPdf(infoList, fileName);

            InputStream is = null;
            File file = null;
            try {
                file = new File(fileName);
                is = new FileInputStream(file);
                IOUtils.copy(is, response.getOutputStream());
                response.setContentType("application/pdf");
                response.flushBuffer();
            } catch (FileNotFoundException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            } finally {
                is.close();
                file.delete();
            }
            javax.ws.rs.core.Response.ResponseBuilder responseBuilder = javax.ws.rs.core.Response.ok((Object) is);
            responseBuilder.type("application/pdf");
            responseBuilder.header("Content-Disposition", "filename=intrerupere.pdf");
            return responseBuilder.build();

        }

        javax.ws.rs.core.Response.ResponseBuilder responseBuilder = javax.ws.rs.core.Response.noContent();
        return responseBuilder.build();

    }

}
