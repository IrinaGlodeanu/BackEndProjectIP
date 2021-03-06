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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.documents.models.Request;
import com.documents.models.ScolarSituationDocument;
import com.documents.models.ScolarSituationDocumentInput;
import com.documents.models.Student;
import com.documents.services.RequestService;
import com.documents.services.ScolarSituationRequestService;
import com.documents.services.StudentService;
import com.itextpdf.text.DocumentException;

@Controller
@CrossOrigin("*")
@RequestMapping(value = "/scolarSituation")
public class ScolarSituationRequestController {

    static Long idScolarSituation = Long.valueOf("0");

    @Autowired
    private StudentService studentService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private ScolarSituationRequestService scolarSituationRequestService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ScolarSituationDocument> searchDocById(@PathVariable Long id) {
        ScolarSituationDocument document = scolarSituationRequestService.findById(id);
        if (document != null) {
            return new ResponseEntity<ScolarSituationDocument>(document, HttpStatus.OK);
        } else {
            return new ResponseEntity<ScolarSituationDocument>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ScolarSituationDocument>> getAllDocs() {
        List<ScolarSituationDocument> all = scolarSituationRequestService.findAll();
        return new ResponseEntity<List<ScolarSituationDocument>>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ScolarSituationDocument> deleteDoc(@PathVariable Long id) {
        ScolarSituationDocument document = scolarSituationRequestService.findById(id);
        if (document != null) {
            scolarSituationRequestService.delete(id);
        } else {
            return new ResponseEntity<ScolarSituationDocument>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ScolarSituationDocument>(HttpStatus.OK);
    }

    @RequestMapping(value = "/document", method = RequestMethod.POST)
    public ResponseEntity<ScolarSituationDocument> createDocument(@RequestBody ScolarSituationDocument newDoc) {
        ScolarSituationDocument savedStudent = scolarSituationRequestService.save(newDoc);
        return new ResponseEntity<ScolarSituationDocument>(savedStudent, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ScolarSituationDocument> updateDocument(@RequestBody ScolarSituationDocument student, @PathVariable Long id) {
        if (!id.equals(student.getId())) {
            return new ResponseEntity<ScolarSituationDocument>(HttpStatus.BAD_REQUEST);
        }
        ScolarSituationDocument newDoc = scolarSituationRequestService.save(student);
        return new ResponseEntity<ScolarSituationDocument>(newDoc, HttpStatus.OK);
    }


    @RequestMapping(value = "/insert/{id}", method = RequestMethod.POST)
    public ResponseEntity<Request> insertScolarSituation(@RequestBody ScolarSituationDocumentInput scolarSituationInput, @PathVariable String id) {
        Student student = this.studentService.findById(Long.parseLong(id));

        if (student.equals(null)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ScolarSituationDocument scolarSituationDocument = new ScolarSituationDocument();
        scolarSituationDocument.setId(idScolarSituation + 1);
        idScolarSituation = idScolarSituation + 1;
        scolarSituationDocument.setStudentId(student.getId().toString());
        scolarSituationDocument.setStudentName(student.getFirstName());
        scolarSituationDocument.setCurrentYear(scolarSituationInput.getCurrentYear());
        scolarSituationDocument.setYearOfStudy(scolarSituationInput.getYearOfStudy());

        this.scolarSituationRequestService.save(scolarSituationDocument);

        Request request = new Request();
        request.setId(idRequest + 1);
        idRequest = idRequest + 1;
        request.setStudentId(student.getId());
        request.setDocumentId(Long.parseLong("5"));
        this.requestService.save(request);

        return new ResponseEntity<Request>(request, HttpStatus.OK);
    }

    @RequestMapping(value = "getStudent/{id}", method = RequestMethod.GET)
    public ResponseEntity<ScolarSituationDocument> getStudent(@PathVariable Long id) {
        ScolarSituationDocument scolarSituationDocument = this.scolarSituationRequestService.getStudentListByScolarSituationDocument(id);
        if (scolarSituationDocument.equals(null)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(scolarSituationDocument, HttpStatus.OK);

    }


    @RequestMapping(value = "/getPdf/{id}/scolarSituation.pdf", method = RequestMethod.GET)
    public javax.ws.rs.core.Response getPdf(@PathVariable String id, HttpServletResponse response) throws IOException, DocumentException {

            /* change */
        String fileName = "D:\\ScolarSituationRequest.pdf";


        Student student = this.studentService.findById(Long.parseLong(id));
        ScolarSituationDocument scolarSituationDocument = this.scolarSituationRequestService.getStudentListByScolarSituationDocument(Long.parseLong(id));

        if (student != null) {

            List<String> infoList = new ArrayList<String>();

            infoList.add(student.getFirstName() + " " + student.getLastName());
            infoList.add(scolarSituationDocument.getCurrentYear());
            infoList.add(scolarSituationDocument.getYearOfStudy());

            this.scolarSituationRequestService.createPdf(infoList, fileName);

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
