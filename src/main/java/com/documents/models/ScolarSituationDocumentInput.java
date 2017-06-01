package com.documents.models;

public class ScolarSituationDocumentInput {
    private String yearOfStudy;
    private String currentYear;
    private String typeOfCourses;
    private String motivation;

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

    public String getTypeOfCourses() {
        return typeOfCourses;
    }

    public void setTypeOfCourses(String typeOfCourses) {
        this.typeOfCourses = typeOfCourses;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }
}
