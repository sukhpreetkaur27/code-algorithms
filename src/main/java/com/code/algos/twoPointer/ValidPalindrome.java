package com.code.algos.twoPointer;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 * @author sukh
 *
 */
public class ValidPalindrome {

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param s
   * @return
   */
  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      char c_left = Character.toLowerCase(s.charAt(left));
      char c_right = Character.toUpperCase(s.charAt(right));

      if (!((c_left >= 97 && c_left <= 122) || (c_left >= 48 && c_left <= 57))) {
        left++;
        continue;
      }
      if (!((c_right >= 97 && c_right <= 122) || (c_right >= 48 && c_right <= 57))) {
        right--;
        continue;
      }

      if (c_left != c_right) {
        return false;
      }
    }
    return true;
  }

}
