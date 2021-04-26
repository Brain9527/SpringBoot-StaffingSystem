package com.huang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * 员工表
 */
@Data
@NoArgsConstructor
public class Employees {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String staffName;
    private String email;
    /** 0:女  1:男 */
    private Integer gender;
    private Integer department;
}
