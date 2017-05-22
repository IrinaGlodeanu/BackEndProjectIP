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

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "current_year")
    private Integer currentYear;

    @Column(name = "year_of_study")
    private Integer yearOfStudy;

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

    public Integer getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(Integer currentYear) {
        this.currentYear = currentYear;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getHasBroughtReceipt() {
        return hasBroughtReceipt;
    }

    public void setHasBroughtReceipt(String hasBroughtReceipt) {
        this.hasBroughtReceipt = hasBroughtReceipt;
    }
}
