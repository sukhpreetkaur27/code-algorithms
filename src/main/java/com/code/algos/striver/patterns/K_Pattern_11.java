package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 5

Output:
1 
0 1 
1 0 1
0 1 0 1 
1 0 1 0 1
 * 
 * @author sukh
 *
 */
public class K_Pattern_11 {

  public void pattern(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = i; j >= 1; j--) {
        System.out.print(j % 2 + " ");
      }
      System.out.println();
    }
  }

}
