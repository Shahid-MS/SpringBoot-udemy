package com.ms.todoapp.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

  private static List<Todo> todos = new ArrayList<>();
  static int count = 0;

  static {
    todos.add(
      new Todo(
        ++count,
        "john_doe",
        "Finish project report",
        LocalDate.of(2024, 11, 15),
        false
      )
    );
    todos.add(
      new Todo(
        ++count,
        "jane_smith",
        "Buy groceries",
        LocalDate.of(2024, 11, 12),
        true
      )
    );
    todos.add(
      new Todo(
        ++count,
        "john_doe",
        "Book flight tickets",
        LocalDate.of(2024, 11, 20),
        false
      )
    );
    todos.add(
      new Todo(
        ++count,
        "alice_wonder",
        "Prepare presentation",
        LocalDate.of(2024, 11, 14),
        false
      )
    );
  }

  public List<Todo> findByusername(String username) {
    return todos;
  }

  public Todo findById(int id) {
    return todos
      .stream()
      .filter(todo -> todo.getId() == id)
      .findFirst()
      .orElse(null);
  }

  public boolean deleteById(int id) {
    return todos.removeIf(todo -> todo.getId() == id);
  }

  public Todo addTodo(
    String username,
    String description,
    LocalDate targetDate,
    boolean done
  ) {
    Todo newTodo = new Todo(++count, username, description, targetDate, done);
    todos.add(newTodo);
    return newTodo;
  }

  public Todo updateTodo(Todo targetTodo) {
    Todo existTodo = todos
      .stream()
      .filter(td -> td.getId() == targetTodo.getId())
      .findFirst()
      .orElse(null);
    // System.out.println("targetTodo" + targetTodo);
    existTodo.setDone(targetTodo.isDone());
    // existTodo.setUsername(targetTodo.getUsername());
    existTodo.setDescription(targetTodo.getDescription());
    existTodo.setTargetDate(targetTodo.getTargetDate());
    // System.out.println("added toto" + existTodo);
    return existTodo;
  }
}
