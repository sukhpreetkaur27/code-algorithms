package com.code.algos.striver.bits;

/**
 * Given a positive integer N, determine whether it is odd or even.

 

Example 1:

Input:
N = 1
Output:
odd
Explanation:
The output is self-
explanatory.
 

Example 2:

Input:
N = 2
Output:
even
Explanation:
The output is self-
explanatory.

 * @author sukh
 *
 */
public class _2_OddEven {

  /**
   * Time: O(1) <br>
   * Space: O(1)
   * @param N
   * @return
   */
  public String oddEven(int N) {
    return (N & 1) == 0 ? "even" : "odd";
  }

}
