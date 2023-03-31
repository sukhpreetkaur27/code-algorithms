package com.code.algos.striver.dp;

import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, 
you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
 * 
 * @author sukh
 *
 */
public class _14_TrianglePathSum {
  
  /**
   * NOTE: Single Starting Point and Variable Ending Point 
   */

  /**
   * Time: O(2^n) (or) O(n^2) <br>
   * Space: O(n)
   * 
   * @param triangle
   * @return
   */
  public int minimumTotal_recursion(List<List<Integer>> triangle) {
    /**
     * Recursion
     */
    int n = triangle.size();
    /**
     * As we don't have a single destination (destination = all values in the last
     * row) --> we will start from 0-th row rather than n-th row
     */
    return minimumTotal_recursive(triangle, 0, 0, n - 1);
  }

  public int minimumTotal_recursive(List<List<Integer>> triangle, int r, int c, int n) {
    if (r > n || c >= triangle.get(r).size()) {
      return Integer.MAX_VALUE;
    }
    if (r == n) {
      return triangle.get(r).get(c);
    }

    int num = triangle.get(r).get(c);
    int down = minimumTotal_recursive(triangle, r + 1, c, n);
    if (down != Integer.MAX_VALUE) {
      down += num;
    }
    int diagonal = minimumTotal_recursive(triangle, r + 1, c + 1, n);
    if (diagonal != Integer.MAX_VALUE) {
      diagonal += num;
    }
    return Math.min(down, diagonal);
  }

  /**
   * Time: O(2^n) (or) O(n^2) <br>
   * Space: O(n + n^2)
   * 
   * @param triangle
   * @return
   */
  public int minimumTotal_memoization(List<List<Integer>> triangle) {
    /**
     * Memoization
     */
    int n = triangle.size();
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }
    return minimumTotal_memoize(triangle, 0, 0, n - 1, dp);
  }

  public int minimumTotal_memoize(List<List<Integer>> triangle, int r, int c, int n,
      int[][] dp) {
    if (r > n || c >= triangle.get(r).size()) {
      return Integer.MAX_VALUE;
    }
    if (r == n) {
      return triangle.get(r).get(c);
    }
    if (dp[r][c] != -1) {
      return dp[r][c];
    }
    int num = triangle.get(r).get(c);
    int down = minimumTotal_memoize(triangle, r + 1, c, n, dp);
    if (down != Integer.MAX_VALUE) {
      down += num;
    }
    int diagonal = minimumTotal_memoize(triangle, r + 1, c + 1, n, dp);
    if (diagonal != Integer.MAX_VALUE) {
      diagonal += num;
    }
    return dp[r][c] = Math.min(down, diagonal);
  }

  /**
   * Time: O(# of elements) <br>
   * Space: O(n^2)
   * 
   * @param triangle
   * @return
   */
  public int minimumTotal_tabulation(List<List<Integer>> triangle) {
    /**
     * Tabulation
     */
    int n = triangle.size();
    int[][] dp = new int[n][n];
    for (int r = n - 1, num = 0, down = 0, diagonal = 0; r >= 0; r--) {
      /**
       * Since it's a triangle --> i-th row will have i columns
       */
      for (int c = 0; c <= r; c++) {
        num = triangle.get(r).get(c);
        if (r == n - 1) {
          dp[r][c] = num;
        } else {
          down = num + dp[r + 1][c];
          diagonal = num + dp[r + 1][c + 1];
          dp[r][c] = Math.min(down, diagonal);
        }
      }
    }
    return dp[0][0];
  }

  /**
   * Time: O(# of elements) <br>
   * Space: O(n)
   * 
   * @param triangle
   * @return
   */
  public int minimumTotal_optimal(List<List<Integer>> triangle) {
    /**
     * Space Optimization
     */
    int n = triangle.size();
    int[] dp = new int[n];
    for (int r = n - 1, num = 0, down = 0, diagonal = 0; r >= 0; r--) {
      for (int c = 0; c <= r; c++) {
        num = triangle.get(r).get(c);
        if (r == n - 1) {
          dp[c] = num;
        } else {
          down = num + dp[c];
          diagonal = num + dp[c + 1];
          dp[c] = Math.min(down, diagonal);
        }
      }
    }
    return dp[0];
  }

}
