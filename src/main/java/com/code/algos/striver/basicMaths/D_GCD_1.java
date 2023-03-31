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
public class D_GCD_1 {

  /**
   * Time: O(min(a,b))<br>
   * Space: O(1)
   * @param a
   * @param b
   * @return
   */
  public int gcd(int a, int b) {
    int ans = 1;
    int div = Math.min(a, b);
    for (int i = 2; i <= div; i++) {
      if (a % i == 0 && b % i == 0) {
        ans = i;
      }
    }
    return ans;
  }

}
