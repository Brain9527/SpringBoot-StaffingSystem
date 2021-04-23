package com.huang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//员工表


@Data
@AllArgsConstructor
@NoArgsConstructor
public class employees {
    private Integer id;
    private String staff_name;
    private String email;
    private Integer gender; //0:女  1:男



}
