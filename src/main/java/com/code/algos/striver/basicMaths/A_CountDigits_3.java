package com.code.algos.striver.basicMaths;

public class A_CountDigits_3 {

  /**
   * Time: O(1)<br>
   * Space: O(1)
   * @param n
   * @return
   */
  public int countDigits(int n) {
    int count = 0;
    count = (int) Math.floor(Math.log10(n) + 1);
    return count;
  }

}
