package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) 
with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0
 

Constraints:

1 <= prices.length <= 5000
0 <= prices[i] <= 1000
 * 
 * @author sukh
 *
 */
public class _43_BuyAndSellStock_CoolDown {

  /**
   * NOTE: This is an extension to com.code.algos.striver.dp._40_BuySellStock_II
   */

  /**
   * Time: O(2^n) <br>
   * Space: O(n)
   * 
   * @param prices
   * @return
   */
  public int maxProfit_recursion(int[] prices) {

    /**
     * Recursion: TLE
     */
    return max_recursive(prices, 0, true);

  }

  private int max_recursive(int[] prices, int index, boolean buy) {
    /**
     * Base Case:
     * 
     * if previously bought, profit (pick) = negative --> return 0, as profit cannot
     * be negative
     * 
     * if previously sold, profit = sp - cp --> return 0
     */
    if (index >= prices.length) {
      return 0;
    }
    /**
     * IF Buy OR Sell, you have 2 options
     * 
     * 1. go for it
     * 
     * 2. don't go for it
     * 
     * --> if you go for buy, profit decreases by the buy amount
     * 
     * --> if you go for sell, profit increases by the sell amount
     */
    int pick = 0;
    int notPick = 0;
    if (buy) {
      pick = -prices[index] + max_recursive(prices, index + 1, false);
      notPick = 0 + max_recursive(prices, index + 1, true);
    } else {
      pick = prices[index] + max_recursive(prices, index + 2, true);
      notPick = 0 + max_recursive(prices, index + 1, false);
    }
    return Math.max(pick, notPick);
  }

  /**
   * Time: O(2n) <br>
   * Space: O(2n) + O(n)
   * 
   * @param prices
   * @return
   */
  public int maxProfit_memoization(int[] prices) {
    /**
     * Memoization
     */
    int n = prices.length;
    int[][] dp = new int[n][2];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return max_memoize(prices, 0, 1, dp);
  }

  private int max_memoize(int[] prices, int index, int buy, int[][] dp) {
    if (index >= prices.length) {
      return 0;
    }
    if (dp[index][buy] != -1) {
      return dp[index][buy];
    }
    int pick = 0;
    int notPick = 0;
    if (buy == 1) {
      pick = -prices[index] + max_memoize(prices, index + 1, 0, dp);
      notPick = 0 + max_memoize(prices, index + 1, 1, dp);
    } else {
      pick = prices[index] + max_memoize(prices, index + 2, 1, dp);
      notPick = 0 + max_memoize(prices, index + 1, 0, dp);
    }
    return dp[index][buy] = Math.max(pick, notPick);
  }

  /**
   * Time: O(2n) <br>
   * Space: O(2n)
   * 
   * @param prices
   * @return
   */
  public int maxProfit_tabulation(int[] prices) {
    /**
     * Tabulation
     */
    int n = prices.length;
    int[][] dp = new int[n + 2][2];
    for (int index = n - 1, pick = 0, notPick = 0; index >= 0; index--) {
      for (int buy = 0; buy < 2; buy++) {
        if (buy == 1) {
          pick = -prices[index] + dp[index + 1][0];
          notPick = 0 + dp[index + 1][1];
        } else {
          pick = prices[index] + dp[index + 2][1];
          notPick = 0 + dp[index + 1][0];
        }
        dp[index][buy] = Math.max(pick, notPick);
      }
    }
    /**
     * Tabulation == Bottom Up == Opposite of Recursion
     * 
     * for recursion: we started from index = 0, buy = 1
     * 
     * do opposite for tabulation
     * 
     * hence, the answer dp[0][1]
     * 
     * i.e., go and buy first (logically you cannot sell first if you haven't bought
     * it)
     */
    return dp[0][1];
  }

  /**
   * Time: O(2n) <br>
   * Space: O(2 * 2 * 2)
   * 
   * @param prices
   * @return
   */
  public int maxProfit_spaceOptimization(int[] prices) {
    /**
     * Space Optimization
     */
    int n = prices.length;
    int[] next = new int[2];
    int[] next2 = new int[2];
    int[] curr = new int[2];
    for (int index = n - 1, pick = 0, notPick = 0; index >= 0; index--) {
      for (int buy = 0; buy < 2; buy++) {
        if (buy == 1) {
          pick = -prices[index] + next[0];
          notPick = 0 + next[1];
        } else {
          pick = prices[index] + next2[1];
          notPick = 0 + next[0];
        }
        curr[buy] = Math.max(pick, notPick);
      }
      for (int buy = 0; buy < 2; buy++) {
        next2[buy] = next[buy];
        next[buy] = curr[buy];
      }
    }
    return next[1];
  }

}
