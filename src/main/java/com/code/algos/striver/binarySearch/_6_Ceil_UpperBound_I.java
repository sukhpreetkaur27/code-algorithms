package com.code.algos.striver.binarySearch;

public class _6_Ceil_UpperBound_I {

  /**
   * NOTE: <br>
   * Ceil of X is the smallest element which is greater than or equal to X. Ceil
   * of X doesn’t exist if X is greater than greatest element of Arr[].
   */

  /**
   * Time: O(log n)<br>
   * Space: O(1)
   * @param arr
   * @param x
   * @return
   */
  public int ceil(int[] arr, int x) {
    return ceil(arr, x, 0, arr.length - 1);
  }

  private int ceil(int[] arr, int x, int lo, int hi) {
    if (lo > hi) {
      return -1;
    }
    if (x > arr[hi]) {
      return -1;
    }
    if (x == arr[hi]) {
      return arr[hi];
    }
    if (x <= arr[lo]) {
      return arr[lo];
    }

    int mid = lo + (hi - lo) / 2;
    if (arr[mid] == x) {
      return arr[mid];
    } else if (mid + 1 < arr.length && arr[mid] < x && x <= arr[mid + 1]) {
      return arr[mid + 1];
    } else if (x < arr[mid]) {
      return ceil(arr, x, lo, mid - 1);
    }
    return ceil(arr, x, mid + 1, hi);
  }

  public static void main(String[] args) {
    int[] arr = { 5, 5, 5, 6, 6, 6, 8, 9 };
    _6_Ceil_UpperBound_I obj = new _6_Ceil_UpperBound_I();
//    System.out.println(obj.ceil(arr, 7));   // 8
    System.out.println(obj.ceil(arr, 10));    // -1
  }

}
