package com.code.algos.sorting.comparison;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
//    int[] arr = { 2, 7, 4, 5, 1, 3 };
    int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  /**
   * Time: O(n^2)<br>
   * Space:O(1)
   * @param arr
   */
  public static void sort(int[] arr) {
    int n = arr.length;
    int temp;
    boolean swap = true;
    for (int i = 0; i < n - 1 && swap; i++) {
      swap = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swap = true;
        }
      }
    }
  }

}
