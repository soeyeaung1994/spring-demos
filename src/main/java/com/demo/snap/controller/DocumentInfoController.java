package com.demo.snap.controller;

/**
 * @Author: Soe Ye Aung
 * @Date: 24/1/24
 * @Time: 1:43 am
 */

import com.demo.snap.record.DocumentInfoRecord;
import com.demo.snap.service.DocumentInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/docInfo", produces = {"application/json"})
@Tag(name = "Document Info Controller")
public class DocumentInfoController {

    private DocumentInfoService documentInfoService;

    public DocumentInfoController(DocumentInfoService documentInfoService) {
        this.documentInfoService = documentInfoService;
    }

    @GetMapping("/fetchAllDocInfo")
    @Operation(summary = "To fetch all of the document information")
    public List<DocumentInfoRecord> fetchAllDocInfo(){
        return documentInfoService.getDocumentInfoList();
    }

    @GetMapping("/fetchDocInfoById")
    @Operation(summary = "To fetch document information by its ID")
    public DocumentInfoRecord fetchAllDocInfo(@RequestParam Long id){
        return documentInfoService.getDocumentInfoById(id);
    }

    @GetMapping("/fetchDocInfosByDocStatus")
    @Operation(summary = "To fetch all of the document information by its status")
    public List<DocumentInfoRecord> fetchDocInfosByDocStatus(@RequestParam String docStatus){
        return documentInfoService.getDocumentInfosByDocStatus(docStatus);
    }

    @GetMapping("/fetchDocInfosByDocName")
    @Operation(summary = "To fetch all of the document information by its name")
    public List<DocumentInfoRecord> fetchDocInfosByDocName(@RequestParam String docName){
        return documentInfoService.getDocumentInfosByDocName(docName);
    }


}
