package com.code.algos.striver.dp;

/**
 * You are given an n x n grid representing a field of cherries, each cell is one of three possible integers.

0 means the cell is empty, so you can pass through,
1 means the cell contains a cherry that you can pick up and pass through, or
-1 means the cell contains a thorn that blocks your way.
Return the maximum number of cherries you can collect by following the rules below:

Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right or down through valid path cells (cells with value 0 or 1).
After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.
When passing through a path cell containing a cherry, you pick it up, and the cell becomes an empty cell 0.
If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.
 

Example 1:


Input: grid = [[0,1,-1],[1,0,-1],[1,1,1]]
Output: 5
Explanation: The player started at (0, 0) and went down, down, right right to reach (2, 2).
4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
Then, the player went left, up, up, left to return home, picking up one more cherry.
The total number of cherries picked up is 5, and this is the maximum possible.
Example 2:

Input: grid = [[1,1,-1],[1,-1,1],[-1,1,1]]
Output: 0
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 50
grid[i][j] is -1, 0, or 1.
grid[0][0] != -1
grid[n - 1][n - 1] != -1
 * 
 * @author sukh
 *
 */
public class _17_CherryPickup {

  public int cherryPickup_recursion(int[][] grid) {
    /**
     * Check NOTES
     */
    /**
     * Recursion: TLE
     */
    /**
     * the # of ways to reach from source to destination == the # of ways to reach
     * from destination to source
     * 
     * Instead of revisiting the source from destination --> we visit the
     * destination from source twice
     */
    /**
     * if no path exists --> return 0
     */
    return Math.max(0, cherryPickup_recursive(grid, 0, 0, 0, 0));
  }

  public int cherryPickup_recursive(int[][] grid, int r1, int c1, int r2, int c2) {
    /**
     * Edge Case
     */
    if (r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length
        || c2 >= grid[0].length || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
      return Integer.MIN_VALUE;
    }
    /**
     * at each step both the points increment by 1 --> therefore the overall
     * distance from source (0,0) remains same to reach the destination
     * 
     * if any one reaches the destination --> the other one also has reached the
     * destination
     */
    if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
      return grid[r1][c1];
    }

    int max = Integer.MIN_VALUE;
    /**
     * if both are at the same position --> count as 1
     * 
     * Why? <br>
     * As it implies that the cherries weren't available on the return journey
     */
    int count;
    if (r1 == r2 && c1 == c2) {
      count = grid[r1][c1];
    } else {
      count = grid[r1][c1] + grid[r2][c2];
    }
    // 4 combos
    /**
     * 
     */
    int hh = cherryPickup_recursive(grid, r1, c1 + 1, r2, c2 + 1);
    int vv = cherryPickup_recursive(grid, r1 + 1, c1, r2 + 1, c2);
    int hv = cherryPickup_recursive(grid, r1, c1 + 1, r2 + 1, c2);
    int vh = cherryPickup_recursive(grid, r1 + 1, c1, r2, c2 + 1);
    max = Math.max(Math.max(hh, vv), Math.max(hv, vh));
    max = max != Integer.MIN_VALUE ? count + max : max;
    return max;
  }

  public int cherryPickup_memoization(int[][] grid) {
    int n = grid.length;
    int[][][][] dp = new int[n][n][n][n];
    return Math.max(0, cherryPickup_memoize(grid, 0, 0, 0, 0, dp));
  }

  public int cherryPickup_memoize(int[][] grid, int r1, int c1, int r2, int c2,
      int[][][][] dp) {
    if (r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length
        || c2 >= grid[0].length || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
      return Integer.MIN_VALUE;
    }
    if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
      return grid[r1][c1];
    }
    if (dp[r1][c1][r2][c2] != 0) {
      return dp[r1][c1][r2][c2];
    }
    int max = Integer.MIN_VALUE;
    int count;
    if (r1 == r2 && c1 == c2) {
      count = grid[r1][c1];
    } else {
      count = grid[r1][c1] + grid[r2][c2];
    }
    // 4 combos
    int hh = cherryPickup_memoize(grid, r1, c1 + 1, r2, c2 + 1, dp);
    int vv = cherryPickup_memoize(grid, r1 + 1, c1, r2 + 1, c2, dp);
    int hv = cherryPickup_memoize(grid, r1, c1 + 1, r2 + 1, c2, dp);
    int vh = cherryPickup_memoize(grid, r1 + 1, c1, r2, c2 + 1, dp);
    max = Math.max(Math.max(hh, vv), Math.max(hv, vh));
    max = max != Integer.MIN_VALUE ? count + max : max;
    return dp[r1][c1][r2][c2] = max;
  }

  public int cherryPickup_optimized(int[][] grid) {
    int n = grid.length;
    int[][][] dp = new int[n][n][n];
    return Math.max(0, cherryPickup_optimized(grid, 0, 0, 0, dp));
  }

  public int cherryPickup_optimized(int[][] grid, int r1, int c1, int r2, int[][][] dp) {
    /**
     * Manhattan Distance from (0,0) to (r1,c1) = (r1-0) + (c1-0) = r1+c1 Manhattan
     * Distance from (0,0) to (r2,c2) = (r2-0) + (c2-0) = r2+c2
     * 
     * at each step both the points increment by 1 --> therefore the overall
     * distance from source (0,0) remains same
     * 
     * r1+c1 = r2+c2
     * 
     * thus, 4D DP can be converted to 3D DP
     */
    int c2 = r1 + c1 - r2;
    if (r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length
        || c2 >= grid[0].length || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
      return Integer.MIN_VALUE;
    }
    if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
      return grid[r1][c1];
    }
    if (dp[r1][c1][r2] != 0) {
      return dp[r1][c1][r2];
    }
    int max = Integer.MIN_VALUE;
    int count;
    if (r1 == r2 && c1 == c2) {
      count = grid[r1][c1];
    } else {
      count = grid[r1][c1] + grid[r2][c2];
    }
    // 4 combos
    int hh = cherryPickup_optimized(grid, r1, c1 + 1, r2, dp);
    int vv = cherryPickup_optimized(grid, r1 + 1, c1, r2 + 1, dp);
    int hv = cherryPickup_optimized(grid, r1, c1 + 1, r2 + 1, dp);
    int vh = cherryPickup_optimized(grid, r1 + 1, c1, r2, dp);
    max = Math.max(Math.max(hh, vv), Math.max(hv, vh));
    max = max != Integer.MIN_VALUE ? count + max : max;
    return dp[r1][c1][r2] = max;
  }

}
