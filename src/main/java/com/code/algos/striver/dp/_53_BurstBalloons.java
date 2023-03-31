package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, 
then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10
 

Constraints:

n == nums.length
1 <= n <= 300
0 <= nums[i] <= 100
 * 
 * @author sukh
 *
 */
public class _53_BurstBalloons {

  /**
   * NOTE: This is a similar problem to com.code.algos.striver.dp._51_MCM
   */

  /**
   * Time: exponential <br>
   * Space:
   * 
   * @param nums
   * @return
   */
  public int maxCoins_recursion(int[] nums) {
    /**
     * Recursion: TLE
     */
    /**
     * Algorithm:
     * 
     * we cannot burst a balloon and proceed recursively as the partitions aren't
     * independent
     * 
     * instead we proceed in a reverse fashion, i.e., burst the balloon at the last,
     * such that the left and right partitions become independent
     * 
     * eg: 1, 3, 1, 5, 8, 1
     * 
     * note first and last 1 are dummy balloons
     * 
     * if we decide to burst balloon 1 at the last, the left partition (1, 3) and
     * right partition (5, 8, 1) become independent of each other
     * 
     * had we deleted it first then they would have become dependent on each other
     * and its difficult to keep track
     * 
     * hence, for balloon 1 cost (1) = nums[start - 1] * nums[burst] * nums[end + 1]
     * = 1 * 1 * 1 = 1
     * 
     * for left partition cost (3) = nums[start - 1] * nums[burst] * nums[end + 1] =
     * 1 * 3 * 1 = 3
     */
    int n = nums.length;
    int[] balloons = new int[n + 2];
    /**
     * dummy balloons
     * 
     * for the first and last balloons
     * 
     * i - 1 = 1
     * 
     * i + 1 = 1 respectively
     */
    balloons[0] = 1;
    balloons[n + 1] = 1;
    int j = 1;
    for (int i : nums) {
      balloons[j] = i;
      j++;
    }
    return max_recursive(balloons, 1, n);
  }

  private int max_recursive(int[] nums, int start, int end) {
    if (start > end) {
      return 0;
    }
    int max = 0;
    for (int k = start, coins = 0; k <= end; k++) {
      coins = max_recursive(nums, start, k - 1) + max_recursive(nums, k + 1, end)
          + nums[start - 1] * nums[k] * nums[end + 1];
      max = Math.max(max, coins);
    }
    return max;
  }

  /**
   * Time: O(n * n * n) <br>
   * Space: O(n * n) + O(n)
   * 
   * @param nums
   * @return
   */
  public int maxCoins_memoization(int[] nums) {
    /**
     * Memoization
     */
    int n = nums.length;
    int[] balloons = new int[n + 2];
    balloons[0] = 1;
    balloons[n + 1] = 1;
    int j = 1;
    for (int i : nums) {
      balloons[j] = i;
      j++;
    }
    int[][] dp = new int[n + 2][n + 2];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return max_memoize(balloons, 1, n, dp);
  }

  private int max_memoize(int[] nums, int start, int end, int[][] dp) {
    if (start > end) {
      return 0;
    }
    if (dp[start][end] != -1) {
      return dp[start][end];
    }
    int max = 0;
    for (int k = start, coins = 0; k <= end; k++) {
      coins = max_memoize(nums, start, k - 1, dp) + max_memoize(nums, k + 1, end, dp)
          + nums[start - 1] * nums[k] * nums[end + 1];
      max = Math.max(max, coins);
    }
    return dp[start][end] = max;
  }

  /**
   * Time: O(n * n * n) <br>
   * Space: O(n * n)
   * 
   * @param nums
   * @return
   */
  public int maxCoins_tabulation(int[] nums) {
    /**
     * Tabulation
     */
    int n = nums.length;
    int[] balloons = new int[n + 2];
    balloons[0] = 1;
    balloons[n + 1] = 1;
    int j = 1;
    for (int i : nums) {
      balloons[j] = i;
      j++;
    }
    int[][] dp = new int[n + 3][n + 3];
    for (int start = n, coins = 0, max = 0; start > 0; start--) {
      for (int end = start; end <= n; end++) {
        max = 0;
        for (int k = start; k <= end; k++) {
          coins = dp[start][k - 1] + dp[k + 1][end]
              + balloons[start - 1] * balloons[k] * balloons[end + 1];
          max = Math.max(max, coins);
        }
        dp[start][end] = max;
      }
    }
    return dp[1][n];
  }

}
