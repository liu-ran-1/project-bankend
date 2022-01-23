package org.com.lr.service.service.impl;

import java.io.IOException;
import java.io.InputStream;
import org.com.lr.model.RespBean;
import org.com.lr.service.service.ToolsPdfService;
import org.com.lr.common.minio.MinioUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ToolsPdfServiceImpl  implements ToolsPdfService {

  @Override
  public RespBean uploadPdf(MultipartFile file) {
    try {
      InputStream inputStream = file.getInputStream();
      String name = file.getOriginalFilename();
      MinioUtils.upLoadFile(name,inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }
}
