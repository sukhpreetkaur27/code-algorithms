package com.code.algos.striver.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
 * 
 * @author sukh
 *
 */
public class _8_MeetingRoomsII {

  /**
   * Time: O(n log n) <br>
   * Space: O(1)
   * 
   * @param intervals
   * @return
   */
  public int minMeetingRooms(int[][] intervals) {
    /**
     * Sort by start time
     */
    Arrays.sort(intervals, new Comparator<int[]>() {
      public int compare(final int[] a, final int[] b) {
        return a[0] - b[0];
      }
    });

    /**
     * Store end time in a min Heap
     */
    Queue<Integer> minHeap = new PriorityQueue<>();
    minHeap.offer(intervals[0][1]);

    for (int i = 1; i < intervals.length; i++) {
      if (minHeap.peek() <= intervals[i][0]) {
        minHeap.poll();
      }
      minHeap.offer(intervals[i][1]);
    }

    return minHeap.size();
  }

}
