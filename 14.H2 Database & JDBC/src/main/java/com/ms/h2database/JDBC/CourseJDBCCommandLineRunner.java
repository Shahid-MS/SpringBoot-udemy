package com.ms.h2database.JDBC;

import com.ms.h2database.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJDBCCommandLineRunner implements CommandLineRunner {

  @Autowired
  private CourseJdbcRepository courseJdbcRepository;

  @Override
  public void run(String... args) throws Exception {
    // courseJdbcRepository.insert();
    courseJdbcRepository.insert(new Course(1, "Learn Java", "MS"));
    courseJdbcRepository.insert(new Course(2, "Learn SpringBoot", "MS"));
    courseJdbcRepository.insert(new Course(3, "Learn AWS", "MS"));

    courseJdbcRepository.delete(1);

    System.out.println(courseJdbcRepository.findCourseById(2));

    System.out.println(courseJdbcRepository.findCourseById(3));
  }
}
