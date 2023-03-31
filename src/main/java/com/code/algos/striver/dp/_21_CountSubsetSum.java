package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given an array arr[] of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

Note: Answer can be very large, so, output answer modulo 109+7

Example 1:

Input: N = 6, arr[] = {2, 3, 5, 6, 8, 10}
       sum = 10
Output: 3
Explanation: {2, 3, 5}, {2, 8}, {10}
Example 2:
Input: N = 5, arr[] = {1, 2, 3, 4, 5}
       sum = 10
Output: 3
Explanation: {1, 2, 3, 4}, {1, 4, 5}, 
             {2, 3, 5}

Your Task:  
You don't need to read input or print anything. Complete the function perfectSum() which takes N, array arr[] and sum as input parameters and returns an integer value

Expected Time Complexity: O(N*sum)
Expected Auxiliary Space: O(N*sum)

Constraints:
1 ≤ N*sum ≤ 106
0<=arr[I]<=106
 * 
 * @author sukh
 *
 */
public class _21_CountSubsetSum {
  
  /**
   * NOTE:
   * 
   * Constraints:
   * 
   * 0<=arr[i]<=106
   */

  private static int MOD = (int) 1e9 + 7;
  
  /**
   * Time: O(2^n) <br>
   * Space: O(n)
   * 
   * @param arr
   * @param n
   * @param sum
   * @return
   */
  public int perfectSum_recursion(int arr[], int n, int sum) {
    /**
     * Recursion: TLE
     */
    return sum_recursive(arr, n - 1, sum);
  }

  private int sum_recursive(int[] arr, int index, int target) {
    /**
     * Commenting the code due to arr[index] = 0
     */
//    if (target == 0) {
//      return 1;
//    }
    /**
     * Base Case: last index reached
     * 
     * index = 0
     */
    if (index == 0) {
      /**
       * if sum = 0 and arr[0] = 0
       * 
       * for both pick and notPick cases --> the sum remains unaltered
       * 
       * hence, count possibilities = 2
       */
      if (target == 0 && arr[index] == target) {
        return 2;
      }
      /**
       * if sum has reached 0 (OR) arr[0] == sum
       * 
       * return 1
       */
      if (target == 0 || arr[index] == target) {
        return 1;
      }
      /**
       * for all other cases return 0
       */
      return 0;
    }
    int count = sum_recursive(arr, index - 1, target) % MOD;
    if (target >= arr[index]) {
      count += sum_recursive(arr, index - 1, target - arr[index]) % MOD;
    }
    return count % MOD;
  }

  /**
   * Time: O(n * target) <br>
   * Space: O(n) + O(n * target) <br>
   * 
   * @param arr
   * @param n
   * @param sum
   * @return
   */
  public int perfectSum_memoization(int arr[], int n, int sum) {
    /**
     * Memoization
     */
    int[][] dp = new int[n][sum + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }
    return sum_memoize(arr, n - 1, sum, dp);
  }

  private int sum_memoize(int[] arr, int index, int target, int[][] dp) {
    /**
     * Commenting the code due to arr[index] = 0
     */
//    if (target == 0) {
//      return 1;
//    }
    /**
     * Base Case: last index reached
     * 
     * index = 0
     */
    if (index == 0) {
      /**
       * if sum = 0 and arr[0] = 0
       * 
       * for both pick and notPick cases --> the sum remains unaltered
       * 
       * hence, count possibilities = 2
       */
      if (target == 0 && arr[index] == target) {
        return 2;
      }
      /**
       * if sum has reached 0 (OR) arr[0] == sum
       * 
       * return 1
       */
      if (target == 0 || arr[index] == target) {
        return 1;
      }
      /**
       * for all other cases return 0
       */
      return 0;
    }
    if (dp[index][target] != -1) {
      return dp[index][target];
    }
    int count = sum_memoize(arr, index - 1, target, dp) % MOD;
    if (target >= arr[index]) {
      count += sum_memoize(arr, index - 1, target - arr[index], dp) % MOD;
    }
    return dp[index][target] = count % MOD;
  }

  /**
   * Time: O(n * target) <br>
   * Space: O(n * target) <br>
   * 
   * @param arr
   * @param n
   * @param sum
   * @return
   */
  public int perfectSum_tabulation(int arr[], int n, int sum) {
    /**
     * Tabulation
     */
    int[][] dp = new int[n][sum + 1];
    /**
     * Commenting the code due to arr[index] = 0
     * 
     * if (target == 0) {
          return 1;
       }
     */
//    for (int i = 0; i < n; i++) {
//      dp[i][0] = 1;
//    }
    /**
     * if (index == 0) {
     *  if (target == 0 && arr[index] == target) {
        return 2;
      } }
     */
    if (arr[0] == 0) {
      dp[0][0] = 2;
    } else {
      /**
       * target == 0
       */
      dp[0][0] = 1;
    } 
    /**
     * case: arr[0] == 0
     * 
     * has already been handled
     */
    if (arr[0] != 0 && arr[0] <= sum) {
      dp[0][arr[0]] = 1;
    }
    for (int i = 1, count = 0; i < n; i++) {
      /**
       * sum = 0 is handled only for index = 0
       */
      for (int j = 0; j <= sum; j++) {
        count = dp[i - 1][j] % MOD;
        if (j >= arr[i]) {
          count += dp[i - 1][j - arr[i]] % MOD;
        }
        dp[i][j] = count % MOD;
      }
    }
    return dp[n - 1][sum] % MOD;
  }

  /**
   * Time: O(n * target) <br>
   * Space: O(target) <br>
   * 
   * @param arr
   * @param n
   * @param sum
   * @return
   */
  public int perfectSum_optimal(int arr[], int n, int sum) {
    /**
     * Space Optimization
     */
    int[] dp = new int[sum + 1];
    if (arr[0] == 0) {
      dp[0] = 2;
    } else {
      dp[0] = 1;
    } 
    /**
     * case: arr[0] == 0
     * 
     * has already been handled
     */
    if (arr[0] != 0 && arr[0] <= sum) {
      dp[arr[0]] = 1;
    }
    int[] curr = new int[sum + 1];
    curr[0] = 1;
    for (int i = 1, count = 0; i < n; i++) {
      /**
       * sum = 0 is handled only for index = 0
       */
      for (int j = 0; j <= sum; j++) {
        count = dp[j] % MOD;
        if (j >= arr[i]) {
          count += dp[j - arr[i]] % MOD;
        }
        curr[j] = count % MOD;
      }
      /**
       * sum = 0 is handled only for index = 0
       */
      for (int k = 0; k <= sum; k++) {
        dp[k] = curr[k] % MOD;
      }
    }
    return dp[sum] % MOD;
  }

}
