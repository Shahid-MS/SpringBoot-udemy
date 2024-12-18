package com.ms.webapp.Login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  //   @RequestMapping("login")
  //   public String login(@RequestParam String name) {
  //     //Not recommende for production
  //     System.out.println("Requesr param : " + name);
  //     return "login";
  //   }

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @RequestMapping("login")
  public String login(@RequestParam String name, ModelMap model) {
    model.put("name", name);
    logger.debug("Debug level name : " + name);
    logger.info("Info level name : " + name); 
    return "login";
  }
}
