package com.code.algos.striver.bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _8_SwapTwoNumbers {

  /**
   * Time: O(1) <br>
   * Space: O(1)
   * @param a
   * @param b
   * @return
   */
  public List<Integer> get(int a, int b) {
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    return new ArrayList<>(Arrays.asList(a, b));
  }

}
