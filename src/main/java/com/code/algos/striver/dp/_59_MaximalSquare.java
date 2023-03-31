package com.code.algos.striver.dp;

/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
Example 2:


Input: matrix = [["0","1"],["1","0"]]
Output: 1
Example 3:

Input: matrix = [["0"]]
Output: 0
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.

 * @author sukh
 *
 */
public class _59_MaximalSquare {

  /**
   * NOTE: This problem is similar to
   * com.code.algos.striver.dp._58_CountSquareSubmatrices
   */

  /**
   * Time: O(n + m + m * n) <br>
   * Space: O(m * n)
   * 
   * @param matrix
   * @return
   */
  public int maximalSquare_I(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    int max = 0;
    for (int c = 0; c < n; c++) {
      if (matrix[0][c] == '1') {
        dp[0][c] = 1;
        max = 1;
      }
    }
    for (int r = 1; r < m; r++) {
      if (matrix[r][0] == '1') {
        dp[r][0] = 1;
        max = 1;
      }
    }
    for (int r = 1; r < m; r++) {
      for (int c = 1; c < n; c++) {
        if (matrix[r][c] == '1') {
          dp[r][c] = 1 + Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1]));
          max = Math.max(max, dp[r][c]);
        }
      }
    }
    return max * max;
  }

  /**
   * Time: O(m * n) <br>
   * Space: O(m * n)
   * 
   * @param matrix
   * @return
   */
  public int maximalSquare_II(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m + 1][n + 1];
    int max = 0;
    for (int r = 1; r <= m; r++) {
      for (int c = 1; c <= n; c++) {
        if (matrix[r - 1][c - 1] == '1') {
          dp[r][c] = 1 + Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1]));
          max = Math.max(max, dp[r][c]);
        }
      }
    }
    return max * max;
  }

}
