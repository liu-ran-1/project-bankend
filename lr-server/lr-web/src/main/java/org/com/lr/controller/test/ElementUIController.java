package org.com.lr.controller.test;

import com.alibaba.druid.support.json.JSONUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import org.com.lr.dto.EmpDto;
import org.com.lr.model.RespBean;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
public class ElementUIController {

  @RequestMapping("/test")
  public RespBean uploadPdf(@RequestParam("param")String paramMap) {
    Map<String,Object> param = (Map<String, Object>) JSONUtils.parse(paramMap);
    int currentPage = Integer.valueOf(param.get("currentPage").toString());
    int pageSize = Integer.valueOf(param.get("pageSize").toString());
    List<Map<String,Object>> list = new ArrayList<>();
    for(int i = 0;i<35;i++){
      Map<String,Object> row = new HashMap<>();
      row.put("date","2022-02-22 22:22:22");
      row.put("name","ranliu"+i);
      row.put("address","汤臣一品"+i);
      //1是可以编辑，0是不可以编辑
      row.put("status","1");
      list.add(row);
    }
    int count = 0;
    if(list != null && list.size() > 0) {
      count = list.size();
      int fromIndex = (currentPage-1) * pageSize;
      int toIndex = (currentPage ) * pageSize;
      if (toIndex > count) {
        toIndex = count;
      }
      List<Map<String,Object>> pageList = list.subList(fromIndex, toIndex);
      Map<String,Object> rtnMap = new HashMap<>();
      rtnMap.put("totalSize",list.size());
      rtnMap.put("data",pageList);
      return RespBean.build().setObj(rtnMap);
    }
    Map<String,Object> rtnMap = new HashMap<>();
    rtnMap.put("totalSize",list.size());
    rtnMap.put("data",list);
    return  RespBean.build().setObj(rtnMap);


  }

  @RequestMapping("/menus")
  public RespBean menus() {
    List<Map<String,Object>> list = new ArrayList<>();
    for(int i = 0;i<2;i++){
      list.add(getRow(i));
//      list.add(getRow(i+1));
    }
    Map<String,Object> rtnMap = new HashMap<>();
    rtnMap.put("list",list);
    List<String> showIndexList = new ArrayList<>();
    showIndexList.add("1");
//    showIndexList.add("2");
    rtnMap.put("showIndex",showIndexList);
    return  RespBean.build().setObj(rtnMap);


  }

  private Map getRow(int i){
    Map<String,Object> row = new HashMap<>();
    row.put("index",i+1+"");
    row.put("key",i+"");
    row.put("menuType",getIcon(i));
    row.put("navName","导航"+(i+1));
    List<Map<String,Object>> childList = new ArrayList<>();
    Map<String,Object> childRow = new HashMap<>();
    childRow.put("title","分组"+(i+1));
    List<Map<String,Object>> titleList = new ArrayList<>();
    Map<String,Object> detailRow = new HashMap<>();
    detailRow.put("name","选项"+(i+1));
    if(i ==0){
        detailRow.put("route","/content");
    }else if( i ==1){
        detailRow.put("route","/setting");
    }
    titleList.add(detailRow);
    childRow.put("options",titleList);
    childRow.put("menuType","el-icon-menu");
    childList.add(childRow);
    row.put("childList",childList);
    return row;
  }

  private String getIcon(int index){
    switch (index){
      case 0:
        return "el-icon-platform-eleme";
      case 1:
        return "el-icon-setting";
        default:
          return "el-icon-menu";
    }
  }

    @RequestMapping("/saveRow")
    public RespBean saveRow(@RequestBody Map<String,EmpDto> empDtoMap) {
      System.out.println(JSON.toJSONString(empDtoMap));
        return  RespBean.build().setStatus(0);


    }

}
