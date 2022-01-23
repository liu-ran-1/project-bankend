package org.com.lr.service.service.impl;

import org.com.lr.model.RespBean;
import org.com.lr.service.service.UpLoadService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UpLoadServiceImpl implements UpLoadService {
    @Override
    public RespBean uploadFile(MultipartFile multipartFile) {
        return null;
    }
}
