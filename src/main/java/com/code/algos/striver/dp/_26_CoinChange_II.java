package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

 

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
 

Constraints:

1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000
 * 
 * @author sukh
 *
 */
public class _26_CoinChange_II {

  /**
   * Time >> O(2^n) --> exponential <br>
   * Space >> O(n) --> O(target)
   * 
   * @param amount
   * @param coins
   * @return
   */
  public int change_recursion(int amount, int[] coins) {
    /**
     * Recursion: TLE
     */
    int n = coins.length;
    return coinChange_recursive(coins, n - 1, amount);
  }

  private int coinChange_recursive(int[] coins, int index, int amount) {
    /**
     * Edge Case
     */
    if (amount == 0) {
      return 1;
    }
    /**
     * Base Case
     */
    if (index == 0) {
      /**
       * if only single coin, just check its divisibility
       */
      if (amount % coins[index] == 0) {
        return 1;
      }
      /**
       * Invalid case
       * 
       * as we are finding minimum count --> return maximum value
       */
      return 0;
    }
    int notPick = coinChange_recursive(coins, index - 1, amount);
    int pick = 0;
    if (coins[index] <= amount) {
      /**
       * as we have infinite supply of coins, we pick the coin and remain at the same
       * index
       */
      pick = coinChange_recursive(coins, index, amount - coins[index]);
    }
    return pick + notPick;
  }

  /**
   * Time: O(index * amount) <br>
   * Space: O(index * amount) + O(amount) <br>
   * 
   * @param coins
   * @param amount
   * @return
   */
  public int change_memoization(int[] coins, int amount) {
    /**
     * Memoization
     */
    int n = coins.length;
    int[][] dp = new int[n][amount + 1];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return coinChange_memoize(coins, n - 1, amount, dp);
  }

  private int coinChange_memoize(int[] coins, int index, int amount, int[][] dp) {
    if (amount == 0) {
      return 1;
    }
    if (index == 0) {
      if (amount % coins[index] == 0) {
        return 1;
      }
      return 0;
    }
    if (dp[index][amount] != -1) {
      return dp[index][amount];
    }
    int notPick = coinChange_memoize(coins, index - 1, amount, dp);
    int pick = 0;
    if (coins[index] <= amount) {
      pick = coinChange_memoize(coins, index, amount - coins[index], dp);
    }
    return dp[index][amount] = pick + notPick;
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
     * 
     * amount = 0 --> return 1
     * 
     * if (amount % coins[index] == 0) { return 1;
     */
    for (int i = 0; i <= amount; i++) {
      if (i % coins[0] == 0) {
        dp[0][i] = 1;
      }
    }
    for (int i = 1, notPick = 0, pick = 0; i < n; i++) {
      for (int j = 0; j <= amount; j++) {
        notPick = dp[i - 1][j];
        pick = 0;
        if (coins[i] <= j) {
          pick = dp[i][j - coins[i]];
        }
        dp[i][j] = pick + notPick;
      }
    }
    return dp[n - 1][amount];
  }

  /**
   * Time: O(n * amount) <br>
   * Space: O(2amount)
   * 
   * @param coins
   * @param amount
   * @return
   */
  public int coinChange_spaceOptimization(int[] coins, int amount) {
    /**
     * Space Optimization
     */
    int n = coins.length;
    int[] dp = new int[amount + 1];
    int[] curr = new int[amount + 1];
    for (int i = 0; i <= amount; i++) {
      if (i % coins[0] == 0) {
        dp[i] = 1;
      }
    }
    for (int i = 1, notPick = 0, pick = 0; i < n; i++) {
      for (int j = 0; j <= amount; j++) {
        notPick = 0 + dp[j];
        pick = 0;
        if (coins[i] <= j) {
          pick = curr[j - coins[i]];
        }
        curr[j] = pick + notPick;
      }
      dp = curr;
    }
    return dp[amount];
  }

  /**
   * Time: O(n * amount) <br>
   * Space: O(amount)
   * 
   * @param coins
   * @param amount
   * @return
   */
  public int change(int amount, int[] coins) {
    /**
     * Space Optimization
     */
    int n = coins.length;
    int[] dp = new int[amount + 1];
    for (int i = 0; i <= amount; i++) {
      if (i % coins[0] == 0) {
        dp[i] = 1;
      }
    }
    for (int i = 1, notPick = 0, pick = 0; i < n; i++) {
      /**
       * 0....j....amount
       * 
       * j - coins[i] --> lie on the left side
       * 
       * so dp[j] is not impacted
       */
      for (int j = 0; j <= amount; j++) {
        notPick = 0 + dp[j];
        pick = 0;
        if (coins[i] <= j) {
          pick = dp[j - coins[i]];
        }
        dp[j] = pick + notPick;
      }
    }
    return dp[amount];
  }

}
