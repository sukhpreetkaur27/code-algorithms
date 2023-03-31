package com.code.algos.striver.dp;

/**
 * Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning,
 *  each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: arr = [1,15,7,9,2,5,10], k = 3
Output: 84
Explanation: arr becomes [15,15,15,9,10,10,10]
Example 2:

Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
Output: 83
Example 3:

Input: arr = [1], k = 1
Output: 1
 

Constraints:

1 <= arr.length <= 500
0 <= arr[i] <= 109
1 <= k <= arr.length
 * 
 * @author sukh
 *
 */
public class _56_PartitionArrayMaxSum {

  /**
   * Time: Exponential
   * 
   * @param arr
   * @param k
   * @return
   */
  public int maxSumAfterPartitioning_recursion(int[] arr, int k) {
    /**
     * Recursion: TLE
     */
    return partition_recursive(arr, k, 0);
  }

  private int partition_recursive(int[] arr, int k, int index) {
    if (index == arr.length) {
      return 0;
    }
    int max = 0;
    for (int cut = 0, largest = -1, sum = 0; index + cut < arr.length && cut < k; cut++) {
      largest = Math.max(largest, arr[index + cut]);
      sum = largest * (cut + 1) + partition_recursive(arr, k, index + cut + 1);
      max = Math.max(max, sum);
    }
    return max;
  }

  /**
   * Time: O(n * k) <br>
   * Space: O(n)
   * 
   * @param arr
   * @param k
   * @return
   */
  public int maxSumAfterPartitioning_tabulation(int[] arr, int k) {
    /**
     * Tabulation
     */
    int n = arr.length;
    int[] dp = new int[n + 1];
    for (int index = n - 1, max = 0; index >= 0; index--) {
      max = 0;
      for (int cut = 0, largest = -1, sum = 0; index + cut < arr.length
          && cut < k; cut++) {
        largest = Math.max(largest, arr[index + cut]);
        sum = largest * (cut + 1) + dp[index + cut + 1];
        max = Math.max(max, sum);
      }
      dp[index] = max;
    }
    return dp[0];
  }

}
