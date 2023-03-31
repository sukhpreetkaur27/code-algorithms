package com.code.algos.striver.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Consider a rat placed at (0, 0) in a square matrix of order N * N. 
 * It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. 
 * The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents 
 * that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.
Example 2:
Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is 
blocked.
Your Task:  
You don't need to read input or print anything. Complete the function printPath() which takes N and 2D array m[ ][ ] 
as input parameters and returns the list of paths in lexicographically increasing order. 
Note: In case of no path, return an empty list. The driver will output "-1" automatically.
 * 
 * @author sukh
 *
 */
public class _11_RatInAMaze {

  /**
   * NOTE: to print the answer i.e. directions is lexicographical order, scan for
   * the paths in lexicographic order i.e. D -> L -> R -> U
   */

  /**
   * Time: O(3^(n*n)) <br>
   * Space: O(n * n)
   * @param m
   * @param n
   * @return
   */
  public static List<String> findPath(int[][] m, int n) {
    List<String> list = new ArrayList<>();
    /**
     * Edge case: if start is 0, i.e., block
     */
    if (m[0][0] == 1) {
      backtrack(list, new StringBuilder(), m, 0, 0, n);
    }
    return list;
  }

  /**
   * the paths in lexicographic order i.e. D -> L -> R -> U
   */
  private static int[] rowDirections = { 1, 0, 0, -1 };
  private static int[] colDirections = { 0, -1, 1, 0 };

  private static void backtrack(List<String> list, StringBuilder temp, int[][] m, int row, int col,
      int n) {
    if (row == (n - 1) && col == (n - 1)) {
      list.add(temp.toString());
      return;
    }
    /**
     * To avoid infinite loop (stack overflow), we need to mark the already visited
     * node as 0
     */
    m[row][col] = 0;
    
    /**
     * Parse all possible directions
     */
    for (int dir = 0, r = 0, c = 0; dir < 4; dir++) {
      r = row + rowDirections[dir];
      c = col + colDirections[dir];

      /**
       * Pruning the edge cases
       */
      if (r < 0 || r == n || c < 0 || c == n) {
        continue;
      }

      if (m[r][c] != 0) {
        /**
         * PICK
         */
        char ch = getDirection(rowDirections[dir], colDirections[dir]);
        temp.append(ch);
        backtrack(list, temp, m, r, c, n);
        /**
         * Not PICK
         */
        temp.deleteCharAt(temp.length() - 1);
      }
    }
    m[row][col] = 1;
  }

  private static char getDirection(int row, int col) {
    if (row == 0 && col == 1) {
      return 'R';
    } else if (row == 1 && col == 0) {
      return 'D';
    } else if (row == 0 && col == -1) {
      return 'L';
    } else {
      return 'U';
    }
  }

  public static void main(String[] args) {
    int n = 4;
    int[][] m = { { 0, 1, 1, 1 }, { 1, 1, 1, 0 }, { 1, 0, 1, 1 }, { 0, 0, 1, 1 } };
    List<String> list = findPath(m, n);
    System.out.println(list);
  }

}
