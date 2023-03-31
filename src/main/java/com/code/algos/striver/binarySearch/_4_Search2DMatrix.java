package com.code.algos.striver.binarySearch;

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 * 
 * @author sukh
 *
 */
public class _4_Search2DMatrix {

  /**
   * Time: O(log n)<br>
   * Space: O(1)
   * @param matrix
   * @param target
   * @return
   */
  public boolean search(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    int lo = 0;
    int hi = rows * cols - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      int r = mid / rows;
      int c = mid % rows;
      if (matrix[r][c] == target) {
        return true;
      } else if (matrix[r][c] > target) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return false;
  }

}
