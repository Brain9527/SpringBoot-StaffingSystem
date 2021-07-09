package com.huang.pojo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId

/**
 * 员工表
 */
data class Employee(
    @TableId(type = IdType.AUTO)
    val id: Int?,
    val staffName: String,
    val email: String,

    /**
     * 0:女  1:男
     */
    val gender: Long,
    val department: Int,
)