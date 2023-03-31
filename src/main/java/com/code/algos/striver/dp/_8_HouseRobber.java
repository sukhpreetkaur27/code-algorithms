package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically 
 * contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 * 
 * @author sukh
 *
 */
public class _8_HouseRobber {

  public int findMaxSum_recursion(int arr[]) {
    /**
     * Recursion: TLE
     */
    int n = arr.length;
    return findMaxSum_recursive(arr, n - 1);
  }

  private int findMaxSum_recursive(int arr[], int index) {
    /**
     * Base Case
     */
    if (index == 0) {
      return arr[index];
    }
    /**
     * Edge Case
     * 
     * for negative indices --> return 0
     */
    if (index < 0) {
      return 0;
    }
    /**
     * pick the current element and skip the adjacent
     */
    int pick = arr[index] + findMaxSum_recursive(arr, index - 2);
    /**
     * skip the current element and pick the adjacent
     */
    int notPick = 0 + findMaxSum_recursive(arr, index - 1);
    return Math.max(pick, notPick);
  }

  public int findMaxSum_memoization(int arr[]) {
    int n = arr.length;
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = arr[0];
    return findMaxSum_memoize(arr, n - 1, dp);
  }

  private int findMaxSum_memoize(int arr[], int index, int[] dp) {
    if (index == 0) {
      return dp[index];
    }
    if (index < 0) {
      return 0;
    }
    if (dp[index] != Integer.MAX_VALUE) {
      return dp[index];
    }
    int pick = arr[index] + findMaxSum_memoize(arr, index - 2, dp);
    int notPick = 0 + findMaxSum_memoize(arr, index - 1, dp);
    return dp[index] = Math.max(pick, notPick);
  }

  public int findMaxSum_tabulation(int arr[]) {
    int n = arr.length;
    if (n == 1) {
      return arr[0];
    }
    /**
     * Max Sum till i-th index
     */
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = arr[0];
    dp[1] = Math.max(arr[1], arr[0]);
//    int max = Math.max(dp[0], dp[1]);
    for (int i = 2; i < n; i++) {
      /**
       * pick
       */
      dp[i] = arr[i] + dp[i - 2];
      /**
       * not pick
       */
      dp[i] = Math.max(dp[i], dp[i - 1]);
//      max = Math.max(max, dp[i]);
    }
//    return max;
    return dp[n - 1];
  }

  public int findMaxSum_optimal(int arr[]) {
    int n = arr.length;
    if (n == 1) {
      return arr[0];
    }
    /**
     * Max Sum till i-2 element
     */
    int prev2 = arr[0];
    /**
     * Max Sum till i-1 element
     */
    int prev1 = Math.max(arr[1], arr[0]);
    /**
     * Max Sum
     */
//    int max = prev1;
    for (int i = 2, curr = 0; i < n; i++) {
      /**
       * pick + skip adjacent sum
       */
      curr = arr[i] + prev2;
      /**
       * not pick + pick adjacent sum
       */
      curr = Math.max(curr, prev1);
//      max = Math.max(max, curr);
      /**
       * max sum till previous 2 elements = max sum till previous element
       */
      prev2 = prev1;
      /**
       * max sum till previous element = max sum till current element
       */
      prev1 = curr;
    }
//    return max;
    return prev1;
  }

}
