package com.code.algos.striver.recursion;

public class _7_ReverseArray_1 {

  public void reverse(int[] arr) {
    reverse(arr, 0, arr.length);
  }

  private void reverse(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    reverse(arr, ++left, --right);
  }

}
