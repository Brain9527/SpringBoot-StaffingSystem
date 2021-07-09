package com.huang.dao

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.huang.pojo.Consumer
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Component

@Mapper
@Component
interface ConsumerMapper : BaseMapper<Consumer>