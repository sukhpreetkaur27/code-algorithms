package com.code.algos.sorting.comparison;

import java.util.Arrays;

public class SelectionSort {

  public static void main(String[] args) {
    int[] arr = { 2, 7, 4, 5, 1, 3 };
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void sort(int[] arr) {
    int minIndex;
    for (int i = 0; i < arr.length - 1; i++) {
      minIndex = minIndex(arr, i);
      swap(arr, i, minIndex);
    }
  }

  private static int minIndex(int[] arr, int start) {
    int minIndex = start;
    int min = arr[start];

    for (int i = start + 1; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
        minIndex = i;
      }
    }
    return minIndex;
  }

  private static void swap(int[] arr, int index, int minIndex) {
    arr[index] ^= arr[minIndex];
    arr[minIndex] ^= arr[index];
    arr[index] ^= arr[minIndex];
  }

}
