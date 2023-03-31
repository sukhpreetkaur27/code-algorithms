package com.code.algos.striver.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Sub Problem of Power Set:
 * 
 * Print any one subsequence.
 * 
 * @author sukh
 *
 */
public class _18_CombinationSum_OneSubset {

  /**
   * Time: O(2^n) <br>
   * Space: O(n)
   * @param nums
   * @param target
   * @return
   */
  public List<Integer> print(int[] nums, int target) {
    List<Integer> list = new ArrayList<>();
    backtrack(list, nums, 0, target);
    return list;
  }

  private boolean backtrack(List<Integer> list, int[] nums, int index, int target) {
    if (target == 0) {
      return true;
    }
    if (index == nums.length) {
      return false;
    }
    if (nums[index] <= target) {
      list.add(nums[index]);
      if (backtrack(list, nums, 0, target - nums[index]) == true) {
        return true;
      }
      list.remove(list.size() - 1);
      return backtrack(list, nums, 0, target);
    }
    return false;
  }

}
