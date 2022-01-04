package org.com.lr.mapper.service;

import org.com.lr.mapper.model.RespBean;
import org.springframework.web.multipart.MultipartFile;

public interface ToolsPdfService {

  RespBean uploadPdf(MultipartFile file);
}
