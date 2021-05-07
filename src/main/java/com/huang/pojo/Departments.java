package com.huang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

//部门表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departments {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "部门名称不能为空")
    private String departmentName;
}
