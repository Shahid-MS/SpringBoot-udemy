package com.ms.todoapp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

// @Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // Filter chain
    // Basic Authentication
    // Disable csrf for session or stateless api
    http.authorizeHttpRequests(auth ->
      auth
        .requestMatchers(HttpMethod.OPTIONS, "/**")
        .permitAll()
        .anyRequest()
        .authenticated()
    );
    // popup for signin instead of web page
    http.httpBasic(Customizer.withDefaults());

    // Stateless session
    http.sessionManagement(session ->
      session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    );
    // csrf disable
    http.csrf(csrf -> csrf.disable());
    return http.build();
  }
}
