package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase English letters only.
 * 
 * @author sukh
 *
 */
public class _55_PalindromePartitioning_II {

  /**
   * Time: Exponential
   * 
   * @param s
   * @return
   */
  public int minCut_recursion(String s) {
    /**
     * Recursion: TLE
     */
    /**
     * Algorithm:
     * 
     * Front Partitioning
     * 
     * start from the front partition and check for palindrome
     * 
     * NOTE: a single character is in itself a palindrome
     */
    /**
     * for the last character it will partition and return 1
     * 
     * so just -1 to the answer
     */
    return cuts_recursive(s.toCharArray(), 0) - 1;
  }

  private int cuts_recursive(char[] s, int index) {
    if (index == s.length) {
      return 0;
    }
    int min = (int) 1e9;
    for (int i = index, count = 0; i < s.length; i++) {
      if (isPalindrome(s, index, i)) {
        count = 1 + cuts_recursive(s, i + 1);
        min = Math.min(min, count);
      }
    }
    return min;
  }

  private boolean isPalindrome(char[] s, int start, int end) {
    while (start < end) {
      if (s[start] != s[end]) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  /**
   * Time: O(n * n) <br>
   * Space: O(n) + O(n)
   * 
   * @param s
   * @return
   */
  public int minCut_memoization(String s) {
    /**
     * Memoization
     */
    int[] dp = new int[s.length()];
    Arrays.fill(dp, -1);
    return cuts_memoize(s.toCharArray(), 0, dp) - 1;
  }

  private int cuts_memoize(char[] s, int index, int[] dp) {
    if (index == s.length) {
      return 0;
    }
    if (dp[index] != -1) {
      return dp[index];
    }
    int min = (int) 1e9;
    for (int i = index, count = 0; i < s.length; i++) {
      if (isPalindrome(s, index, i)) {
        count = 1 + cuts_memoize(s, i + 1, dp);
        min = Math.min(min, count);
      }
    }
    return dp[index] = min;
  }

  /**
   * Time: O(n * n) <br>
   * Space: O(n)
   * 
   * @param s
   * @return
   */
  public int minCut_tabulation(String s) {
    /**
     * Tabulation
     */
    int n = s.length();
    int[] dp = new int[n + 1];
    char[] ss = s.toCharArray();
    for (int index = n - 1, count = 0, min = 0; index >= 0; index--) {
      min = (int) 1e9;
      for (int i = index; i < n; i++) {
        if (isPalindrome(ss, index, i)) {
          count = 1 + dp[i + 1];
          min = Math.min(min, count);
        }
      }
      dp[index] = min;
    }
    return dp[0] - 1;
  }

}
