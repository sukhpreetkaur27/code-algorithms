package com.code.algos.recursion;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
-104 <= xn <= 104
 * 
 * @author sukh
 *
 */
public class Power_50 {

  /**
   * Time: O(log n)<br>
   * Space: O(log n)
   * @param x
   * @param n
   * @return
   */
  public double pow(int x, int n) {
    if (n < 0) {
      x = 1 / x;
      n = -n;
    }
    return fastPow(x, n);
  }

  public double fastPow(int x, int n) {
    if (n == 0) {
      return 1.0;
    }
    double half = fastPow(x, n / 2);
    if (n % 2 == 0) {
      return half * half;
    } else {
      return half * half * x;
    }
  }

}
