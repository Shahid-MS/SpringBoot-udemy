package com.ms.restful_services.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserService {

  private static List<User> users = new ArrayList<>();

  private static int userCount = 4;

  static {
    users.add(new User(1, "MS", LocalDate.now().minusYears(22)));
    users.add(new User(2, "John Doe", LocalDate.now().minusYears(30)));
    users.add(new User(3, "Jane Smith", LocalDate.now().minusYears(25)));
    users.add(new User(4, "Alex Turner", LocalDate.now().minusYears(35)));
  }

  public List<User> findAll() {
    return users;
  }

  public User findOne(int id) {
    return users
      .stream()
      .filter(user -> user.getId() == id)
      .findFirst()
      .orElse(null);
  }

  public User save(User user) {
    user.setId(++userCount);
    users.add(user);
    return user;
  }

  public void deleteById(int id) {
    users.removeIf(user -> user.getId() == id);
  }
}
