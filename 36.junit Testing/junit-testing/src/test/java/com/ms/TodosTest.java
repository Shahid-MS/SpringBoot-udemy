// package com.ms;

// import static org.junit.jupiter.api.Assertions.assertArrayEquals;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import java.util.Arrays;
// import java.util.List;
// import org.junit.jupiter.api.Test;

// public class TodosTest {

//   List<String> todoList = Arrays.asList("AWS", "Azure", "Devops");

//   @Test
//   void test() {
//     boolean result = todoList.contains("AWS");
//     // assertEquals(true, result);

//     // For boolean values
//     // assertTrue(result);

//     // Message if not match
//     assertTrue(result, "Something went wrong");
//     // assertFalse(result, "Something went wrong");

//     // assertEquals(3, todoList.size());
//     // assertEquals(2, todoList.size());
//     // assertEquals(2, todoList.size(), "Size must be 2");

//     assertArrayEquals(new int[] { 1, 2 }, new int[] { 2 }, "Arrays not equal");
//   }
// }
