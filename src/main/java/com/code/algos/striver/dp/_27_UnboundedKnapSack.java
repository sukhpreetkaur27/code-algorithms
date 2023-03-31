package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given a set of N items, each with a weight and a value, represented by the array w[] and val[] respectively. Also, a knapsack with weight limit W.
The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times.

 

Example 1:

Input: N = 2, W = 3
val[] = {1, 1}
wt[] = {2, 1}
Output: 3
Explanation: 
1.Pick the 2nd element thrice.
2.Total profit = 1 + 1 + 1 = 3. Also the total 
  weight = 1 + 1 + 1  = 3 which is <= W.
 

Example 2:

Input: N = 4, W = 8
val[] = {1, 4, 5, 7}
wt[] = {1, 3, 4, 5}
Output: 11
Explanation: The optimal choice is to 
pick the 2nd and 4th element.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function knapSack() which takes the values N, W 
and the arrays val[] and wt[] as input parameters and returns the maximum possible value.

 

Expected Time Complexity: O(N*W)
Expected Auxiliary Space: O(W)

 

Constraints:
1 ≤ N, W ≤ 1000
1 ≤ val[i], wt[i] ≤ 100
 * 
 * @author sukh
 *
 */
public class _27_UnboundedKnapSack {

  /**
   * Time >> O(2^n) --> exponential <br>
   * Space >> O(n) --> O(weight)
   * 
   * @param N
   * @param W
   * @param val
   * @param wt
   * @return
   */
  public int knapSack_recursion(int N, int W, int val[], int wt[]) {
    /**
     * Recursion: TLE
     */
    return knapsack_recursive(N - 1, W, val, wt);
  }

  private int knapsack_recursive(int index, int weight, int val[], int wt[]) {
    if (weight == 0) {
      return 0;
    }
    if (index == 0) {
      if (wt[index] <= weight) {
        return weight / wt[index] * val[index];
      }
      return 0;
    }
    int notPick = knapsack_recursive(index - 1, weight, val, wt);
    int pick = 0;
    if (wt[index] <= weight) {
      pick = val[index] + knapsack_recursive(index, weight - wt[index], val, wt);
    }
    return Math.max(pick, notPick);
  }

  /**
   * Time: O(N * W) <br>
   * Space: O(W) + O(N * W)
   * 
   * @param N
   * @param W
   * @param val
   * @param wt
   * @return
   */
  public int knapSack_memoization(int N, int W, int val[], int wt[]) {
    /**
     * Memoization
     */
    int[][] dp = new int[N][W + 1];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return knapsack_memoize(N - 1, W, val, wt, dp);
  }

  private int knapsack_memoize(int index, int weight, int val[], int wt[], int[][] dp) {
    if (weight == 0) {
      return 0;
    }
    if (index == 0) {
      if (wt[index] <= weight) {
        return weight / wt[index] * val[index];
      }
      return 0;
    }
    if (dp[index][weight] != -1) {
      return dp[index][weight];
    }
    int notPick = knapsack_memoize(index - 1, weight, val, wt, dp);
    int pick = 0;
    if (wt[index] <= weight) {
      pick = val[index] + knapsack_memoize(index, weight - wt[index], val, wt, dp);
    }
    return dp[index][weight] = Math.max(pick, notPick);
  }

  /**
   * Time: O(N * W) <br>
   * Space: O(N * W)
   * 
   * @param N
   * @param W
   * @param val
   * @param wt
   * @return
   */
  public int knapSack_tabulation(int N, int W, int val[], int wt[]) {
    /**
     * Tabulation
     */
    int[][] dp = new int[N][W + 1];
    for (int i = wt[0]; i <= W; i++) {
      dp[0][i] = i / wt[0] * val[0];
    }
    for (int index = 1, notPick = 0, pick = 0; index < N; index++) {
      for (int weight = 1; weight <= W; weight++) {
        notPick = dp[index - 1][weight];
        pick = 0;
        if (wt[index] <= weight) {
          pick = val[index] + dp[index][weight - wt[index]];
        }
        dp[index][weight] = Math.max(pick, notPick);
      }
    }
    return dp[N - 1][W];
  }

  /**
   * Time: O(N * W) <br>
   * Space: O(2 * W)
   * 
   * @param N
   * @param W
   * @param val
   * @param wt
   * @return
   */
  public int knapSack_spaceOptimization(int N, int W, int val[], int wt[]) {
    /**
     * Space Optimization
     */
    int[] dp = new int[W + 1];
    int[] curr = new int[W + 1];
    for (int i = wt[0]; i <= W; i++) {
      dp[i] = i / wt[0] * val[0];
    }
    for (int index = 1, notPick = 0, pick = 0; index < N; index++) {
      for (int weight = 1; weight <= W; weight++) {
        notPick = dp[weight];
        pick = 0;
        if (wt[index] <= weight) {
          pick = val[index] + curr[weight - wt[index]];
        }
        curr[weight] = Math.max(pick, notPick);
      }
      dp = curr;
    }
    return dp[W];
  }

  /**
   * Time: O(N * W) <br>
   * Space: O(W)
   * 
   * @param N
   * @param W
   * @param val
   * @param wt
   * @return
   */
  public int knapSack_optimal(int N, int W, int val[], int wt[]) {
    /**
     * One 1D DP array
     */
    int[] dp = new int[W + 1];
    for (int i = wt[0]; i <= W; i++) {
      dp[i] = i / wt[0] * val[0];
    }
    for (int index = 1, notPick = 0, pick = 0; index < N; index++) {
      for (int weight = 1; weight <= W; weight++) {
        notPick = dp[weight];
        pick = 0;
        if (wt[index] <= weight) {
          pick = val[index] + dp[weight - wt[index]];
        }
        dp[weight] = Math.max(pick, notPick);
      }
    }
    return dp[W];
  }

}
