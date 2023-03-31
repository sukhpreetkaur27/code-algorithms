package com.code.algos.sorting.comparison;

/**
 * Time: O(n log n)<br>
 * Space: O(1)<br>
 * NOTE: Recursion takes space on the stack = O(n)
 * @author sukh
 *
 */
public class HeapSort {

  public void sort(int[] arr) {
    int size = arr.length;

    // Assume the array to be a binary tree
    // Max Heapify
    /**
     * Time: O(n)
     */
    for (int i = size / 2 - 1; i >= 0; i--) {
      maxHeapify(arr, size, i);
    }

    int temp;
    // Sort the heap
    // Top == Max
    /**
     * Time: O(n log n)
     */
    for (int i = size - 1; i >= 0; i--) {
      temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      maxHeapify(arr, i, 0);
    }
  }

  private void maxHeapify(int[] arr, int size, int index) {
    int left = index * 2 + 1;
    int right = index * 2 + 2;
    int max = index;

    if (left < size && arr[left] > arr[max]) {
      max = left;
    }
    if (right < size && arr[right] > arr[max]) {
      max = right;
    }
    if (max != index) {
      int temp = arr[index];
      arr[index] = arr[max];
      arr[max] = temp;
      maxHeapify(arr, size, max);
    }
  }

}
