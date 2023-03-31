package com.code.algos.striver.basicMaths;

public class A_CountDigits_2 {

  /**
   * Time: O(1)<br>
   * Space: O(1)
   * @param n
   * @return
   */
  public int countDigits(int n) {
    int count = 0;
    String s = Integer.toString(n);
    count = s.length();
    return count;
  }

}
