package com.ms.todoapp.Todo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

  @Autowired
  private TodoRepository todoRepo;

  @GetMapping("/users/{username}/todos")
  public List<Todo> retriveTodos(@PathVariable String username) {
    return todoRepo.findByUsername(username);
  }

  @GetMapping("/users/{username}/todos/{id}")
  public Todo retriveTodo(@PathVariable String username, @PathVariable int id) {
    return todoRepo.findById(id).get();
  }

  @DeleteMapping("/users/{username}/todos/{id}")
  public ResponseEntity<Void> deleteTodo(
    @PathVariable String username,
    @PathVariable int id
  ) {
    todoRepo.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/users/{username}/todos")
  public Todo createTodo(
    @PathVariable String username,
    @RequestBody Todo todo
  ) {
    System.out.println(todo.toString());
    return todoRepo.save(todo);
  }

  @PutMapping("/users/{username}/todos/{id}")
  public Todo updateTodo(
    @PathVariable String username,
    @PathVariable int id,
    @RequestBody Todo todo
  ) {
    return todoRepo.save(todo);
  }
}
