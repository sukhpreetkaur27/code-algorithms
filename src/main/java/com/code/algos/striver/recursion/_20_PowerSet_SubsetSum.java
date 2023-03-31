package com.code.algos.striver.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list arr of N integers, print sums of all subsets in it.

 

Example 1:

Input:
N = 2
arr[] = {2, 3}
Output:
0 2 3 5
Explanation:
When no elements is taken then Sum = 0.
When only 2 is taken then Sum = 2.
When only 3 is taken then Sum = 3.
When element 2 and 3 are taken then 
Sum = 2+3 = 5.
Example 2:

Input:
N = 3
arr = {5, 2, 1}
Output:
0 1 2 3 5 6 7 8
 * 
 * @author sukh
 *
 */
public class _20_PowerSet_SubsetSum {

  /**
   * Time: O(2^n) <br>
   * Space: O(n)
   * @param arr
   * @param N
   * @return
   */
  public List<Integer> subsetSums(List<Integer> arr, int N) {
    Collections.sort(arr);
    List<Integer> sums = new ArrayList<>();
    backtrack(arr, sums, 0, 0);
    return sums;
  }

  private void backtrack(List<Integer> arr, List<Integer> sums, int index, int sum) {
    if (index == arr.size()) {
      sums.add(sum);
      return;
    }

    /**
     * pick
     */
    backtrack(arr, sums, index + 1, sum + arr.get(index));
    // sum+=arr.get(index);
    // sums.add(sum);
    // temp.add(arr.get(index));
    // backtrack(arr, sums, temp,index+1, sum);
    // temp.remove(temp.size()-1);
    // sum-=arr.get(index);
    /**
     * not pick
     */
    backtrack(arr, sums, index + 1, sum);
  }

}
