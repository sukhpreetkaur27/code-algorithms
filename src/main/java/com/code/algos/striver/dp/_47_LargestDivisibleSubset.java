package com.code.algos.striver.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.
 * 
 * @author sukh
 *
 */
public class _47_LargestDivisibleSubset {
  /**
   * NOTE: This is an extension to com.code.algos.striver.dp._46_PrintLIS
   */

  /**
   * Time: O(n * n) + O(n) <br>
   * Space: O(2n)
   * 
   * @param nums
   * @return
   */
  public List<Integer> largestDivisibleSubset(int[] nums) {
    /**
     * Algorithm:
     * 
     * LDS[i] = the LDS length from [0, i]
     */
    int n = nums.length;
    /**
     * why sort?
     * 
     * 1. subset == non-contiguous
     * 
     * 2. we have to check divisible or not --> hence, if a[i] > a[j], then a[i] %
     * a[j] == 0 can easily be tested
     */
    Arrays.sort(nums);
    /**
     * Stores the LDS length
     */
    int[] dp = new int[n];
    /**
     * The Backtrack Array: Stores the previous index
     */
    int[] hash = new int[n];
    for (int i = 0; i < n; i++) {
      hash[i] = i;
    }
    /**
     * By default, each element can be a part of an LDS containing the single
     * element only
     */
    Arrays.fill(dp, 1);
    int maxLdsIndex = 0;
    int maxLds = 1;
    for (int index = 1; index < n; index++) {
      for (int prev_index = 0; prev_index < index; prev_index++) {
        if (nums[index] % nums[prev_index] == 0 && (dp[prev_index] + 1) > dp[index]) {
          dp[index] = dp[prev_index] + 1;
          hash[index] = prev_index;
        }
      }
      if (maxLds < dp[index]) {
        maxLds = dp[index];
        maxLdsIndex = index;
      }
    }
    List<Integer> list = new ArrayList<>();
    while (maxLds > 0) {
      list.add(nums[maxLdsIndex]);
      maxLdsIndex = hash[maxLdsIndex];
      maxLds--;
    }
    /**
     * As we backtrack to produce the list, hence, reverse the list
     */
    /**
     * no need to reverse as it is a subset not a subsequence
     */
//    Collections.reverse(list);
    return list;
  }

}
