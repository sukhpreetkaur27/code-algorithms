package com.code.algos.sorting.comparison;

import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) {
//  int[] arr = { 2, 7, 4, 5, 1, 3 };
    int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  /**
   * Time: O(n^2)<br>
   * Space: O(1)
   * @param arr
   */
  public static void sort(int[] arr) {
    int n = arr.length;

    for (int i = 1, current, temp; i < n; i++) {
      current = i;
      while (current > 0 && arr[current - 1] > arr[current]) {
        temp = arr[current];
        arr[current] = arr[current - 1];
        arr[current - 1] = temp;
        current--;
      }
    }
  }

}
