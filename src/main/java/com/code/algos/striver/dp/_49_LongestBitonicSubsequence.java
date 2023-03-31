package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing.
 

Example 1:

Input: nums = [1, 2, 5, 3, 2]
Output: 5
Explanation: The sequence {1, 2, 5} is
increasing and the sequence {3, 2} is 
decreasing so merging both we will get 
length 5.
Example 2:

Input: nums = [1, 11, 2, 10, 4, 5, 2, 1]
Output: 6
Explanation: The bitonic sequence 
{1, 2, 10, 4, 2, 1} has length 6.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function LongestBitonicSequence() which takes the array nums[] as input parameter 
and returns the maximum length of bitonic subsequence.
 

Expected Time Complexity: O(n2)
Expected Space Complexity: O(n)
 

Constraints:
1 ≤ length of array ≤ 103
1 ≤ arr[i] ≤ 106
 * 
 * @author sukh
 *
 */
public class _49_LongestBitonicSubsequence {

  /**
   * NOTE: This is an extension to com.code.algos.striver.dp._45_LIS
   */

  /**
   * Time: O(n * n) <br>
   * Space: O(n)
   * 
   * @param nums
   * @return
   */
  public int LongestBitonicSequence(int[] nums) {
    /**
     * Bitonic: <br>
     * Strictly increasing (or) <br>
     * Strictly decreasing (or)<br>
     * Strictly increasing and then strictly decreasing
     */
    /**
     * Find LIS from both the sides <br>
     * Sum - 1= answer
     * 
     * Why -1 ? <br>
     * As the i-th element is counted twice
     */
    int n = nums.length;
    int[] dp_left = lengthOfLIS_algo_left(nums);
    int[] dp_right = lengthOfLIS_algo_right(nums);
    int max = 1;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp_left[i] + dp_right[i] - 1);
    }
    return max;
  }

  public int[] lengthOfLIS_algo_right(int[] nums) {
    /**
     * Algorithm:
     * 
     * LIS[i] = the LIS length from [n-1, i]
     */
    int n = nums.length;
    int[] dp = new int[n];
    /**
     * By default, each element can be a part of an LIS containing the single
     * element only
     */
    Arrays.fill(dp, 1);
    for (int index = n - 2; index >= 0; index--) {
      for (int prev_index = n - 1; prev_index > index; prev_index--) {
        if (nums[index] > nums[prev_index]) {
          dp[index] = Math.max(dp[prev_index] + 1, dp[index]);
        }
      }
    }
    return dp;
  }

  public int[] lengthOfLIS_algo_left(int[] nums) {
    /**
     * Algorithm:
     * 
     * LIS[i] = the LIS length from [0, i]
     */
    int n = nums.length;
    int[] dp = new int[n];
    /**
     * By default, each element can be a part of an LIS containing the single
     * element only
     */
    Arrays.fill(dp, 1);
    for (int index = 1; index < n; index++) {
      for (int prev_index = 0; prev_index < index; prev_index++) {
        if (nums[index] > nums[prev_index]) {
          dp[index] = Math.max(dp[prev_index] + 1, dp[index]);
        }
      }
    }
    return dp;
  }

}
