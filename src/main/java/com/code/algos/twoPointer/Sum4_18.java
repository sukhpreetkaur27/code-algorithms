package com.code.algos.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4_18 {

  /**
   * Time: O(n^k-1)<br>
   * Space: O(n)
   * @param nums
   * @param target
   * @return
   */
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    int k = 4;
    int start = 0;
    return kSum(nums, target, start, k);
  }

  private List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
    List<List<Integer>> res = new ArrayList<>();

    /**
     * if end of array is reached
     */
    if (start == nums.length) {
      return res;
    }

    /**
     * NOTE:<br>
     * There are k remaining values to add to the sum.<br>
     * The average of these values is at least target / k.
     */
    long avg = target / k;
    /**
     * We cannot obtain a sum of target if the smallest value in nums is greater
     * than target / k or if the largest value in nums is smaller than target / k.
     */
    if (avg < nums[start] || avg > nums[nums.length - 1]) {
      return res;
    }

    /**
     * Finally, when k = 2, apply two sum approach
     */
    if (k == 2) {
      return twoSum(nums, target, start);
    }

    for (int i = start; i < nums.length; i++) {
      /**
       * Avoid duplicates
       */
      if (i == start || nums[i - 1] != nums[i]) {
        /**
         * As we recurse:<br>
         * 1. decrement the target by nums[i]<br>
         * 2. increment the start pointer to i+1<br>
         * 3. decrement the k counter by 1
         */
        for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
          res.add(new ArrayList<>(Arrays.asList(nums[i])));
          res.get(res.size() - 1).addAll(subset);
        }
      }
    }
    return res;
  }

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param nums
   * @param target
   * @param start
   * @return
   */
  private List<List<Integer>> twoSum(int[] nums, int target, int start) {
    List<List<Integer>> res = new ArrayList<>();

    /**
     * NOTE: Two-Pointer Approach
     */

    int lo = start;
    int hi = nums.length - 1;

    /**
     * Avoid duplicates and check for sum inequality
     */
    while (lo < hi) {
      int s = nums[lo] + nums[hi];
      if (s < target || (lo > start && nums[lo - 1] == nums[lo])) {
        lo++;
      } else if (s > target || (hi < nums.length - 1 && nums[hi + 1] == nums[hi])) {
        hi--;
      } else {
        res.add(Arrays.asList(nums[lo++], nums[hi--]));
      }
    }
    return res;
  }

}
