package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45
 * 
 * @author sukh
 *
 */
public class _2_ClimbingStairs {

  /**
   * Time: O(2^n) <br>
   * Space: O(n + n)
   * 
   * @param n
   * @return
   */
  public int climbStairs_recursion(int n) {
    /**
     * Recursion - TLE
     * 
     * Convert the problem into index - 0 to n
     */
    /**
     * Base Case
     * 
     * n=2, 2-2=0 --> 1 way
     */
    if (n == 0) {
      return 1;
    }
    /*
     * Edge Case:
     * 
     * n=1, n-2 < 0
     */
    if (n == 1) {
      return 1;
    }
    /**
     * Do all possible stuff as per problem statement
     * 
     * can climb 1 step or 2 steps
     */
    int left = climbStairs_recursion(n - 1);
    int right = climbStairs_recursion(n - 2);
    /**
     * All possible ways == Sum left recursion and right recursion
     */
    return left + right;
  }

  /**
   * Time: O(n) <br>
   * Space: O(n + n)
   * 
   * @param n
   * @return
   */
  public int climbStairs_memoization(int n) {
    /**
     * Recursion --> Memoization -- TLE
     */
    /**
     * +1 due to 0-th step
     */
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    return climbStairs_memoization(n, dp);
  }

  public int climbStairs_memoization(int n, int[] dp) {
    if (n == 0) {
      return dp[0] = 1;
    }
    if (n == 1) {
      return dp[1] = 1;
    }
    int left, right = 0;
    if (dp[n - 1] != -1) {
      left = dp[n - 1];
    } else {
      left = climbStairs_memoization(n - 1);
    }
    if (dp[n - 2] != -1) {
      right = dp[n - 2];
    } else {
      right = climbStairs_memoization(n - 2);
    }
    return dp[n] = left + right;
  }

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param n
   * @return
   */
  public int climbStairs_tabulation(int n) {
    /**
     * Tabulation
     */
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param n
   * @return
   */
  public int climbStairs(int n) {
    /**
     * Space Optimal
     */
    int prev = 1;
    int prev2 = 1;
    for (int i = 2, curr = 0; i <= n; i++) {
      curr = prev + prev2;
      prev2 = prev;
      prev = curr;
    }
    return prev;
  }

}
