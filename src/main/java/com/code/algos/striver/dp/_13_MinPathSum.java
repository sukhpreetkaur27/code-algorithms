package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
 * 
 * @author sukh
 *
 */
public class _13_MinPathSum {

  /**
   * Time: O(2^(m*n)) <br>
   * Space: O(path length) = O(m + n) <br>
   * Dry run it from [m-1, n-1] to [0, 0]
   * 
   * @param grid
   * @return
   */
  public int minPathSum_recursion(int[][] grid) {
    /**
     * Recursion: TLE
     */
    /**
     * Top-Down --> from target to source
     */
    int m = grid.length;
    int n = grid[0].length;
    return minPathSum_recursive(m - 1, n - 1, grid);

  }

  private int minPathSum_recursive(int r, int c, int[][] grid) {
    /**
     * Base Case: Reached Target
     */
    if (r == 0 && c == 0) {
      return grid[0][0];
    }
    /**
     * Edge Case: Out of Bounds
     * 
     * We will not pick the sum for this path --> as we need to find the minimum
     * path sum --> return a MAX value
     */
    if (r < 0 || c < 0) {
      return Integer.MAX_VALUE;
    }
    /**
     * Top-Down --> can move up or left
     */
    int up = minPathSum_recursive(r - 1, c, grid);
    if (up != Integer.MAX_VALUE) {
      up += grid[r][c];
    }
    int left = minPathSum_recursive(r, c - 1, grid);
    if (left != Integer.MAX_VALUE) {
      left += grid[r][c];
    }
    return Math.min(left, up);
  }

  /**
   * Time: O(m * n) <br>
   * having calls for all the cells at max <br>
   * Space: O(path length + (m*n)) = O(m + n) <br>
   * Dry run it from [m-1, n-1] to [0, 0]
   * 
   * @param grid
   * @return
   */
  public int minPathSum_memoization(int[][] grid) {
    /**
     * Memoization
     */
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], -1);
    }
    return minPathSum_memoize(m - 1, n - 1, grid, dp);

  }

  private int minPathSum_memoize(int r, int c, int[][] grid, int[][] dp) {
    if (r == 0 && c == 0) {
      return dp[0][0] = grid[0][0];
    }
    if (r < 0 || c < 0) {
      return Integer.MAX_VALUE;
    }
    if (dp[r][c] != -1) {
      return dp[r][c];
    }
    /**
     * Top-Down --> can move up or left
     */
    int up = minPathSum_memoize(r - 1, c, grid, dp);
    if (up != Integer.MAX_VALUE) {
      up += grid[r][c];
    }
    int left = minPathSum_memoize(r, c - 1, grid, dp);
    if (left != Integer.MAX_VALUE) {
      left += grid[r][c];
    }
    return dp[r][c] = Math.min(left, up);
  }

  /**
   * Time: O(m * n) <br>
   * Space: O(m * n)
   * 
   * @param grid
   * @return
   */
  public int minPathSum_tabulation(int[][] grid) {
    /**
     * Tabulation
     */
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    // for(int i=0;i<m;i++){
    // Arrays.fill(dp[i],Integer.MAX_VALUE);
    // }
    /**
     * traverse each column per row
     */
    for (int r = 0; r < m; r++) {
      for (int c = 0, up = 0, left = 0; c < n; c++) {
        /**
         * Base Case: For Source Initialization
         */
        if (r == 0 && c == 0) {
          dp[0][0] = grid[0][0];
        } else {
          up = Integer.MAX_VALUE;
          if (r - 1 >= 0) {
            up = grid[r][c] + dp[r - 1][c];
          }
          left = Integer.MAX_VALUE;
          if (c - 1 >= 0) {
            left = grid[r][c] + dp[r][c - 1];
          }
          dp[r][c] = Math.min(up, left);
        }
      }
    }
    return dp[m - 1][n - 1];
  }

  /**
   * Time: O(m * n) <br>
   * Space: O(1)
   * 
   * @param grid
   * @return
   */
  public int minPathSum_optimal(int[][] grid) {
    /**
     * Space Optimization
     */
    int m = grid.length;
    int n = grid[0].length;
    int[] dp = new int[n];
    /**
     * traverse each column per row
     */
    for (int r = 0; r < m; r++) {
      for (int c = 0, up = 0, left = 0; c < n; c++) {
        if (r == 0 && c == 0) {
          dp[c] = grid[0][0];
        } else {
          up = Integer.MAX_VALUE;
          if (r - 1 >= 0) {
            up = grid[r][c] + dp[c];
          }
          left = Integer.MAX_VALUE;
          if (c - 1 >= 0) {
            left = grid[r][c] + dp[c - 1];
          }
          dp[c] = Math.min(up, left);
        }
      }
    }
    return dp[n - 1];
  }

}
