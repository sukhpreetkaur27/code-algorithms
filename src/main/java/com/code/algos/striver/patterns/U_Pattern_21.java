package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 4

Output:
****
*  *
*  *
****
 * 
 * @author sukh
 *
 */
public class U_Pattern_21 {

  public void pattern(int n) {
    for (int i = 1; i <= n; i++) {
      if (i == 1 || i == n) {
        for (int j = 1; j <= n; j++) {
          System.out.print("*");
        }
      } else {
        System.out.print("*");
        for (int j = 2; j <= n - 1; j++) {
          System.out.print(" ");
        }
        System.out.print("*");
      }
      System.out.println();
    }
  }

}
