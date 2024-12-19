package com.ms.spring_secutity.Todo;

import jakarta.annotation.security.RolesAllowed;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

  private TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/users/{username}/todos")
  public List<Todo> retriveTodos(@PathVariable String username) {
    return todoService.findByusername(username);
  }

  @GetMapping("/users/{username}/todos/{id}")
  @PreAuthorize("hasRole('USER') and #username == authentication.name")
  // @PostAuthorize("returnObject.username == 'msUser'")
  @RolesAllowed({ "ADMIN", "USER" })
  @Secured({ "ROLE_ADMIN", "ROLE_USER" })
  public Todo retriveTodo(@PathVariable String username, @PathVariable int id) {
    return todoService.findById(id);
  }

  @DeleteMapping("/users/{username}/todos/{id}")
  public ResponseEntity<Void> deleteTodo(
    @PathVariable String username,
    @PathVariable int id
  ) {
    todoService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/users/{username}/todos")
  public Todo createTodo(
    @PathVariable String username,
    @RequestBody Todo todo
  ) {
    // System.out.println("New todo" + todo);
    Todo createdTodo = todoService.addTodo(
      username,
      todo.getDescription(),
      todo.getTargetDate(),
      todo.isDone()
    );

    return createdTodo;
  }

  @PutMapping("/users/{username}/todos/{id}")
  public Todo updateTodo(
    @PathVariable String username,
    @PathVariable int id,
    @RequestBody Todo todo
  ) {
    // System.out.println("New todo" + todo);
    return todoService.updateTodo(todo);
  }
}
