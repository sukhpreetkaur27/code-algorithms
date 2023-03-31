package com.code.algos.striver.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
 * 
 * @author sukh
 *
 */
public class _19_PowerSet_Subsets_II {

  /**
   * Time: O((2^n) * n) <br>
   * Space: O(n)
   * @param nums
   * @return
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    backtrack(list, temp, nums, 0);
    return list;
  }

  private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int index) {
    List<Integer> subset = new ArrayList<>();
    subset.addAll(temp);
    list.add(subset);

    for (int i = index; i < nums.length; i++) {
      if (i != index && nums[i] == nums[i - 1]) {
        continue;
      }
      temp.add(nums[i]);
      backtrack(list, temp, nums, i + 1);
      temp.remove(temp.size() - 1);
    }
  }

}
