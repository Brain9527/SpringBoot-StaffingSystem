package com.huang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.huang.dao.DepartmentsMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departments {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String departmentName;

}
