package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 5

Output:
A
AB
ABC
ABCD
ABCDE
 * 
 * @author sukh
 *
 */
public class N_Pattern_14 {

  public static void pattern(int n) {
    for (int i = 1, k = 65; i <= 5; i++) {
      k = 65;
      for (int j = 1; j <= i; j++, k++) {
        System.out.print((char) k);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    pattern(5);
  }

}
