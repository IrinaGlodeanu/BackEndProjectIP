package com.documents.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Elena Hardon
 * @date 4/27/17.
 */
@Entity
public class Document {

    @Id
    private Long id;

    @Column(name = "document_type")
    private String documentType;

}
