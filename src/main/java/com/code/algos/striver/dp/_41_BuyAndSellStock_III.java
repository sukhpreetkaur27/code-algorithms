package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 105
 * 
 * @author sukh
 *
 */
public class _41_BuyAndSellStock_III {

  /**
   * Time: O(2^n) == exponential<br>
   * Space: O(n)
   * 
   * @param prices
   * @return
   */
  public int maxProfit_recursion(int[] prices) {
    /**
     * Recursion: TLE
     */
    return max_recursive(prices, 0, 1, 0);
  }

  private int max_recursive(int[] prices, int index, int buy, int txn) {
    if (txn == 2) {
      return 0;
    }
    if (index == prices.length) {
      return 0;
    }
    int pick = 0;
    int notPick = 0;
    if (buy == 1) {
      pick = -prices[index] + max_recursive(prices, index + 1, 0, txn);
      notPick = 0 + max_recursive(prices, index + 1, 1, txn);
    } else {
      pick = prices[index] + max_recursive(prices, index + 1, 1, txn + 1);
      notPick = 0 + max_recursive(prices, index + 1, 0, txn);
    }
    return Math.max(pick, notPick);
  }

  /**
   * Time: O(n * 2 * 3) <br>
   * Space: O(n * 2 * 3) + O(n)
   * 
   * @param prices
   * @return
   */
  public int maxProfit_memoization(int[] prices) {
    /**
     * Memoization
     */
    int n = prices.length;
    int[][][] dp = new int[n][2][2];
    for (int[][] i : dp) {
      for (int[] j : i) {
        Arrays.fill(j, -1);
      }
    }
    return max_memoize(prices, 0, 1, 0, dp);
  }

  private int max_memoize(int[] prices, int index, int buy, int txn, int[][][] dp) {
    if (txn == 2) {
      return 0;
    }

    if (index == prices.length) {
      return 0;
    }
    if (dp[index][buy][txn] != -1) {
      return dp[index][buy][txn];
    }
    int pick = 0;
    int notPick = 0;
    if (buy == 1) {
      pick = -prices[index] + max_memoize(prices, index + 1, 0, txn, dp);
      notPick = 0 + max_memoize(prices, index + 1, 1, txn, dp);
    } else {
      pick = prices[index] + max_memoize(prices, index + 1, 1, txn + 1, dp);
      notPick = 0 + max_memoize(prices, index + 1, 0, txn, dp);
    }
    return dp[index][buy][txn] = Math.max(pick, notPick);
  }

  /**
   * Time: O(n * 2 * 3) <br>
   * Space: O(n * 2 * 3)
   * 
   * @param prices
   * @return
   */
  public int maxProfit_tabulation(int[] prices) {
    /**
     * Tabulation
     */
    int n = prices.length;
    int[][][] dp = new int[n + 1][2][3];
    for (int index = n - 1, pick = 0, notPick = 0; index >= 0; index--) {
      for (int buy = 1; buy >= 0; buy--) {
        for (int txn = 1; txn >= 0; txn--) {
          if (buy == 1) {
            pick = -prices[index] + dp[index + 1][0][txn];
            notPick = 0 + dp[index + 1][1][txn];
          } else {
            pick = prices[index] + dp[index + 1][1][txn + 1];
            notPick = 0 + dp[index + 1][0][txn];
          }
          dp[index][buy][txn] = Math.max(pick, notPick);
        }
      }
    }
    /**
     * Tabulation == Bottom Up == Opposite of Recursion
     * 
     * for recursion: we started from index = 0, buy = 1, txn = 0
     * 
     * do opposite for tabulation
     * 
     * hence, the answer dp[0][1][0]
     * 
     * i.e., go and buy first with 0 transactions (logically you cannot sell first
     * if you haven't bought it)
     */
    return dp[0][1][0];
  }

  /**
   * Time: O(n * 2 * 3) <br>
   * Space: O(2 * 2 * 3)
   * 
   * @param prices
   * @return
   */
  public int maxProfit_spaceOptimization(int[] prices) {
    /**
     * Space Optimization
     */
    int n = prices.length;
    int[][] dp = new int[2][3];
    int[][] curr = new int[2][3];
    for (int index = n - 1, pick = 0, notPick = 0; index >= 0; index--) {
      for (int buy = 0; buy < 2; buy++) {
        for (int txn = 1; txn >= 0; txn--) {
          if (buy == 1) {
            pick = -prices[index] + dp[0][txn];
            notPick = 0 + dp[1][txn];
          } else {
            pick = prices[index] + dp[1][txn + 1];
            notPick = 0 + dp[0][txn];
          }
          curr[buy][txn] = Math.max(pick, notPick);
        }
      }
      for (int buy = 0; buy < 2; buy++) {
        for (int txn = 1; txn >= 0; txn--) {
          dp[buy][txn] = curr[buy][txn];
        }
      }
    }
    return dp[1][0];
  }
  
  /**
   * Time: O(n * 2 * 3) <br>
   * Space: O(2 * 3)
   * 
   * @param prices
   * @return
   */
  public int maxProfit_optimal(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[2][3];
    for (int index = n - 1, pick = 0, notPick = 0; index >= 0; index--) {
      for (int buy = 0; buy < 2; buy++) {
        for (int txn = 1; txn >= 0; txn--) {
          if (buy == 1) {
            pick = -prices[index] + dp[0][txn];
            notPick = 0 + dp[1][txn];
          } else {
            pick = prices[index] + dp[1][txn + 1];
            notPick = 0 + dp[0][txn];
          }
          dp[buy][txn] = Math.max(pick, notPick);
        }
      }
    }
    return dp[1][0];
  }

}
