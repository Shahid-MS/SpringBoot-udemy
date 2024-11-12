package com.ms.todoapp.Todo;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {

  private TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @RequestMapping("list-todos")
  public String listAllTodos(ModelMap model) {
    List<Todo> todos = todoService.findByusername("todo");
    model.put("todos", todos);
    return "listAllTodos";
  }
}
