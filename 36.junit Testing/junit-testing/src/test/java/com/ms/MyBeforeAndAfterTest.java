package com.ms;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyBeforeAndAfterTest {

  @BeforeAll
  static void beforeAll() {
    System.out.println("before All");
  }

  @BeforeEach
  void beforeEach() {
    System.out.println("Before each");
  }

  @AfterEach
  void afterEach() {
    System.out.println("After each");
  }

  @Test
  void test1() {
    System.out.println("Test 1");
  }

  @Test
  void test2() {
    System.out.println("Test 2");
  }

  @Test
  void test3() {
    System.out.println("Test 3");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("after All");
  }
}
