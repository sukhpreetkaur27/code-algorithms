package com.code.algos.striver.dp;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Example 2:

Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6
 

Constraints:

1 <= prices.length <= 5 * 104
1 <= prices[i] < 5 * 104
0 <= fee < 5 * 104
 * 
 * @author sukh
 *
 */
public class _44_BuySellStock_Fee {

  /**
   * NOTE: This is an extension to com.code.algos.striver.dp._40_BuySellStock_II
   */

  /**
   * Time: O(2n) <br>
   * Space: O(2)
   * 
   * @param prices
   * @return
   */
  public int maxProfit_optimal(int[] prices, int fee) {
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
          pick = -fee + prices[index] + dp[1];
          notPick = 0 + dp[0];
        }
        dp[buy] = Math.max(pick, notPick);
      }
    }
    return dp[1];
  }

}
