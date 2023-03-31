package com.code.algos.striver.binarySearch;

public class _6_Ceil_UpperBound_II {

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
    /**
     * NOTE:<br>
     * ceil always exist in this case
     */
    
    int lo = 0;
    int hi = arr.length - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      if (arr[mid] <= x) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return arr[lo];
  }
  
}
