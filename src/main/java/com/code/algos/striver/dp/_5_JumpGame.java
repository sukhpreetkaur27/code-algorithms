package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
 * 
 * @author sukh
 *
 */
public class _5_JumpGame {

  public boolean canJump_recursion(int[] nums) {
    /**
     * Recursion: TLE
     */
    int N = nums.length;
    return canJump_recursive(nums, N - 1, 0);
  }

  public boolean canJump_recursive(int[] nums, int N, int index) {
    if (index >= N) {
      return true;
    }
    for (int i = nums[index]; i > 0; i--) {
      if (canJump_recursive(nums, N, index + i)) {
        return true;
      }
    }
    return false;
  }

  public boolean canJump_memoization(int[] nums) {
    int N = nums.length;
    int[] dp = new int[N];
    /**
     * -1 = not found <br>
     * 0 = false <br>
     * 1 = true
     */
    Arrays.fill(dp, -1);
    dp[N - 1] = 1;
    return canJump_memoize(nums, N - 1, 0, dp);
  }

  public boolean canJump_memoize(int[] nums, int N, int index, int[] dp) {
    /**
     * Base Case
     * 
     * Reached Goal
     */
    if (index == N) {
      dp[index] = 1;
      return true;
    }
    /**
     * if already found --> return
     */
    if (dp[index] != -1) {
      return dp[index] == 0 ? false : true;
    }
    /**
     * Greedy Optimization to start from maximum value to reach the goal ASAP
     */
    int limit = Math.min(index + nums[index], N);
    for (int i = limit; i >= index + 1; i--) {
      /**
       * if index+i can cross N (goal) --> return true
       */
      if (canJump_memoize(nums, N, index + i, dp)) {
        dp[index] = 1;
        return true;
      }
    }
    dp[index] = 0;
    return false;
  }

  public boolean canJump_tabulation(int[] nums) {
    int N = nums.length;
    int[] dp = new int[N];
    Arrays.fill(dp, -1);
    dp[N - 1] = 1;
    /**
     * Greedy Approach to start from n-2
     */
    for (int index = N - 2; index >= 0; index--) {
      int limit = Math.min(index + nums[index], N);
      for (int i = limit; i >= index + 1; i--) {
        if (dp[i] != -1) {
          dp[index] = dp[i];
          break;
        }
      }
    }
    return dp[0] == 1;
  }

  public boolean canJump_optimal(int[] nums) {
    int n = nums.length;
    int goal = n - 1;
    for (int i = n - 2; i >= 0; i--) {
      if (i + nums[i] >= goal) {
        goal = i;
      }
    }
    return goal == 0;
  }

}
