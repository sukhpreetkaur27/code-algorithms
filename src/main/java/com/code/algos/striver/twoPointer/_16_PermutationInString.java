package com.code.algos.striver.twoPointer;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 * 
 * @author sukh
 *
 */
public class _16_PermutationInString {

  /**
   * Time: O(l1 * l2 * 26) <br>
   * Space: O(1)
   * 
   * @param s1
   * @param s2
   * @return
   */
  public boolean checkInclusion(String s1, String s2) {
    /**
     * Sliding Window
     * 
     * slide the string to be compared(shorter string) on to the larger string
     */
    int s1_length = s1.length();
    int s2_length = s2.length();
    if (s1_length > s2_length) {
      return false;
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
          return true;
        }
        ch = s2_chars[left];
        s2_count[ch - 'a']--;
        left++;
        right++;
        continue;
      }
      right++;
    }
    return false;
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
