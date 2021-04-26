package com.huang.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.pojo.Consumer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
@TableName("consumer")
public interface ConsumerMapper extends BaseMapper<Consumer> {

}
