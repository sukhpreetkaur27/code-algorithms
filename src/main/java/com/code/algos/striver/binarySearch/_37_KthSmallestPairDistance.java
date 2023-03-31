package com.code.algos.striver.binarySearch;

import java.util.Arrays;

/**
 * The distance of a pair of integers a and b is defined as the absolute difference between a and b.

Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.

 

Example 1:

Input: nums = [1,3,1], k = 1
Output: 0
Explanation: Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Example 2:

Input: nums = [1,1,1], k = 2
Output: 0
Example 3:

Input: nums = [1,6,1], k = 3
Output: 5
 

Constraints:

n == nums.length
2 <= n <= 104
0 <= nums[i] <= 106
1 <= k <= n * (n - 1) / 2
 * 
 * @author sukh
 *
 */
public class _37_KthSmallestPairDistance {

  /**
   * Time: O(n log m + n log n)<br>
   * m = nums[n-1] - nums[0]<br>
   * Space: O(n log n) <br>
   * required for sorting
   * @param nums
   * @param k
   * @return
   */
  public int kthSmallestPairDist(int[] nums, int k) {
    /**
     * Time: O(n log n)
     */
    Arrays.sort(nums);
    int n = nums.length;
    int lo = 0;
    int hi = nums[n - 1] - nums[0];
    int mid, ans = 0;
    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;
      if (isPossible(mid, nums, k)) {
        ans = mid;
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return ans;
  }

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param mid
   * @param nums
   * @param k
   * @return
   */
  private boolean isPossible(int mid, int[] nums, int k) {
    int count = 0;
    /**
     * NOTE:<br>
     * Two Pointer Approach
     */
    for (int right = 0, left = 0; right < nums.length; right++) {
      /**
       * if the distance of a pair (left, right) > mid <br>
       * this implies for all other rights, a pair formed with left will also have a
       * distance > mid <br>
       * as we want the smallest distance, so increment left in order to look for
       * other pairs
       */
      while (nums[right] - nums[left] > mid) {
        left++;
      }
      /**
       * # of pairs for the current left = right-left
       */
      count += right - left;
      if (count >= k) {
        return true;
      }
    }
    return false;
  }

}
