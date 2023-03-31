package com.code.algos.twoPointer;

import java.util.Arrays;

public class IntersectionOfArrays_2_350 {

  /**
   * Time: O(n log n + m log m)<br>
   * Space: O(n + m)
   * @param a
   * @param b
   * @return
   */
  public int[] intersection(int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);

    int i = 0, j = 0, k = 0;
    while (i < a.length && j < b.length) {
      if (a[i] < b[j]) {
        i++;
      } else if (a[i] > b[j]) {
        j++;
      } else {
        a[k++] = a[i++];
        j++;
      }
    }
    return Arrays.copyOf(a, k);
  }

}
