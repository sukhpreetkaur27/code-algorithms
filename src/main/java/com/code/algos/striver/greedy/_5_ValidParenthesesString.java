package com.code.algos.striver.greedy;

/**
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.
 * 
 * @author sukh
 *
 */
public class _5_ValidParenthesesString {

  /**
   * NOTE: <br>
   * Greedy Algo with O(1) space
   */

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param s
   * @return
   */
  public boolean check(String s) {
    /**
     * counts the minimum open parenthesis, <br>
     * which means the number of unbalanced '(' that MUST be paired.
     */
    int lo = 0;
    /**
     * counts the maximum open parenthesis, <br>
     * which means the maximum number of unbalanced '(' that COULD be paired.
     */
    int hi = 0;
    for (char ch : s.toCharArray()) {
      /**
       * count +1 for ( <br>
       * count -1 for * or ) , i.e., balanced (
       */
      lo += ch == '(' ? 1 : -1;
      /**
       * count -1 for ) , i.e., balanced parenthesis <br>
       * count +1 for * or ( , i.e., max open parenthesis to be balanced
       */
      hi += ch == ')' ? -1 : 1;
      /**
       * count of ) > count of * or (
       */
      if (hi < 0) {
        return false;
      }
      /**
       * if count of * > count (
       */
      if (lo < 0) {
        lo = Math.max(lo, 0);
      }
    }
    /**
     * No open parenthesis left to be balanced
     */
    return lo == 0;
  }

}
