package com.rs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * created by rs 4/12/2022.
 */
@Entity
@Table(name ="contact_messages")
public class Contact {

    @Id
    @Column(name="contact_id")
    private String contactId;

    @Column(name="contact_name")
    private String contactName;

    @Column(name="contact_email")
    private String contactEmail;

    private String subject;

    private String message;

    @Column(name="create_dt")
    private String createDt;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }
}
