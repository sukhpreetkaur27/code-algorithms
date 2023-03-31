package com.code.algos.striver.binarySearch;

import java.util.Arrays;

/**
 * There is a new barn with N stalls and C cows. The stalls are located on a straight line at positions x1,….,xN (0 <= xi <= 1,000,000,000).
 *  We want to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

Examples:

Input: No of stalls = 5 
       Array: {1,2,8,4,9}
       And number of cows: 3

Output: One integer, the largest minimum distance 3
 * 
 * @author sukh
 *
 */
public class _26_AggressiveCows {

  /**
   * Time: O(n log k) <br>
   * k = max(coords) - min(coords) <br>
   * Space: O(1)
   * @param coords
   * @param cows
   * @return
   */
  public int largestMinDistance(int[] coords, int cows) {
    Arrays.sort(coords);

    int n = coords.length;
    int lo = 1;
    int hi = coords[n - 1] - coords[0];

    int mid, count;
    while (lo < hi) {
      mid = (lo + hi + 1) / 2;

      count = 1;
      for (int i = 1, curr = coords[0]; i < n; i++) {
        if ((coords[i] - curr) >= mid) {
          count++;
          curr = coords[i];
        }
      }

      if (count >= cows) {
        lo = mid;
      } else {
        hi = mid - 1;
      }
    }

    return lo;
  }

}
