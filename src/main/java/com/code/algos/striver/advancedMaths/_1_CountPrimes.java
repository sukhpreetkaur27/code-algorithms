package com.code.algos.striver.advancedMaths;

/**
 * Given an integer n, return the number of prime numbers that are strictly less than n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106
 * 
 * @author sukh
 *
 */
public class _1_CountPrimes {

  /**
   * Sieve of Eratosthenes
   */

  /**
   * Time: O(sqrt(n) (log(log n))) <br>
   * Space: O(n)
   * @param n
   * @return
   */
  public int countPrimes(int n) {
    if (n <= 2) {
      return 0;
    }
    boolean[] primes = new boolean[n];
    for (int i = 2; i <= (int) Math.sqrt(n); i++) {
      if (primes[i] == false) {
        for (int j = i * i; j < n; j += i) {
          primes[j] = true;
        }
      }
    }

    int count = 0;
    for (int i = 2; i < n; i++) {
      if (primes[i] == false) {
        count++;
      }
    }
    return count;
  }

}
