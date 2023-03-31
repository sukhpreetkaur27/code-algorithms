package com.code.algos.striver.dp;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

Constraints:

1 <= k <= 100
1 <= prices.length <= 1000
0 <= prices[i] <= 1000
 * 
 * @author sukh
 *
 */
public class _42_BuyAndSellStock_IV {

  /**
   * NOTE: This is an extension to
   * com.code.algos.striver.dp._41_BuyAndSellStock_III
   */

  /**
   * Time: O(n * 2 * k) <br>
   * Space: O(2 * k)
   * 
   * @param prices
   * @return
   */
  public int maxProfit_optimal(int k, int[] prices) {
    int n = prices.length;
    int[][] dp = new int[2][k + 1];
    for (int index = n - 1, pick = 0, notPick = 0; index >= 0; index--) {
      for (int buy = 0; buy < 2; buy++) {
        for (int txn = k - 1; txn >= 0; txn--) {
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
