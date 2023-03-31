package com.code.algos.striver.advancedMaths;

/**
 * Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.

An integer m is a divisor of n if there exists an integer k such that n = k * m.

 

Example 1:

Input: n = 2
Output: false
Explantion: 2 has only two divisors: 1 and 2.
Example 2:

Input: n = 4
Output: true
Explantion: 4 has three divisors: 1, 2, and 4.
 

Constraints:

1 <= n <= 104
 * 
 * @author sukh
 *
 */
public class _4_ThreeDivisors {

  /**
   * Time: O(1) <br>
   * Space: O(1)
   * @param num
   * @return
   */
  public boolean isThree(int num) {
    if (num <= 1) {
      return false;
    }
    /**
     * 1 is a factor of every number
     */
    int count = 1;
    for (int i = 2; i <= num; i++) {
      if (num % i == 0) {
        count++;
        if (count > 3) {
          return false;
        }
      }
    }
    return count == 3;

  }

}
