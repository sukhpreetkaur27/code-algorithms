package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 4

Output:
4 4 4 4 4 4 4
4 3 3 3 3 3 4
4 3 2 2 2 3 4
4 3 2 1 2 3 4
4 3 2 2 2 3 4
4 3 3 3 3 3 4
4 4 4 4 4 4 4
 * 
 * @author sukh
 *
 */
public class V_Pattern_22 {

  public void pattern(int n) {
    for (int i = n; i >= 1; i--) {
      for (int j = n - i; j > 0; j--) {
        System.out.print(j + i + " ");
      }
      for (int s = 1; s <= 2 * i - 1; s++) {
        System.out.print(i + " ");
      }
      for (int j = n - i, l = 1; j > 0; j--, l++) {
        System.out.print(l + i);
      }
    }

    for (int i = 2; i <= n; i++) {
      for (int j = n - i; j > 0; j--) {
        System.out.print(j + i + " ");
      }
      for (int s = 1; s <= 2 * i - 1; s++) {
        System.out.print(i + " ");
      }
      for (int j = n - i, l = 1; j > 0; j--, l++) {
        System.out.print(l + i);
      }
    }
  }

}
