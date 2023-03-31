package com.code.algos.striver.binarySearch;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

 * 
 * @author sukh
 *
 */
public class _2_SquareRoot {

  /**
   * Time: O(log n)<br>
   * Space: O(1)
   * @param x
   * @return
   */
  public int squareroot(int x) {
    if (x < 2) {
      return x;
    }
    int lo = 1;
    int hi = x;
    while (lo <= hi) {
      long mid = lo + (hi - lo) / 2;
      long sq = mid * mid;
      if (sq == x) {
        return (int) mid;
      } else if (sq < x) {
        lo = (int) mid + 1;
      } else {
        hi = (int) mid - 1;
      }
    }
    return hi;
  }

}
