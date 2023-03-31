package com.code.algos.striver.greedy;

import java.util.Arrays;

/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to 
 * remove to make the rest of the intervals non-overlapping.

 

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Constraints:

1 <= intervals.length <= 105
intervals[i].length == 2
-5 * 104 <= starti < endi <= 5 * 104
 * 
 * @author sukh
 *
 */
public class _19_NonOverlappingIntervals {

  /**
   * Time: O(n log n) <br>
   * Space: O(1)
   * @param intervals
   * @return
   */
  public int eraseOverlapIntervals(int[][] intervals) {
    /**
     * Sort by start index
     */
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int n = intervals.length;
    int[] prev = intervals[0];
    int count = 0;
    for (int i = 1; i < n; i++) {
      if (intervals[i][0] < prev[1]) {
        /**
         * if current interval is subsumed in the previous, then drop the previous and
         * choose the current <br>
         * why? <br>
         * as we need to find the minimum and choosing a larger interval will remove
         * most of the intervals, but vice-versa will not
         */
        if (intervals[i][1] < prev[1]) {
          prev = intervals[i];
        }
        count++;
      } else {
        prev = intervals[i];
      }
    }
    return count;
  }

}
