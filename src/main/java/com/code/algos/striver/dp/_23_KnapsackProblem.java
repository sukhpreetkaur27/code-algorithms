package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
 * Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. 
Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller 
than or equal to W. You cannot break an item, either pick the complete item or dont pick it (0-1 property).

Example 1:

Input:
N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3
Example 2:

Input:
N = 3
W = 3
values[] = {1,2,3}
weight[] = {4,5,6}
Output: 0
Your Task:
Complete the function knapSack() which takes maximum capacity W, weight array wt[], value array val[], and the number of items n as a parameter 
and returns the maximum possible value you can get.

Expected Time Complexity: O(N*W).
Expected Auxiliary Space: O(N*W)

Constraints:
1 ≤ N ≤ 1000
1 ≤ W ≤ 1000
1 ≤ wt[i] ≤ 1000
1 ≤ v[i] ≤ 1000
 * 
 * @author sukh
 *
 */
public class _23_KnapsackProblem {

  /**
   * Time: O(2^n) <br>
   * Space: O(n)
   * 
   * @param W
   * @param wt
   * @param val
   * @param n
   * @return
   */
  public int knapSack_recursion(int W, int wt[], int val[], int n) {
    /**
     * Recursion: TLE
     */
    return knapsack_recursive(wt, val, n - 1, W);
  }

  /**
   * Till index, what maximum value will we get with knapsack of weight
   * 
   * @param wt
   * @param val
   * @param index
   * @param weight
   * @return
   */
  private int knapsack_recursive(int[] wt, int[] val, int index, int weight) {
    if (weight == 0) {
      return 0;
    }
    if (index == 0) {
      if (wt[index] <= weight) {
        return val[index];
      }
      return 0;
    }
    int pick = 0;
    if (wt[index] <= weight) {
      pick = val[index] + knapsack_recursive(wt, val, index - 1, weight - wt[index]);
    }
    int notPick = knapsack_recursive(wt, val, index - 1, weight);
    return Math.max(pick, notPick);
  }

  /**
   * Time: O(n * W) <br>
   * Space: O(n) + O(n * W)
   * 
   * @param W
   * @param wt
   * @param val
   * @param n
   * @return
   */
  public int knapSack_memoization(int W, int wt[], int val[], int n) {
    /**
     * Memoization
     */
    int[][] dp = new int[n][W + 1];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return knapsack_memoize(wt, val, n - 1, W, dp);
  }

  private int knapsack_memoize(int[] wt, int[] val, int index, int weight, int[][] dp) {
    /**
     * Edge Case
     */
    if (weight == 0) {
      return 0;
    }
    /**
     * Base Case
     */
    if (index == 0) {
      if (wt[index] <= weight) {
        return val[index];
      }
      return 0;
    }
    if (dp[index][weight] != -1) {
      return dp[index][weight];
    }
    int pick = 0;
    if (wt[index] <= weight) {
      pick = val[index] + knapsack_memoize(wt, val, index - 1, weight - wt[index], dp);
    }
    int notPick = knapsack_memoize(wt, val, index - 1, weight, dp);
    return dp[index][weight] = Math.max(pick, notPick);
  }

  /**
   * Time: O(n * W) <br>
   * Space: O(n * W)
   * 
   * @param W
   * @param wt
   * @param val
   * @param n
   * @return
   */
  public int knapSack_tabulation(int W, int wt[], int val[], int n) {
    /**
     * Tabulation
     */
    int[][] dp = new int[n][W + 1];
    /**
     * if (wt[0] <= weight) { return val[0]; }
     */
    /**
     * start from wt[0] as we cannot pick the value if wt[0] > W
     */
    for (int i = wt[0]; i <= W; i++) {
      dp[0][i] = val[0];
    }

    /**
     * index 0 is base case
     */
    for (int index = 1, pick = 0, notPick = 0; index < n; index++) {
      /**
       * weight = 0 is edge case
       */
      for (int weight = 1; weight <= W; weight++) {
        pick = 0;
        if (wt[index] <= weight) {
          pick = val[index] + dp[index - 1][weight - wt[index]];
        }
        notPick = dp[index - 1][weight];
        dp[index][weight] = Math.max(pick, notPick);
      }
    }
    return dp[n - 1][W];
  }

  /**
   * Time: O(n * w) <br>
   * Space: O(2W)
   * 
   * @param W
   * @param wt
   * @param val
   * @param n
   * @return
   */
  public int knapSack_spaceOptimization(int W, int wt[], int val[], int n) {
    /**
     * Space Optimization
     */
    int[] dp = new int[W + 1];
    int[] curr = new int[W + 1];
    for (int i = wt[0]; i <= W; i++) {
      dp[i] = val[0];
    }

    for (int index = 1, pick = 0, notPick = 0; index < n; index++) {
      for (int weight = 1; weight <= W; weight++) {
        pick = 0;
        if (wt[index] <= weight) {
          pick = val[index] + dp[weight - wt[index]];
        }
        notPick = dp[weight];
        curr[weight] = Math.max(pick, notPick);
      }
      for (int weight = 1; weight <= W; weight++) {
        dp[weight] = curr[weight];
      }
    }
    return dp[W];
  }
  
  /**
   * Time: O(n * w) <br>
   * Space: O(W)
   * 
   * @param W
   * @param wt
   * @param val
   * @param n
   * @return
   */
  public int knapSack_optimal(int W, int wt[], int val[], int n) {
    /**
     * Space Optimization
     */
    int[] dp = new int[W + 1];
    for (int i = wt[0]; i <= W; i++) {
      dp[i] = val[0];
    }

    for (int index = 1, pick = 0, notPick = 0; index < n; index++) {
      /**
       * for: 0....weight....W
       * 
       * weight - wt[index] --> will always lie on the left side of weight, i.e.,
       * already processed --> hence, we require 2 separate temp arrays
       * 
       * if we change the loop: W....weight....0
       * 
       * weight - wt[index] --> will lie on the right side and not on the already
       * processed left side --> hence, we can use a single array as the already
       * processed part will never be used for the current index
       */
      for (int weight = W; weight >= 0; weight--) {
        pick = 0;
        if (wt[index] <= weight) {
          pick = val[index] + dp[weight - wt[index]];
        }
        notPick = dp[weight];
        dp[weight] = Math.max(pick, notPick);
      }
    }
    return dp[W];
  }

}
