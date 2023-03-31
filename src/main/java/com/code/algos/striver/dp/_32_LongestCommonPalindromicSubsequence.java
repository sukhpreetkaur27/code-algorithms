package com.code.algos.striver.dp;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.
 * 
 * @author sukh
 *
 */
public class _32_LongestCommonPalindromicSubsequence {

  /**
   * NOTE: this is an extension to com.code.algos.striver.dp._29_LCS
   **/

  public int longestPalindromeSubseq(String s) {
    /**
     * reverse the string
     * 
     * find LCS in string and its reverse
     */
    int len = s.length();
    char[] s1 = s.toCharArray();
    char[] rev = new char[len];
    for (int i = len - 1, j = 0; i >= 0; i--, j++) {
      rev[j] = s1[i];
    }
    _29_LCS obj = new _29_LCS();
    return obj.longestCommonSubsequence_optimal(s, new String(rev));
  }
  
  /**
   * NOTE: To print use the same methods com.code.algos.striver.dp._30_PrintLCS
   */

}
