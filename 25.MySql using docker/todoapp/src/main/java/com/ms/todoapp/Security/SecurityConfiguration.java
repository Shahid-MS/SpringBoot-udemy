package com.ms.todoapp.Security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

  @Bean
  public InMemoryUserDetailsManager createUserDetailsManager() {
    UserDetails userDetails1 = createNewuser("ms", "ms2.o");
    UserDetails userDetails2 = createNewuser("alice_wonder", "ms2.o");
    UserDetails userDetails3 = createNewuser("john_doe", "ms2.o");
    UserDetails userDetails4 = createNewuser("jane_smith", "ms2.o");

    return new InMemoryUserDetailsManager(
      userDetails1,
      userDetails2,
      userDetails3,
      userDetails4
    );
  }

  private UserDetails createNewuser(String username, String password) {
    Function<String, String> passwordEncoder = input ->
      passwordEncoder().encode(input);
    UserDetails userDetails = User
      .builder()
      .passwordEncoder(passwordEncoder)
      .username(username)
      .password(password)
      .roles("USER", "Admin")
      .build();
    return userDetails;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
    http.formLogin(withDefaults());
    http.csrf().disable();
    http.headers().frameOptions().disable();
    return http.build();
  }
}
