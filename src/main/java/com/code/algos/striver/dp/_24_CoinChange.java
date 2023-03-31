package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 * 
 * @author sukh
 *
 */
public class _24_CoinChange {

  /**
   * Time >> O(2^n) --> exponential <br>
   * Space >> O(n) --> O(target)
   * 
   * @param coins
   * @param amount
   * @return
   */
  public int coinChange_recursion(int[] coins, int amount) {
    /**
     * Recursion: TLE
     */
    int n = coins.length;
    int count = coinChange_recursive(coins, n - 1, amount);
    return count == Integer.MAX_VALUE ? -1 : count;
  }

  private int coinChange_recursive(int[] coins, int index, int amount) {
    /**
     * Edge Case
     */
    if (amount == 0) {
      return 0;
    }
    /**
     * Base Case
     */
    if (index == 0) {
      /**
       * if only single coin, just check its divisibility
       */
      if (amount % coins[index] == 0) {
        return amount / coins[index];
      }
      /**
       * Invalid case
       * 
       * as we are finding minimum count --> return maximum value
       */
      return Integer.MAX_VALUE;
    }
    int notPick = 0 + coinChange_recursive(coins, index - 1, amount);
    int pick = Integer.MAX_VALUE;
    if (coins[index] <= amount) {
      /**
       * as we have infinite supply of coins, we pick the coin and remain at the same
       * index
       */
      pick = coinChange_recursive(coins, index, amount - coins[index]);
      if (pick != Integer.MAX_VALUE) {
        pick++;
      }
    }
    return Math.min(pick, notPick);
  }

  /**
   * Time: O(index * amount) <br>
   * Space: O(index * amount) + O(amount) <br>
   * 
   * @param coins
   * @param amount
   * @return
   */
  public int coinChange_memoization(int[] coins, int amount) {
    /**
     * Memoization
     */
    int n = coins.length;
    int[][] dp = new int[n][amount + 1];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    int count = coinChange_memoize(coins, n - 1, amount, dp);
    return count == Integer.MAX_VALUE ? -1 : count;
  }

  private int coinChange_memoize(int[] coins, int index, int amount, int[][] dp) {
    if (amount == 0) {
      return 0;
    }
    if (index == 0) {
      if (amount % coins[index] == 0) {
        return amount / coins[index];
      }
      return Integer.MAX_VALUE;
    }
    if (dp[index][amount] != -1) {
      return dp[index][amount];
    }
    int notPick = 0 + coinChange_memoize(coins, index - 1, amount, dp);
    int pick = Integer.MAX_VALUE;
    if (coins[index] <= amount) {
      pick = coinChange_memoize(coins, index, amount - coins[index], dp);
      if (pick != Integer.MAX_VALUE) {
        pick++;
      }
    }
    return dp[index][amount] = Math.min(pick, notPick);
  }

  /**
   * Time: O(n * amount) <br>
   * Space: O(n * amount)
   * 
   * @param coins
   * @param amount
   * @return
   */
  public int coinChange_tabulation(int[] coins, int amount) {
    /**
     * Tabulation
     */
    int n = coins.length;
    int[][] dp = new int[n][amount + 1];
    /**
     * Base Case
     */
    for (int i = 0; i <= amount; i++) {
      if (i % coins[0] == 0) {
        dp[0][i] = i / coins[0];
      } else {
        dp[0][i] = Integer.MAX_VALUE;
      }
    }
    for (int i = 1, notPick = 0, pick = 0; i < n; i++) {
      for (int j = 0; j <= amount; j++) {
        notPick = 0 + dp[i - 1][j];
        pick = Integer.MAX_VALUE;
        if (coins[i] <= j) {
          pick = dp[i][j - coins[i]];
          if (pick != Integer.MAX_VALUE) {
            pick++;
          }
        }
        dp[i][j] = Math.min(pick, notPick);
      }
    }
    return dp[n - 1][amount] == Integer.MAX_VALUE ? -1 : dp[n - 1][amount];
  }

  /**
   * Time: O(n * amount) <br>
   * Space: O(amount)
   * 
   * @param coins
   * @param amount
   * @return
   */
  public int coinChange_optimal(int[] coins, int amount) {
    /**
     * Space Optimization
     */
    int n = coins.length;
    int[] dp = new int[amount + 1];
    int[] curr = new int[amount + 1];
    for (int i = 0; i <= amount; i++) {
      if (i % coins[0] == 0) {
        dp[i] = i / coins[0];
      } else {
        dp[i] = Integer.MAX_VALUE;
      }
    }
    for (int i = 1, notPick = 0, pick = 0; i < n; i++) {
      for (int j = 0; j <= amount; j++) {
        notPick = 0 + dp[j];
        pick = Integer.MAX_VALUE;
        if (coins[i] <= j) {
          pick = curr[j - coins[i]];
          if (pick != Integer.MAX_VALUE) {
            pick++;
          }
        }
        curr[j] = Math.min(pick, notPick);
      }
      dp = curr;
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }

}
