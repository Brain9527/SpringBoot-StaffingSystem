package com.huang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 顾客表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {
    @TableId(type = IdType.AUTO)
    public Integer userid;
    public String username;
    public String password;
}