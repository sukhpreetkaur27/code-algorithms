package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * 
 * 
 * You are given an m x n integer array grid. There is a robot initially located
 * at the top-left corner (i.e., grid[0][0]). The robot tries to move to the
 * bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
 * either down or right at any point in time.
 * 
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that
 * the robot takes cannot include any square that is an obstacle.
 * 
 * Return the number of possible unique paths that the robot can take to reach
 * the bottom-right corner.
 * 
 * The testcases are generated so that the answer will be less than or equal to
 * 2 * 109.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] Output: 2 Explanation: There
 * is one obstacle in the middle of the 3x3 grid above. There are two ways to
 * reach the bottom-right corner: 1. Right -> Right -> Down -> Down 2. Down ->
 * Down -> Right -> Right Example 2:
 * 
 * 
 * Input: obstacleGrid = [[0,1],[0,0]] Output: 1
 * 
 * 
 * Constraints:
 * 
 * m == obstacleGrid.length n == obstacleGrid[i].length 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1. * @author sukh
 *
 */
public class _12_UniquePaths_II {

  /**
   * Time: O(2^(m*n)) <br>
   * Space: O(path length) = O(m + n) <br>
   * Dry run it from [m-1, n-1] to [0, 0]
   * 
   * @param obstacleGrid
   * @return
   */
  public int uniquePathsWithObstacles_recursion(int[][] obstacleGrid) {
    /**
     * Edge Case: Source == Obstacle
     */
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    /**
     * Recursion: TLE
     */
    /**
     * Top-Down --> from target to source
     */
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    return uniquePaths_recursive(m - 1, n - 1, obstacleGrid);
  }

  private int uniquePaths_recursive(int r, int c, int[][] obstacleGrid) {
    if (r == 0 && c == 0) {
      return 1;
    }
    if (r < 0 || c < 0) {
      return 0;
    }
    if (obstacleGrid[r][c] == 1) {
      return 0;
    }
    /**
     * Top-Down --> can move up or left
     */
    int up = uniquePaths_recursive(r - 1, c, obstacleGrid);
    int left = uniquePaths_recursive(r, c - 1, obstacleGrid);
    return left + up;
  }

  /**
   * Time: O(m * n) <br>
   * having calls for all the cells at max <br>
   * Space: O(path length + (m*n)) = O(m + n) <br>
   * Dry run it from [m-1, n-1] to [0, 0]
   * @param obstacleGrid
   * @return
   */
  public int uniquePathsWithObstacles_memoization(int[][] obstacleGrid) {
    /**
     * Memoization
     */
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], -1);
    }
    return uniquePaths_memoize(m - 1, n - 1, obstacleGrid, dp);
  }

  private int uniquePaths_memoize(int r, int c, int[][] obstacleGrid, int[][] dp) {
    if (r == 0 && c == 0) {
      return 1;
    }
    if (r < 0 || c < 0) {
      return 0;
    }
    if (dp[r][c] != -1) {
      return dp[r][c];
    }
    if (obstacleGrid[r][c] == 1) {
      return 0;
    }
    /**
     * Top-Down --> can move up or left
     */
    int up = uniquePaths_memoize(r - 1, c, obstacleGrid, dp);
    int left = uniquePaths_memoize(r, c - 1, obstacleGrid, dp);
    return dp[r][c] = left + up;
  }

  /**
   *  Time: O(m * n) <br>
   * Space: O(m * n)
   * @param obstacleGrid
   * @return
   */
  public int uniquePathsWithObstacles_tabulation(int[][] obstacleGrid) {
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
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
        if (obstacleGrid[r][c] == 1) {
          /**
           * dp[r][c] remains 0
           */
          continue;
        }
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
   * @param obstacleGrid
   * @return
   */
  public int uniquePathsWithObstacles_optimization(int[][] obstacleGrid) {
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    /**
     * Space Optimization
     */
    int[] prevRow = new int[n];
    prevRow[0] = 1;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (obstacleGrid[r][c] == 1) {
          /**
           * dp[r][c] remains 0
           */
          prevRow[c] = 0;
          continue;
        }
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
