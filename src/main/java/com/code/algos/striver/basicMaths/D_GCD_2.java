package com.code.algos.striver.basicMaths;

/**
 * Find gcd of two numbers.
 * 
 * Example 1:
Input: num1 = 4, num2 = 8
Output: 4
Explanation: Since 4 is the greatest number which divides both num1 and num2.

Example 2:
Input: num1 = 3, num2 = 6
Output: 3
Explanation: Since 3 is the greatest number which divides both num1 and num2.
 * 
 * @author sukh
 *
 */
public class D_GCD_2 {

  /**
   * Euclidean's Theorem<br>
   * Time: O(log min(a,b))<br>
   * Space: O(1)
   * @param a
   * @param b
   * @return
   */
  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  public static void main(String[] args) {
    int a = 12, b = 16;
    if (a < b) {
      int gcd = gcd(b, a);
    } else {
      int gcd = gcd(a, b);
    }
  }

}
