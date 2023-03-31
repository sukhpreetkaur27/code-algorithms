package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Fibonacci Series with DP
 * 
 * @author sukh
 *
 */
public class _1_FibonacciSeries {

  /**
   * Time: O(n) <br>
   * Space: O(n + n) <br>
   * O(n) for Recursion Stack <br>
   * O(n) for Memoization
   * 
   * @param n
   * @param series
   * @return
   */
  public int fibo_memoization_1(int n, int[] series) {
    /**
     * Recursion - DP (Memoization)
     * 
     * Top-Down Approach
     * 
     * Move from answer to base case
     */
    /**
     * Base Case: n = 0 or n = 1
     */
    if (n <= 1) {
      return series[n] = n;
    }
    /**
     * Apply DP: Check if value is already computed in some previous recursion call
     */
    if (series[n] != -1) {
      return series[n];
    }
    /**
     * Else, compute the value and store it
     */
    return series[n] = fibo_memoization_1(n - 1, series)
        + fibo_memoization_1(n - 2, series);
  }

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * Better than Recursion(Memoization)
   * 
   * @param n
   * @param series
   * @return
   */
  public void fibo_tabulation_2(int n, int[] series) {
    /**
     * Recursion - DP (Tabulation)
     * 
     * Bottom-Up Approach
     * 
     * Move from base case to answer
     */
    /**
     * Base Case: n = 0 or n = 1
     */
    series[0] = 0;
    series[1] = 1;
    /**
     * Other cases
     */
    for (int i = 2; i <= n; i++) {
      series[i] = series[i - 1] + series[i - 2];
    }
  }

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param n
   * @return
   */
  public int fibo_optimal(int n) {
    /**
     * Optimal Approach: Avoid the O(n) Space
     * 
     * Observe a pattern
     * 
     * Use variables
     */
    int prev1 = 0;
    int prev2 = 1;
    for (int i = 2, curr; i <= n; i++) {
      curr = prev1 + prev2;
      prev2 = prev1;
      prev1 = curr;
    }
    return prev1;
  }

  public static void main(String[] args) {
    _1_FibonacciSeries obj = new _1_FibonacciSeries();
    int n = 5;
    /**
     * Memoization array of size n + 1
     * 
     * +1 for 0
     */
    int[] series = new int[n + 1];
    Arrays.fill(series, -1);
    obj.fibo_memoization_1(n, series);
    System.out.println(Arrays.toString(series));
  }

}
