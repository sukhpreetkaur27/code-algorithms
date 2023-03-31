package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 5

Output:
A
BB
CCC
DDDD
EEEEE
 * 
 * @author sukh
 *
 */
public class P_Pattern_16 {

  public void pattern(int n) {
    for (int i = 1, k = 65; i <= n; i++, k++) {
      for (int j = 1; j <= i; j++) {
        System.out.print((char) k);
      }
      System.out.println();
    }
  }

}
