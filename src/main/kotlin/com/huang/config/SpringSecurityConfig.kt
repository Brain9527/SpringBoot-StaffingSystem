package com.huang.config

import com.huang.service.UserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository
import javax.sql.DataSource

/**
 * Spring Security 配置类
 */
@Configuration
class SpringSecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var userDetailsService: UserDetailsServiceImpl

    @Autowired
    lateinit var dataSource: DataSource

    @Autowired
    lateinit var persistentTokenRepository: PersistentTokenRepository

    private val AUTH_WHITELIST = arrayOf(
        // Swagger
        "/swagger-resources/**",
        "/swagger-ui/**",
        "/v3/api-docs",
        "/webjars/**",

        // Static
        "/css/*",
        "/js/**",
        "/img/**",

        "/index.html",
        "/user/login",
        "/user/reg"
    )

    override fun configure(http: HttpSecurity) {
        http.formLogin()
            .loginPage("/user/login")
            .loginProcessingUrl("/user/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .successForwardUrl("/")
            .failureHandler { request, response, exception ->
                request.session.setAttribute("msg", exception.message)
                request.getRequestDispatcher("/user/login").forward(request, response)
            }

        http.authorizeRequests()
            .antMatchers(*AUTH_WHITELIST)
            .permitAll()
            .anyRequest().authenticated()

        http.csrf().disable()

        http.rememberMe()
            // .tokenValiditySeconds(60)
            .userDetailsService(userDetailsService)
            .tokenRepository(persistentTokenRepository)

        http.logout()
            .logoutUrl("/user/logout")
            .logoutSuccessUrl("/user/login")
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun persistentTokenRepository(): PersistentTokenRepository {
        val jdbcTokenRepository = JdbcTokenRepositoryImpl()
        jdbcTokenRepository.setDataSource(dataSource)
        // jdbcTokenRepository.setCreateTableOnStartup(true)
        return jdbcTokenRepository
    }
}
