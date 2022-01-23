package org.com.lr.service.service;

import org.com.lr.model.RespBean;
import org.springframework.web.multipart.MultipartFile;

public interface UpLoadService {
    //上传文件
    RespBean uploadFile(MultipartFile multipartFile);
}
