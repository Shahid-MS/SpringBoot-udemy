package com.ms.google_authentication.OAuth;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class OAuthConfiguration {

  @Bean
  @Order(SecurityProperties.BASIC_AUTH_ORDER)
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
    throws Exception {
    http
      .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
      .oauth2Login(Customizer.withDefaults())
      .oauth2Client(Customizer.withDefaults());
    return http.build();
  }
}
