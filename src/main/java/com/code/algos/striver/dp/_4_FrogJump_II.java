package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * There are n stones and an array of heights and Geek is standing at stone 1 and can jump to one of the following: Stone i+1, i+2, ... i+k stone 
 * and cost will be [hi-hj] is incurred, where j is the stone to land on. Find the minimum possible total cost incurred before the Geek reaches Stone N.

Example 1:
Input:
n = 5, k = 3
heights = {10, 30, 40, 50, 20}
Output:
30
Explanation:
Geek will follow the path 1->2->5, the total cost 
would be | 10-30| + |30-20| = 30, which is minimum
Example 2:

Input:
n = 3, k = 1
heights = {10,20,10}
Output:
20
Explanation:
Geek will follow the path 1->2->3, the total cost
would be |10 - 20| + |20 - 10| = 20.
Your Task:
You don't need to read input or print anything. Your task is to complete the function minimizeCost() which takes the array height, and integer n, 
and integer k and returns the minimum energy that is lost.

Expected Time Complexity: O(n*k)
Expected Space Complexity: O(n)

Constraint:
2 <= n <= 105
1 <= k <= 100
1 <= heights[i] <= 104
 * 
 * @author sukh
 *
 */
public class _4_FrogJump_II {

  /**
   * Time: O(n * k) <br>
   * For every index we are running for k steps <br>
   * Space: O(2n)
   * @param arr
   * @param N
   * @param K
   * @return
   */
  public int minimizeCost_recursion(int arr[], int N, int K) {
    /**
     * Recursion - TLE
     */
    /**
     * 0-based array
     */
    return minimizeCost_recursive(arr, N - 1, K);
  }

  public int minimizeCost_recursive(int arr[], int n, int k) {
    /**
     * Recursion - TLE
     */
    /**
     * Base Case
     * 
     * n <= 0, no energy required to jump
     */
    if (n <= 0) {
      return 0;
    }
    /**
     * Edge Case
     * 
     * n = 1,
     * 
     * 1-1=0 --> 0 <br>
     * 1-2 = -1 --> not possible
     */
    if (n == 1) {
      return Math.abs(arr[1] - arr[0]);
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1, cost = 0; i <= k && (n - i) >= 0; i++) {
      /**
       * do all possible stuffs as per question
       */
      /**
       * cost = current cost from n to (n-i)-th index + recursive cost from (n-i)-th
       * index
       */
      cost = Math.abs(arr[n] - arr[n - i]) + minimizeCost_recursive(arr, n - i, k);
      /**
       * Find the minimum cost after trying all possible k ways
       */
      min = Math.min(min, cost);
    }
    return min;
  }

  /**
   * Time: O(n) <br>
   * For every index we are running for k steps <br>
   * Space: O(2n)
   * @param arr
   * @param N
   * @param K
   * @return
   */
  public int minimizeCost_memoization(int arr[], int N, int K) {
    /**
     * Memoization
     */
    int[] dp = new int[N];
    Arrays.fill(dp, -1);
    /**
     * 0-based array
     */
    return minimizeCost_memoize(arr, N - 1, K, dp);
  }

  public int minimizeCost_memoize(int arr[], int n, int k, int[] dp) {
    /**
     * Memoization
     */
    /**
     * Base Case
     * 
     * n <= 0, no energy required to jump
     */
    if (n <= 0) {
      return dp[0] = 0;
    }
    /**
     * Edge Case
     * 
     * n = 1,
     * 
     * 1-1=0 --> 0 <br>
     * 1-2 = -1 --> not possible
     */
    if (n == 1) {
      return dp[1] = Math.abs(arr[1] - arr[0]);
    }
    /**
     * if already found --> return it
     */
    if (dp[n] != -1) {
      return dp[n];
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1, cost = 0; i <= k && (n - i) >= 0; i++) {
      cost = Math.abs(arr[n] - arr[n - i]) + minimizeCost_memoize(arr, n - i, k, dp);
      min = Math.min(min, cost);
    }
    return dp[n] = min;
  }

  /**
   * Time: O(n * k) <br>
   * For every index we are running for k steps <br>
   * Space: O(n)
   * @param arr
   * @param N
   * @param K
   * @return
   */
  public int minimizeCost_tabulation(int arr[], int N, int K) {
    /**
     * Tabulation
     */
    int[] dp = new int[N];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    dp[1] = Math.abs(arr[1] - arr[0]);
    for (int i = 2; i < N; i++) {
      for (int j = 1, cost = 0; j <= K && (i - j) >= 0; j++) {
        cost = Math.abs(arr[i] - arr[i - j]) + dp[i - j];
        /**
         * pick the minimum
         */
        dp[i] = Math.min(dp[i], cost);
      }
    }
    return dp[N - 1];
  }

}
