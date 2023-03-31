package com.code.algos.striver.basicMaths;

/**
 * 
 * Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.
 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 * 
 * @author sukh
 *
 */
public class C_Palindrome_1 {

  /**
   * Only check the reverse of second half == first half<br>
   * Time: O(log10 n)<br>
   * as We divide the input by 10 for every iteration<br>
   * Space: O(1)
   * @param n
   * @return
   */
  public boolean isPalindrome(int n) {
    /**
     * Edge cases:<br>
     * 1. negative numbers, i.e., -123<br>
     * 2. numbers ending with 0, except 0
     */
    if (n < 0 || (n % 10 == 0 && n != 0)) {
      return false;
    }
    int rev = 0;
    /**
     * Till n becomes less than rev
     */
    while (n > rev) {
      rev = rev * 10 + n % 10;
      n /= 10;
    }
    /**
     * 1. Odd # of digits: 1221 --> reverse == n<br>
     * 2. Even # of digits: 12321 --> reverse/10 == n
     */
    return rev == n || (n == rev / 10);
  }

}
