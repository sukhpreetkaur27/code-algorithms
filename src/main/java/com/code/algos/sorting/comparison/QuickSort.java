package com.code.algos.sorting.comparison;

import java.util.Arrays;
import java.util.Random;

/**
 * Average Time: O(n log n)<br>
 * Worst Time: O(n^2)<br>
 * Space: O(1)
 * @author sukh
 *
 */
public class QuickSort {
  
  private void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  private void quickSort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }

//    int pivotIndex = getPivotIndex(left, right);
    int pivot = arr[(left + right) / 2];
    int partition = partition(arr, pivot, left, right);
//    pivotIndex = partition(arr, left, right, pivotIndex);
    /**
     * LHS < pivot element
     */
//    quickSort(arr, left, pivotIndex - 1);
    quickSort(arr, left, partition - 1);
    /**
     * RHS >= pivot element
     */
//    quickSort(arr, pivotIndex, right);
    quickSort(arr, partition, right);
  }

  private int getPivotIndex(int left, int right) {
    Random rand = new Random();
    int pivotIndex = left + rand.nextInt(right - left);
    return pivotIndex;
  }

//  private int partition(int[] arr, int left, int right, int pivotIndex) {
//    int pivot = arr[pivotIndex];
//
//    swap(arr, pivotIndex, right);
//
//    int index = left;
//    for (int i = left; i <= right; i++) {
//      if (arr[i] < pivot) {
//        swap(arr, index, i);
//        index++;
//      }
//    }
//
//    swap(arr, index, right);
//
//    return index;
//  }

  private void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  private int partition(int[] arr, int pivot, int left, int right) {
    while (left <= right) {
      while (arr[left] < pivot) {
        left++;
      }
      while (arr[right] > pivot) {
        right--;
      }
      if (left <= right) {
        swap(arr, left, right);
        left++;
        right--;
      }
    }

    return left;
  }

  public static void main(String[] args) {
    QuickSort obj = new QuickSort();
    int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
    obj.quickSort(arr);
    System.out.println(Arrays.toString(arr));
  }

}
