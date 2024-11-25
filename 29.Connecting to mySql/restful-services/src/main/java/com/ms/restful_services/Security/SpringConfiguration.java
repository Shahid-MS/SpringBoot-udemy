package com.ms.restful_services.Security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfiguration {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // All requests should be authenticated
    http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
    // Pop up will be shown not login page
    http.httpBasic(withDefaults());

    // Csrf
    http.csrf().disable();
    return http.build();
  }
}
