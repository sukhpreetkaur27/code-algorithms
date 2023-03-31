package com.code.algos.striver.binarySearch;

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. 
Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas,
 she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
 * 
 * @author sukh
 *
 */
public class _20_KokoEatingBananas {

  /**
   * Time: O(n log k)<br>
   * k = piles(max)<br>
   * Space: O(1)
   * @param piles
   * @param h
   * @return
   */
  public int minSpeed(int[] piles, int h) {
    /**
     * Use BS as we have a search space, i.e., <br>
     * Min. speed = 1<br>
     * Max. Speed = Max(piles)
     */
    int lo = 1;
    int hi = piles[0];
    for (int i = 1; i < piles.length; i++) {
      hi = Math.max(hi, piles[i]);
    }

    int mid;
    int totalHours;

    while (lo < hi) {
      /**
       * Consider mid as a workable speed
       */
      mid = lo + (hi - lo) / 2;

      totalHours = 0;

      for (int i = 0; i < piles.length; i++) {
        /**
         * if speed = 5, piles[i] = 6<br>
         * time = 6/5 = 2<br>
         * Hence, we use the ceil method.
         */
        totalHours += Math.ceil((double) piles[i] / mid);
      }

      if (totalHours <= h) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }

}
