package com.code.algos.striver.recursion.backtrack;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase English letters only.
 * 
 * @author sukh
 *
 */
public class _9_PalindromePartitioning_MinCuts {

  /**
   * Time: O((2^n) * n) <br>
   * in the worst case, all subsets are palindrome <br>
   * Space: O(n)
   * @param s
   * @return
   */
  public int minCut(String s) {
    int min = backtrack(s, 0, s.length());
    return min;
  }

  private int backtrack(String s, int index, int min) {
    if (index == s.length() || isPalindrome(s, index, s.length() - 1)) {
      return 0;
    }
    for (int cut = index; cut < s.length(); cut++) {
      if (isPalindrome(s, index, cut)) {
        int count = 1 + backtrack(s, cut + 1, min);
        min = Math.min(min, count);
      }
    }
    return min;
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
