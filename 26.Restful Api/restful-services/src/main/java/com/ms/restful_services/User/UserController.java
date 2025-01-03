package com.ms.restful_services.User;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userService.findAll();
  }

  @GetMapping("/users/{id}")
  public User getUser(@PathVariable int id) {
    User user = userService.findOne(id);
    if (user == null) {
      throw new UserNotFoundException("User not found with id: " + id);
    }
    return user;
  }

  @PostMapping("/users")
  public ResponseEntity<User> Usercreate(@Valid @RequestBody User user) {
    User savedUser = userService.save(user);
    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(savedUser.getId())
      .toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    userService.deleteById(id);
  }
}
