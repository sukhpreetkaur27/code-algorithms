package com.code.algos.striver.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer n and array of integers, returns the Longest Increasing subsequence which is lexicographically smallest.
LIS  of a given sequence such that all elements of the subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 
and LIS is {10, 22, 33, 50, 60, 80}. 
 

Example 1:

Input:
n = 16
arr = [0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15]
Output:
0 4 6 9 13 15 
Explanation:
longest Increasing subsequence is 0 4 6 9 13 15  and the length of the longest increasing subsequence is 6.
Example 2:

Input:
n = 1
arr = [1]
Output:
1
Your Task:
You don't need to read input or print anything. Your task is to complete the function longestIncreasingSubsequence() which takes integer n and array arr 
and returns the longest increasing subsequence.

Expected Time Complexity: O(n2)
Expected Space Complexity: O(n)

Constraint:
1 <= n < = 1000
1 <= arr[i] <= 50000
 * 
 * @author sukh
 *
 */
public class _46_PrintLIS {

  /**
   * NOTE: This is an extension to com.code.algos.striver.dp._45_LIS
   */

  /**
   * Time: O(n * n) + O(n) <br>
   * Space: O(2n)
   * 
   * @param nums
   * @return
   */
  public List<Integer> print(int[] nums) {
    /**
     * Algorithm:
     * 
     * LIS[i] = the LIS length from [0, i]
     */
    int n = nums.length;
    /**
     * Stores the LIS length
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
     * By default, each element can be a part of an LIS containing the single
     * element only
     */
    Arrays.fill(dp, 1);
    int maxLisIndex = 0;
    int maxLis = 1;
    for (int index = 1; index < n; index++) {
      for (int prev_index = 0; prev_index < index; prev_index++) {
        if (nums[index] > nums[prev_index] && (dp[prev_index] + 1) > dp[index]) {
          dp[index] = dp[prev_index] + 1;
          hash[index] = prev_index;
        }
      }
      if (maxLis < dp[index]) {
        maxLis = dp[index];
        maxLisIndex = index;
      }
    }
    List<Integer> list = new ArrayList<>();
    while (maxLis > 0) {
      list.add(nums[maxLisIndex]);
      maxLisIndex = hash[maxLisIndex];
      maxLis--;
    }
    /**
     * As we backtrack to produce the list, hence, reverse the list
     */
    Collections.reverse(list);
    return list;
  }

  public static void main(String[] args) {
    _46_PrintLIS obj = new _46_PrintLIS();
    int[] nums = { 5, 4, 11, 1, 16, 8 };
    List<Integer> list = obj.print(nums);
    System.out.println(list.toString());
  }

}
