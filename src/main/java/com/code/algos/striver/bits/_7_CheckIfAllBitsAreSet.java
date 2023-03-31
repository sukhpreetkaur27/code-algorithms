package com.code.algos.striver.bits;

public class _7_CheckIfAllBitsAreSet {

  /**
   * Time: O(1) <br>
   * Space: O(1)
   * @param n
   * @return
   */
  public boolean check(int n) {
    return (n & (n + 1)) == 0;
  }

}
