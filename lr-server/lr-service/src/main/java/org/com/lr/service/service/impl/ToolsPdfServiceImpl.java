package org.com.lr.service.service.impl;

import java.io.IOException;
import java.io.InputStream;
import org.com.lr.model.RespBean;
import org.com.lr.service.service.ToolsPdfService;
import org.lr.com.minio.MinioUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ToolsPdfServiceImpl  implements ToolsPdfService {

  @Override
  public RespBean uploadPdf(MultipartFile file) {
    try {
      InputStream inputStream = file.getInputStream();
      String name = file.getName();
      MinioUtils.upLoadFile(name,inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }
}
