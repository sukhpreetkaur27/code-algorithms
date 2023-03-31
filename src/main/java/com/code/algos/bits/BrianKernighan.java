package com.code.algos.bits;

/**
 * Count set bits in an integer.
 * @author sukh
 *
 */
public class BrianKernighan {

  /**
   * Time: O(log n) <br>
   * Space: O(1)
   * @param num
   * @return
   */
  public int countSetBits(int num) {
    int count = 0;
    while (num > 0) {
      num &= num - 1;
      count++;
    }
    return count;
  }

}
