package com.code.algos.striver.dp;

/**
 * Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 * 
 * @author sukh
 *
 */
public class _33_MinInsertions_LCPalindromicSubseq {

  public int minInsertions(String s) {
    /**
     * Intuition:
     * 
     * To find minimum changes --> touch minimum differences --> i.e. leave the
     * maximum correct characters (LCS) intact
     */
    /**
     * Algo:
     * 
     * Keep the longest palindromic subsequence intact
     * 
     * tweak the other characters to make the string a palindrome
     * 
     * eg: abcaa
     * 
     * longest palindromic subsequence = a _ _ a a
     * 
     * To make palindrome --> a b a c a b a
     */
    int n = s.length();
    _32_LongestCommonPalindromicSubsequence obj = new _32_LongestCommonPalindromicSubsequence();
    int palindromeSubseqLen = obj.longestPalindromeSubseq(s);
    return n - palindromeSubseqLen;
  }

}
