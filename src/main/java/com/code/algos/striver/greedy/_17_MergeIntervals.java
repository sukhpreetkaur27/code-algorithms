package com.code.algos.striver.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _17_MergeIntervals {

  /**
   * Time: O(n log n) <br>
   * Space: O(n)
   * @param intervals
   * @return
   */
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> {
      return a[0] - b[0];
    });
    List<int[]> list = new ArrayList<>();
    int[] prev = intervals[0];
    for (int[] interval : intervals) {
      /**
       * if i_start <= end
       * <br>
       * end = Math.max(interval[1], prev[1]);
       */
      if (interval[0] <= prev[1]) {
        prev[1] = Math.max(interval[1], prev[1]);
      } else {
        /**
         * if i_start > end
         * <br>
         * add to list
         */
        list.add(prev);
        prev = interval;
      }
    }
    list.add(prev);
    int[][] res = new int[list.size()][];
    return list.toArray(res);
  }

}
