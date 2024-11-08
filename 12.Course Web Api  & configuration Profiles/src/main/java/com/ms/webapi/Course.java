package com.ms.webapi;

public class Course {

  private int id;
  private String courseName;

  public Course(int id, String courseName) {
    this.id = id;
    this.courseName = courseName;
  }

  public int getId() {
    return id;
  }

  public String getCourseName() {
    return courseName;
  }

  @Override
  public String toString() {
    return "Course [id=" + id + ", courseName=" + courseName + "]";
  }
}
