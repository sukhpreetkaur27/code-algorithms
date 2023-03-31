package com.code.algos.striver.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
 * 
 * @author sukh
 *
 */
public class _57_MaximalRectangle {

  /**
   * NOTE: This is an extension to
   * com.code.ds.striver.stack._22_LargestRectangleInHistogram
   */

  /**
   * Time: O(m * n + m * n)  <br>
   * Space: O(n + n)
   * 
   * @param matrix
   * @return
   */
  public int maximalRectangle(char[][] matrix) {
    /**
     * why DP ?
     * 
     * as we are memoizing the heights
     */
    int m = matrix.length;
    int n = matrix[0].length;
    int[] heights = new int[n];
    int maxArea = 0;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        /**
         * height per row
         */
        heights[c] = matrix[r][c] == '1' ? heights[c] + 1 : 0;
      }
      /**
       * maximum area per row
       */
      maxArea = Math.max(maxArea, maxAreaHistogram(heights));
    }
    return maxArea;
  }

  private int maxAreaHistogram(int[] heights) {

    /**
     * NOTE: <br>
     * Find the previous smaller (+1) and next smaller (-1) for the current index
     * <br>
     * this implies the range in which the current index is smallest
     */

    int n = heights.length;

    Deque<Integer> stack = new ArrayDeque<>();
    int max = 0;
    /**
     * Time: O(n)
     */
    for (int right = 0, min = 0, left = 0, area = 0; right <= n; right++) {
      while (!stack.isEmpty()
          && (right == n || heights[right] <= heights[stack.peek()])) {
        min = stack.pop();
        left = stack.isEmpty() ? 0 : stack.peek() + 1;
        /**
         * right = next smaller <br>
         * left = previous smaller <br>
         * min = current small <br>
         * # of elements with min as smallest = ( right - left - 1 ) == length <br>
         * height[min] == breadth
         */
        area = (right - 1 - left + 1) * heights[min];
        max = Math.max(max, area);
      }
      stack.push(right);
    }

    return max;

  }

}
