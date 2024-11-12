package com.ms.todoapp.Todo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
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

  @RequestMapping(value = "add-todo", method = RequestMethod.GET)
  public String newTodo() {
    return "addTodo";
  }

  @RequestMapping(value = "add-todo", method = RequestMethod.POST)
  public String addNewTodo(@RequestParam String description, ModelMap model) {
    String userName = (String) model.get("name");
    System.out.println(userName);
    todoService.addTodo(
      userName,
      description,
      LocalDate.now().plusMonths(3),
      false
    );
    return "redirect:list-todos";
  }
}
