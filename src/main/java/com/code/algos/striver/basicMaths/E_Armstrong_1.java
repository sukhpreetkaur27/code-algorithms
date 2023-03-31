package com.code.algos.striver.basicMaths;

/**
 * Given an integer n, return true if and only if it is an Armstrong number.

The k-digit number n is an Armstrong number if and only if the kth power of each digit sums to n.

 

Example 1:

Input: n = 153
Output: true
Explanation: 153 is a 3-digit number, and 153 = 13 + 53 + 33.
Example 2:

Input: n = 123
Output: false
Explanation: 123 is a 3-digit number, and 123 != 13 + 23 + 33 = 36.
 

Constraints:

1 <= n <= 108
 * @author sukh
 *
 */
public class E_Armstrong_1 {

  /**
   * Time: O(d); d = # of digits in n<br>
   * Space: O(1)
   * @param n
   * @return
   */
  public boolean isArmstrong(int n) {
    int pow = (int) Math.floor(Math.log10(n) + 1);
    int armstrong = 0;
    int n1 = n;
    while (n1 != 0) {
      armstrong += Math.pow(n1 % 10, pow);
      n1 /= 10;
    }
    return armstrong == n;
  }

}
