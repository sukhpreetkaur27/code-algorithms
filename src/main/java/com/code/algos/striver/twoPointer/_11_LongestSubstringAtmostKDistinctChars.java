package com.code.algos.striver.twoPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

 

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 

Constraints:

1 <= s.length <= 5 * 104
0 <= k <= 50
 * 
 * @author sukh
 *
 */
public class _11_LongestSubstringAtmostKDistinctChars {

  /**
   * Time: O(n) <br>
   * Space: O(k) <br>
   * k = k + 1 distinct characters
   * 
   * @param s
   * @param k
   * @return
   */
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int l = 0;
    int r = 0;
    int n = s.length();
    int max = 0;

    Map<Character, Integer> map = new HashMap<>();

    while (r < n) {
      char ch = s.charAt(r);
      if (map.getOrDefault(ch, 0) == 0) {
        k--;
      }
      map.put(ch, map.getOrDefault(ch, 0) + 1);
      while (k < 0) {
        ch = s.charAt(l);
        map.put(ch, map.get(ch) - 1);
        if (map.get(ch) == 0) {
          k++;
        }
        l++;
      }

      max = Math.max(max, r - l + 1);
      r++;
    }
    return max;
  }

}
