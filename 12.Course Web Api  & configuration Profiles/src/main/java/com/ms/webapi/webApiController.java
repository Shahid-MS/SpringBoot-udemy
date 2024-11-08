package com.ms.webapi;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class webApiController {

  @RequestMapping("/courses")
  public List<Course> AllCourses() {
    return Arrays.asList(new Course(1, "MySql"), new Course(2, "Java"),new Course(3, "Spring Boot"),new Course(4, "ReactJs"));
  }
}
