package com.code.algos.striver.recursion.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9
 * @author sukh
 *
 */
public class _0_NQueens_51 {

  private int size;
  private List<List<String>> solutions = new ArrayList<>();

  /**
   * Time: O(N!)<br>
   * Unlike the brute force approach, we will only place queens on squares that
   * aren't under attack. For the first queen, we have NN options. For the next
   * queen, we won't attempt to place it in the same column as the first queen,
   * and there must be at least one square attacked diagonally by the first queen
   * as well. Thus, the maximum number of squares we can consider for the second
   * queen is N - 2. For the third queen, we won't attempt to place it in 2
   * columns already occupied by the first 2 queens, and there must be at least
   * two squares attacked diagonally from the first 2 queens. Thus, the maximum
   * number of squares we can consider for the third queen is N - 4. This pattern
   * continues, resulting in an approximate time complexity of N!.<br>
   * Space: O(n^2)<br>
   * Extra memory used includes the 3 sets used to store board state, as well as
   * the recursion call stack. All of this scales linearly with the number of
   * queens. However, to keep the board state costs O(N^2)O(N 2 ), since the board
   * is of size N * N. Space used for the output does not count towards space
   * complexity.
   * @param n
   * @return
   */
  public List<List<String>> solveNQueens(int n) {
    size = n;

    char[][] emptyBoard = new char[size][size];
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        emptyBoard[r][c] = '.';
      }
    }

    backtrack(0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(),
        emptyBoard);
    return solutions;
  }

  private List<String> createBoard(char[][] state) {
    List<String> board = new ArrayList<>();
    for (int r = 0; r < size; r++) {
      String row = new String(state[r]);
      board.add(row);
    }
    return board;
  }

  private void backtrack(int row, Set<Integer> cols, Set<Integer> diagonals,
      Set<Integer> antiDiagonals, char[][] state) {
    /**
     * candidate is a valid solution
     */
    if (row == size) {
      solutions.add(createBoard(state));
      return;
    }

    /**
     * for each next candidate
     */
    for (int col = 0; col < size; col++) {
      int currDiagonal = row - col;
      int currAntiDiagonal = row + col;
      /**
       * pruning
       */
      if (cols.contains(col) || diagonals.contains(currDiagonal)
          || antiDiagonals.contains(currAntiDiagonal)) {
        continue;
      }

      /**
       * place next candidate
       */
      cols.add(col);
      diagonals.add(currDiagonal);
      antiDiagonals.add(currAntiDiagonal);
      state[row][col] = 'Q';
      /**
       * call backtrack on next candidate
       */
      backtrack(row + 1, cols, diagonals, antiDiagonals, state);
      /**
       * backtrack i.e. remove next candidate
       */
      cols.remove(col);
      diagonals.remove(currDiagonal);
      antiDiagonals.remove(currAntiDiagonal);
      state[row][col] = '.';
    }
  }

}
