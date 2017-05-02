package com.documents.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This class represents the models for the student table.
 */
@Entity
public class Student {
    @Id
    private Long id;

    @Column(name = "nrMatricol")
    private String nrMatricol;


    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "cnp")
    private Long cnp;

    @Column(name = "identityCardId")
    private String identityCardId;

    @Column(name = "fatherInitial")
    private String fatherInitial;

    @Column(name = "address")
    private String address;

    @Column(name = "webmail")
    private String webmail;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "password")
    private String password;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCnp() {
        return cnp;
    }

    public void setCnp(Long cnp) {
        this.cnp = cnp;
    }

    public String getIdentityCardId() {
        return identityCardId;
    }

    public void setIdentityCardId(String identityCardId) {
        this.identityCardId = identityCardId;
    }

    public String getFatherInitial() {
        return fatherInitial;
    }

    public void setFatherInitial(String fatherInitial) {
        this.fatherInitial = fatherInitial;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebmail() {
        return webmail;
    }

    public void setWebmail(String webmail) {
        this.webmail = webmail;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
