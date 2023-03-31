package com.code.algos.striver.advancedMaths;

/**
 * A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. 
 * A divisor of an integer x is an integer that can divide x evenly.

Given an integer n, return true if n is a perfect number, otherwise return false.

 

Example 1:

Input: num = 28
Output: true
Explanation: 28 = 1 + 2 + 4 + 7 + 14
1, 2, 4, 7, and 14 are all divisors of 28.
Example 2:

Input: num = 7
Output: false
 

Constraints:

1 <= num <= 108
 * 
 * @author sukh
 *
 */
public class _3_PerfectNumber {

  /**
   * Time: O(sqrt(n)) <br>
   * Space: O(1)
   * @param num
   * @return
   */
  public boolean checkPerfectNumber(int num) {
    if (num <= 1) {
      return false;
    }
    /**
     * 1 is a factor of every number
     */
    int sum = 1;
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        sum += i;
        /**
         * To avoid adding the same number twice
         */
        if (i * i != num) {
          sum += num / i;
        }
      }
    }
    return sum == num;
  }

}
