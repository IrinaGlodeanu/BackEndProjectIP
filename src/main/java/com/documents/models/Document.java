package com.documents.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * The @Inheritance specifies the fact that this class can be inherited.
 * The @DiscriminatorColumn defines the name of the column to be added into the table containing all the inheritors of this class,
 * and the type of the discriminator that will be a string.
 * Long story short : the column "document_type" from the table containing all the types of documents will contain a string with the
 * name of the Document.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "document_type", discriminatorType = DiscriminatorType.STRING)
public class Document {

    @Id
    private Long id;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "valability_in_days")
    private String valabilityInDays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getValabilityInDays() {
        return valabilityInDays;
    }

    public void setValabilityInDays(String valabilityInDays) {
        this.valabilityInDays = valabilityInDays;
    }


}

