package com.code.algos.striver.basicMaths;

/**
 * Given a number, print all the divisors of the number. A divisor is a number that gives remainder as zero when divided.
 * 
 * Example 1:
Input: n = 36
Output: 1 2 3 4 6 9 12 18 36
Explanation: All the divisors of 36 are printed.

Example 2:
Input: n = 97
Output: 1 97
Explanation: Since 97 is a prime number, only 1 and 97 are printed.
 * 
 * @author sukh
 *
 */
public class F_Divisors_1 {

  /**
   * Time: O(sqrt(n))<br>
   * Space: O(1)
   * @param n
   */
  public void findDivisors(int n) {
    /**
     * Square root of a number acts as a splitting point.<br>
     * if n/i == 0, then n/i is also a divisor on the other end of the splitting
     * point.
     */

    for (int i = 1; i <= (int) Math.sqrt(n); i++) {
      if (n % i == 0) {
        System.out.print(i + ", ");
        if (i != n / i) {
          System.out.print(n / i + ", ");
        }
      }
    }
  }

}
