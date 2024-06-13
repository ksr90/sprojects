package com.sboot.io.sproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@RestController
public class FileController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file")MultipartFile file){
        String filePath = System.getProperty("user.dir") + "/uploads" + File.separator + file.getOriginalFilename();
        String fileUploadStatus;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
            fileUploadStatus = "File Uploaded Successfully";
        }
        catch (Exception e){
            e.printStackTrace();
            fileUploadStatus = "Error in Uploading File: " + e;
        }

        return fileUploadStatus;
    }
}
