package com.code.algos.striver.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
 * 
 * @author sukh
 *
 */
public class _16_ParenthesesGenerator {

  /**
   * Time: O(2^(2n)) <br>
   * At each step we have to choose between ( and ). Hence, we branch into 2 <br>
   * 2n = max length of valid string == depth of the recursion tree <br>
   * Space: O(2n)
   * @param n
   * @return
   */
  public List<String> generate(int n) {
    List<String> res = new ArrayList<>();
    backtrack(res, new StringBuilder(), 0, 0, n);
    return res;
  }

  private void backtrack(List<String> res, StringBuilder curr, int open, int close, int max) {
    if (curr.length() == 2 * max) {
      res.add(curr.toString());
      return;
    }
    if (open < max) {
      curr.append('(');
      backtrack(res, curr, open + 1, close, max);
      curr.deleteCharAt(curr.length() - 1);
    }
    if (close < open) {
      curr.append(')');
      backtrack(res, curr, open, close + 1, max);
      curr.deleteCharAt(curr.length() - 1);
    }
  }

}
