package com.code.algos.striver.patterns;

/**
 * Example 1:

Input: 5

Output:
* * * * *
* * * * *
* * * * *
* * * * *
* * * * *
* 
* 
 * @author sukh
 *
 */
public class A_Pattern_1 {

  /**
   * Time: O(n^2)<br>
   * Space: O(1)
   * @param n
   */
  public void pattern(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }

}
