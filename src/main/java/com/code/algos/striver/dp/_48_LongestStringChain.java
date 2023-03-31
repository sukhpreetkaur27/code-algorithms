package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on.
 A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.

 

Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
Example 2:

Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
Example 3:

Input: words = ["abcd","dbqca"]
Output: 1
Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of lowercase English letters.
 * 
 * @author sukh
 *
 */
public class _48_LongestStringChain {
  
  /**
   * NOTE: This is a subset problem.
   */

  /**
   * Time: O(n * n * l) <br>
   * Space: O(n)
   * 
   * @param nums
   * @return
   */
  public int longestStrChain_subsequence(String[] words) {
    /**
     * NOTE: This is an extension to com.code.algos.striver.dp._45_LIS
     */
    /**
     * Algorithm:
     * 
     * LIS[i] = the LIS length from [0, i]
     */
    int n = words.length;
    int[] dp = new int[n];
    /**
     * By default, each element can be a part of an LIS containing the single
     * element only
     */
    Arrays.fill(dp, 1);
    int maxLis = 1;
    for (int index = 0; index < n; index++) {
      for (int prev_index = 0; prev_index < index; prev_index++) {
        if (compare(words[index], words[prev_index])) {
          dp[index] = Math.max(dp[prev_index] + 1, dp[index]);
        }
      }
      maxLis = Math.max(maxLis, dp[index]);
    }
    return maxLis;
  }

  private boolean compare(String next, String prev) {
    int prev_len = prev.length();
    int next_len = next.length();
    if (next_len - prev_len != 1) {
      return false;
    }
    char[] _next = next.toCharArray();
    char[] _prev = prev.toCharArray();
    int mismatch = 0;
    int next_ptr = 0;
    int prev_ptr = 0;
    while (next_ptr < next_len && prev_ptr < prev_len && mismatch < 2) {
      if (_next[next_ptr] == _prev[prev_ptr]) {
        next_ptr++;
        prev_ptr++;
      } else {
        mismatch++;
        next_ptr++;
      }
    }
    return mismatch < 2;
  }

  /**
   * Time: O(n * n * l) + O(n log n) <br>
   * Space: O(n)
   * 
   * @param nums
   * @return
   */
  public int longestStrChain_subset(String[] words) {
    /**
     * NOTE: This is an extension to com.code.algos.striver.dp._45_LIS and
     * com.code.algos.striver.dp._47_LargestDivisibleSubset
     */
    /**
     * Algorithm:
     * 
     * LIS[i] = the LIS length from [0, i]
     */
    int n = words.length;
    /**
     * why sort?
     * 
     * 1. subset == non-contiguous
     * 
     * 2. we have to check divisible or not --> hence, if size(a[i]) > size(a[j]),
     * then word chain can easily be tested
     */
    Arrays.sort(words, (a, b) -> {
      return a.length() - b.length();
    });
    int[] dp = new int[n];
    /**
     * By default, each element can be a part of an LIS containing the single
     * element only
     */
    Arrays.fill(dp, 1);
    int maxLis = 1;
    for (int index = 0; index < n; index++) {
      for (int prev_index = 0; prev_index < index; prev_index++) {
        if (compare(words[index], words[prev_index])) {
          dp[index] = Math.max(dp[prev_index] + 1, dp[index]);
        }
      }
      maxLis = Math.max(maxLis, dp[index]);
    }
    return maxLis;
  }

  public static void main(String[] args) {
    _48_LongestStringChain obj = new _48_LongestStringChain();
    String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
    int max = obj.longestStrChain_subsequence(words);
    System.out.println(max);
  }

}
