package com.code.algos.striver.greedy;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti < endi <= 106
 * 
 * @author sukh
 *
 */
public class _7_MeetingRooms {

  /**
   * Time: O(n log n) <br>
   * Space: O(1)
   * 
   * @param intervals
   * @return
   */
  public boolean canAttendMeetings(int[][] intervals) {
    /**
     * Sort by start time
     */
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int n = intervals.length;
    for (int i = 1; i < n; i++) {
      /**
       * if previous end > next start <br>
       * meetings overlap
       */
      if (intervals[i - 1][1] > intervals[i][0]) {
        return false;
      }
    }
    return true;
  }

}
