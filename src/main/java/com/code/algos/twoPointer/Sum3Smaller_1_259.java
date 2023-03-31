package com.code.algos.twoPointer;

import java.util.Arrays;

/**
 * Given an array of n integers nums and an integer target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

 

Example 1:

Input: nums = [-2,0,1,3], target = 2
Output: 2
Explanation: Because there are two triplets which sums are less than 2:
[-2,0,1]
[-2,0,3]
Example 2:

Input: nums = [], target = 0
Output: 0
Example 3:

Input: nums = [0], target = 0
Output: 0
 

Constraints:

n == nums.length
0 <= n <= 3500
-100 <= nums[i] <= 100
-100 <= target <= 100
 * @author sukh
 *
 */
public class Sum3Smaller_1_259 {

  /**
   * Time: O(n^2)<br>
   * Space: O(1)
   * @param nums
   * @param target
   * @return
   */
  public int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);

    int s = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      threeSumSmaller(nums, i + 1, target - nums[i]);
    }
    return s;
  }

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param nums
   * @param lo
   * @param target
   * @return
   */
  private int threeSumSmaller(int[] nums, int lo, int target) {
    int hi = nums.length - 1;
    int count = 0;
    while (lo < hi) {
      if (nums[lo] + nums[hi] < target) {
        /**
         * All numbers between lo and hi, pairing with lo, will sum up to < target
         */
        count += hi - lo;
        lo++;
      } else {
        hi--;
      }
    }
    return count;
  }

}
