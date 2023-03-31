package com.code.algos.striver.recursion;

public class _7_ReverseArray_2 {

  private int n;

  /**
   * NOTE: Without using two pointers.
   * @param arr
   */
  public void reverse(int[] arr) {
    n = arr.length;
    reverse(arr, 0);
  }

  private void reverse(int[] arr, int i) {
    if (i >= n / 2) {
      return;
    }
    int temp = arr[i];
    arr[i] = arr[n - i - 1];
    arr[n - i - 1] = temp;
    reverse(arr, i + 1);
  }

}
