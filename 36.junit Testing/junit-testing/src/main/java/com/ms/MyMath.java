package com.ms;

public class MyMath {

  public int calculateMax(int[] numbers) {
    int sum = 0;
    for (int num : numbers) {
      sum += num;
    }
    return sum;
  }
}
