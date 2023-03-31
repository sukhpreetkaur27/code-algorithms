package com.code.algos.striver.binarySearch;

/**
 * A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

 

Example 1:



Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
Example 2:



Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 500
1 <= mat[i][j] <= 105
No two adjacent cells are equal.

 * @author sukh
 *
 */
public class _8_PeakElementIndex_2D {

  /**
   * Time: O(log n)<br>
   * Space: O(1)
   * @param matrix
   * @return
   */
  public int[] peak(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int col_l = 0;
    int col_r = cols - 1;

    int col_mid;
    int max_row = 0;
    while (col_l <= col_r) {
      col_mid = col_l + (col_r - col_l) / 2;

      for (int row = 0; row < rows; row++) {
        max_row = matrix[row][col_mid] > matrix[max_row][col_mid] ? row : max_row;
      }

      if (col_mid + 1 <= col_r && matrix[max_row][col_mid + 1] > matrix[max_row][col_mid]) {
        col_l = col_mid + 1;
      } else if (col_mid - 1 >= col_l && matrix[max_row][col_mid - 1] > matrix[max_row][col_mid]) {
        col_r = col_mid - 1;
      } else {
        return new int[] { max_row, col_mid };
      }
    }
    return null;
  }

}
