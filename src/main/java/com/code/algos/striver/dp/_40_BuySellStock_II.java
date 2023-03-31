package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. 
However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 

Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
 * 
 * @author sukh
 *
 */
public class _40_BuySellStock_II {

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
    if (index == prices.length) {
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
      pick = prices[index] + max_recursive(prices, index + 1, true);
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
    if (index == prices.length) {
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
      pick = prices[index] + max_memoize(prices, index + 1, 1, dp);
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
    int[][] dp = new int[n + 1][2];
    for (int index = n - 1, pick = 0, notPick = 0; index >= 0; index--) {
      for (int buy = 0; buy < 2; buy++) {
        if (buy == 1) {
          pick = -prices[index] + dp[index + 1][0];
          notPick = 0 + dp[index + 1][1];
        } else {
          pick = prices[index] + dp[index + 1][1];
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
   * Space: O(2 * 2)
   * 
   * @param prices
   * @return
   */
  public int maxProfit_spaceOptimization(int[] prices) {
    /**
     * Space Optimization
     */
    int n = prices.length;
    int[] dp = new int[2];
    int[] curr = new int[2];
    for (int index = n - 1, pick = 0, notPick = 0; index >= 0; index--) {
      for (int buy = 0; buy < 2; buy++) {
        if (buy == 1) {
          pick = -prices[index] + dp[0];
          notPick = 0 + dp[1];
        } else {
          pick = prices[index] + dp[1];
          notPick = 0 + dp[0];
        }
        curr[buy] = Math.max(pick, notPick);
      }
      for (int buy = 0; buy < 2; buy++) {
        dp[buy] = curr[buy];
      }
    }
    return dp[1];
  }

  /**
   * Time: O(2n) <br>
   * Space: O(2)
   * 
   * @param prices
   * @return
   */
  public int maxProfit_optimal(int[] prices) {
    /**
     * One 1D DP Array
     */
    int n = prices.length;
    int[] dp = new int[2];
    for (int index = n - 1, pick = 0, notPick = 0; index >= 0; index--) {
      for (int buy = 0; buy < 2; buy++) {
        if (buy == 1) {
          pick = -prices[index] + dp[0];
          notPick = 0 + dp[1];
        } else {
          pick = prices[index] + dp[1];
          notPick = 0 + dp[0];
        }
        dp[buy] = Math.max(pick, notPick);
      }
    }
    return dp[1];
  }

}
