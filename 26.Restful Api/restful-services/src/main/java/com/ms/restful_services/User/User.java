package com.ms.restful_services.User;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class User {

  private int id;

  @Size(min = 2, message = "Name have atleast 2 characters")
  private String name;

  @Past(message = "Birth date should be past")
  private LocalDate birth;

  public User(int id, String name, LocalDate birth) {
    this.id = id;
    this.name = name;
    this.birth = birth;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getBirth() {
    return birth;
  }

  public void setBirth(LocalDate birth) {
    this.birth = birth;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", birth=" + birth + "]";
  }
}
