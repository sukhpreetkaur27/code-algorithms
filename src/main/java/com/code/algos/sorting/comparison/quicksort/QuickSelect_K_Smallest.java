package com.code.algos.sorting.comparison.quicksort;

import java.util.Arrays;
import java.util.Random;

public class QuickSelect_K_Smallest {

  public int kSmallest(int[] arr, int k) {
    int size = arr.length;
    int kSmallest = kSmallest(arr, 0, size - 1, k);
    return kSmallest;
  }

  private int kSmallest(int[] arr, int left, int right, int kSmallest) {
    if (left == right) {
      return arr[left];
    }

    int pivotIndex = getPivotIndex(left, right);
//    int pivotIndex = getMid(left, right);
    pivotIndex = partition(arr, left, right, pivotIndex);

    if (pivotIndex == kSmallest) {
      return arr[pivotIndex];
    } else if (kSmallest < pivotIndex) {
      return kSmallest(arr, left, pivotIndex - 1, kSmallest);
    }
    return kSmallest(arr, pivotIndex + 1, right, kSmallest);
  }

  private int partition(int[] arr, int left, int right, int pivotIndex) {
    int pivot = arr[pivotIndex];

    swap(arr, pivotIndex, right);

    int index = left;
    for (int i = left; i <= right; i++) {
      if (arr[i] < pivot) {
        swap(arr, index, i);
        index++;
      }
    }

    swap(arr, index, right);
    return index;
  }

  private void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  private int getMid(int left, int right) {
    int mid = (left + right) / 2;
    return mid;
  }

  private int getPivotIndex(int left, int right) {
    Random rand = new Random();
    int pivotIndex = left + rand.nextInt(right - left);
    return pivotIndex;
  }

  public static void main(String[] args) {
    QuickSelect_K_Smallest obj = new QuickSelect_K_Smallest();
    int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
    int k = 2;
    System.out.println(Arrays.toString(arr));
    int kSmallest = obj.kSmallest(arr, k);
    System.out.println(k + "-th smallest = " + kSmallest);
  }

}
