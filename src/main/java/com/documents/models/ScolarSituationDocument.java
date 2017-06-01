package com.documents.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ScolarSituation")
@DiscriminatorValue("Cerere Situatie Scolara")
public class ScolarSituationDocument extends Document {
    @Id
    private Long id;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "current_year")
    private String currentYear;

    @Column(name = "year_of_study")
    private String yearOfStudy;

    @Column(name = "receipt_received")
    private String hasBroughtReceipt;

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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(String currentYear) {
        this.currentYear = currentYear;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getHasBroughtReceipt() {
        return hasBroughtReceipt;
    }

    public void setHasBroughtReceipt(String hasBroughtReceipt) {
        this.hasBroughtReceipt = hasBroughtReceipt;
    }
}
