package com.code.algos.striver.basicMaths;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class H_PerfectSquares {

  public int solution(int[] numbers) {
    int count = 0;
    int length = numbers.length;
    if (length == 1) {
      return 1;
    }
    int maxPerfectSquare = maxPerfectSquare(numbers);

    List<Integer> perfectSquares = getPerfectSquares(maxPerfectSquare);

    Set<Integer> nums = new HashSet<>();
    for (int i = 0; i < numbers.length; i++) {
      nums.add(numbers[i]);
    }

    for (int i = 0, num = 0; i < numbers.length; i++) {
      for (int j : perfectSquares) {
        num = j - numbers[i];
        if (num > numbers[i] && nums.contains(num)) {
          System.out.println(numbers[i] + " + " + num + " = " + j);
          count++;
        }
      }
    }
    return count;
  }

  private List<Integer> getPerfectSquares(int limit) {
    List<Integer> list = new ArrayList<>();

    for (int i = 1, value = 0; value <= limit; i++) {
      list.add(value);
      value = (int) Math.pow(i, 2);
    }
    return list;
  }

  private int maxPerfectSquare(int[] numbers) {
    int max;
    int max2;
    if (numbers[0] > numbers[1]) {
      max = numbers[0];
      max2 = numbers[1];
    } else {
      max = numbers[1];
      max2 = numbers[0];
    }
    for (int i = 2; i < numbers.length; i++) {
      if (numbers[i] > max) {
        max2 = max;
        max = numbers[i];
      } else if (numbers[i] > max2) {
        max2 = numbers[i];
      }
    }
    return max + max2;
  }

  public static void main(String[] args) {
    H_PerfectSquares obj = new H_PerfectSquares();
    int[] nums = { -1, 18, 3, 1, 5 };
    obj.solution(nums);
  }

}
