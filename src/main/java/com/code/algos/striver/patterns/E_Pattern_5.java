package com.code.algos.striver.patterns;

/**
 * Example 1:

Input: 5

Output:
* * * * *
* * * * 
* * * 
* *  
* 
 * 
 * 
 * @author sukh
 *
 */
public class E_Pattern_5 {

  public void pattern(int n) {
    for (int i = n; i >= 1; i--) {
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }

}
