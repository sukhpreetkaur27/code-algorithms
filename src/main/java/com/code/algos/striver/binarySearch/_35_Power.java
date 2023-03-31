package com.code.algos.striver.binarySearch;

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
public class _35_Power {

  /**
   * NOTE: x^n <br>
   * if n = 2*a --> (x^a)^2 = x^n
   */

  /**
   * Time: O(log n)<br>
   * Space: O(1)
   * @param x
   * @param n
   * @return
   */
  public double power(double x, int n) {
    long N = n;
    if (n < 0) {
      N = -n;
      x = 1 / x;
    }
    double ans = 1;
    double curr = x;
    for (long i = N; i > 0; i /= 2) {
      if (i % 2 == 1) {
        ans *= curr;
      }
      curr = curr * curr;
    }
    return ans;
  }

}
