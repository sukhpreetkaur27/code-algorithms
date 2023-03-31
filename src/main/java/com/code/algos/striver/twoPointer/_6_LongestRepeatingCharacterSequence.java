package com.code.algos.striver.twoPointer;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. 
 * You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
 * 
 * @author sukh
 *
 */
public class _6_LongestRepeatingCharacterSequence {

  /**
   * Time: O(2N) <br>
   * Space: O(1)
   * @param s
   * @param k
   * @return
   */
  public int characterReplacement(String s, int k) {
    int max = 0;

    int n = s.length();
    int l = 0;
    int r = 0;

    /**
     * NOTE: <br>
     * the sum of all the frequencies = the max length
     */
    int[] charFreq = new int[26];

    // maximum frequency of any fixed repeating character found in a valid window
    int maxFreq = 0;

    while (r < n) {
      // check if the current character has the max frequency in the current window
      maxFreq = Math.max(maxFreq, ++charFreq[s.charAt(r) - 'A']);

      /**
       * length of window = r-l+1 <br>
       * maxFreq = maximum frequency of any fixed repeating character found in a valid
       * window <br>
       * the difference = other characters which could be replaced to the maxFreq
       * character <br>
       * k = max shifts allowed to get the maxFreq character
       */
      if (r - l + 1 - maxFreq > k) {
        // if the above condition is invalid
        // shrink the window from the left while maintaining the window length
        /**
         * Why do we maintain the window length ? <br>
         * Ans: because we are interested in the max length
         */
        --charFreq[s.charAt(l) - 'A'];
        l++;
      }
      max = Math.max(max, r - l + 1);
      r++;
    }

    return max;
  }

}
