package com.code.algos.striver.recursion.backtrack;

import java.util.HashSet;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9
 * 
 * @author sukh
 *
 */
public class _0_NQueensII_52 {

  private int size;

  /**
   * Time: O(N!) <br>
   * Unlike the brute force approach, we will only place queens on squares that
   * aren't under attack. For the first queen, we have NN options. For the next
   * queen, we won't attempt to place it in the same column as the first queen,
   * and there must be at least one square attacked diagonally by the first queen
   * as well. Thus, the maximum number of squares we can consider for the second
   * queen is N - 2. For the third queen, we won't attempt to place it in 2
   * columns already occupied by the first 2 queens, and there must be at least
   * two squares attacked diagonally from the first 2 queens. Thus, the maximum
   * number of squares we can consider for the third queen is N - 4. This
   * pattern continues, resulting in an approximate time complexity of N!.<br>
   * Space: O(N)
   * @param n
   * @return
   */
  public int totalNQueens(int n) {
    size = n;
    return backtrack(0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
  }

  private int backtrack(int row, Set<Integer> cols, Set<Integer> diagonals,
      Set<Integer> antiDiagonals) {
    if (row == size) {
      return 1;
    }
    int solution = 0;

    for (int col = 0; col < size; col++) {
      int currDiagonal = row - col;
      int currAntiDiagonal = row + col;

      if (cols.contains(col) || diagonals.contains(currDiagonal)
          || antiDiagonals.contains(currAntiDiagonal)) {
        continue;
      }

      cols.add(col);
      diagonals.add(currDiagonal);
      antiDiagonals.add(currAntiDiagonal);

      solution += backtrack(row + 1, cols, diagonals, antiDiagonals);

      cols.remove(col);
      diagonals.remove(currDiagonal);
      antiDiagonals.remove(currAntiDiagonal);
    }
    return solution;
  }

}
