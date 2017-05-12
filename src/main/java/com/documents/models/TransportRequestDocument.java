package com.documents.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Simona on 12-May-17.
 */
@Entity
@DiscriminatorValue("Cerere Transport")
public class TransportRequestDocument extends Document {
    @Id
    private Long id;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "nr_series_id")
    private Integer nrSeriesId;

    @Column(name = "year_of_study")
    private Integer yearOfStudy;

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

    public Integer getNrSeriesId() {
        return nrSeriesId;
    }

    public void setNrSeriesId(Integer nrSeriesId) {
        this.nrSeriesId = nrSeriesId;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
