package com.code.algos.striver.dp;

/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
 * 
 * @author sukh
 *
 */
public class _58_CountSquareSubmatrices {

  /**
   * Time: O(n + m + m * n) <br>
   * Space: O(m * n)
   * 
   * @param matrix
   * @return
   */
  public int countSquares_I(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    /**
     * stores the # of squares with i-th row and j-th column as the bottom right
     * corner
     */
    int[][] dp = new int[m][n];
    int count = 0;
    for (int c = 0; c < n; c++) {
      if (matrix[0][c] == 1) {
        dp[0][c] = 1;
        count++;
      }
    }
    for (int r = 1; r < m; r++) {
      if (matrix[r][0] == 1) {
        dp[r][0] = 1;
        count++;
      }
    }
    for (int r = 1; r < m; r++) {
      for (int c = 1; c < n; c++) {
        if (matrix[r][c] == 1) {
          dp[r][c] = matrix[r][c]
              + Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1]));
          count += dp[r][c];
        }
      }
    }
    return count;
  }

  /**
   * Time: O(m * n) <br>
   * Space: O(m * n)
   * 
   * @param matrix
   * @return
   */
  public int countSquares_II(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m + 1][n + 1];
    int count = 0;
    for (int r = 1; r <= m; r++) {
      for (int c = 1; c <= n; c++) {
        if (matrix[r - 1][c - 1] == 1) {
          dp[r][c] = 1 + Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1]));
          count += dp[r][c];
        }
      }
    }
    return count;
  }

}
