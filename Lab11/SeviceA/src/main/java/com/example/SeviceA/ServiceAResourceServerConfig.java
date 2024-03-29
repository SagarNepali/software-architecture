package com.example.SeviceA;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ServiceAResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
               authorizeRequests()
                .antMatchers("/phone").hasAnyRole("EMPLOYEE","MANAGER")
                .antMatchers("/salary").hasRole("MANAGER")
                .antMatchers("/product").hasAnyRole("EMPLOYEE","MANAGER","CUSTOMER")
                .anyRequest().authenticated();
    }
}
