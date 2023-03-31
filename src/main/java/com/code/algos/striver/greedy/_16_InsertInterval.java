package com.code.algos.striver.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval 
 * and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals 
(merge overlapping intervals if necessary).

Return intervals after the insertion.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
 * 
 * @author sukh
 *
 */
public class _16_InsertInterval {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param intervals
   * @param newInterval
   * @return
   */
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int n = intervals.length;
    int i = 0;
    int start = newInterval[0];
    int end = newInterval[1];
    List<int[]> list = new ArrayList<>();
    /**
     * if i_end < start 
     * <br>
     * add to list
     */
    while (i < n && intervals[i][1] < start) {
      list.add(intervals[i++]);
    }
    /**
     * if i_start <= end
     *  <br>
     * start = Math.min(start, intervals[i][0]); <br>
     * end = Math.max(end, intervals[i++][1]);
     */
    while (i < n && intervals[i][0] <= end) {
      start = Math.min(start, intervals[i][0]);
      end = Math.max(end, intervals[i++][1]);
    }
    list.add(new int[] { start, end });
    /**
     * Add other elements
     */
    while (i < n) {
      list.add(intervals[i++]);
    }
    return list.toArray(new int[list.size()][2]);
  }

}
