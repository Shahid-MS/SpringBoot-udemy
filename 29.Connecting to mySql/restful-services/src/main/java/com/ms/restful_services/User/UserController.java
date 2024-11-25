package com.ms.restful_services.User;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
  private UserRepo userRepository;

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/users/{id}")
  public EntityModel<User> getUser(@PathVariable int id) {
    User user = userRepository.findById(id).get();
    if (user == null) {
      throw new UserNotFoundException("User not found with id: " + id);
    }
    EntityModel<User> entityModel = EntityModel.of(user);
    WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());

    entityModel.add(link.withRel("All Users"));

    return entityModel;
  }

  @PostMapping("/users")
  public ResponseEntity<User> Usercreate(@Valid @RequestBody User user) {
    User savedUser = userRepository.save(user);
    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(savedUser.getId())
      .toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    userRepository.deleteById(id);
  }
}
