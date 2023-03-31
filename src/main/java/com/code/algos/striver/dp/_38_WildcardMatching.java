package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
 * 
 * @author sukh
 *
 */
public class _38_WildcardMatching {

  /**
   * Time: O(exponential) <br>
   * Space: O(n + m)
   * 
   * @param s
   * @param p
   * @return
   */
  public boolean isMatch_recursion(String s, String p) {
    /**
     * Recursion: TLE
     */
    char[] s1 = s.toCharArray();
    char[] s2 = p.toCharArray();
    int l1 = s1.length;
    int l2 = s2.length;
    return isMatch_recursive(s1, s2, l1 - 1, l2 - 1);
  }

  private boolean isMatch_recursive(char[] s1, char[] s2, int index1, int index2) {
    /**
     * if Pattern gets exhausted
     */
    if (index2 < 0) {
      /**
       * if both pattern and string gets exhausted --> return true, else false
       */
      if (index1 < 0) {
        return true;
      }
      return false;
    }
    /**
     * if string gets exhausted, check for pattern with characters != '*' --> return
     * false, else true
     * 
     * eg:
     * 
     * pattern = ***** --> true
     * 
     * pattern = a**** --> false
     */
    if (index1 < 0) {
      if (s2[index2] == '*') {
        for (int i = index2 - 1; i >= 0; i--) {
          if (s2[i] != '*') {
            return false;
          }
        }
        return true;
      }
      return false;
    }
    /**
     * Match Case
     */
    if (s1[index1] == s2[index2] || s2[index2] == '?') {
      return isMatch_recursive(s1, s2, index1 - 1, index2 - 1);
    }
    /**
     * '*' == 0 or more characters
     * 
     * go recursively for 0 or 1 character
     */
    if (s2[index2] == '*') {
      return isMatch_recursive(s1, s2, index1 - 1, index2)
          || isMatch_recursive(s1, s2, index1, index2 - 1);
    }
    /**
     * Mismatch Case
     */
    return false;
  }

  /**
   * Time: O(n * m) <br>
   * Space: O(n * m) + O(n + m)
   * 
   * @param s
   * @param p
   * @return
   */
  public boolean isMatch_memoization(String s, String p) {
    /**
     * Memoization
     */
    char[] s1 = s.toCharArray();
    char[] s2 = p.toCharArray();
    int l1 = s1.length;
    int l2 = s2.length;
    int[][] dp = new int[l1][l2];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return isMatch_memoize(s1, s2, l1 - 1, l2 - 1, dp);
  }

  private boolean isMatch_memoize(char[] s1, char[] s2, int index1, int index2,
      int[][] dp) {
    if (index2 < 0) {
      if (index1 < 0) {
        return true;
      }
      return false;
    }
    if (index1 < 0) {
      if (s2[index2] == '*') {
        for (int i = index2 - 1; i >= 0; i--) {
          if (s2[i] != '*') {
            return false;
          }
        }
        return true;
      }
      return false;
    }
    boolean flag = false;
    if (dp[index1][index2] != -1) {
      return dp[index1][index2] == 1 ? true : false;
    }
    if (s1[index1] == s2[index2] || s2[index2] == '?') {
      flag = isMatch_memoize(s1, s2, index1 - 1, index2 - 1, dp);
    } else if (s2[index2] == '*') {
      flag = isMatch_memoize(s1, s2, index1 - 1, index2, dp)
          || isMatch_memoize(s1, s2, index1, index2 - 1, dp);
    }
    dp[index1][index2] = flag ? 1 : 0;
    return flag;
  }

  /**
   * Time: O(n * m) <br>
   * Space: O(n * m)
   * 
   * @param s
   * @param p
   * @return
   */
  public boolean isMatch_tabulation(String s, String p) {
    /**
     * Tabulation
     */
    char[] s1 = s.toCharArray();
    char[] s2 = p.toCharArray();
    int l1 = s1.length;
    int l2 = s2.length;
    boolean[][] dp = new boolean[l1 + 1][l2 + 1];
    dp[0][0] = true;
    for (int i = 1; i <= l2 && s2[i - 1] == '*'; i++) {
      dp[0][i] = true;
    }
    for (int index1 = 1; index1 <= l1; index1++) {
      for (int index2 = 1; index2 <= l2; index2++) {
        if (s1[index1 - 1] == s2[index2 - 1] || s2[index2 - 1] == '?') {
          dp[index1][index2] = dp[index1 - 1][index2 - 1];
        } else if (s2[index2 - 1] == '*') {
          dp[index1][index2] = dp[index1 - 1][index2] || dp[index1][index2 - 1];
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
   * @param p
   * @return
   */
  public boolean isMatch_optimal(String s, String p) {
    /**
     * Space Optimization
     */
    char[] s1 = s.toCharArray();
    char[] s2 = p.toCharArray();
    int l1 = s1.length;
    int l2 = s2.length;
    boolean[] dp = new boolean[l2 + 1];
    boolean[] curr = new boolean[l2 + 1];
    dp[0] = true;
    for (int i = 1; i <= l2 && s2[i - 1] == '*'; i++) {
      dp[i] = true;
    }
    for (int index1 = 1; index1 <= l1; index1++) {
      for (int index2 = 1; index2 <= l2; index2++) {
        if (s1[index1 - 1] == s2[index2 - 1] || s2[index2 - 1] == '?') {
          curr[index2] = dp[index2 - 1];
        } else if (s2[index2 - 1] == '*') {
          curr[index2] = dp[index2] || curr[index2 - 1];
        } else {
          curr[index2] = false;
        }
      }
      for (int index2 = 0; index2 <= l2; index2++) {
        dp[index2] = curr[index2];
      }
    }
    return dp[l2];
  }

}
