package com.code.algos.striver.dp;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
 * 
 * @author sukh
 *
 */
public class _39_BestTimeBuyAndSellStock {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
    /**
     * To maximize the profit on i-th day
     * 
     * you have to find the minimum CP from prices [0-i)
     */
    int cp = prices[0];
    int profit = 0;
    for (int sp = 1; sp < prices.length; sp++) {
      profit = Math.max(profit, prices[sp] - cp);
      cp = Math.min(cp, prices[sp]);
    }
    return profit;
  }

}
