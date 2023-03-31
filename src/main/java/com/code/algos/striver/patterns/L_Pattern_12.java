package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 5

Output:
1                 1
1 2             2 1
1 2 3         3 2 1
1 2 3 4     4 3 2 1
1 2 3 4 5 5 4 3 2 1
 * 
 * @author sukh
 *
 */
public class L_Pattern_12 {

  public static void pattern(int n) {
    for (int i = 1; i <= n; i++) {
      int j;
      for (j = 1; j <= i; j++) {
        System.out.print(j + " ");
      }
      for (int k = 1; k <= 2 * n - 2 * i; k++) {
        System.out.print("  ");
      }
      for (int k = j - 1; k >= 1; k--) {
        System.out.print(k + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    pattern(5);
  }

}
