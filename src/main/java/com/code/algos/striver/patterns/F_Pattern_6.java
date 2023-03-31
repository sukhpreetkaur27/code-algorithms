package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:
 * 
 * Input: 5
 * 
 * Output: 1 2 3 4 5 1 2 3 4 1 2 3 1 2 1
 * 
 * 
 * @author sukh
 *
 */
public class F_Pattern_6 {

  public static void pattern(int n) {
    for (int i = n; i >= 1; i--) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    pattern(5);
  }

}
