package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given a rod of length N inches and an array of prices, price[]. pricei denotes the value of a piece of length i. Determine the maximum value obtainable 
 * by cutting up the rod and selling the pieces.

 

Example 1:

Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by
cutting in two pieces of lengths 2 and 
6, i.e., 5+17=22.
Example 2:

Input:
N=8
Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
Output: 24
Explanation: 
The maximum obtainable value is 
24 by cutting the rod into 8 pieces 
of length 1, i.e, 8*3=24. 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function cutRod() which takes the array A[] and its size N as inputs 
and returns the maximum price obtainable.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 1000
1 ≤ Ai ≤ 105
 * 
 * @author sukh
 *
 */
public class _28_RodCutting {

  /**
   * Time >> O(2^n) --> exponential <br>
   * Space >> O(n) --> O(length)
   * 
   * @param price
   * @param n
   * @return
   */
  public int cutRod_recursion(int price[], int n) {
    /**
     * Recursion: TLE
     */
    return cutRod_recursive(price, n - 1, n);
  }

  private int cutRod_recursive(int[] price, int index, int length) {
    if (length == 0) {
      return 0;
    }
    if (index == 0) {
//      if (index + 1 <= length) {
//        return price[index] + cutRod_recursive(price, index, length - index - 1);
      /**
       * since index = 0 --> current rod length = 1
       * 
       * required length = length
       * 
       * therefore, # of pieces required to achieve length = 1 * length
       * 
       * hence, max price = price[index] * length
       */
      return price[index] * length;
//      }
//      return 0;
    }
    int notPick = cutRod_recursive(price, index - 1, length);
    int pick = 0;
    if (index + 1 <= length) {
      pick = price[index] + cutRod_recursive(price, index, length - index - 1);
    }
    return Math.max(notPick, pick);
  }

  /**
   * Time: O(n^2)<br>
   * Space: O(n) + O(n^2)
   * 
   * @param price
   * @param n
   * @return
   */
  public int cutRod_memoization(int price[], int n) {
    /**
     * Memoization
     */
    int[][] dp = new int[n][n + 1];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return cutRodmemoize(price, n - 1, n, dp);
  }

  private int cutRodmemoize(int[] price, int index, int length, int[][] dp) {
    if (length == 0) {
      return 0;
    }
    if (index == 0) {
      // if(index+1<=length){
      // return price[index] + cutRod(price, index, length-index-1);
      return price[index] * length;
      // }
      // return 0;
    }
    if (dp[index][length] != -1) {
      return dp[index][length];
    }
    int notPick = cutRodmemoize(price, index - 1, length, dp);
    int pick = 0;
    if (index + 1 <= length) {
      pick = price[index] + cutRodmemoize(price, index, length - index - 1, dp);
    }
    return dp[index][length] = Math.max(notPick, pick);
  }

  /**
   * Time: O(n^2)<br>
   * Space: O(n^2)
   * 
   * @param price
   * @param n
   * @return
   */
  public int cutRod_tabulation(int price[], int n) {
    /**
     * Tabulation
     */
    int[][] dp = new int[n][n + 1];
    for (int i = 1; i <= n; i++) {
      dp[0][i] = price[0] * i;
    }
    for (int index = 1, notPick = 0, pick = 0; index < n; index++) {
      for (int length = 1; length <= n; length++) {
        notPick = dp[index - 1][length];
        pick = 0;
        if (index + 1 <= length) {
          pick = price[index] + dp[index][length - index - 1];
        }
        dp[index][length] = Math.max(notPick, pick);
      }
    }
    return dp[n - 1][n];
  }

  /**
   * Time: O(n^2)<br>
   * Space: O(2n)
   * 
   * @param price
   * @param n
   * @return
   */
  public int cutRod_spaceOptimization(int price[], int n) {
    /**
     * Space Optimization
     */
    int[] dp = new int[n + 1];
    int[] curr = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i] = price[0] * i;
    }
    for (int index = 1, notPick = 0, pick = 0; index < n; index++) {
      for (int length = 1; length <= n; length++) {
        notPick = dp[length];
        pick = 0;
        if (index + 1 <= length) {
          pick = price[index] + curr[length - index - 1];
        }
        curr[length] = Math.max(notPick, pick);
      }
      dp = curr;
    }
    return dp[n];
  }

  /**
   * Time: O(n^2)<br>
   * Space: O(n)
   * 
   * @param price
   * @param n
   * @return
   */
  public int cutRod_optimal(int price[], int n) {
    /**
     * Space: 2 1D DP to 1 1D DP
     */
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i] = price[0] * i;
    }
    for (int index = 1, notPick = 0, pick = 0; index < n; index++) {
      for (int length = 1; length <= n; length++) {
        notPick = dp[length];
        pick = 0;
        if (index + 1 <= length) {
          pick = price[index] + dp[length - index - 1];
        }
        dp[length] = Math.max(notPick, pick);
      }
    }
    return dp[n];
  }

}
