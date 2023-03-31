package com.code.algos.striver.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 * 
 * @author sukh
 *
 */
public class _5_CombinationSum_II {

  /**
   * Time: O((2^n) * k) <br>
   * k = average size of the subsequence <br>
   * Space: O(n)
   * @param candidates
   * @param target
   * @return
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>(candidates.length);
    backtrack(list, temp, candidates, target, 0);
    return list;
  }

  private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] candidates,
      int target, int index) {
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

    for (int i = index; i < candidates.length; i++) {
      if (candidates[i] > target) {
        break;
      }
      /**
       * don't pick the same value again as it will result into the same recursion
       * tree
       */
      if (i > index && candidates[i] == candidates[i - 1]) {
        continue;
      }
      /**
       * pick the candidate
       */
      temp.add(candidates[index]);
      backtrack(list, temp, candidates, target - candidates[index], index + 1);
      /**
       * backtrack
       */
      temp.remove(temp.size() - 1);
    }
  }

}
