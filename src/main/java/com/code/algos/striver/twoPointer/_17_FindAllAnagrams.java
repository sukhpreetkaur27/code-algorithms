package com.code.algos.striver.twoPointer;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
 * 
 * @author sukh
 *
 */
public class _17_FindAllAnagrams {

  /**
   * Time: O(l1 * l2 * 26) <br>
   * Space: O(1)
   * 
   * @param s1
   * @param s2
   * @return
   */
  public List<Integer> findAnagrams(String s2, String s1) {
    /**
     * Sliding Window
     * 
     * slide the string to be compared(shorter string) on to the larger string
     */
    List<Integer> list = new ArrayList<>();

    int s1_length = s1.length();
    int s2_length = s2.length();
    if (s1_length > s2_length) {
      return list;
    }

    int[] s1_count = new int[26];
    char[] s1_chars = s1.toCharArray();
    for (char ch : s1_chars) {
      s1_count[ch - 'a']++;
    }

    char[] s2_chars = s2.toCharArray();
    int[] s2_count = new int[26];

    int left = 0;
    int right = 0;
    char ch;
    while (right < s2_length) {
      ch = s2_chars[right];
      s2_count[ch - 'a']++;
      if (right - left + 1 == s1_length) {
        if (matches(s1_count, s2_count)) {
          list.add(left);
        }
        ch = s2_chars[left];
        s2_count[ch - 'a']--;
        left++;
        right++;
        continue;
      }
      right++;
    }
    return list;
  }

  private boolean matches(int[] s1_count, int[] s2_count) {
    for (int freq = 0; freq < 26; freq++) {
      if (s1_count[freq] != s2_count[freq]) {
        return false;
      }
    }
    return true;
  }

}
