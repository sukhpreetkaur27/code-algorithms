package com.code.algos.striver.binarySearch;

/**
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

 

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 

Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] for 1 <= i < j <= arr.length
 * 
 * @author sukh
 *
 */
public class _31_KthMissingPositive {

  /**
   * Time: O(log n) <br>
   * Space: O(1)
   * @param arr
   * @param k
   * @return
   */
  public int missing(int[] arr, int k) {
    int lo = 0;
    int hi = arr.length - 1;
    int mid;

    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;
      /**
       * # of missing positives before arr[i] = arr[i] - the actual positive at i
       */
      if (arr[mid] - mid - 1 < k) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    /**
     * k-th element = <br>
     * = arr[hi] + (k - (arr[hi] - hi - 1)) <br>
     * = hi + 1 + k <br>
     * = lo + k
     */
    return lo + k;
  }

}
