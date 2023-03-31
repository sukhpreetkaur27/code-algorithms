package com.code.algos.striver.patterns;

/**
 * Example 1:

Input: 5

Output:
1
2 2 
3 3 3 
4 4 4 4 
5 5 5 5 5
 * 
 * 
 * @author sukh
 *
 */
public class D_Pattern_4 {

  public void pattern(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

}
