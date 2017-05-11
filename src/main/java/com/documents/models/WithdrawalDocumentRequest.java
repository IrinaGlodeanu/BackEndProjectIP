package com.documents.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Cami on 2017-05-11.
 */
@Entity
@DiscriminatorValue("Cerere retragere")
public class WithdrawalDocumentRequest extends Document{
    @Id
    private Long id;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "series_ID_Card")
    private String series;

    @Column(name = "number_ID_Card")
    private Long numberIDCard;

    @Column(name = "study_year")
    private Long studyYear;

    @Column(name = "university_year")
    private Long universityYear;

    @Column(name = "type_of_courses")
    private String typeOfCourses;

    @Column(name = "approve_reason")
    private String approveReason;

    @Column(name = "date")
    private String date;

    @Column(name = "signature")
    private String signature;

    @Column(name = "series_BAC")
    private String seriesBAC;

    @Column(name = "number_BAC")
    private Long numberBAC;

    @Column(name = "number_sheet")
    private Long numberSheet;

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

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Long getNumberIDCard() {
        return numberIDCard;
    }

    public void setNumberIDCard(Long numberIDCard) {
        this.numberIDCard = numberIDCard;
    }

    public Long getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(Long studyYear) {
        this.studyYear = studyYear;
    }

    public Long getUniversityYear() {
        return universityYear;
    }

    public void setUniversityYear(Long universityYear) {
        this.universityYear = universityYear;
    }

    public String getTypeOfCourses() {
        return typeOfCourses;
    }

    public void setTypeOfCourses(String typeOfCourses) {
        this.typeOfCourses = typeOfCourses;
    }

    public String getApproveReason() {
        return approveReason;
    }

    public void setApproveReason(String approveReason) {
        this.approveReason = approveReason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSeriesBAC() {
        return seriesBAC;
    }

    public void setSeriesBAC(String seriesBAC) {
        this.seriesBAC = seriesBAC;
    }

    public Long getNumberBAC() {
        return numberBAC;
    }

    public void setNumberBAC(Long numberBAC) {
        this.numberBAC = numberBAC;
    }

    public Long getNumberSheet() {
        return numberSheet;
    }

    public void setNumberSheet(Long numberSheet) {
        this.numberSheet = numberSheet;
    }
}
