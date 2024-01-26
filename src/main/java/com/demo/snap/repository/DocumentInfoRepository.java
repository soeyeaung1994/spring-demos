package com.demo.snap.repository;

/**
 * @Author: Soe Ye Aung
 * @Date: 24/1/24
 * @Time: 1:43 am
 */

import com.demo.snap.model.entity.DocumentInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentInfoRepository extends CrudRepository<DocumentInfo, Long> {

    List<DocumentInfo> findByDocName(String docName);
    List<DocumentInfo> findByDocType(String docType);
    List<DocumentInfo> findByDocStatus(String docStatus);

}
