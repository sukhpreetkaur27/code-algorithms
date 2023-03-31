package com.code.algos.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 * @author sukh
 *
 */
public class Sum3_1_15 {

  /**
   * NOTE:<br>
   * Two-Pointer Approach
   */

  /**
   * Time: O(n^2)<br>
   * Space: from O(log n) to O(n), depending on the implementation of the sorting
   * algorithm.
   * @param nums
   * @return
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();

//    int[] nums_clone = nums.clone();
    Arrays.sort(nums);

    /**
     * The array is sorted. Therefore, if nums[i]>0, then there is no possibility to
     * get a triplet that sums up to 0.
     */
    for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
      /**
       * To avoid duplicates
       */
      if (i == 0 || nums[i - 1] != nums[i]) {
        threeSum(nums, res, i);
      }
    }

    return res;
  }

  /**
   * Time: O(n)<br>
   * Space: O(1)
   * @param nums
   * @param res
   * @param i
   */
  private void threeSum(int[] nums, List<List<Integer>> res, int i) {
    /**
     * Two-Pointer Approach
     */
    int lo = i + 1;
    int hi = nums.length - 1;

    while (lo < hi) {
      int s = nums[i] + nums[lo] + nums[hi];

      if (s < 0) {
        lo++;
      } else if (s > 0) {
        hi--;
      } else {
        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
        lo++;
        hi--;

        /**
         * To avoid duplicates
         */
        while (lo < hi && nums[lo - 1] == nums[lo]) {
          lo++;
        }
      }
    }
  }

}
