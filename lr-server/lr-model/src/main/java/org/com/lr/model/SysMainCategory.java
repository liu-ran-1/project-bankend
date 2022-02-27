package org.com.lr.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysMainCategory implements Serializable {

    private Long id;

    private Long childCategoryId;

    private String name;

}
