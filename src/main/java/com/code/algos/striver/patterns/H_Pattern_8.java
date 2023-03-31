package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 5

Output:

*********
 *******
  *****
   ***
    *

 * 
 * @author sukh
 *
 */
public class H_Pattern_8 {

  public static void pattern(int n) {
    for (int i = n; i >= 1; i--) {
      for (int j = i; j < n; j++) {
        System.out.print(" ");
      }
      for (int k = 0; k <= 2 * i - 2; k++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    pattern(5);
  }

}
