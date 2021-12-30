package com.kingshuk.restapi.fileuploaddownloadapi;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

@SpringBootTest
class FileUploadDownloadApiApplicationTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadDownloadApiApplicationTests.class);

    @Value("${fileLocation}")
    private String directory;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void uploadFile() throws IOException {
        //We first specify the form data as multi-part form data
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> valueMap = new LinkedMultiValueMap<>();
        valueMap.add("file", new ClassPathResource("51206152.jpg"));

        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(valueMap, headers);

        ResponseEntity<Boolean> response = restTemplate.postForEntity("http://localhost:8080/upload", httpEntity, Boolean.class);

        LOGGER.info("The response is {}", response.getBody());
    }

    @Test
    void testDownload() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<byte[]> response = restTemplate.exchange("http://localhost:8080/download/51206152.jpg", HttpMethod.GET, entity, byte[].class);

        //We need to convert the byte array into the image back
        Files.write(Path.of(directory+"download\\51206152.jpg"), response.getBody());

    }

}
