package com.code.algos.striver.binarySearch;

/**
 * A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

 

Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
Example 2:

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
Example 3:

Input: weights = [1,2,3,1,1], days = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1
 

Constraints:

1 <= days <= weights.length <= 5 * 104
1 <= weights[i] <= 500
 * 
 * @author sukh
 *
 */
public class _24_CapacityToShip {

  /**
   * Time: O(n log k) <br>
   * k = sum(weights) <br>
   * Space: O(1)
   * @param weights
   * @param days
   * @return
   */
  public int capacity(int[] weights, int days) {
    int n = weights.length;
    int lo = weights[0];
    int hi = weights[0];
    /**
     * lo == max(weights)<br>
     * hi == sum(weights)
     */
    for (int i = 1; i < n; i++) {
      lo = Math.max(lo, weights[i]);
      hi += weights[i];
    }

    int mid, dayCount;
    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;

      /**
       * if dayCount = 0 , then:<br>
       * 1. the last weight goes uncounted, (or) <br>
       * 2. if sum(weights) <= mid, then dayCount remains 0
       */
      dayCount = 1;

      for (int i = 0, sum = 0; i < n; i++) {
        sum += weights[i];
        if (sum > mid) {
          dayCount++;
          sum = 0;
          i--;
        }
      }

      if (dayCount <= days) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }

}
