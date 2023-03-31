package com.code.algos.striver.patterns;

/**
 * Example 1:

Input: 5

Output:
* 
* * 
* * * 
* * * * 
* * * * *
* 
* 
 * @author sukh
 *
 */
public class B_Pattern_2 {

  public void pattern(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }

}
