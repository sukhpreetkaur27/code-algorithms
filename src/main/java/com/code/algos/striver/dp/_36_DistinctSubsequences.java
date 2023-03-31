package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given two strings s and t, return the number of distinct subsequences of s
 * which equals t.
 * 
 * The test cases are generated so that the answer fits on a 32-bit signed
 * integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "rabbbit", t = "rabbit" Output: 3 Explanation: As shown below,
 * there are 3 ways you can generate "rabbit" from s. rabbbit rabbbit rabbbit
 * Example 2:
 * 
 * Input: s = "babgbag", t = "bag" Output: 5 Explanation: As shown below, there
 * are 5 ways you can generate "bag" from s. babgbag babgbag babgbag babgbag
 * babgbag
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length, t.length <= 1000 s and t consist of English letters.
 * 
 * @author sukh
 *
 */
public class _36_DistinctSubsequences {

  /**
   * Time: exponential <br>
   * # of subsets for s = O(2^n) <br>
   * # of subsets for t = O(2^m) <br>
   * Time = O(2^n) * O(2^m) <br>
   * Space: O(n + m)
   * 
   * @param s
   * @param t
   * @return
   */
  public int numDistinct_recursion(String s, String t) {
    /**
     * Recursion: TLE
     */
    int l1 = s.length();
    int l2 = t.length();
    return count_recursive(s.toCharArray(), t.toCharArray(), l1 - 1, l2 - 1);
  }

  private int count_recursive(char[] s, char[] t, int index1, int index2) {
    if (index2 < 0) {
      return 1;
    }
    if (index1 < 0) {
      return 0;
    }
    /**
     * If match --> 2 cases
     * 
     * 1. you accept the s[index1] as part of the subsequence
     * 
     * 2. you want some other character in s[] == s[index1] = t[index2] ,i.e. look
     * for the matching character on the left of the string s[]
     */
    if (s[index1] == t[index2]) {
      return count_recursive(s, t, index1 - 1, index2 - 1)
          + count_recursive(s, t, index1 - 1, index2);
    }
    /**
     * If mismatch --> look for the t[] character on the left of the string s[]
     */
    return count_recursive(s, t, index1 - 1, index2);
  }

  /**
   * Time: O(n * m) <br>
   * Space: O(n * m) + O(n + m)
   * 
   * @param s
   * @param t
   * @return
   */
  public int numDistinct_memoization(String s, String t) {
    /**
     * Memoization
     */
    int l1 = s.length();
    int l2 = t.length();
    int[][] dp = new int[l1][l2];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return count_memoize(s.toCharArray(), t.toCharArray(), l1 - 1, l2 - 1, dp);
  }

  private int count_memoize(char[] s, char[] t, int index1, int index2, int[][] dp) {
    if (index2 < 0) {
      return 1;
    }
    if (index1 < 0) {
      return 0;
    }
    if (dp[index1][index2] != -1) {
      return dp[index1][index2];
    }
    if (s[index1] == t[index2]) {
      return dp[index1][index2] = count_memoize(s, t, index1 - 1, index2 - 1, dp)
          + count_memoize(s, t, index1 - 1, index2, dp);
    }
    return dp[index1][index2] = count_memoize(s, t, index1 - 1, index2, dp);
  }

  /**
   * Time: O(n * m) <br>
   * Space: O(n * m)
   * 
   * @param s
   * @param t
   * @return
   */
  public int numDistinct_tabulation(String s1, String t1) {
    /**
     * Tabulation
     */
    int l1 = s1.length();
    int l2 = t1.length();
    int[][] dp = new int[l1 + 1][l2 + 1];
    for (int i = 0; i < l1; i++) {
      dp[i][0] = 1;
    }
    char[] s = s1.toCharArray();
    char[] t = t1.toCharArray();
    for (int index1 = 1; index1 <= l1; index1++) {
      for (int index2 = 1; index2 <= l2; index2++) {
        if (s[index1 - 1] == t[index2 - 1]) {
          dp[index1][index2] = dp[index1 - 1][index2 - 1] + dp[index1 - 1][index2];
        } else {
          dp[index1][index2] = dp[index1 - 1][index2];
        }
      }
    }
    return dp[l1][l2];
  }

  /**
   * Time: O(n * m) <br>
   * Space: O(2m)
   * 
   * @param s
   * @param t
   * @return
   */
  public int numDistinct_spaceOptimization(String s1, String t1) {
    /**
     * Space Optimization
     */
    int l1 = s1.length();
    int l2 = t1.length();
    int[] dp = new int[l2 + 1];
    int[] curr = new int[l2 + 1];
    dp[0] = 1;
    char[] s = s1.toCharArray();
    char[] t = t1.toCharArray();
    for (int index1 = 1; index1 <= l1; index1++) {
      for (int index2 = 1; index2 <= l2; index2++) {
        if (s[index1 - 1] == t[index2 - 1]) {
          curr[index2] = dp[index2 - 1] + dp[index2];
        } else {
          curr[index2] = dp[index2];
        }
      }
      for (int index2 = 1; index2 <= l2; index2++) {
        dp[index2] = curr[index2];
      }
    }
    return dp[l2];
  }

  /**
   * Time: O(n * m) <br>
   * Space: O(m)
   * 
   * @param s
   * @param t
   * @return
   */
  public int numDistinct_optimal(String s1, String t1) {
    /**
     * 2D-DP to 1D-DP
     */
    /**
     * as current row's index is dependent on the previous row's previous and
     * current indexes
     * 
     * so we can traverse the indexes in reverse order
     */
    int l1 = s1.length();
    int l2 = t1.length();
    int[] dp = new int[l2 + 1];
    dp[0] = 1;
    char[] s = s1.toCharArray();
    char[] t = t1.toCharArray();
    for (int index1 = 1; index1 <= l1; index1++) {
      for (int index2 = l2; index2 > 0; index2--) {
        if (s[index1 - 1] == t[index2 - 1]) {
          dp[index2] = dp[index2 - 1] + dp[index2];
        }
      }
    }
    return dp[l2];
  }
  
}
