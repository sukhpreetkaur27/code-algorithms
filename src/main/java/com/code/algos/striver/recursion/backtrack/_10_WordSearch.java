package com.code.algos.striver.recursion.backtrack;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, 
where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?
 * 
 * @author sukh
 *
 */
public class _10_WordSearch {

  private char[][] board;
  private int ROWS;
  private int COLS;

  /**
   * Time: O(n * (3^l)) <br>
   * where n is the number of cells in the board and l is the length of the word
   * to be matched. <br>
   * For the backtracking function, initially we could have at most 4 directions
   * to explore, but further the choices are reduced into 3 (since we won't go
   * back to where we come from). As a result, the execution trace after the first
   * step could be visualized as a 3-ary tree, each of the branches represent a
   * potential exploration in the corresponding direction. Therefore, in the worst
   * case, the total number of invocation would be the number of nodes in a full
   * 3-nary tree, which is about 3^l <br>
   * We iterate through the board for backtracking, i.e. there could be NN times
   * invocation for the backtracking function in the worst case. <br>
   * Space: O(l) <br>
   * The maximum length of the call stack would be the length of the word.
   * @param board
   * @param word
   * @return
   */
  public boolean exist(char[][] board, String word) {
    this.board = board;
    this.ROWS = board.length;
    this.COLS = board[0].length;

    for (int r = 0; r < ROWS; r++) {
      for (int c = 0; c < COLS; c++) {
        if (backtrack(word, r, c, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean backtrack(String word, int row, int col, int index) {
    if (index == word.length()) {
      return true;
    }

    if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
        || board[row][col] != word.charAt(index)) {
      return false;
    }

    // don't check the same box again for the match
    board[row][col] = '#';

    boolean check = false;
    /**
     * RIGHT -> DOWN -> LEFT -> UP
     */
    int[] rowDirections = { 0, 1, 0, -1 };
    int[] colDirections = { 1, 0, -1, 0 };

    for (int direction = 0; direction < 4; direction++) {
      // move in the direction
      if (backtrack(word, row + rowDirections[direction], col + colDirections[direction],
          index + 1)) {
        check = true;
        break;
      }
    }

    this.board[row][col] = word.charAt(index);

    return check;
  }

}
