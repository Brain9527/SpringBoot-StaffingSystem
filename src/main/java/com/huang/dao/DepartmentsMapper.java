package com.huang.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.pojo.Departments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
@TableName("Departments")
public interface DepartmentsMapper extends BaseMapper<Departments> {


}
