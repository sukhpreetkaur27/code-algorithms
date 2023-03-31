package com.code.algos.striver.twoPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) 
 * is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?
 * 
 * @author sukh
 *
 */
public class _13_MinWindowSubstring {

  /**
   * Time: O(s+t) <br>
   * Space: O(s+t)
   * 
   * @param s
   * @param t
   * @return
   */
  public String minWindow(String s, String t) {
    /**
     * t character count
     */
    Map<Character, Integer> tmap = new HashMap<>();
    for (char ch : t.toCharArray()) {
      tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
    }

    // k distinct characters
    int k = tmap.size();

    int l = 0;
    int r = 0;
    int n = s.length();
    int count = 0;

    /**
     * s character count
     */
    Map<Character, Integer> smap = new HashMap<>();

    /**
     * min window sub-string
     */
    int min = Integer.MAX_VALUE;
    int minLeft = 0;
    int minRight = 0;

    while (r < n) {
      char ch = s.charAt(r);
      smap.put(ch, smap.getOrDefault(ch, 0) + 1);

      /**
       * if same character count found in both s and t <br>
       * consider it as a distinct character
       */
      if (tmap.containsKey(ch) && smap.get(ch).intValue() == tmap.get(ch).intValue()) {
        count++;
      }

      /**
       * shrink the left window if s_distinct_character_count =
       * t_distinct_character_count
       */
      while (l <= r && count == k) {
        ch = s.charAt(l);

        // min window length
        if (min > r - l + 1) {
          min = r - l + 1;
          minLeft = l;
          minRight = r + 1;
        }

        smap.put(ch, smap.get(ch) - 1);

        if (tmap.containsKey(ch) && smap.get(ch).intValue() < tmap.get(ch).intValue()) {
          count--;
        }

        l++;
      }

      r++;
    }

    return s.substring(minLeft, minRight);
  }

}
