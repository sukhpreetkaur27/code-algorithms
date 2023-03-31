package com.code.algos.bits;

/**
 * Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

 

Example 1:

Input: left = 5, right = 7
Output: 4
Example 2:

Input: left = 0, right = 0
Output: 0
Example 3:

Input: left = 1, right = 2147483647
Output: 0
 

Constraints:

0 <= left <= right <= 231 - 1
 * 
 * @author sukh
 *
 */
public class BitwiseAndRange_201 {

  /**
   * Time: O(1) <br>
   * because each integer contains 3232 bits. <br>
   * Space: O(1)
   * @param left
   * @param right
   * @return
   */
  public int rangeBitwiseAnd(int left, int right) {
    /**
     * Brian Kernighan's Algo
     */
    while (left < right) {
      right = right & (right - 1);
    }
    return right;
  }

}
