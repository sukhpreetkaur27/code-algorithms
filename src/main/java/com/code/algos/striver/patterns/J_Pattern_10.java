package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 5

Output:
* 
* * 
* * * 
* * * * 
* * * * *
* * * *
* * *
* *
*
 * 
 * @author sukh
 *
 */
public class J_Pattern_10 {

  public void pattern(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
    for (int i = n - 1; i >= 1; i--) {
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }

}
