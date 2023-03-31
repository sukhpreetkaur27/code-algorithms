package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 5

Output:
E
E D
E D C
E D C B
E D C B A
 * 
 * @author sukh
 *
 */
public class R_Pattern_18 {

  public void pattern(int n) {
    for (int i = 1; i <= n; i++) {
      int k = 64 + n;
      for (int j = 1; j <= i; j++, k--) {
        System.out.print((char) k + " ");
      }
      System.out.println();
    }
  }

}
