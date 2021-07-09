package com.huang.pojo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import javax.validation.constraints.NotBlank

/**
 * 部门表
 */
data class Department(
    @TableId(type = IdType.AUTO)
    var id: Int?,

    @field:NotBlank(message = "部门名称不能为空！")
    var departmentName: String,
)