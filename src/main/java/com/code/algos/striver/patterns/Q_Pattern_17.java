package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 4
Output:
   A
  ABA
 ABCBA
ABCDCBA
 * 
 * @author sukh
 *
 */
public class Q_Pattern_17 {

  public void pattern(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = i; j < n; j++) {
        System.out.print(" ");
      }
      char ch = 65;
      for (int k = 1; k <= i; k++, ch++) {
        System.out.print(ch);
      }
      ch -= 2;
      for (int l = 1; l < i; l++, ch--) {
        System.out.print(ch);
      }
      System.out.println();
    }
  }

}
