package com.code.algos.striver.twoPointer;

/**
 * Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.
 * 
 * @author sukh
 *
 */
public class _9_SubstringsAll3Chars {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param s
   * @return
   */
  public int numberOfSubstrings(String s) {
    // last index of a, b, c
    int last[] = { -1, -1, -1 };
    int res = 0, n = s.length();
    for (int i = 0; i < n; ++i) {
      last[s.charAt(i) - 'a'] = i;
      res += 1 + Math.min(last[0], Math.min(last[1], last[2]));
    }
    return res;
  }

}
