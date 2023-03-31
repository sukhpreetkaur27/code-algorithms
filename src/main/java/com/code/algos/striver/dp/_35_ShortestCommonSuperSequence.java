package com.code.algos.striver.dp;

/**
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

 

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters.
 * 
 * @author sukh
 *
 */
public class _35_ShortestCommonSuperSequence {

  public String shortestCommonSupersequence(String str1, String str2) {
    int l1 = str1.length();
    int l2 = str2.length();
    _29_LCS obj = new _29_LCS();
    int[][] dp = obj.longestCommonSubsequence_tabulation1(str1, str2);
    /**
     * Length of Super Sequence -> count the LCS once
     * 
     * l1 + l2 - lcs_length
     */
    int super_len = l1 + l2 - dp[l1][l2];
    StringBuilder sb = new StringBuilder();
    int index1 = l1;
    int index2 = l2;
    char[] s1 = str1.toCharArray();
    char[] s2 = str2.toCharArray();
    /**
     * if there is a mismatch, move to the max of previous row or previous column
     * 
     * and print the character which we leave
     */
    while (index1 > 0 && index2 > 0) {
      if (s1[index1 - 1] == s2[index2 - 1]) {
        sb.append(s1[index1 - 1]);
        index1 = index1 - 1;
        index2 = index2 - 1;
      } else if (dp[index1 - 1][index2] > dp[index1][index2 - 1]) {
        sb.append(s1[index1 - 1]);
        index1 = index1 - 1;
      } else {
        sb.append(s2[index2 - 1]);
        index2 = index2 - 1;
      }
    }
    while (index1 > 0) {
      sb.append(s1[index1 - 1]);
      index1--;
    }
    while (index2 > 0) {
      sb.append(s2[index2 - 1]);
      index2--;
    }
    return sb.reverse().toString();
  }

}
