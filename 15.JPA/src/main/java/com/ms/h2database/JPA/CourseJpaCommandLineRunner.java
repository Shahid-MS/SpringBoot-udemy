package com.ms.h2database.JPA;

import com.ms.h2database.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {

  @Autowired
  private CourseJpaRepository courseJpaRepository;

  @Override
  public void run(String... args) throws Exception {
    // courseJdbcRepository.insert();
    courseJpaRepository.insert(new Course(1, "Learn Java", "MS"));
    courseJpaRepository.insert(new Course(2, "Learn SpringBoot", "MS"));
    courseJpaRepository.insert(new Course(3, "Learn AWS", "MS"));

    courseJpaRepository.deleteById(1);

    System.out.println(courseJpaRepository.findCourseById(2));

    System.out.println(courseJpaRepository.findCourseById(3));
  }
}
