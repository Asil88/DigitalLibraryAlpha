package com.digital_library.config;

import com.digital_library.security.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  /*  @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("user"))
                .authorities("ROLE_USER");
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .authorities("ROLE_ADMIN");
    }*/
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerUserDetailsService).passwordEncoder(passwordEncoder());
    }

    CustomerUserDetailsService customerUserDetailsService;

    @Autowired
    public SecurityConfig(CustomerUserDetailsService customerUserDetailsService) {
        this.customerUserDetailsService = customerUserDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/registration","/").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
