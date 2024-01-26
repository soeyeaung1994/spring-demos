package com.demo.snap.model.entity;

/**
 * @Author: Soe Ye Aung
 * @Date: 24/1/24
 * @Time: 1:43 am
 */

import jakarta.persistence.*;

@Entity
public class DocumentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String docName;

    @Column(nullable = false)
    private String docType;

    @Column(nullable = false)
    private String docStatus;

    public DocumentInfo(Long id, String docName, String docType, String docStatus) {
        this.id = id;
        this.docName = docName;
        this.docType = docType;
        this.docStatus = docStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

}
