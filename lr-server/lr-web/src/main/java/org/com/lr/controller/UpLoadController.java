package org.com.lr.controller;

import org.com.lr.model.RespBean;
import org.com.lr.service.service.UpLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UpLoadController {

    @Autowired
    private UpLoadService upLoadService;

    @PostMapping
    public RespBean uploadFile(MultipartFile multipartFile){
        RespBean respBean = upLoadService.uploadFile(multipartFile);
    }



}
