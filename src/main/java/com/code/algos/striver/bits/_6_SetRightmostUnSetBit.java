package com.code.algos.striver.bits;

/**
 * Given a non-negative number N. The problem is to set the rightmost unset bit in the binary representation of N. 
 * If there are no unset bits, then just leave the number as it is.

Example 1:

Input:
N = 6
Output:
7
Explanation:
The binary representation of 6 is 110.
After setting right most bit it becomes
111 which is 7.
Example 2:

Input:
N = 15
Output:
15
Explanation:
The binary representation of 15 is 1111.
As there is no unset bit it remains the
same.
 * 
 * @author sukh
 *
 */
public class _6_SetRightmostUnSetBit {

  /**
   * Time: O(1) <br>
   * Space: O(1)
   * @param n
   * @return
   */
  public int setBit(int n) {
    /**
     * Check if all bits are set in a number <br>
     * eg: 7 = 0111 <br>
     * 7 + 1 = 8 = 1000 <br>
     * it sets the MSB, which isn't required
     */
    if ((n & (n + 1)) == 0) {
      return n;
    }
    return n | (n + 1);
  }

}
