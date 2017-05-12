package com.documents.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by pc on 5/11/2017.
 */

@Entity
@DiscriminatorValue("Formular inscriere licenta")
public class LicenseRegistrationForm extends Document {
    @Id
    private Long id;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "matricol_nr")
    private String mantricolNumber;

    @Column(name = "graduation_year")
    private Integer graduationYear;

    @Column(name = "date_receipt_linguistic_competence")
    private String dateReceiptLinguisticCompetence;

    @Column(name = "payment_receipt_linguistic_competence")
    private Integer paymentReceiptLinguisticCompetence;

    @Column(name = "date_receipt_redo_license_exam")
    private String dateReceiptRedoExam;

    @Column(name = "payment_receipt_redo_license_exam")
    private Integer paymentReceiptRedoExam;

    //todo for the table
    //todo the dates to be in the Date format

    @Column(name = "license_topic")
    private String licenseTopic;

    @Column(name = "coordinator_prof")
    private String coordinatorProf;

    @Column(name = "current_date_today")
    private String currentDateToday;

    @Column(name = "phone_number")
    private String phoneNumber;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getDocumentName() {
        return documentName;
    }

    @Override
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMantricolNumber() {
        return mantricolNumber;
    }

    public void setMantricolNumber(String mantricolNumber) {
        this.mantricolNumber = mantricolNumber;
    }

    public Integer getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Integer graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getDateReceiptLinguisticCompetence() {
        return dateReceiptLinguisticCompetence;
    }

    public void setDateReceiptLinguisticCompetence(String dateReceiptLinguisticCompetence) {
        this.dateReceiptLinguisticCompetence = dateReceiptLinguisticCompetence;
    }

    public Integer getPaymentReceiptLinguisticCompetence() {
        return paymentReceiptLinguisticCompetence;
    }

    public void setPaymentReceiptLinguisticCompetence(Integer paymentReceiptLinguisticCompetence) {
        this.paymentReceiptLinguisticCompetence = paymentReceiptLinguisticCompetence;
    }

    public String getDateReceiptRedoExam() {
        return dateReceiptRedoExam;
    }

    public void setDateReceiptRedoExam(String dateReceiptRedoExam) {
        this.dateReceiptRedoExam = dateReceiptRedoExam;
    }

    public Integer getPaymentReceiptRedoExam() {
        return paymentReceiptRedoExam;
    }

    public void setPaymentReceiptRedoExam(Integer paymentReceiptRedoExam) {
        this.paymentReceiptRedoExam = paymentReceiptRedoExam;
    }

    public String getLicenseTopic() {
        return licenseTopic;
    }

    public void setLicenseTopic(String licenseTopic) {
        this.licenseTopic = licenseTopic;
    }

    public String getCoordinatorProf() {
        return coordinatorProf;
    }

    public void setCoordinatorProf(String coordinatorProf) {
        this.coordinatorProf = coordinatorProf;
    }

    public String getCurrentDate() {
        return currentDateToday;
    }

    public void setCurrentDate(String currentDateToday) {
        this.currentDateToday = currentDateToday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
