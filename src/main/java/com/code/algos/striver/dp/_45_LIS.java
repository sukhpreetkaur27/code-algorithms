package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 * 
 * @author sukh
 *
 */
public class _45_LIS {

  /**
   * Time: O(2^n) <br>
   * Space: O(n)
   * 
   * @param nums
   * @return
   */
  public int lengthOfLIS_recursion(int[] nums) {
    /**
     * Recursion: TLE
     */
    return lis_recursive(nums, 0, -1);
  }

  private int lis_recursive(int[] nums, int index, int prev_index) {
    if (index >= nums.length) {
      return 0;
    }
    int pick = 0;
    int notPick = 0;
    if (prev_index == -1 || nums[index] > nums[prev_index]) {
      pick = 1 + lis_recursive(nums, index + 1, index);
    }
    notPick = 0 + lis_recursive(nums, index + 1, prev_index);
    return Math.max(pick, notPick);
  }

  /**
   * Time: O(n * n) <br>
   * Space: O(n * n) + O(n)
   * 
   * @param nums
   * @return
   */
  public int lengthOfLIS_memoization(int[] nums) {
    /**
     * Memoization
     */
    int n = nums.length;
    int[][] dp = new int[n][n + 1];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return lis_memoize(nums, 0, -1, dp);
  }

  private int lis_memoize(int[] nums, int index, int prev_index, int[][] dp) {
    if (index == nums.length) {
      return 0;
    }
    if (dp[index][prev_index + 1] != -1) {
      return dp[index][prev_index + 1];
    }
    int pick = 0;
    int notPick = 0;
    if (prev_index == -1 || nums[index] > nums[prev_index]) {
      pick = 1 + lis_memoize(nums, index + 1, index, dp);
    }
    notPick = 0 + lis_memoize(nums, index + 1, prev_index, dp);
    return dp[index][prev_index + 1] = Math.max(pick, notPick);
  }

  /**
   * Time: O(n * n) <br>
   * Space: O(n * n)
   * 
   * @param nums
   * @return
   */
  public int lengthOfLIS_tabulation(int[] nums) {
    /**
     * Tabulation
     */
    int n = nums.length;
    int[][] dp = new int[n + 1][n + 1];
    for (int index = n - 1, pick = 0, notPick = 0; index >= 0; index--) {
      for (int prev_index = index - 1; prev_index >= -1; prev_index--) {
        pick = 0;
        notPick = 0;
        if (prev_index == -1 || nums[index] > nums[prev_index]) {
          /**
           * Shifting of coordinates for prev_index
           */
          pick = 1 + dp[index + 1][index + 1];
        }
        /**
         * Shifting of coordinates for prev_index
         */
        notPick = 0 + dp[index + 1][prev_index + 1];
        dp[index][prev_index + 1] = Math.max(pick, notPick);
      }
    }
    /**
     * Shifting of Coordinates: dp[0][-1+1]
     */
    return dp[0][0];
  }

  /**
   * Time: O(n * n) <br>
   * Space: O(n)
   * 
   * @param nums
   * @return
   */
  public int lengthOfLIS_spaceOptimization(int[] nums) {
    /**
     * Space Optimization
     */
    int n = nums.length;
    int[] dp = new int[n + 1];
    for (int index = n - 1, pick = 0, notPick = 0; index >= 0; index--) {
      for (int prev_index = index - 1; prev_index >= -1; prev_index--) {
        pick = 0;
        notPick = 0;
        if (prev_index == -1 || nums[index] > nums[prev_index]) {
          pick = 1 + dp[index + 1];
        }
        notPick = 0 + dp[prev_index + 1];
        dp[prev_index + 1] = Math.max(pick, notPick);
      }
    }
    return dp[0];
  }

  /**
   * Time: O(n * n) <br>
   * Space: O(n)
   * 
   * @param nums
   * @return
   */
  public int lengthOfLIS_algo(int[] nums) {
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
    int maxLis = 1;
    for (int index = 0; index < n; index++) {
      for (int prev_index = 0; prev_index < index; prev_index++) {
        if (nums[index] > nums[prev_index]) {
          dp[index] = Math.max(dp[prev_index] + 1, dp[index]);
        }
      }
      maxLis = Math.max(maxLis, dp[index]);
    }
    return maxLis;
  }

  /**
   * Time: O(n log n) <br>
   * Space: O(n)
   * 
   * @param nums
   * @return
   */
  public int lengthOfLIS_binarySarch(int[] nums) {
    /**
     * Intuition:
     * 
     * eg: 1, 7, 8, 4, 5, 6, -1, 9
     * 
     * IS_1: 1, 7, 8, 9
     * 
     * IS_2: 1, 4, 5, 6, 9
     * 
     * IS_3: -1, 9
     * 
     * we observe the individual lists are sorted and as we are interested in
     * finding the longest --> we can simply overwrite the values in case a new IS
     * starts, as the essence remains the same, i.e., to find the length of the LIS
     * 
     * when we have an element num that is not greater than all the elements in sub,
     * we perform a linear scan to find the first element in sub that is greater
     * than or equal to num. Since sub is in sorted order, we can use binary search
     * instead to greatly improve the efficiency of our algorithm.
     */

    /**
     * NOTE: the temp lis[] is not the LIS 
     */
    
    int n = nums.length;
    int[] lis = new int[n];
    lis[0] = nums[0];
    int length = 1;
    for (int i = 1, mid = 0, lo = 0, hi = 0; i < n; i++) {
      if (nums[i] > lis[length - 1]) {
        lis[length] = nums[i];
        length++;
      } else {
        /**
         * perform binary search to fit in the value
         */
        lo = 0;
        hi = length - 1;
        while (lo < hi) {
          mid = (lo + hi) / 2;
          if (lis[mid] == nums[i]) {
            lo = mid;
            break;
          } else if (lis[mid] > nums[i]) {
            hi = mid;
          } else {
            lo = mid + 1;
          }
        }
        lis[lo] = nums[i];
      }
    }
    return length;
  }

  public static void main(String[] args) {
    _45_LIS obj = new _45_LIS();
    int[] nums = { 5, 4, 11, 1, 16, 8 };
    int l = obj.lengthOfLIS_binarySarch(nums);
    System.out.println(l);
  }

}
