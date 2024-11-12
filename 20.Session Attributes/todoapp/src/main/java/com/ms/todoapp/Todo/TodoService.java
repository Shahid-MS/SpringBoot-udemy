package com.ms.todoapp.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

  private static List<Todo> todos = new ArrayList<>();

  static {
    todos.add(
      new Todo(
        1,
        "john_doe",
        "Finish project report",
        LocalDate.of(2024, 11, 15),
        false
      )
    );
    todos.add(
      new Todo(
        2,
        "jane_smith",
        "Buy groceries",
        LocalDate.of(2024, 11, 12),
        true
      )
    );
    todos.add(
      new Todo(
        3,
        "john_doe",
        "Book flight tickets",
        LocalDate.of(2024, 11, 20),
        false
      )
    );
    todos.add(
      new Todo(
        4,
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
}
