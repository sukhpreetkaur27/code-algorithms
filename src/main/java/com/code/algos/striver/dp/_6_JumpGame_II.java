package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
 * 
 * @author sukh
 *
 */
public class _6_JumpGame_II {

  public int jump_recursion(int[] nums) {
    int N = nums.length;
    return canJump_recursive(nums, N - 1, 0);
  }

  public int canJump_recursive(int[] nums, int N, int index) {
    if (index == N) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    int limit = Math.min(nums[index] + index, N);
    for (int i = limit, cost = 0; i >= index + 1; i--) {
      cost = canJump_recursive(nums, N, i);
      if (cost != Integer.MAX_VALUE) {
        min = Math.min(min, 1 + cost);
      }
    }
    return min;
  }

  public int jump_memoization(int[] nums) {
    int N = nums.length;
    int[] dp = new int[N];
    Arrays.fill(dp, Integer.MAX_VALUE);
    return canJump_memoize(nums, N - 1, 0, dp);
  }

  public int canJump_memoize(int[] nums, int N, int index, int[] dp) {
    if (index == N) {
      return dp[index] = 0;
    }
    if (dp[index] != Integer.MAX_VALUE) {
      return dp[index];
    }
    int min = Integer.MAX_VALUE;
    int limit = Math.min(nums[index] + index, N);
    for (int i = limit, cost = 0; i >= index + 1; i--) {
      cost = canJump_memoize(nums, N, i, dp);
      if (cost != Integer.MAX_VALUE) {
        min = Math.min(min, 1 + cost);
      }
    }
    return dp[index] = min;
  }

  public int jump_tabulation(int[] nums) {
    int N = nums.length - 1;
    int[] dp = new int[N + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int index = 0; index <= N; index++) {
      int limit = Math.min(nums[index] + index, N);
      for (int i = limit; i >= index + 1; i--) {
        dp[i] = Math.min(dp[i], 1 + dp[index]);
      }
    }
    return dp[N];
  }

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param nums
   * @return
   */
  public int jump_optimal(int[] nums) {
    /**
     * Two Pointer - Greedy
     */
    int count = 0;
    int n = nums.length;
    int l = 0;
    int r = 0;
    int farthest = 0;
    while (r < n - 1) {
      for (int i = l; i <= r && farthest < n; i++) {
        farthest = Math.max(farthest, nums[i] + i);
      }
      l = r + 1;
      r = farthest;
      count++;
    }

    return count;
  }

}
