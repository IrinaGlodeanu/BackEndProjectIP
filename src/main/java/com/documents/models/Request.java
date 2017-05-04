package com.documents.models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Elena Hardon
 * @date 4/27/17.
 */
@Entity
public class Request {

    @Id
    private Long id;

    private Long studentId;

    private Long documentId;

}
