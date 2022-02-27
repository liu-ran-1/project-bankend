package org.com.lr.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysDetailCategory implements Serializable {

    private Long id;

    private Long childCategoryId;

    private String name;

}
