package com.ms.webapp.Login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  public boolean authenticate(String name, String password) {
    boolean isNameValid = name.equalsIgnoreCase("ms");
    boolean isPasswordValid = password.equalsIgnoreCase("ms2.o");
    return isNameValid && isPasswordValid;
  }
}
