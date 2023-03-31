package com.code.algos.striver.dp;

/**
 * You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.

You have two robots that can collect cherries for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of cherries collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.
 

Example 1:


Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output: 24
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
Total of cherries: 12 + 12 = 24.
Example 2:


Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
Output: 28
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
Total of cherries: 17 + 11 = 28.
 

Constraints:

rows == grid.length
cols == grid[i].length
2 <= rows, cols <= 70
0 <= grid[i][j] <= 100
 * 
 * @author sukh
 *
 */
public class _16_CherryPickup_II {

  /**
   * Time: O(3^n) * O(3^n) <br>
   * Both the Robots will travel till n depth and each node will have 3
   * possibilities <br>
   * Space: O(n) <br>
   * the recursion stack at max will go n deep
   * 
   * @param grid
   * @return
   */
  public int cherryPickup_recursion(int[][] grid) {
    /**
     * Recursion: TLE
     */
    return cherryPickup_recursive(grid, 0, 0, grid[0].length - 1);
  }

  public int cherryPickup_recursive(int[][] grid, int r, int c1, int c2) {
    /**
     * Edge Case
     */
    if (c1 < 0 || c1 >= grid[0].length || c2 < 0 || c2 >= grid[0].length) {
      return Integer.MIN_VALUE;
    }
    /**
     * Base Case:
     * 
     * if destination reached --> return value
     */
    if (r == grid.length - 1) {
      if (c1 == c2) {
        return grid[r][c1];
      }
      return grid[r][c1] + grid[r][c2];
    }
    int max = Integer.MIN_VALUE;
    /**
     * if both the Robots are at the same position --> count as 1
     */
    int curr;
    if (c1 == c2) {
      curr = grid[r][c1];
    } else {
      curr = grid[r][c1] + grid[r][c2];
    }
    /**
     * Robot_1 can move --> 3 directions (left diagonal, straight, right diagonal)
     * <br>
     * Robot_2 can move --> 3 directions per move of Robot_1
     * 
     * Therefore, 3 * 3 = 9 combos possible
     */
    for (int offset_c1 = -1, col1 = 0, col2 = 0, count = 0; offset_c1 <= 1; offset_c1++) {
      col1 = c1 + offset_c1;
      for (int offset_c2 = -1; offset_c2 <= 1; offset_c2++) {
        col2 = c2 + offset_c2;
        count = cherryPickup_recursive(grid, r + 1, col1, col2);
        if (count != Integer.MIN_VALUE) {
          max = Math.max(max, curr + count);
        }
      }
    }
    return max;
  }

