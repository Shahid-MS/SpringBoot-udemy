package com.ms.spring_secutity.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthentication {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

    http.sessionManagement(session ->
      session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    );
    http.csrf().disable();

    http.httpBasic();
    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    var admin = User
      .withUsername("ms@gmail.com")
      .password("{noop}ms")
      .roles("Admin")
      .build();

    var user = User
      .withUsername("msUser")
      .password("{noop}ms")
      .roles("USER")
      .build();

    return new InMemoryUserDetailsManager(user, admin);
  }
}
