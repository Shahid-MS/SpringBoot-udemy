package com.ms.todoapp.Todo;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
  public String newTodo(ModelMap model) {
    String userName = (String) model.get("name");
    Todo todo = new Todo(0, userName, "", LocalDate.now().plusMonths(3), false);
    model.put("todo", todo);
    return "addTodo";
  }

  @RequestMapping(value = "add-todo", method = RequestMethod.POST)
  public String addNewTodo(
    ModelMap model,
    @Valid Todo todo,
    BindingResult result
  ) {
    if (result.hasErrors()) {
      // System.out.println("Errors");
      return "addTodo";
    }
    String userName = (String) model.get("name");
    // System.out.println(userName);
    todoService.addTodo(
      userName,
      todo.getDescription(),
      LocalDate.now().plusMonths(3),
      false
    );
    return "redirect:list-todos";
  }

  @RequestMapping("delete-todo")
  public String deleteTodo(@RequestParam int id) {
    todoService.deleteById(id);
    return "redirect:list-todos";
  }

  @RequestMapping(value = "update-todo", method = RequestMethod.GET)
  public String showPageUpdateTodo(@RequestParam int id, ModelMap model) {
    Todo todo = todoService.findById(id);
    model.addAttribute("todo", todo);
    return "updateTodo";
  }

  @RequestMapping(value = "update-todo", method = RequestMethod.POST)
  public String updateTodo(
    ModelMap model,
    @Valid Todo todo,
    BindingResult result
  ) {
    if (result.hasErrors()) {
      return "updateTodo";
    }

    todoService.updateTodo(todo);
    return "redirect:list-todos";
  }
}
