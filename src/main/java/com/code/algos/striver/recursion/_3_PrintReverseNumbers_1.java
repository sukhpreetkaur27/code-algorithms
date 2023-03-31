package com.code.algos.striver.recursion;

/**
 * Example 1:

Input:
N = 10
Output: 10 9 8 7 6 5 4 3 2 1
 * 
 * @author sukh
 *
 */
public class _3_PrintReverseNumbers_1 {

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param n
   */
  public void print(int n) {
    if (n < 1) {
      return;
    }
    System.out.print(n + " ");
    print(n - 1);
  }

}
