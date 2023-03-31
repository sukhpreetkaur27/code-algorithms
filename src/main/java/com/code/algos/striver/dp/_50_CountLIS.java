package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 

Constraints:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106
 * 
 * @author sukh
 *
 */
public class _50_CountLIS {

  /**
   * Time: O(n * n) + O(n) <br>
   * Space: O(2n)
   * 
   * @param nums
   * @return
   */
  public int findNumberOfLIS(int[] nums) {
    /**
     * Algorithm:
     * 
     * LIS[i] = the LIS length from [0, i]
     */
    int n = nums.length;
    /**
     * Stores the LIS length
     */
    int[] dp = new int[n];
    /**
     * Stores the length count
     */
    int[] count = new int[n];
    /**
     * By default, each element can be a part of an LIS containing the single
     * element only
     */
    Arrays.fill(dp, 1);
    Arrays.fill(count, 1);
    int lis_count = 0;
    int maxLis = 1;
    for (int index = 1; index < n; index++) {
      for (int prev_index = 0; prev_index < index; prev_index++) {
        /**
         * if attaching the previous element to the current element increases its length
         * 
         * it implies that it is a new length for the current element
         * 
         * and the # LIS with the previous element to form its length = the # of LIS
         * with the current element to form its new length
         */
        if (nums[index] > nums[prev_index] && (dp[prev_index] + 1) > dp[index]) {
          dp[index] = dp[prev_index] + 1;
          count[index] = count[prev_index];
        }
        /**
         * if attaching the previous element to the current element == the current
         * element's length
         * 
         * it implies that it is the same length for the current element
         * 
         * and the # of LIS with the current element to form the same length += the #
         * LIS with the previous element to form this length
         */
        else if (nums[index] > nums[prev_index] && (dp[prev_index] + 1) == dp[index]) {
          count[index] += count[prev_index];
        }
      }
      maxLis = Math.max(maxLis, dp[index]);
    }
    for (int i = 0; i < n; i++) {
      if (dp[i] == maxLis) {
        lis_count += count[i];
      }
    }
    return lis_count;
  }

}
