package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given a boolean expression S of length N with following symbols.
Symbols
    'T' ---> true
    'F' ---> false
and following operators filled between symbols
Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

 

Example 1:

Input: N = 7
S = T|T&F^T
Output: 4
Explaination: The expression evaluates 
to true in 4 ways ((T|T)&(F^T)), 
(T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
Example 2:

Input: N = 5
S = T^F|F
Output: 2
Explaination: ((T^F)|F) and (T^(F|F)) are the 
only ways.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function countWays() which takes N and S as input parameters 
and returns number of possible ways modulo 1003.

 

Expected Time Complexity: O(N3)
Expected Auxiliary Space: O(N2)

 

Constraints:
1 ≤ N ≤ 200 
 * 
 * @author sukh
 *
 */
public class _54_BooleanParenthesization {

  private static final int MOD = (int) 1e3 + 3;

  /**
   * Time: exponential
   * 
   * @param N
   * @param S
   * @return
   */
  public int countWays_recursion(int N, String S) {
    /**
     * Recursion: TLE
     */
    /**
     * Algorithm:
     * 
     * partition the expression on operators and check for T or F as per
     * requirement, with the initial requirement as T
     * 
     * # of ways to get T with & = left_true * right_true <br>
     * # of ways to get F with & = (left_true * right_false) + (left_false *
     * right_true) + (left_false * right_false)
     * 
     * # of ways to get T with | = (left_true * right_true) + (left_true *
     * right_false) + (left_false * right_true) <br>
     * # of ways to get F with | = left_false * right_false
     * 
     * # of ways to get T with ^ = (left_true * right_false) + (left_false *
     * right_true) <br>
     * # of ways to get F with ^ = (left_false * right_false) + (left_true *
     * right_true)
     */
    char[] expr = S.toCharArray();
    return ways_recursive(expr, 0, N - 1, 1);
  }

  private int ways_recursive(char[] expr, int start, int end, int isTrue) {
    if (start > end) {
      return 0;
    }
    if (start == end) {
      if (isTrue == 1) {
        return expr[start] == 'T' ? 1 : 0;
      }
      return expr[start] == 'F' ? 1 : 0;
    }
    int ways = 0;
    int left_true = 0;
    int right_true = 0;
    int left_false = 0;
    int right_false = 0;
    for (int partition = start + 1; partition < end; partition += 2) {
      if (expr[partition] == '&') {
        left_true = ways_recursive(expr, start, partition - 1, 1);
        right_true = ways_recursive(expr, partition + 1, end, 1);
        if (isTrue == 1) {
          ways += (left_true * right_true);
        } else {
          left_false = ways_recursive(expr, start, partition - 1, 0);
          right_false = ways_recursive(expr, partition + 1, end, 0);
          ways += (left_true * right_false) + (left_false * right_true)
              + (left_false * right_false);
        }
      } else if (expr[partition] == '|') {
        left_true = ways_recursive(expr, start, partition - 1, 1);
        right_true = ways_recursive(expr, partition + 1, end, 1);
        left_false = ways_recursive(expr, start, partition - 1, 0);
        right_false = ways_recursive(expr, partition + 1, end, 0);
        if (isTrue == 1) {
          ways += (left_true * right_true) + (left_true * right_false)
              + (left_false * right_true);
        } else {
          ways += (left_false * right_false);
        }
      } else if (expr[partition] == '^') {
        left_true = ways_recursive(expr, start, partition - 1, 1);
        right_true = ways_recursive(expr, partition + 1, end, 1);
        left_false = ways_recursive(expr, start, partition - 1, 0);
        right_false = ways_recursive(expr, partition + 1, end, 0);
        if (isTrue == 1) {
          ways += (left_true * right_false) + (left_false * right_true);
        } else {
          ways += (left_false * right_false) + (left_true * right_true);
        }
      }
    }
    return ways;
  }

  /**
   * Time: O(n * n * 2 * n) <br>
   * Space: O(n * n * 2) + O(n)
   * 
   * @param N
   * @param S
   * @return
   */
  public int countWays_memoization(int N, String S) {
    /**
     * Memoization
     */
    char[] expr = S.toCharArray();
    int[][][] dp = new int[N][N][2];
    for (int[][] i : dp) {
      for (int[] j : i) {
        Arrays.fill(j, -1);
      }
    }
    return ways(expr, 0, N - 1, 1, dp);
  }

  private int ways(char[] expr, int start, int end, int isTrue, int[][][] dp) {
    if (start > end) {
      return 0;
    }
    if (start == end) {
      if (isTrue == 1) {
        return expr[start] == 'T' ? 1 : 0;
      }
      return expr[start] == 'F' ? 1 : 0;
    }
    if (dp[start][end][isTrue] != -1) {
      return dp[start][end][isTrue];
    }
    int ways = 0;
    int left_true = 0;
    int right_true = 0;
    int left_false = 0;
    int right_false = 0;
    for (int partition = start + 1; partition < end; partition += 2) {
      if (expr[partition] == '&') {
        left_true = ways(expr, start, partition - 1, 1, dp) % MOD;
        right_true = ways(expr, partition + 1, end, 1, dp) % MOD;
        if (isTrue == 1) {
          ways += (left_true * right_true) % MOD;
        } else {
          left_false = ways(expr, start, partition - 1, 0, dp) % MOD;
          right_false = ways(expr, partition + 1, end, 0, dp) % MOD;
          ways += (left_true * right_false) % MOD + (left_false * right_true) % MOD
              + (left_false * right_false) % MOD;
        }
      } else if (expr[partition] == '|') {
        left_true = ways(expr, start, partition - 1, 1, dp) % MOD;
        right_true = ways(expr, partition + 1, end, 1, dp) % MOD;
        left_false = ways(expr, start, partition - 1, 0, dp) % MOD;
        right_false = ways(expr, partition + 1, end, 0, dp) % MOD;
        if (isTrue == 1) {
          ways += (left_true * right_true) % MOD + (left_true * right_false) % MOD
              + (left_false * right_true) % MOD;
        } else {
          ways += (left_false * right_false) % MOD;
        }
      } else if (expr[partition] == '^') {
        left_true = ways(expr, start, partition - 1, 1, dp) % MOD;
        right_true = ways(expr, partition + 1, end, 1, dp) % MOD;
        left_false = ways(expr, start, partition - 1, 0, dp) % MOD;
        right_false = ways(expr, partition + 1, end, 0, dp) % MOD;
        if (isTrue == 1) {
          ways += (left_true * right_false) % MOD + (left_false * right_true) % MOD;
        } else {
          ways += (left_false * right_false) % MOD + (left_true * right_true) % MOD;
        }
      }
    }
    return dp[start][end][isTrue] = ways % MOD;
  }

}
