package com.huang.service

import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
    val userService: UserService,
    val pw: PasswordEncoder
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        username ?: throw UsernameNotFoundException("用户名不能为空")
        val user = userService.getUser(username) ?: throw UsernameNotFoundException("用户名不存在！")
        val password = pw.encode(user.password)
        return User(username, password, AuthorityUtils.createAuthorityList("admin", "normal"))
    }

}
