package com.code.algos.striver.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 * 
 * @author sukh
 *
 */
public class _17_PowerSet_Subsets {

  /**
   * Time: O((2^n) * n) <br>
   * the last n is due to copying the subsequence from temp to the new list <br>
   * Space: O(n)
   * @param nums
   * @return
   */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    int n = nums.length;
    List<Integer> temp = new ArrayList<>();
    backtrack(list, nums, temp, 0, n);
    return list;
  }

  private void backtrack(List<List<Integer>> list, int[] nums, List<Integer> temp, int index,
      int n) {
    if (index == n) {
      List<Integer> subset = new ArrayList<>();
      subset.addAll(temp);
      list.add(subset);
      return;
    }
    /**
     * Add the new # to the subsequence and go for recursive call
     */
    temp.add(nums[index]);
    backtrack(list, nums, temp, index + 1, n);
    /**
     * Remove the new # from the subsequence and go for recursive call
     */
    temp.remove(temp.size() - 1);
    backtrack(list, nums, temp, index + 1, n);
  }

}
