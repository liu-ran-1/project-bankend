package org.com.lr.service.service;

import org.com.lr.model.RespBean;
import org.springframework.web.multipart.MultipartFile;

public interface ToolsPdfService {

  RespBean uploadPdf(MultipartFile file);
}
