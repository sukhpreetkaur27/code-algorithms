package com.code.algos.sorting.comparison;

import java.util.Arrays;

/**
 * Time: O(n log n)<br>
 * Space: O(n)
 * @author sukh
 *
 */
public class MergeSort {

  private void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
    if (leftStart >= rightEnd) {
      return;
    }

    int middle = (leftStart + rightEnd) / 2;
    mergeSort(arr, temp, leftStart, middle);
    mergeSort(arr, temp, middle + 1, rightEnd);
    mergeHalves(arr, temp, leftStart, middle, rightEnd);
  }

  public void mergeSort(int[] arr) {
    mergeSort(arr, new int[arr.length], 0, arr.length - 1);
  }

  private void mergeHalves(int[] arr, int[] temp, int leftStart, int middle, int rightEnd) {
    int left = leftStart;
    int right = middle + 1;
    int index = leftStart;

    while (left <= middle && right <= rightEnd) {
      if (arr[left] <= arr[right]) {
        temp[index] = arr[left];
        left++;
      } else {
        temp[index] = arr[right];
        right++;
      }
      index++;
    }

    while (left <= middle) {
      temp[index] = arr[left];
      left++;
      index++;
    }

    while (right <= rightEnd) {
      temp[index] = arr[right];
      right++;
      index++;
    }

    // Copy from temp to the original array half
    while (leftStart <= rightEnd) {
      arr[leftStart] = temp[leftStart];
      leftStart++;
    }

  }

  public static void main(String[] args) {
    MergeSort obj = new MergeSort();
    int arr[] = { 2, 1, 3, 4, 0 };
    obj.mergeSort(arr);
    System.out.println(Arrays.toString(arr));
  }

}
