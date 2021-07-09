package com.huang.pojo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 顾客表
 */
@ApiModel("顾客模型")
data class Consumer(
    @ApiModelProperty("顾客ID")
    @TableId(type = IdType.AUTO)
    var userid: Long?,

    @ApiModelProperty("用户名")
    var username: String,

    @ApiModelProperty("密码")
    var password: String
)
