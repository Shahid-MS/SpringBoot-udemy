package com.ms.todoapp.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    return todos;
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
}
