package com.demo.snap.service.impl;

/**
 * @Author: Soe Ye Aung
 * @Date: 24/1/24
 * @Time: 1:43 am
 */

import com.demo.snap.model.entity.DocumentInfo;
import com.demo.snap.model.record.DocumentInfoRecord;
import com.demo.snap.model.request.DocumentInfoRequest;
import com.demo.snap.repository.DocumentInfoRepository;
import com.demo.snap.service.DocumentInfoService;
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

    @Override
    public List<DocumentInfoRecord> saveDocumentInfos(List<DocumentInfoRequest> documentInfoRequests) {
        List<DocumentInfo> documentInfos = documentInfoRequests.stream().map(documentInfoRequest -> new DocumentInfo(documentInfoRequest.getId(), documentInfoRequest.getDocName(), documentInfoRequest.getDocType(), documentInfoRequest.getDocStatus())).toList();
        documentInfos = (List<DocumentInfo>) documentInfoRepository.saveAll(documentInfos);
        return documentInfos.stream().map(documentInfo -> new DocumentInfoRecord(documentInfo.getId(), documentInfo.getDocName(), documentInfo.getDocType(), documentInfo.getDocStatus())).toList();
    }

}
