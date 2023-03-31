package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 

Constraints:

1 <= m, n <= 100
 * 
 * @author sukh
 *
 */
public class _11_UniquePaths {

  /**
   * Time: O(2^(m*n)) <br>
   * Space: O(path length) = O(m + n) <br>
   * Dry run it from [m-1, n-1] to [0, 0]
   * 
   * @param m
   * @param n
   * @return
   */
  public int uniquePaths_recursion(int m, int n) {
    /**
     * Recursion: TLE
     */
    /**
     * Top-Down --> from target to source
     */
    return uniquePaths_recursive(m - 1, n - 1);
  }

  private int uniquePaths_recursive(int r, int c) {
    if (r == 0 && c == 0) {
      return 1;
    }
    if (r < 0 || c < 0) {
      return 0;
    }
    /**
     * Top-Down --> can move up or left
     */
    int up = uniquePaths_recursive(r - 1, c);
    int left = uniquePaths_recursive(r, c - 1);
    return left + up;
  }

  /**
   * Time: O(m * n) <br>
   * having calls for all the cells at max <br>
   * Space: O(path length + (m*n)) = O(m + n) <br>
   * Dry run it from [m-1, n-1] to [0, 0]
   * 
   * @param m
   * @param n
   * @return
   */
  public int uniquePaths_memoization(int m, int n) {
    /**
     * Memoization
     */
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], -1);
    }
    return uniquePaths_memoize(m - 1, n - 1, dp);
  }

  private int uniquePaths_memoize(int r, int c, int[][] dp) {
    if (r == 0 && c == 0) {
      return 1;
    }
    if (r < 0 || c < 0) {
      return 0;
    }
    if (dp[r][c] != -1) {
      return dp[r][c];
    }
    int up = uniquePaths_memoize(r - 1, c, dp);
    int left = uniquePaths_memoize(r, c - 1, dp);
    return dp[r][c] = left + up;
  }

  /**
   * Time: O(m * n) <br>
   * Space: O(m * n)
   * 
   * @param m
   * @param n
   * @return
   */
  public int uniquePaths_tabulation(int m, int n) {
    /**
     * Tabulation
     */
    int[][] dp = new int[m][n];
    dp[0][0] = 1;
    /**
     * traverse each column per row
     */
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (r - 1 >= 0) {
          dp[r][c] += dp[r - 1][c];
        }
        if (c - 1 >= 0) {
          dp[r][c] += dp[r][c - 1];
        }
      }
    }
    return dp[m - 1][n - 1];
  }

  /**
   * Time: O(m * n) <br>
   * Space: O(1)
   * 
   * @param m
   * @param n
   * @return
   */
  public int uniquePaths_optimal(int m, int n) {
    /**
     * Space Optimization
     */
    int[] prevRow = new int[n];
    prevRow[0] = 1;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        // int curr=0;
        // if(r-1 >= 0) {
        // curr=prevRow[c] ;
        // }
        if (c - 1 >= 0) {
          prevRow[c] += prevRow[c - 1];
        }
        // if(curr>0){
        // prevRow[c]=curr;
        // }
      }
    }
    return prevRow[n - 1];
  }

}
