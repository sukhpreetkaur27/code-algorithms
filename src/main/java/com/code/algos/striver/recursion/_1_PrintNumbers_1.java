package com.code.algos.striver.recursion;

/**
 * Print numbers from 1 to N without the help of loops.

Example 1:

Input:
N = 10
Output: 1 2 3 4 5 6 7 8 9 10

Example 2:

Input:
N = 5
Output: 1 2 3 4 5
 * 
 * @author sukh
 *
 */
public class _1_PrintNumbers_1 {

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param n
   */
  public void print(int n) {
    print(1, n);
  }

  public void print(int i, int n) {
    System.out.print(i + " ");
    if (i == n) {
      return;
    }
    i++;
    print(i, n);
  }

}
