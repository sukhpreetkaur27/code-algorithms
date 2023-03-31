package com.code.algos.bits;

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.

 

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5
 

Constraints:

-1000 <= a, b <= 1000
 * 
 * @author sukh
 *
 */
public class SumOfTwoIntegers {

  /**
   * Time: O(1) <br>
   * because each integer contains 3232 bits. <br>
   * Space: O(1)
   * @param a
   * @param b
   * @return
   */
  public int getSum(int a, int b) {
    int x = Math.abs(a);
    int y = Math.abs(b);

    if (x < y) {
      return getSum(b, a);
    }

    int sign = 1;
    if (a < 0) {
      sign = -1;
    }

    int ans;
    int carry;
    if ((a <= 0 && b <= 0) || (a >= 0 && b >= 0)) {
      // sum
      while (y != 0) {
        ans = x ^ y;
        carry = (x & y) << 1;
        x = ans;
        y = carry;
      }
    } else {
      // difference
      while (y != 0) {
        ans = x ^ y;
        carry = ((~x) & y) << 1;
        x = ans;
        y = carry;
      }
    }

    return x * sign;
  }

}
