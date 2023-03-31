package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. 
Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100
 * 
 * @author sukh
 *
 */
public class _15_MinimumFallingPathSum {

  /**
   * Time: O(3^m) <br>
   * Space: O(n)
   * 
   * @param matrix
   * @return
   */
  public int minFallingPathSum_recursion(int[][] matrix) {
    /**
     * Recursion: TLE
     */
    /**
     * Top-Down --> from target to source
     */
    int m = matrix.length;
    int n = matrix[0].length;
    int min = Integer.MAX_VALUE;
    for (int c = n - 1; c >= 0; c--) {
      min = Math.min(min, minFallingPathSum_recursive(m - 1, c, matrix));
    }
    return min;
  }

  private int minFallingPathSum_recursive(int r, int c, int[][] matrix) {
    /**
     * Edge Case: Out of Bounds
     * 
     * We will not pick the sum for this path --> as we need to find the minimum
     * path sum --> return a MAX value
     */
    if (r < 0 || c < 0 || c >= matrix[0].length) {
      return Integer.MAX_VALUE;
    }
    /**
     * Base Case: Reached Target
     */
    if (r == 0) {
      return matrix[0][c];
    }
    /**
     * Top-Down --> can move up or left or right
     */
    int up = minFallingPathSum_recursive(r - 1, c, matrix);
    if (up != Integer.MAX_VALUE) {
      up += matrix[r][c];
    }
    int left = minFallingPathSum_recursive(r - 1, c - 1, matrix);
    if (left != Integer.MAX_VALUE) {
      left += matrix[r][c];
    }
    int right = minFallingPathSum_recursive(r - 1, c + 1, matrix);
    if (right != Integer.MAX_VALUE) {
      right += matrix[r][c];
    }
    return Math.min(right, Math.min(left, up));
  }

  /**
   * Time: O(m * n) <br>
   * Space: O(n + m * n)
   * 
   * @param matrix
   * @return
   */
  public int minFallingPathSum_memoization(int[][] matrix) {
    /**
     * Memoization
     */
    /**
     * Top-Down --> from target to source
     */
    int m = matrix.length;
    int n = matrix[0].length;
    int min = Integer.MAX_VALUE;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], -1);
    }
    for (int c = n - 1; c >= 0; c--) {
      min = Math.min(min, minFallingPathSum_memoize(m - 1, c, matrix, dp));
    }
    return min;
  }

  private int minFallingPathSum_memoize(int r, int c, int[][] matrix, int[][] dp) {
    /**
     * Edge Case: Out of Bounds
     * 
     * We will not pick the sum for this path --> as we need to find the minimum
     * path sum --> return a MAX value
     */
    if (r < 0 || c < 0 || c >= matrix[0].length) {
      return Integer.MAX_VALUE;
    }
    /**
     * Base Case: Reached Target
     */
    if (r == 0) {
      return dp[r][c] = matrix[0][c];
    }
    if (dp[r][c] != -1) {
      return dp[r][c];
    }
    /**
     * Top-Down --> can move up or left
     */
    int up = minFallingPathSum_memoize(r - 1, c, matrix, dp);
    if (up != Integer.MAX_VALUE) {
      up += matrix[r][c];
    }
    int left = minFallingPathSum_memoize(r - 1, c - 1, matrix, dp);
    if (left != Integer.MAX_VALUE) {
      left += matrix[r][c];
    }
    int right = minFallingPathSum_memoize(r - 1, c + 1, matrix, dp);
    if (right != Integer.MAX_VALUE) {
      right += matrix[r][c];
    }
    return dp[r][c] = Math.min(right, Math.min(left, up));
  }

  /**
   * Time: O(m * n + n) <br>
   * Space: O(m * n)
   * 
   * @param matrix
   * @return
   */
  public int minFallingPathSum_tabulation(int[][] matrix) {
    /**
     * Tabulation
     */
    /**
     * Bottom-Up --> from source to target
     */
    int m = matrix.length;
    int n = matrix[0].length;
    int min = Integer.MAX_VALUE;
    int[][] dp = new int[m][n];
    for (int c = 0; c < n; c++) {
      dp[0][c] = matrix[0][c];
    }
    int up, left, right;
    for (int r = 1; r < m; r++) {
      for (int c = 0; c < n; c++) {
        up = matrix[r][c] + dp[r - 1][c];
        if (c - 1 >= 0) {
          left = matrix[r][c] + dp[r - 1][c - 1];
        } else {
          left = Integer.MAX_VALUE;
        }
        if (c + 1 < n) {
          right = matrix[r][c] + dp[r - 1][c + 1];
        } else {
          right = Integer.MAX_VALUE;
        }
        dp[r][c] = Math.min(right, Math.min(left, up));
      }
    }
    /**
     * Minimum of all Paths
     */
    for (int c = 0; c < n; c++) {
      min = Math.min(min, dp[m - 1][c]);
    }
    return min;
  }

  /**
   * Time: O(m * n + n) <br>
   * Space: O(2n)
   * 
   * @param matrix
   * @return
   */
  public int minFallingPathSum(int[][] matrix) {
    /**
     * Space Optimization
     */
    int m = matrix.length;
    int n = matrix[0].length;
    int min = Integer.MAX_VALUE;
    int[] dp = new int[n];
    for (int c = 0; c < n; c++) {
      dp[c] = matrix[0][c];
    }
    int up, left, right;
    int[] curr = new int[n];
    for (int r = 1; r < m; r++) {
      for (int c = 0; c < n; c++) {
        up = matrix[r][c] + dp[c];
        if (c - 1 >= 0) {
          left = matrix[r][c] + dp[c - 1];
        } else {
          left = Integer.MAX_VALUE;
        }
        if (c + 1 < n) {
          right = matrix[r][c] + dp[c + 1];
        } else {
          right = Integer.MAX_VALUE;
        }
        curr[c] = Math.min(right, Math.min(left, up));
      }
      for (int i = 0; i < n; i++) {
        dp[i] = curr[i];
      }
    }
    for (int c = 0; c < n; c++) {
      min = Math.min(min, dp[c]);
    }
    return min;
  }

}
