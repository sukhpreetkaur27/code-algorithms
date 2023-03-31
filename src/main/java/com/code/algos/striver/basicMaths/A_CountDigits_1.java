package com.code.algos.striver.basicMaths;

public class A_CountDigits_1 {

  /**
   * NOTE: There are roughly log10(n) digits in a number.
   */
  /**
   * Time: O(log10(n))<br>
   * Space: O(1)
   * @param n
   * @return
   */
  public int countDigits(int n) {
    int count = 0;
    while (n != 0) {
      n = n / 10;
      count++;
    }
    return count;
  }

}
