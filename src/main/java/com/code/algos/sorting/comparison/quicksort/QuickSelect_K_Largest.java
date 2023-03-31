package com.code.algos.sorting.comparison.quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 * Average Time: O(n)<br>
 * Worst Time: O(n^2)<br>
 * Space: O(1)
 * @author sukh
 *
 */
public class QuickSelect_K_Largest {

  public int kLargest(int[] arr, int k) {
    int size = arr.length;
    int kLargest = kLargest(arr, 0, size - 1, size - k);
    return kLargest;
  }

  private int kLargest(int[] arr, int left, int right, int k_largest) {
    /**
     * Only 1 element in the array
     */
    if (left == right) {
      return arr[left];
    }

    /**
     * Get a random pivot index
     */
    int pivotIndex;
//    pivotIndex = getPivotIndex(left, right);
    int pivot = arr[(left + right) / 2];
    /**
     * Get the sorted pivot index such that<br>
     * 1. LHS elements < pivot index element<br>
     * 2. RHS elements > pivot index element
     */
//    pivotIndex = partition(arr, left, right, pivotIndex);
    pivotIndex = partition(arr, left, right, pivot);

    if (pivotIndex == k_largest) {
      /**
       * k-th largest == pivot
       */
      return arr[pivotIndex];
    } else if (k_largest < pivotIndex) {
      /**
       * Go left side
       */
      return kLargest(arr, left, pivotIndex - 1, k_largest);

    }
    /**
     * else if (pivotIndex < k_largest)<br>
     * Go right side
     */
    return kLargest(arr, pivotIndex + 1, right, k_largest);
  }

  private int getPivotIndex(int left, int right) {
//    Random rand = new Random();
//    int pivotIndex = left + rand.nextInt(right - left);
    int pivotIndex = (left + right) / 2;
    return pivotIndex;
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

//  private int partition(int[] arr, int left, int right, int pivotIndex) {
//    int pivot = arr[pivotIndex];
//
//    /**
//     * Move pivot to the end
//     */
//    swap(arr, pivotIndex, right);
//
//    int index = left;
//    /**
//     * Move elements < pivot to the left
//     */
//    for (int i = left; i <= right; i++) {
//      if (arr[i] < pivot) {
//        swap(arr, index, i);
//        index++;
//      }
//    }
//
//    /**
//     * Move pivot to its correct ordered position such that<br>
//     * 1. LHS elements < pivot index element<br>
//     * 2. RHS elements > pivot index element
//     */
//    swap(arr, index, right);
//
//    return index;
//  }

  private void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  public static void main(String[] args) {
    QuickSelect_K_Largest obj = new QuickSelect_K_Largest();
    int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
    int k = 2;
    System.out.println(Arrays.toString(arr));
    int kLargest = obj.kLargest(arr, k);
    System.out.println(k + "-th largest = " + kLargest);
  }

}
