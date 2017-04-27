package com.documents.entity;

import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author Elena Hardon
 * @date 4/27/17.
 */
@Entity
public class Secretary {

    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "webmail")
    private String webmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getWebmail() {
        return webmail;
    }

    public void setWebmail(String webmail) {
        this.webmail = webmail;
    }
}
