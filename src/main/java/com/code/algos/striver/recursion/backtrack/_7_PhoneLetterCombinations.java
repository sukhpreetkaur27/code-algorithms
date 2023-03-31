package com.code.algos.striver.recursion.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 * 
 * @author sukh
 *
 */
public class _7_PhoneLetterCombinations {

  private static Map<Character, String> map = new HashMap<>();

  static {
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqr");
    map.put('8', "stuv");
    map.put('9', "wxyz");
  }

  /**
   * Time: O((4^n) * n) <br>
   * Space: O(n)
   * @param digits
   * @return
   */
  public List<String> combos(String digits) {
    List<String> list = new ArrayList<>();
    /**
     * Edge case
     */
    if (digits.length() > 0) {
      backtrack(list, digits, 0, new StringBuilder());
    }
    return list;
  }

  private void backtrack(List<String> list, String digits, int index, StringBuilder temp) {
    if (index == digits.length()) {
      list.add(temp.toString());
      return;
    }
    char[] chars = map.get(digits.charAt(index)).toCharArray();
    for (char ch : chars) {
      temp.append(ch);
      backtrack(list, digits, index + 1, temp);
      temp.deleteCharAt(temp.length() - 1);
    }
  }

}
