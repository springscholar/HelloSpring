package com.hr.learning.projectbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    // Enables AuthenticationManager as Bean, i.e. to be able to refer to it via shared context,
    // in other parts of application, e.g. in the AuthServerConfig
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // Configure in memory user name and password of actual users trying to login to our REST API
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().
                withUser("goran").
                password("{noop}12345").
                roles("USER").
                and().
                withUser("bobby").
                password("{noop}123").
                roles("USER");
    }
}
