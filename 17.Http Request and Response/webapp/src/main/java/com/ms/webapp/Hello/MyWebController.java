package com.ms.webapp.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyWebController {

  @RequestMapping("say-hello")
  @ResponseBody
  public String sayhello() {
    return "Hello, This is MS 2.O";
  }

  @RequestMapping("say-hello-html")
  @ResponseBody
  public String sayhelloHtml() {
    StringBuilder sb = new StringBuilder();
    sb.append("<!DOCTYPE html>");
    sb.append("<html>");
    sb.append("<head>");
    sb.append("<title>Say Hello</title>");
    sb.append("</head>");
    sb.append("<body>");
    sb.append("<h1>Hello, World!</h1>");
    sb.append("<p>Welcome to the Spring Boot HTML page!</p>");
    sb.append(
      "<button onclick=\"alert('Hello from Spring Boot!')\">Click Me</button>"
    );
    sb.append("</body>");
    sb.append("</html>");

    return sb.toString();
  }

  @RequestMapping("say-hello-jsp")
  public String sayhelloJSP() {
    return "sayHello";
  }
}
