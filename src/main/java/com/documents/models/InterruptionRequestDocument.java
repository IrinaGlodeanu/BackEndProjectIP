package com.documents.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Simona on 11-May-17.
 */
@Entity
@DiscriminatorValue("Cerere Intrerupere Studii")
public class InterruptionRequestDocument extends Document {
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

    @Column(name = "starting_semester")
    private Integer startingSemester;

    @Column(name = "from_university_year")
    private Integer fromUniversityYear;

    @Column(name = "number_of_semesters")
    private Integer numberOfSemesters;


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

    public Integer getStartingSemester() {
        return startingSemester;
    }

    public void setStartingSemester(Integer startingSemester) {
        this.startingSemester = startingSemester;
    }

    public Integer getFromUniversityYear() {
        return fromUniversityYear;
    }

    public void setFromUniversityYear(Integer fromUniversityYear) {
        this.fromUniversityYear = fromUniversityYear;
    }

    public Integer getNumberOfSemesters() {
        return numberOfSemesters;
    }

    public void setNumberOfSemesters(Integer numberOfSemesters) {
        this.numberOfSemesters = numberOfSemesters;
    }
}
