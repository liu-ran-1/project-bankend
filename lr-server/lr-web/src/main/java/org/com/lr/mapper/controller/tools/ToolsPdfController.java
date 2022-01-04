package org.com.lr.mapper.controller.tools;

import org.com.lr.mapper.model.RespBean;
import org.com.lr.mapper.service.ToolsPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/tools/pdf")
public class ToolsPdfController {

  @Autowired
   private ToolsPdfService toolsPdfService;
  @RequestMapping("/upload")
  public RespBean uploadPdf(MultipartFile file) {
    return toolsPdfService.uploadPdf(file);
  }

}