package com.code.algos.striver.binarySearch;

/**
 * Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.

Example 1:

Input:
R = 3, C = 3
M = [[1, 3, 5], 
     [2, 6, 9], 
     [3, 6, 9]]
Output: 5
Explanation: Sorting matrix elements gives 
us {1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
 

Example 2:

Input:
R = 3, C = 1
M = [[1], [2], [3]]
Output: 2
Explanation: Sorting matrix elements gives 
us {1,2,3}. Hence, 2 is median.

Your Task:  
You don't need to read input or print anything.
 Your task is to complete the function median() which takes the integers R and C along with the 2D matrix as input parameters and returns the median of the matrix.

Expected Time Complexity: O(32 * R * log(C))
Expected Auxiliary Space: O(1)


Constraints:
1 <= R, C <= 400
1 <= matrix[i][j] <= 2000
 * 
 * @author sukh
 *
 */
public class _19_Median2DMatrix {

  /**
   * Time: O( log k * r * log c)<br>
   * k = max element in the matrix<br>
   * (OR) O( log 2^32 * r * log c)<br>
   * Max search space = 10^9 == 2^32<br>
   * i.e. 32-bit is the max integer possible<br>
   * Space: O(1)
   * @param matrix
   * @return
   */
  public int median(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    int lo = Integer.MAX_VALUE;
    int hi = Integer.MIN_VALUE;
    int mid;

    /**
     * Find the Search Space
     */
    for (int r = 0, c = cols - 1; r < rows; r++) {
      lo = Math.min(lo, matrix[r][0]);
      hi = Math.max(hi, matrix[r][c]);
    }

    int medianPosition = (rows * cols + 1) >> 1;

    int count = 0;

    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;

      count = 0;

      for (int r = 0; r < rows; r++) {
        count += countSmallerThanMid(matrix[r], mid);
      }

      if (count <= medianPosition) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return lo;
  }

  private int countSmallerThanMid(int[] arr, int mid) {
    int lo = 0;
    int hi = arr.length - 1;
    int m;

    while (lo <= hi) {
      m = lo + (hi - lo) / 2;

      if (arr[m] <= arr[mid]) {
        lo = m + 1;
      } else {
        hi = m - 1;
      }
    }
    return lo;
  }

}
