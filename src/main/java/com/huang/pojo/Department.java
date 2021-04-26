package com.huang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String departmentName;
}
