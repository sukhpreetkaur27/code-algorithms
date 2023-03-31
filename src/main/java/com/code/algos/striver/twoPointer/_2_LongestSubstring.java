package com.code.algos.striver.twoPointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 * 
 * @author sukh
 *
 */
public class _2_LongestSubstring {

  /**
   * Optimized <br>
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring(String s) {
    // character-index map
    Map<Character, Integer> char_index = new HashMap<>();
    int res = 0;

    int left = 0;
    int right = 0;
    int len = s.length();
    while (right < len) {
      char ch_r = s.charAt(right);
      Integer index = char_index.get(ch_r);
      // if index exists == repeating characters 
      // shrink left window to index + 1
      if (index != null && index >= left) {
        left = index + 1;
      }
      char_index.put(ch_r, right);
      res = Math.max(res, right - left + 1);
      right++;
    }

    return res;
  }

  /**
   * Better <br>
   * Time: O(2N) <br>
   * Space: O(n)
   * 
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring2(String s) {
    // store frequency per charcter
    Map<Character, Integer> char_counts = new HashMap<>();

    int res = 0;
    int left = 0;
    int right = 0;
    int len = s.length();
    while (right < len) {
      char ch_r = s.charAt(right);
      char_counts.put(ch_r, char_counts.getOrDefault(ch_r, 0) + 1);

      // if frequency > 1 == repeating characters 
      // shrink the left window
      while (char_counts.get(ch_r) > 1) {
        char ch_l = s.charAt(left);
        char_counts.put(ch_l, char_counts.get(ch_l) - 1);
        left++;
      }

      res = Math.max(res, right - left + 1);
      right++;
    }
    return res;
  }

  /**
   * Brute Force <br>
   * Time: O(n^3) <br>
   * 
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring1(String s) {
    int n = s.length();

    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (checkRepetition(s, i, j)) {
          res = Math.max(res, j - i + 1);
        }
      }
    }

    return res;
  }

  // Brute Force
  private boolean checkRepetition(String s, int start, int end) {
    Set<Character> chars = new HashSet<>();

    for (int i = start; i <= end; i++) {
      char c = s.charAt(i);
      if (chars.contains(c)) {
        return false;
      }
      chars.add(c);
    }

    return true;
  }

}
