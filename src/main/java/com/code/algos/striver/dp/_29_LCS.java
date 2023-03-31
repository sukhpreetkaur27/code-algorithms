package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without 
changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
 * 
 * @author sukh
 *
 */
public class _29_LCS {

  /**
   * Time: O(2^n * 2^m) <br>
   * Space: O(n + m)
   * 
   * Dry-run and check for AB | CD --> At max stack space goes till 4 steps
   * 
   * in short, there can be n deletion from string_1 and m deletions from string_2
   * 
   * NOTE: # of subsets in a string of length n = 2^n
   * 
   * @param text1
   * @param text2
   * @return
   */
  public int longestCommonSubsequence_recursion(String text1, String text2) {
    /**
     * Try all subsequences for both the Strings and compare on the way
     * 
     * Match | Not Match
     */
    /**
     * Recursion: TLE
     */
    int l1 = text1.length();
    int l2 = text2.length();
    return lcs_recursive(text1.toCharArray(), text2.toCharArray(), l1 - 1, l2 - 1);
  }

  private int lcs_recursive(char[] s1, char[] s2, int index1, int index2) {
    /**
     * Base Case
     * 
     * Either goes out of bounds
     */
    if (index1 < 0 || index2 < 0) {
      return 0;
    }
    /**
     * Match
     */
    if (s1[index1] == s2[index2]) {
      return 1 + lcs_recursive(s1, s2, index1 - 1, index2 - 1);
    }
    /**
     * Not Match
     */
    return Math.max(lcs_recursive(s1, s2, index1 - 1, index2),
        lcs_recursive(s1, s2, index1, index2 - 1));
  }

  /**
   * Time: O(n * m) <br>
   * Space: O(n * m) + O(n + m)
   * 
   * @param text1
   * @param text2
   * @return
   */
  public int longestCommonSubsequence_memoization(String text1, String text2) {
    /**
     * Memoization
     */
    int l1 = text1.length();
    int l2 = text2.length();
    int[][] dp = new int[l1][l2];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return lcs_memoize(text1.toCharArray(), text2.toCharArray(), l1 - 1, l2 - 1, dp);
  }

  private int lcs_memoize(char[] s1, char[] s2, int index1, int index2, int[][] dp) {
    if (index1 < 0 || index2 < 0) {
      return 0;
    }
    if (dp[index1][index2] != -1) {
      return dp[index1][index2];
    }
    if (s1[index1] == s2[index2]) {
      return dp[index1][index2] = 1 + lcs_memoize(s1, s2, index1 - 1, index2 - 1, dp);
    }
    return dp[index1][index2] = Math.max(lcs_memoize(s1, s2, index1 - 1, index2, dp),
        lcs_memoize(s1, s2, index1, index2 - 1, dp));
  }

  /**
   * Time: O(n * m) <br>
   * Space: O(n * m) + O(n + m)
   * 
   * @param text1
   * @param text2
   * @return
   */
  public int longestCommonSubsequence_shiftingIndexes(String text1, String text2) {
    /**
     * Shifting of indexes for Tabulation
     * 
     * from 0-based indexing to 1-based indexing
     */
    int l1 = text1.length();
    int l2 = text2.length();
    int[][] dp = new int[l1 + 1][l2 + 1];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return lcs_shiftingIndexes(text1.toCharArray(), text2.toCharArray(), l1, l2, dp);
  }

  private int lcs_shiftingIndexes(char[] s1, char[] s2, int index1, int index2,
      int[][] dp) {
    if (index1 == 0 || index2 == 0) {
      return 0;
    }
    if (dp[index1][index2] != -1) {
      return dp[index1][index2];
    }
    if (s1[index1 - 1] == s2[index2 - 1]) {
      return dp[index1][index2] = 1
          + lcs_shiftingIndexes(s1, s2, index1 - 1, index2 - 1, dp);
    }
    return dp[index1][index2] = Math.max(
        lcs_shiftingIndexes(s1, s2, index1 - 1, index2, dp),
        lcs_shiftingIndexes(s1, s2, index1, index2 - 1, dp));
  }

  /**
   * Time: O(n * m) <br>
   * Space: O(n * m)
   * 
   * @param text1
   * @param text2
   * @return
   */
  public int longestCommonSubsequence_tabulation(String text1, String text2) {
    /**
     * Tabulation
     */
    int l1 = text1.length();
    int l2 = text2.length();
    int[][] dp = new int[l1 + 1][l2 + 1];
    /**
     * Base Case
     * 
     * 1-based indexing
     */
    for (int i = 0; i <= l2; i++) {
      dp[0][i] = 0;
    }
    for (int i = 0; i <= l1; i++) {
      dp[i][0] = 0;
    }
    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();
    for (int index1 = 1; index1 <= l1; index1++) {
      for (int index2 = 1; index2 <= l2; index2++) {
        if (s1[index1 - 1] == s2[index2 - 1]) {
          dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
        } else {
          dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
        }
      }
    }
    return dp[l1][l2];
  }
  
  /**
   * Return the DP tabulation
   */
  public int[][] longestCommonSubsequence_tabulation1(String text1, String text2) {
    /**
     * Tabulation
     */
    int l1 = text1.length();
    int l2 = text2.length();
    int[][] dp = new int[l1 + 1][l2 + 1];
    /**
     * Base Case
     * 
     * 1-based indexing
     */
    for (int i = 0; i <= l2; i++) {
      dp[0][i] = 0;
    }
    for (int i = 0; i <= l1; i++) {
      dp[i][0] = 0;
    }
    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();
    for (int index1 = 1; index1 <= l1; index1++) {
      for (int index2 = 1; index2 <= l2; index2++) {
        if (s1[index1 - 1] == s2[index2 - 1]) {
          dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
        } else {
          dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
        }
      }
    }
    return dp;
  }


  /**
   * Time: O(n * m) <br>
   * Sapce: O(2m)
   * 
   * @param text1
   * @param text2
   * @return
   */
  public int longestCommonSubsequence_optimal(String text1, String text2) {
    /**
     * Space Optimization
     */
    int l1 = text1.length();
    int l2 = text2.length();
    int[] dp = new int[l2 + 1];
    int[] curr = new int[l2 + 1];
    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();
    for (int index1 = 1; index1 <= l1; index1++) {
      for (int index2 = 1; index2 <= l2; index2++) {
        if (s1[index1 - 1] == s2[index2 - 1]) {
          curr[index2] = 1 + dp[index2 - 1];
        } else {
          curr[index2] = Math.max(dp[index2], curr[index2 - 1]);
        }
      }
      for (int index2 = 1; index2 <= l2; index2++) {
        dp[index2] = curr[index2];
      }
    }
    return dp[l2];
  }

}
