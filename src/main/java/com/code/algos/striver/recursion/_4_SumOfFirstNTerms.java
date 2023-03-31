package com.code.algos.striver.recursion;

/**
 * Given and integer N.
 * 
 * Calculate the sum of series 1^3 + 2^3 + 3^3 + 4^3 + … till N-th term.

Example 1:

Input:
N=5
Output:
225
Explanation:
1^3+2^3+3^3+4^3+5^3=225


 * @author sukh
 *
 */
public class _4_SumOfFirstNTerms {

  /**
   * NOTE: TLE<br>
   * @param N
   * @return
   */
  public long sumOfSeries(long N) {
    if (N < 1) {
      return 0;
    }
    return (long) N * N * N + sumOfSeries(N - 1);
  }
  
  /**
   * Sum of cube of first N natural numbers = [n*(n+1)/2]^2
   * @param n
   * @return
   */
  public long sum(long n) {
    long sum = n * n * (n + 1) * (n + 1) / 4;
    return sum;
  }

}