  /**
   * Time: O(n * m * m * 9) <br>
   * Time = DP states (3D) <br>
   * 9 = # of combinations <br>
   * Space: O(n * m * m) + O(n)
   * 
   * @param grid
   * @return
   */
  public int cherryPickup_memoization(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][][] dp = new int[n][m][m];
    return cherryPickup_memoize(grid, 0, 0, m - 1, dp);
  }

  public int cherryPickup_memoize(int[][] grid, int r, int c1, int c2, int[][][] dp) {
    if (c1 < 0 || c1 >= grid[0].length || c2 < 0 || c2 >= grid[0].length) {
      return Integer.MIN_VALUE;
    }
    if (r == grid.length - 1) {
      if (c1 == c2) {
        return grid[r][c1];
      }
      return grid[r][c1] + grid[r][c2];
    }
    if (dp[r][c1][c2] != 0) {
      return dp[r][c1][c2];
    }
    int max = Integer.MIN_VALUE;
    int curr;
    if (c1 == c2) {
      curr = grid[r][c1];
    } else {
      curr = grid[r][c1] + grid[r][c2];
    }
    int count;
    for (int offset_c1 = -1, col1 = 0, col2 = 0; offset_c1 <= 1; offset_c1++) {
      col1 = c1 + offset_c1;
      for (int offset_c2 = -1; offset_c2 <= 1; offset_c2++) {
        col2 = c2 + offset_c2;
        count = cherryPickup_memoize(grid, r + 1, col1, col2, dp);
        if (count != Integer.MIN_VALUE) {
          max = Math.max(max, curr + count);
        }
      }
    }
    return dp[r][c1][c2] = max;
  }

  /**
   * Time: O(n * m * m * 9) <br>
   * Time = DP states (3D) <br>
   * 9 = # of combinations <br>
   * Space: O(n * m * m)
   * 
   * @param grid
   * @return
   */
  public int cherryPickup_tabulation(int[][] grid) {
    /**
     * Tabulation
     */
    int n = grid.length;
    int m = grid[0].length;
    int[][][] dp = new int[n][m][m];
    /**
     * Base Case
     */
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        if (i == j) {
          dp[n - 1][i][i] = grid[n - 1][i];
        } else {
          dp[n - 1][i][j] = grid[n - 1][i] + grid[n - 1][j];
        }
      }
    }

    for (int r = n - 2, curr = 0; r >= 0; r--) {
      for (int c1 = 0; c1 < m; c1++) {
        for (int c2 = 0, max = 0; c2 < m; c2++) {
          max = Integer.MIN_VALUE;
          if (c1 == c2) {
            curr = grid[r][c1];
          } else {
            curr = grid[r][c1] + grid[r][c2];
          }
          for (int offset_c1 = -1, col1 = 0, col2 = 0; offset_c1 <= 1; offset_c1++) {
            col1 = c1 + offset_c1;
            /**
             * Edge Case
             */
            if (col1 < 0 || col1 >= m) {
              continue;
            }
            for (int offset_c2 = -1; offset_c2 <= 1; offset_c2++) {
              col2 = c2 + offset_c2;
              /**
               * Edge Case
               */
              if (col2 < 0 || col2 >= m) {
                continue;
              }
              max = Math.max(max, curr + dp[r + 1][col1][col2]);
            }
          }
          dp[r][c1][c2] = max;
        }
      }
    }
    /**
     * Starting Points
     * 
     * Robot 1 = [0,0]
     * 
     * Robot 2 = [0,m-1]
     */
    return dp[0][0][m - 1];
  }

  /**
   * Time: O(n * m * m * 9) <br>
   * Time = DP states (3D) <br>
   * 9 = # of combinations <br>
   * Space: O(m * m)
   * 
   * @param grid
   * @return
   */
  public int cherryPickup_optimal(int[][] grid) {
    /**
     * Space Optimization
     */
    int n = grid.length;
    int m = grid[0].length;
    /**
     * 3D-DP --> 2D-DP
     */
    int[][] dp = new int[m][m];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        if (i == j) {
          dp[i][i] = grid[n - 1][i];
        } else {
          dp[i][j] = grid[n - 1][i] + grid[n - 1][j];
        }
      }
    }
    int[][] temp = new int[m][m];
    for (int r = n - 2, curr = 0; r >= 0; r--) {
      for (int c1 = 0; c1 < m; c1++) {
        for (int c2 = 0, max = 0; c2 < m; c2++) {
          max = Integer.MIN_VALUE;
          if (c1 == c2) {
            curr = grid[r][c1];
          } else {
            curr = grid[r][c1] + grid[r][c2];
          }
          for (int offset_c1 = -1, col1 = 0, col2 = 0; offset_c1 <= 1; offset_c1++) {
            col1 = c1 + offset_c1;
            if (col1 < 0 || col1 >= m) {
              continue;
            }
            for (int offset_c2 = -1; offset_c2 <= 1; offset_c2++) {
              col2 = c2 + offset_c2;
              if (col2 < 0 || col2 >= m) {
                continue;
              }
              max = Math.max(max, curr + dp[col1][col2]);
            }
          }
          temp[c1][c2] = max;
        }
      }
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < m; j++) {
          dp[i][j] = temp[i][j];
        }
      }
    }
    /**
     * Robot 1 = [0,0]
     * 
     * Robot 2 = [0,m-1]
     */
    return dp[0][m - 1];
  }

}
