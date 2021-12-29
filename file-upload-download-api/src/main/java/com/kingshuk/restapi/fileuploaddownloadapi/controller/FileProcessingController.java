package com.kingshuk.restapi.fileuploaddownloadapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class FileProcessingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileProcessingController.class);

    @Value("${fileLocation}")
    private String directory;

    @PostMapping("/upload")
    public boolean uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        LOGGER.info("The original file name is: {}", file.getOriginalFilename());
        file.transferTo(new File(directory + file.getOriginalFilename()));
        return true;
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable("fileName") String fileName) throws IOException {
        final byte[] bytes = Files.readAllBytes(Path.of(directory + fileName));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
    }
}
