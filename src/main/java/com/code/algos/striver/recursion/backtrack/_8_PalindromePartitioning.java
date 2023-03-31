package com.code.algos.striver.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
 * 
 * @author sukh
 *
 */
public class _8_PalindromePartitioning {

  /**
   * Time: O((2^n) * n) <br>
   * in the worst case, all subsets are palindrome <br>
   * Space: O(n)
   * @param s
   * @return
   */
  public List<List<String>> partition(String s) {
    List<List<String>> list = new ArrayList<>();
    backtrack(list, s, 0, new ArrayList<>(s.length()));
    return list;
  }

  private void backtrack(List<List<String>> list, String s, int index, List<String> temp) {
    if (index == s.length()) {
      List<String> subset = new ArrayList<>();
      subset.addAll(temp);
      list.add(subset);
      return;
    }
    for (int cut = index; cut < s.length(); cut++) {
      if (isPalindrome(s, index, cut)) {
        temp.add(s.substring(index, cut + 1));
        backtrack(list, s, cut + 1, temp);
        temp.remove(temp.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

}
