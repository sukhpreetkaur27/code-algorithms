package com.code.algos.striver.patterns;

/**
 * Example 1:

Input: 5

Output:
1
1 2 
1 2 3 
1 2 3 4 
1 2 3 4 5
 * 
 * @author sukh
 *
 */
public class C_Pattern_3 {

  public void pattern(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }

}
