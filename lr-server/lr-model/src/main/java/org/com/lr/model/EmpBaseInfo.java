package org.com.lr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EmpBaseInfo implements Serializable {

    private Long id;

    private long categoryId;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
