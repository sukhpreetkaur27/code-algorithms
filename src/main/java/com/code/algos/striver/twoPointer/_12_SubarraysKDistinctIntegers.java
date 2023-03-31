package com.code.algos.striver.twoPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length
 * 
 * @author sukh
 *
 */
public class _12_SubarraysKDistinctIntegers {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param nums
   * @param k
   * @return
   */
  public int subarraysWithKDistinct(int[] nums, int k) {
    /**
     * NOTE: <br>
     * Exactly K times = at most K times - at most K - 1 times
     */
    return subarrays(nums, k) - subarrays(nums, k - 1);
  }

  public int subarrays(int[] nums, int k) {
    int l = 0;
    int r = 0;
    int n = nums.length;
    int count = 0;

    Map<Integer, Integer> map = new HashMap<>();

    while (r < n) {
      if (map.getOrDefault(nums[r], 0) == 0) {
        k--;
      }
      map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
      while (k < 0) {
        map.put(nums[l], map.get(nums[l]) - 1);
        if (map.get(nums[l]) == 0) {
          k++;
        }
        l++;
      }

      count += r - l + 1;
      r++;
    }
    return count;
  }

}
