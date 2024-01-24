package com.demo.snap.service;

/**
 * @Author: Soe Ye Aung
 * @Date: 24/1/24
 * @Time: 1:43 am
 */

import com.demo.snap.record.DocumentInfoRecord;
import java.util.List;

public interface DocumentInfoService {

    List<DocumentInfoRecord> getDocumentInfoList();
    List<DocumentInfoRecord> getDocumentInfosByDocName(String docName);
    List<DocumentInfoRecord> getDocumentInfosByDocType(String docType);
    List<DocumentInfoRecord> getDocumentInfosByDocStatus(String docStatus);
    DocumentInfoRecord getDocumentInfoById(Long id);

}
