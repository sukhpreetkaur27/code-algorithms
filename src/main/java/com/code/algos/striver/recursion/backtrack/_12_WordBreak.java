package com.code.algos.striver.recursion.backtrack;

import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 * 
 * @author sukh
 *
 */
public class _12_WordBreak {

  /**
   * Time: O(n^3) <br>
   * Space: O(n)
   * @param s
   * @param wordDict
   * @return
   */
  public boolean wordBreak(String s, List<String> wordDict) {
    return backtrack(s, wordDict, 0, new Boolean[s.length()]);
  }

  private boolean backtrack(String s, List<String> wordDict, int index, Boolean[] memo) {
    if (index == s.length()) {
      return true;
    }
    if (memo[index] != null) {
      return memo[index];
    }
    for (int i = index; i < s.length(); i++) {
      if (wordDict.contains(s.substring(index, i + 1)) && backtrack(s, wordDict, i + 1, memo)) {
        return memo[index] = true;
      }
    }
    return memo[index] = false;
  }

  /**
   * NOTE: this results into TLE for larger inputs; hence use above memoization approach
   */

  /**
   * Time: O(2^n) <br>
   * Space: O(n)
   * @param s
   * @param wordDict
   * @return
   */
  public boolean wordBreakWithoutMemo(String s, List<String> wordDict) {
    return backtrack(s, wordDict, 0);
  }

  private boolean backtrack(String s, List<String> wordDict, int index) {
    if (index == s.length()) {
      return true;
    }
    for (int i = index; i < s.length(); i++) {
      if (wordDict.contains(s.substring(index, i + 1)) && backtrack(s, wordDict, i + 1)) {
        return true;
      }
    }
    return false;
  }

}
