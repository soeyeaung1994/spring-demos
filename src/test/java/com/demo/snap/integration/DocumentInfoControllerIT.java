package com.demo.snap.integration;

import com.demo.snap.repository.DocumentInfoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @Author: Soe Ye Aung
 * @Date: 24/1/24
 * @Time: 1:45 pm
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DocumentInfoControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    DocumentInfoRepository documentInfoRepository;

    @AfterEach
    void tearDown() {
        documentInfoRepository.deleteAll();
    }

    @Test
    public void testFetchDocInfosByDocStatus() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/docInfo/fetchDocInfosByDocStatus")
                        .param("docStatus", "PENDING"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].docName").value("Phone Bill Test"))
                .andExpect(jsonPath("$.[0].docType").value("Residential Address Document"))
                .andExpect(jsonPath("$.[1].docName").value("IRAS Notice of Assessment Test"))
                .andExpect(jsonPath("$.[1].docType").value("Tax Declaration Document"));

    }

}
