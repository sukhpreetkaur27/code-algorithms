package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 5

Output:
1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15
 * 
 * @author sukh
 *
 */
public class M_Pattern_13 {

  public static void pattern(int n) {
    for (int i = 1, k = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++, k++) {
        System.out.print(k + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    pattern(5);
  }

}
