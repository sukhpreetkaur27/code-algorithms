package com.code.algos.striver.patterns;

/**
 * 
 * Example 1:

Input: 5

Output:

    * 
   * * 
  * * * 
 * * * * 
* * * * * 
* * * * * 
 * * * * 
  * * * 
   * * 
    * 

 * 
 * @author sukh
 *
 */
public class I_Pattern_9 {

  public static void pattern(int n) {
    for (int i = n; i >= 1; i--) {
      for (int j = 1; j < i; j++) {
        System.out.print(" ");
      }
      for (int k = i; k <= n; k++) {
        System.out.print("* ");
      }
      System.out.println();
    }
    for (int i = n; i >= 1; i--) {
      for (int j = i; j < n; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= i; k++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    pattern(5);
  }
}
