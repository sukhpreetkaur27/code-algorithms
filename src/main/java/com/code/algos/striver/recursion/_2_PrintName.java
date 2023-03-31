package com.code.algos.striver.recursion;

/**
 * Example:

Input:
5
Output:
GFG GFG GFG GFG GFG
 * 
 * @author sukh
 *
 */
public class _2_PrintName {

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param n
   */
  public void print(int n) {
    print(1, n);
  }

  private void print(int i, int n) {
    if (i > n) {
      return;
    }
    System.out.print("Sukh");
    print(i + 1, n);
  }

}
