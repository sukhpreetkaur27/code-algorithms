package com.code.algos.striver.bits;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. 
For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. 
For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

 

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 

Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0
 * 
 * @author sukh
 *
 */
public class _9_DivideTwoIntegers {

  /**
   * Time: O(log n) <br>
   * Space: O(1)
   * @param dividend
   * @param divisor
   * @return
   */
  public int divide(int dividend, int divisor) {
    /**
     * Divide 93706 by 157
     */
    
    /**
     * Edge case to avoid overflow
     */
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    /**
     * Since, negatives have a greater range than positives, we prefer it to the
     * other.
     */
    int negatives = 2;
    if (dividend > 0) {
      dividend = -dividend;
      negatives--;
    }
    if (divisor > 0) {
      divisor = -divisor;
      negatives--;
    }

    int highestPowerOfTwo = -1;
    int highestDouble = divisor;

    final int HALF_INT_MIN = Integer.MIN_VALUE / 2;

    /**
     * Find the highest power of two (which will be the quotient) of the divisor and
     * the highest double (of the divisor) which divides the dividend
     */
    while (highestDouble >= HALF_INT_MIN && dividend <= (highestDouble << 1)) {
      highestDouble <<= 1;
      highestPowerOfTwo <<= 1;
    }

    int quotient = 0;

    /**
     * Iterate backwards to find for other lesser values <br>
     * On the first step we did this:

157
314
628
1256
2512
5024
10048
20096
40192
80384
160768 # Too big
This left us with a difference of 93706 - 80384 = 13322.

On the second step we repeated this process again with 13322:

157
314
628
1256
2512
5024
10048
20096 # Too big
Notice that we've just recomputed the first seven terms of the doubles again!

Instead of doing this, we should find a way so that we can compute the sequence just once and then use the results from this to compute our quotient.
     */
    while (dividend <= divisor) {
      if (dividend <= highestDouble) {
        quotient += highestPowerOfTwo;
        dividend -= highestDouble;
      }
      highestDouble >>= 1;
      highestPowerOfTwo >>= 1;
    }

    if (negatives != 1) {
      quotient = -quotient;
    }
    return quotient;
  }

}
