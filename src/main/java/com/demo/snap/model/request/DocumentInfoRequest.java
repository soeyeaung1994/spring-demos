package com.demo.snap.model.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @Author: Soe Ye Aung
 * @Date: 26/1/24
 * @Time: 3:41 pm
 */
public class DocumentInfoRequest {

    private Long id;

    private String docName;

    private String docType;

    private String docStatus;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentInfoRequest that = (DocumentInfoRequest) o;

        if (!id.equals(that.id)) return false;
        if (!docName.equals(that.docName)) return false;
        if (!docType.equals(that.docType)) return false;
        return docStatus.equals(that.docStatus);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + docName.hashCode();
        result = 31 * result + docType.hashCode();
        result = 31 * result + docStatus.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DocumentInfoRequest{" +
                "id=" + id +
                ", docName='" + docName + '\'' +
                ", docType='" + docType + '\'' +
                ", docStatus='" + docStatus + '\'' +
                '}';
    }
}
