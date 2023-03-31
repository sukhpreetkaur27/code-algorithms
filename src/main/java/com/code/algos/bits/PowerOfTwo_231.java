package com.code.algos.bits;

public class PowerOfTwo_231 {

  /**
   * Time: O(1)<br>
   * Space: O(1)
   * @param num
   * @return
   */
  public boolean isPowerOfTwo(int num) {
    if (num == 0) {
      return false;
    }
    long x = (long) num;
    return (x & (-x)) == x;
  }

}
