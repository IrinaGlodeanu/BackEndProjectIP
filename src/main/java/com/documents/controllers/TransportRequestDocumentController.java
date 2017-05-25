package com.documents.controllers;


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

import com.documents.models.Student;
import com.documents.models.TransportRequestDocument;
import com.documents.services.StudentService;
import com.documents.services.TransportRequestDocumentService;
import com.itextpdf.text.DocumentException;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/transport")
public class TransportRequestDocumentController {


    @Autowired
    TransportRequestDocumentService transportRequestDocumentService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TransportRequestDocument> getRequestbyId(@PathVariable Long id) {
        TransportRequestDocument transportDocument = transportRequestDocumentService.findById(id);
        if (transportDocument != null) {
            return new ResponseEntity<TransportRequestDocument>(transportDocument, HttpStatus.OK);
        } else {
            return new ResponseEntity<TransportRequestDocument>(HttpStatus.NO_CONTENT);
        }
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<TransportRequestDocument>> getAllInterruptionRequest() {
        List<TransportRequestDocument> interruptionDocumentList = transportRequestDocumentService.findAll();
        return new ResponseEntity<List<TransportRequestDocument>>(interruptionDocumentList, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TransportRequestDocument> deleteInterruptionRequest(@PathVariable Long id) {
        TransportRequestDocument requestDocument = transportRequestDocumentService.findById(id);
        if (requestDocument != null) {
            transportRequestDocumentService.delete(id);
        } else {
            return new ResponseEntity<TransportRequestDocument>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<TransportRequestDocument>(HttpStatus.OK);
    }


    @RequestMapping(value = "/transportation", method = RequestMethod.POST)
    public ResponseEntity<TransportRequestDocument> createInterruptionRequest(@RequestBody TransportRequestDocument newStudent) {
        TransportRequestDocument savedRequestDocument = transportRequestDocumentService.save(newStudent);
        return new ResponseEntity<TransportRequestDocument>(savedRequestDocument, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TransportRequestDocument> updateInterruptionRequest(@RequestBody TransportRequestDocument interruptionRequest, @PathVariable Long id) {
        if (!id.equals(interruptionRequest.getId())) {
            return new ResponseEntity<TransportRequestDocument>(HttpStatus.BAD_REQUEST);
        }
        TransportRequestDocument newStudent = transportRequestDocumentService.save(interruptionRequest);
        return new ResponseEntity<TransportRequestDocument>(newStudent, HttpStatus.OK);
    }

    /**
     * Get the list of students that have a Transport Request
     * @return Student List
     */
    @RequestMapping(value = "/studentList",method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudentListForTransport(){
        List<Student> list = this.transportRequestDocumentService.getStudentListForTransport();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(list,HttpStatus.OK);
    }


    @RequestMapping(value = "/getPdf/{id}/transport.pdf", method = RequestMethod.GET)
    public javax.ws.rs.core.Response getPdf(@PathVariable String id, HttpServletResponse response) throws IOException, DocumentException {


        String fileName = "D:\\transportRequest.pdf";

        Student student = this.studentService.findById(Long.parseLong(id));

        List<String> infoList = new ArrayList<String>();
        infoList.add(student.getFirstName() +" "+ student.getLastName() );
        infoList.add(student.getIdentityCardId());
        /** NU OBSERVAM */
        infoList.add("2");

        this.transportRequestDocumentService.createPdf(infoList, fileName);

        InputStream is = null;
        File file = null;
        try {
            file = new File(fileName);
            is = new FileInputStream(file);
            IOUtils.copy(is, response.getOutputStream());
            response.setContentType("application/pdf");
            response.flushBuffer();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            is.close();
            file.delete();
        }
        javax.ws.rs.core.Response.ResponseBuilder responseBuilder = javax.ws.rs.core.Response.ok((Object) is);
        responseBuilder.type("application/pdf");
        responseBuilder.header("Content-Disposition", "filename=test.pdf");
        return responseBuilder.build();
    }



}
