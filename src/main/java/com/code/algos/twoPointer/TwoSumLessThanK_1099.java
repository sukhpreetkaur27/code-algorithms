package com.code.algos.twoPointer;

import java.util.Arrays;

/**
 * Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.

 

Example 1:

Input: nums = [34,23,1,24,75,33,54,8], k = 60
Output: 58
Explanation: We can use 34 and 24 to sum 58 which is less than 60.
Example 2:

Input: nums = [10,20,30], k = 15
Output: -1
Explanation: In this case it is not possible to get a pair sum less that 15.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 1000
1 <= k <= 2000
 * @author sukh
 *
 */
public class TwoSumLessThanK_1099 {

  /**
   * O(n log n)<br>
   * Space: from O(log n) to O(n), depending on the implementation of the sorting
   * algorithm.
   * @param nums
   * @param k
   * @return
   */
  public int twoSum(int[] nums, int k) {
    Arrays.sort(nums);

    int res = -1;

    int lo = 0;
    int hi = nums.length - 1;

    while (lo < hi) {
      int s = nums[lo] + nums[hi];
      if (s < k) {
        res = Math.max(res, s);
        lo++;
      } else {
        hi--;
      }
    }

    return res;
  }

}
