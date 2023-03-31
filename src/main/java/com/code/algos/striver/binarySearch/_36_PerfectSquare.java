package com.code.algos.striver.binarySearch;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.

 

Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false
 

Constraints:

1 <= num <= 2^31 - 1
 * 
 * @author sukh
 *
 */
public class _36_PerfectSquare {

  /**
   * NOTE:<br>
   * For n > 2 the square root a is always less than n/2 and greater than 1: 1 < x
   * < n/2. Since x is an integer, the problem goes down to the search in the
   * sorted set of integer numbers. Binary search is a standard way to proceed in
   * such a situation.
   */

  /**
   * Time: O(log n)<br>
   * Space: O(1)
   * @param n
   * @return
   */
  public boolean isPerfectSquare(int n) {
    if (n == 1) {
      return true;
    }
    int lo = 2;
    int hi = n / 2;
    int mid;
    long sq;
    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;
      sq = (long) mid * mid;
      if (sq == n) {
        return true;
      } else if (sq > n) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return false;
  }

}
