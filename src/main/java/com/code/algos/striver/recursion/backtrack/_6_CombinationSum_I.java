package com.code.algos.striver.recursion.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, 
 * return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. 
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
 * 
 * @author sukh
 *
 */
public class _6_CombinationSum_I {

  /**
   * NOTE: Time is exponential in nature and the depth of the recursion tree > the # of elements <br>
   * Time: O((2^t) * k) <br>
   * t =  depth of the recursion tree <br>
   * k = average size of a sequence <br>
   * Space: O(t)
   * @param candidates
   * @param target
   * @return
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>(candidates.length);
    backtrack(list, candidates, target, 0, temp);
    return list;
  }

  private void backtrack(List<List<Integer>> list, int[] candidates, int target, int index,
      List<Integer> temp) {
    if (0 == target) {
      /**
       * Time: O(k)
       */
      List<Integer> subset = new ArrayList<>();
      subset.addAll(temp);
      list.add(subset);
      return;
    }
    if (index == candidates.length) {
      return;
    }
    /**
     * If current index fits into target, don't move to the next index
     */
    if (candidates[index] <= target) {
      // pick it again and again, i.e., don't move to the next index
      temp.add(candidates[index]);
      backtrack(list, candidates, target - candidates[index], index, temp);
      // not pick it
      temp.remove(temp.size() - 1);
      // move to the next index
      backtrack(list, candidates, target, index + 1, temp);
    }
  }

}
