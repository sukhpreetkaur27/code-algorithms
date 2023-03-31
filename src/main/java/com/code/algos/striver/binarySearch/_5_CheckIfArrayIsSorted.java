package com.code.algos.striver.binarySearch;

public class _5_CheckIfArrayIsSorted {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public boolean isSorted(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] > arr[i]) {
        return false;
      }
    }
    return true;
  }

}
