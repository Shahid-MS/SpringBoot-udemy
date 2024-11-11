package com.ms.h2database.JPA;

import com.ms.h2database.Course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJpaRepository extends JpaRepository<Course, Long> {
  //custom method
  List<Course> findByName(String name);
}
