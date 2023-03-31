package com.code.algos.striver.advancedMaths;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a number N. Find its unique prime factors in increasing order.
 

Example 1:

Input: N = 100
Output: 2 5
Explanation: 2 and 5 are the unique prime
factors of 100.
Example 2:

Input: N = 35
Output: 5 7
Explanation: 5 and 7 are the unique prime
factors of 35.
 * 
 * @author sukh
 *
 */
public class _2_UniquePrimeFactors {

  /**
   * Time: O(log n + n(log(log n))) <br>
   * Space: O(n)
   * @param n
   * @return
   */
  public int[] allPrimeFactors(int n) {
    int[] sieve = new int[n + 1];
    /**
     * create a sieve of smallest prime factors
     */
    sieve(sieve, n);

    Set<Integer> factors = new TreeSet<>();
    while (n > 1) {
      factors.add(sieve[n]);
      /**
       * divide by smallest prime factor at every step
       */
      n /= sieve[n];
    }
    return factors.stream().mapToInt(Integer::intValue).toArray();
  }

  private void sieve(int[] sieve, int n) {
    sieve[1] = 1;
    /**
     * marking smallest prime factor for every number to be itself.
     */
    for (int i = 2; i <= n; i++) {
      sieve[i] = i;
    }
    /**
     * separately marking smallest prime factor for every even number as 2
     */
    for (int i = 4; i <= n; i += 2) {
      sieve[i] = 2;
    }
    for (int i = 3; i <= n; i++) {
      /**
       * checking if i is prime
       */
      if (sieve[i] == i) {
        /**
         * Handle Integer Overflow
         */
        if (i > 0 && (i * i) < 0) {
          break;
        }
        /**
         * marking smallest prime factor for all numbers divisible by i
         */
        for (int j = i * i; j <= n; j += i) {
          /**
           * marking smallest prime factor[j] if it is not previously marked
           */
          if (sieve[j] == j) {
            sieve[j] = i;
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    _2_UniquePrimeFactors obj = new _2_UniquePrimeFactors();
    int[] factors = obj.allPrimeFactors(95401);
    System.out.println(Arrays.toString(factors));
  }

}
