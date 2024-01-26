package com.demo.snap.unit.service.impl;

/**
 * @Author: Soe Ye Aung
 * @Date: 24/1/24
 * @Time: 1:43 am
 */

import com.demo.snap.entity.DocumentInfo;
import com.demo.snap.record.DocumentInfoRecord;
import com.demo.snap.repository.DocumentInfoRepository;
import com.demo.snap.unit.service.DocumentInfoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentInfoServiceImpl implements DocumentInfoService {

    private final DocumentInfoRepository documentInfoRepository;

    public DocumentInfoServiceImpl(DocumentInfoRepository documentInfoRepository) {
        this.documentInfoRepository = documentInfoRepository;
    }

    @Override
    public List<DocumentInfoRecord> getDocumentInfoList() {
        List<DocumentInfo> documentInfoList = (List<DocumentInfo>) documentInfoRepository.findAll();
        return documentInfoList.stream().map(documentInfo -> {
            return new DocumentInfoRecord(documentInfo.getId(), documentInfo.getDocName(), documentInfo.getDocType(), documentInfo.getDocStatus());
        }).collect(Collectors.toList());
    }

    @Override
    public List<DocumentInfoRecord> getDocumentInfosByDocName(String docName) {
        return documentInfoRepository.findByDocName(docName).stream().map(documentInfo -> {
            return new DocumentInfoRecord(documentInfo.getId(), documentInfo.getDocName(), documentInfo.getDocType(), documentInfo.getDocStatus());
        }).collect(Collectors.toList());
    }

    @Override
    public List<DocumentInfoRecord> getDocumentInfosByDocType(String docType) {
        return documentInfoRepository.findByDocType(docType).stream().map(documentInfo -> {
            return new DocumentInfoRecord(documentInfo.getId(), documentInfo.getDocName(), documentInfo.getDocType(), documentInfo.getDocStatus());
        }).collect(Collectors.toList());
    }

    @Override
    public List<DocumentInfoRecord> getDocumentInfosByDocStatus(String docStatus) {
        return documentInfoRepository.findByDocStatus(docStatus).stream().map(documentInfo -> {
            return new DocumentInfoRecord(documentInfo.getId(), documentInfo.getDocName(), documentInfo.getDocType(), documentInfo.getDocStatus());
        }).collect(Collectors.toList());
    }

    @Override
    public DocumentInfoRecord getDocumentInfoById(Long id) {
        DocumentInfo documentInfo = documentInfoRepository.findById(id).get();
        return new DocumentInfoRecord(documentInfo.getId(), documentInfo.getDocName(), documentInfo.getDocType(), documentInfo.getDocStatus());
    }

}
