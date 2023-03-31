package com.code.algos.striver.binarySearch;

public class _3_NthRoot {

  /**
   * Time: O(n log [n*10^d])<br>
   * d = decimal places<br>
   * Space: O(1)
   * @param m
   * @param n
   * @return
   */
  public double root(int m, int n) {
    double lo = 1;
    double hi = m;
    /**
     * NOTE: at max 5 decimal places
     */
    double diff = 1e-10;

    while ((hi - lo) > diff) {
      double mid = lo + (hi - lo) / 2;
      double prod = multiply(mid, n);
      if (prod < m) {
        lo = mid;
      } else {
        hi = mid;
      }
    }
    return hi;
  }

  private double multiply(double mid, int n) {
    double prod = 1;
    for (int i = 1; i <= n; i++) {
      prod *= mid;
    }
    return prod;
  }

}
