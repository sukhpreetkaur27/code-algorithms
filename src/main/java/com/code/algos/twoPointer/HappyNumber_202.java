package com.code.algos.twoPointer;

/**
 * Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

 

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false
 

Constraints:

1 <= n <= 231 - 1
 * @author sukh
 *
 */
public class HappyNumber_202 {

  /**
   * Time: O(log n)<br>
   * Space: O(1)
   * @param n
   * @return
   */
  public boolean isHappyNumber(int n) {
    int slow = n;
    int fast = n;
    /**
     * This will run some constant # of times.<br>
     * As the max. # 2^31 = 2147483648<br>
     * whose next num = 275, i.e., a 3-digit # <br>
     * As the largest 3 digit # = 999<br>
     * and its next num = 243
     */
    do {
      slow = getNext(n);
      fast = getNext(getNext(fast));
    } while (fast != 1 && slow != fast);
    return fast == 1;
  }

  /**
   * Time: O(log n)<br>
   * Space: O(1)
   * @param n
   * @return
   */
  private int getNext(int n) {
    int s = 0, d;
    while (n > 0) {
      d = n % 10;
      n = n / 10;
      s += d * d;
    }
    return s;
  }

}
