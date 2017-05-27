package com.documents.models;

public class WithdrawalInput {

    private String nrSeriesId;
    private String yearOfStudy;
    private String currentYear;
    private String course;

    public String getNrSeriesId() {
        return nrSeriesId;
    }

    public void setNrSeriesId(String nrSeriesId) {
        this.nrSeriesId = nrSeriesId;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(String currentYear) {
        this.currentYear = currentYear;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
