package com.documents.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Cami on 2017-05-11.
 */
@Entity
@Table(name = "Withdrawal")
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
    private int numberIDCard;

    @Column(name = "study_year")
    private int studyYear;

    @Column(name = "university_year")
    private int universityYear;

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
    private int numberBAC;

    @Column(name = "number_sheet")
    private int numberSheet;

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

    public int getNumberIDCard() {
        return numberIDCard;
    }

    public void setNumberIDCard(int numberIDCard) {
        this.numberIDCard = numberIDCard;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    public int getUniversityYear() {
        return universityYear;
    }

    public void setUniversityYear(int universityYear) {
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

    public int getNumberBAC() {
        return numberBAC;
    }

    public void setNumberBAC(int numberBAC) {
        this.numberBAC = numberBAC;
    }

    public int getNumberSheet() {
        return numberSheet;
    }

    public void setNumberSheet(int numberSheet) {
        this.numberSheet = numberSheet;
    }
}
