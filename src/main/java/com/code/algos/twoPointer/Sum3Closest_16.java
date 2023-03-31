package com.code.algos.twoPointer;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104
 * @author sukh
 *
 */
public class Sum3Closest_16 {

  /**
   * Time: O(n^2)<br>
   * Space: from O(log n) to O(n), depending on the implementation of the sorting
   * @param nums
   * @param target
   * @return
   */
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int diff = Integer.MAX_VALUE;

    int lo, hi, s;
    for (int i = 0; i < nums.length - 2 && diff != 0; i++) {
      lo = i + 1;
      hi = nums.length - 1;
      while (lo < hi) {
        s = nums[i] + nums[lo] + nums[hi];
        if (Math.abs(target - s) < Math.abs(diff)) {
          diff = target - s;
        }
        if (s < target) {
          lo++;
        } else {
          hi--;
        }
      }
    }

    return target - diff;
  }

}
