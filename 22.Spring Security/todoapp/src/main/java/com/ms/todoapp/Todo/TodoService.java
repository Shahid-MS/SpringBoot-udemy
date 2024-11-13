package com.ms.todoapp.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

  private static List<Todo> todos = new ArrayList<>();
  private static int todoCount = 0;

  static {
    todos.add(
      new Todo(
        ++todoCount,
        "john_doe",
        "Finish project report",
        LocalDate.of(2024, 11, 15),
        false
      )
    );
    todos.add(
      new Todo(
        ++todoCount,
        "jane_smith",
        "Buy groceries",
        LocalDate.of(2024, 11, 12),
        true
      )
    );
    todos.add(
      new Todo(
        ++todoCount,
        "john_doe",
        "Book flight tickets",
        LocalDate.of(2024, 11, 20),
        false
      )
    );
    todos.add(
      new Todo(
        ++todoCount,
        "alice_wonder",
        "Prepare presentation",
        LocalDate.of(2024, 11, 14),
        false
      )
    );
  }

  public List<Todo> findByusername(String username) {
    return todos
      .stream()
      .filter(todo -> todo.getUsername().equalsIgnoreCase(username))
      .collect(Collectors.toList());
  }

  public Todo findById(int id) {
    return todos
      .stream()
      .filter(td -> td.getId() == id)
      .findFirst()
      .orElse(null);
  }

  public void addTodo(
    String username,
    String description,
    LocalDate targetDate,
    boolean done
  ) {
    Todo newTodo = new Todo(
      ++todoCount,
      username,
      description,
      targetDate,
      done
    );
    todos.add(newTodo);
  }

  public void deleteById(int targetId) {
    todos.removeIf(todo -> todo.getId() == targetId);
  }

  public void updateTodo(Todo targetTodo) {
    Todo existTodo = todos
      .stream()
      .filter(td -> td.getId() == targetTodo.getId())
      .findFirst()
      .orElse(null);

    existTodo.setDescription(targetTodo.getDescription());
    existTodo.setTargetDate(targetTodo.getTargetDate());
  }
}
