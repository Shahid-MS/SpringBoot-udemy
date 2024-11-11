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
    // courseJdbcRepository.save();
    courseJpaRepository.save(new Course(1, "Learn Java", "MS"));
    courseJpaRepository.save(new Course(2, "Learn SpringBoot", "MS"));
    courseJpaRepository.save(new Course(3, "Learn AWS", "MS"));

    courseJpaRepository.deleteById(1l);

    System.out.println(courseJpaRepository.findById(2l));

    System.out.println(courseJpaRepository.findById(3l));

    System.out.println(courseJpaRepository.findAll());
    System.out.println(courseJpaRepository.count());

    System.out.println(courseJpaRepository.findByName("Learn AWS"));

    
  }
}
