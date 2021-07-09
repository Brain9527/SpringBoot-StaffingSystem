package com.huang.service

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.huang.dao.ConsumerMapper
import com.huang.pojo.Consumer
import org.springframework.stereotype.Service

@Service
class UserService(
    val consumerMapper: ConsumerMapper
) {
    fun getUser(username: String): Consumer? {
        val wrapper = QueryWrapper<Consumer>()
        wrapper.eq("username", username)
        return consumerMapper.selectOne(wrapper)
    }
}
