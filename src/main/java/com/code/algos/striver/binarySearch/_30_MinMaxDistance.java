package com.code.algos.striver.binarySearch;

/**
 * You are given an integer array stations that represents the positions of the gas stations on the x-axis. You are also given an integer k.

You should add k new gas stations. You can add the stations anywhere on the x-axis, and not necessarily on an integer position.

Let penalty() be the maximum distance between adjacent gas stations after adding the k new stations.

Return the smallest possible value of penalty(). Answers within 10-6 of the actual answer will be accepted.

 

Example 1:

Input: stations = [1,2,3,4,5,6,7,8,9,10], k = 9
Output: 0.50000
Example 2:

Input: stations = [23,24,36,39,46,56,57,65,84,98], k = 1
Output: 14.00000
 

Constraints:

10 <= stations.length <= 2000
0 <= stations[i] <= 108
stations is sorted in a strictly increasing order.
1 <= k <= 106
 * 
 * @author sukh
 *
 */
public class _30_MinMaxDistance {

  /**
   * Time: O(n log k) <br>
   * k = max distance b/w start and end stations <br>
   * Space: O(1)
   * @param stations
   * @param k
   * @return
   */
  public double minMaxDist(int[] stations, int k) {
    int n = stations.length;

    double lo = 0;
    double hi = stations[n - 1] - stations[0];

    double ans = 0;
    double mid;
    /**
     * BS Template III
     */
    while ((hi - lo) > 1e-6) {
      mid = (lo + hi) / 2.0;

      if (isPossible(mid, stations, k)) {
        ans = mid;
        hi = mid;
      } else {
        lo = mid;
      }
    }
    return ans;
  }

  private boolean isPossible(double mid, int[] stations, int k) {
    int count = 0;
    for (int i = 0; i < stations.length - 1; i++) {
      /**
       * Distance b/w 2 points divided by the max. probable distance = # of points
       * that could be added
       */
      count += (int) ((stations[i + 1] - stations[i]) / mid);

      if (count > k) {
        /**
         * Increase the mid value to add less points
         */
        return false;
      }
    }
    return true;
  }

}
