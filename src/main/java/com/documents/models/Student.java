package com.documents.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Elena Hardon
 * @date 4/27/17.
 */

/**
 * This class represents the model for the student table.
 */
@Entity
public class Student {

    @Id
    private Long id;

    @Column(name = "matricol_nr")
    private String mantricolNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "cnp")
    private Long cnp;

    @Column(name = "card_id")
    private String identityCardId;

    @Column(name = "father_initial")
    private String fatherInitial;

    @Column(name = "address")
    private String address;

    @Column(name = "webmail")
    private String webmail;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMantricolNumber() {
        return mantricolNumber;
    }

    public void setMantricolNumber(String mantricolNumber) {
        this.mantricolNumber = mantricolNumber;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
