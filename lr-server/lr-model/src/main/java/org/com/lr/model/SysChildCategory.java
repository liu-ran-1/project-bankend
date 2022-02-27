package org.com.lr.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysChildCategory implements Serializable {

    private Long id;

    private Long mainCategoryId;

    private String title;

}
