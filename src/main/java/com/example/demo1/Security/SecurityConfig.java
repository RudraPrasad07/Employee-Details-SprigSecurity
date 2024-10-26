package com.example.demo1.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	 http
    	 .csrf(csrf -> csrf.disable()) 
         .authorizeHttpRequests(auth -> auth
             .requestMatchers("/Employee/saveEmployee").permitAll()
             .requestMatchers("/Employee/getEmployee").permitAll()
             .requestMatchers("/Employee/delete").permitAll()
             .anyRequest().authenticated()
           );
        return http.build();
    }

}