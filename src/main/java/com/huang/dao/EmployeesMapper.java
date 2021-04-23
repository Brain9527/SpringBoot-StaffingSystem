package com.huang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.pojo.employees;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component

public interface EmployeesMapper  extends BaseMapper<employees> {
}
