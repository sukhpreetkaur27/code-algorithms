package com.code.algos.striver.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.


Example 1:

Input:
N = 6
start[] = {1,3,0,5,8,5}
end[] =  {2,4,6,7,9,9}
Output: 
4
Explanation:
Maximum four meetings can be held with
given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
Example 2:

Input:
N = 3
start[] = {10, 12, 20}
end[] = {20, 25, 30}
Output: 
1
Explanation:
Only one meetings can be held
with given start and end timings.

Your Task :
You don't need to read inputs or print anything. Complete the function maxMeetings() that takes two arrays start[] and end[] along with their size N as input parameters 
and returns the maximum number of meetings that can be held in the meeting room.


Expected Time Complexity : O(N*LogN)
Expected Auxilliary Space : O(N)


Constraints:
1 ≤ N ≤ 105
0 ≤ start[i] < end[i] ≤ 105
 * 
 * @author sukh
 *
 */
public class _6_NMeetingsInOneRoom {

  /**
   * Time: O(n + n log n + n) <br>
   * Space: O(n)
   * 
   * @param start
   * @param end
   * @param n
   * @return
   */
  public static int maxMeetings(int start[], int end[], int n) {
    Meet[] arr = new Meet[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new Meet(start[i], end[i], i + 1);
    }

    /**
     * Sort by end time
     */
    Arrays.sort(arr, new MeetComparator());

    int count = 0;
    int prevEnd = -1;
    for (int i = 0; i < n; i++) {
      Meet meet = arr[i];
      if (meet.start > prevEnd) {
        count++;
        prevEnd = meet.end;
      }
    }
    return count;
  }

  public static class MeetComparator implements Comparator<Meet> {
    public int compare(Meet m1, Meet m2) {
      if (m1.end > m2.end) {
        return 1;
      }
      if (m1.end == m2.end) {
        return m1.index - m2.index;
      }
      return -1;
    }
  }

  public static class Meet {
    int start;
    int end;
    int index;

    Meet(int start, int end, int index) {
      this.start = start;
      this.end = end;
      this.index = index;
    }
  }

}
