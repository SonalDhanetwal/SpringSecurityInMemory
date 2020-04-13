package com.Phoenix.SpringSecurityInmemory;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //set your confirguration on auth object
        auth.inMemoryAuthentication()
                .withUser("Sonal")
                .password("Sonal")
                .roles("USER")
                .and()
                .withUser("Admin")
                .password("Admin")
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //most restrictive - admin on the top and and user can be accessed by admin or user
        // least restrictive url below - permit all
        http.authorizeRequests()
                .antMatchers("/Admin").hasRole("ADMIN")
                .antMatchers("/User").hasAnyRole("USER","ADMIN")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }
}
