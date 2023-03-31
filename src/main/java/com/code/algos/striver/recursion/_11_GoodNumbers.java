package com.code.algos.striver.recursion;

/**
 * A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. 
However, "3245" is not good because 3 is at an even index but is not even.
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
Example 2:

Input: n = 4
Output: 400
Example 3:

Input: n = 50
Output: 564908303
 

Constraints:

1 <= n <= 1015
 * 
 * @author sukh
 *
 */
public class _11_GoodNumbers {

  /**
   * NOTE: <br>
   * Since the answer may be large, return it modulo 10^9 + 7.
   */
  private static int MOD = (int) (1e9 + 7);

  /**
   * Time: O(log n) <br>
   * Space: O(1)
   * @param n
   * @return
   */
  public int count(long n) {
    /**
     * Algorithm: <br>
     * Permutation Approach <br>
     * 1. odd position #s allowed: 4 == 2, 3, 5, 7 <br>
     * 2. even position #s allowed: 5 == 0, 2, 4, 6, 8 <br>
     * 
     * 
     * eg: if n = even = 4 <br>
     * # of odds = n/2 = 2 <br>
     * # of evens = n-(n/2) = 2 <br>
     * ans = _ * _ * _ * _ = 5 * 4 * 5 * 4 = 5^(count of even) * 4^(count of odd)
     * 
     * 
     * eg: if n = odd = 5 <br>
     * # of odds = n/2 = 2 <br>
     * # of evens = n-(n/2) = 3 <br>
     * ans = _ * _ * _ * _ * _ = 5 * 4 * 5 * 4 * 5 = 5^(count of even) * 4^(count of
     * odd)
     * 
     */

    long oddCount = n >> 1;
    long evenCount = n - oddCount;

    int ans = (int) ((power(5l, evenCount) * power(4l, oddCount)) % MOD);
    return ans;
  }

  private long power(long x, long n) {
    long ans = 1;
    for (long i = n; i > 0; i /= 2) {
      if ((i & 1) != 0) {
        ans = (ans * x) % MOD;
      }
      x = (x * x) % MOD;
    }
    return ans;
  }

}
