package com.code.algos.striver.patterns;

/**
 * Example 1:

Input: 5

Output:

    *
   ***  
  *****
 *******
*********
 * 
 * 
 * @author sukh
 *
 */
public class G_Pattern_7 {

  public static void pattern(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
      }
      for (int k = 0; k <= 2 * i - 2; k++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

}
