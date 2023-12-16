package com.vti.config;

import com.vti.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private IUserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .authorizeRequests()
                //Tất cả api GET department được cho phép đăng nhập
                //** thay cho chuỗi bất kì
                .antMatchers(HttpMethod.GET, "/api/v1/products/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/products/**").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.PUT, "/api/v1/products/**").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.DELETE, "/api/v1/products/**").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.GET, "/api/v1/categories/**").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.POST, "/api/v1/categories/**").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.PUT, "/api/v1/categories/**").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.DELETE, "/api/v1/categories/**").hasAnyAuthority("Admin")
                //Ngoại trừ các trường hợp trên thì bắt đăng nhập
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}

