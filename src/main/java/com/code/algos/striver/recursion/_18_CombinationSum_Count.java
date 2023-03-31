package com.code.algos.striver.recursion;

import java.util.ArrayList;
import java.util.List;

public class _18_CombinationSum_Count {

  public int print(int[] nums, int target) {
    return backtrack(new ArrayList<>(nums.length), nums, 0, target);
  }

  private int backtrack(List<Integer> list, int[] nums, int index, int target) {
    if (target == 0) {
      return 1;
    }
    if (index == nums.length) {
      return 0;
    }
    int count = 0;
    if (nums[index] <= target) {
      list.add(nums[index]);
      count += backtrack(list, nums, index + 1, target - nums[index]);
      list.remove(list.size() - 1);
      count += backtrack(list, nums, index + 1, target);
    }
    return count;
  }

}
