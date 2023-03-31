package com.code.algos.striver.twoPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
 * 
 * @author sukh
 *
 */
public class _7_BinarySubArraysWithSum {

  /**
   * Sliding Pointer Approach <br>
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param nums
   * @param goal
   * @return
   */
  public int numSubarraysWithSum(int[] nums, int goal) {
    /**
     * NOTE: <br>
     * Exactly K times = at most K times - at most K - 1 times
     */
    return numSubarraysWithAtmostSum(nums, goal)
        - numSubarraysWithAtmostSum(nums, goal - 1);
  }

  private int numSubarraysWithAtmostSum(int[] nums, int goal) {
    if (goal < 0) {
      return 0;
    }
    int n = nums.length;
    int l = 0;
    int r = 0;
    int count = 0;
    while (r < n) {
      goal -= nums[r];
      while (goal < 0) {
        goal += nums[l];
        l++;
      }
      count += r - l + 1;
      r++;
    }
    return count;
  }

  /**
   * Prefix Sum Approach <br>
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param nums
   * @param goal
   * @return
   */
  public int numSubarraysWithSum_PrefixSum(int[] nums, int goal) {
    Map<Integer, Integer> map = new HashMap<>();
    /**
     * Default value, in case the sum of the complete array = 0
     */
    map.put(0, 1);
    int sum = 0, count = 0;
    for (int i : nums) {
      sum += i;
      if (sum >= goal) {
        count += map.getOrDefault(sum - goal, 0);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

}
