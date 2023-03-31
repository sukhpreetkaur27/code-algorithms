package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.

The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1) where the ith matrix has the dimensions (arr[i-1] x arr[i]).

Example 1:

Input: N = 5
arr = {40, 20, 30, 10, 30}
Output: 26000
Explaination: There are 4 matrices of dimension 
40x20, 20x30, 30x10, 10x30. Say the matrices are 
named as A, B, C, D. Out of all possible combinations,
the most efficient way is (A*(B*C))*D. 
The number of operations are -
20*30*10 + 40*20*10 + 40*10*30 = 26000.

Example 2:

Input: N = 4
arr = {10, 30, 5, 60}
Output: 4500
Explaination: The matrices have dimensions 
10*30, 30*5, 5*60. Say the matrices are A, B 
and C. Out of all possible combinations,the
most efficient way is (A*B)*C. The 
number of multiplications are -
10*30*5 + 10*5*60 = 4500.

Your Task:
You do not need to take input or print anything. Your task is to complete the function matrixMultiplication() which takes the value N and the array arr[] as input parameters 
and returns the minimum number of multiplication operations needed to be performed.


Expected Time Complexity: O(N3)
Expected Auxiliary Space: O(N2)


Constraints: 
2 ≤ N ≤ 100
1 ≤ arr[i] ≤ 500
 * 
 * @author sukh
 *
 */
public class _51_MCM {

  /**
   * Partition DP
   */

  /**
   * Time: exponential
   * 
   * @param N
   * @param arr
   * @return
   */
  public int matrixMultiplication_recursion(int N, int arr[]) {
    /**
     * Recursion: TLE
     */
    int n = arr.length;
    return mcm_recursive(arr, 1, n - 1);
  }

  private int mcm_recursive(int[] arr, int start, int end) {
    /**
     * Base Case
     */
    if (start == end) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    for (int k = start, steps = 0; k < end; k++) {
      /**
       * counting the steps and partitioning into 2 halves
       * 
       * steps = arr[i-1] * arr[k] * arr[j] + f(i, k) + f(k+1, j)
       */
      steps = arr[start - 1] * arr[k] * arr[end] + mcm_recursive(arr, start, k)
          + mcm_recursive(arr, k + 1, end);
      min = Math.min(min, steps);
    }
    return min;
  }

  /**
   * Time: O(n * n * n) <br>
   * Space: O(n * n) + O(n) <br>
   * 
   * @param N
   * @param arr
   * @return
   */
  public int matrixMultiplication_memoization(int N, int arr[]) {
    /**
     * Memoization
     */
    int n = arr.length;
    int[][] dp = new int[n][n];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return mcm_memoize(arr, 1, n - 1, dp);
  }

  private int mcm_memoize(int[] arr, int start, int end, int[][] dp) {
    if (start == end) {
      return 0;
    }
    if (dp[start][end] != -1) {
      return dp[start][end];
    }
    int min = Integer.MAX_VALUE;
    for (int k = start, steps = 0; k < end; k++) {
      steps = arr[start - 1] * arr[k] * arr[end] + mcm_memoize(arr, start, k, dp)
          + mcm_memoize(arr, k + 1, end, dp);
      min = Math.min(min, steps);
    }
    return dp[start][end] = min;
  }

  /**
   * Time: O(n * n * n) <br>
   * Space: O(n * n) <br>
   * 
   * @param N
   * @param arr
   * @return
   */
  int matrixMultiplication_tabulation(int N, int arr[]) {
    /**
     * Tabulation
     */
    int n = arr.length;
    int[][] dp = new int[n][n];
    for (int start = n - 1, min = 0; start > 0; start--) {
      for (int end = start + 1; end < n; end++) {
        min = Integer.MAX_VALUE;
        for (int k = start, steps = 0; k < end; k++) {
          steps = arr[start - 1] * arr[k] * arr[end] + dp[start][k] + dp[k + 1][end];
          min = Math.min(min, steps);
        }
        dp[start][end] = min;
      }
    }
    return dp[1][n - 1];
  }

}
