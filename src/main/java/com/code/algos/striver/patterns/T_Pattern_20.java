package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 5

Output:
*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *
 * 
 * @author sukh
 *
 */
public class T_Pattern_20 {

  public void pattern(int n) {
    for (int i = n; i >= 1; i--) {
      for (int j = n; j >= i; j--) {
        System.out.print("*");
      }
      for (int s = 1; s <= 2 * i - 2; s++) {
        System.out.print(" ");
      }
      for (int j = n; j >= i; j--) {
        System.out.print("*");
      }
      System.out.println();
    }
    for (int i = 2; i <= n; i++) {
      for (int j = i; j <= n; j++) {
        System.out.print("*");
      }
      for (int s = 1; s <= 2 * i - 2; s++) {
        System.out.print(" ");
      }
      for (int j = i; j <= n; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

}
