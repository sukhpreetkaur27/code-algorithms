package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 5

Output:
**********
****  ****
***    ***
**      **
*        *
*        *
**      **
***    ***
****  ****
**********
 * 
 * @author sukh
 *
 */
public class S_Pattern_19 {

  public void pattern(int n) {
    for (int i = 1; i <= n; i++) {
      for (int k = n; k >= i; k--) {
        System.out.print("*");
      }
      for (int l = 1; l <= 2 * i - 2; l++) {
        System.out.print(" ");
      }
      for (int k = n; k >= i; k--) {
        System.out.print("*");
      }
      System.out.println();
    }

    for (int i = n; i >= 1; i--) {
      for (int k = n; k >= i; k--) {
        System.out.print("*");
      }
      for (int l = 2 * i - 2; l >= 1; l--) {
        System.out.print(" ");
      }
      for (int k = n; k >= i; k--) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

}
