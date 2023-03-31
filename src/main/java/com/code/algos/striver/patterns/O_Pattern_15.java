package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 5

Output:
ABCDE
ABCD
ABC
AB
A
 * 
 * @author sukh
 *
 */
public class O_Pattern_15 {

  public void pattern(int n) {
    for (int i = n, k = 65; i >= 1; i--) {
      k = 65;
      for (int j = 1; j <= i; j++, k++) {
        System.out.print((char) k);
      }
      System.out.println();
    }
  }

}
