package com.documents.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Requests {

    @Id
    private Long id;

    @Column(name = "nrMatricol")
    private String nrMatricol;

    @Column(name = "documentType")
    private String documentType;

    @Column(name = "dataString")
    private String dataString;

    @Column(name = "approved")
    private boolean approved;

    @Column(name = "notified")
    private boolean notified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNrMatricol() {
        return nrMatricol;
    }

    public void setNrMatricol(String nrMatricol) {
        this.nrMatricol = nrMatricol;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isNotified() {
        return notified;
    }

    public void setNotified(boolean notified) {
        this.notified = notified;
    }
}
