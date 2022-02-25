package org.com.lr.controller.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.com.lr.model.RespBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ElementUIController {

  @RequestMapping("/test")
  public RespBean uploadPdf() {
    List<Map<String,Object>> list = new ArrayList<>();
    for(int i = 0;i<1;i++){
      Map<String,Object> row = new HashMap<>();
      row.put("date","2022-02-22 22:22:22");
      row.put("name","ranliu");
      row.put("address","汤臣一品");
      list.add(row);
    }
    return  RespBean.build().setObj(list);


  }

  @RequestMapping("/menus")
  public RespBean menus() {
    List<Map<String,Object>> list = new ArrayList<>();
    for(int i = 0;i<1;i++){
      Map<String,Object> row = new HashMap<>();
      row.put("index",i+1);
      row.put("key",i);
      row.put("menuType","el-icon-menu");
      List<Map<String,Object>> childList = new ArrayList<>();
      Map<String,Object> childRow = new HashMap<>();
      childRow.put("title","分组1");
      List<String> titleList = new ArrayList<>();
      titleList.add("选项1");
      titleList.add("选项2");
      childRow.put("options",titleList);
      childRow.put("menuType","el-icon-menu");
      childList.add(childRow);
      row.put("childList",childList);
      list.add(row);
    }
    return  RespBean.build().setObj(list);


  }

}
