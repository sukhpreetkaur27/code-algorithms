package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given an array Arr of size N containing positive integers. Find the maximum sum of a subsequence such that no two numbers in the sequence should be adjacent in the array.

Example 1:

Input:
N = 6
Arr[] = {5, 5, 10, 100, 10, 5}
Output: 110
Explanation: If you take indices 0, 3
and 5, then Arr[0]+Arr[3]+Arr[5] =
5+100+5 = 110.
Example 2:

Input:
N = 4
Arr[] = {3, 2, 7, 10}
Output: 13
Explanation: 3 and 10 forms a non
continuous  subsequence with maximum
sum.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findMaxSum() which takes the array of integers arr and n as parameters 
and returns an integer denoting the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 106
1 ≤ Arri ≤ 107
 * 
 * @author sukh
 *
 */
public class _7_MaxSumWithoutAdjacents {

  public int findMaxSum_recursion(int arr[], int n) {
    /**
     * Recursion: TLE
     */
    return findMaxSum_recursive(arr, n - 1);
  }

  private int findMaxSum_recursive(int arr[], int index) {
    /**
     * Base Case
     */
    if (index == 0) {
      return arr[index];
    }
    /**
     * Edge Case
     * 
     * for negative indices --> return 0
     */
    if (index < 0) {
      return 0;
    }
    /**
     * pick the current element and skip the adjacent
     */
    int pick = arr[index] + findMaxSum_recursive(arr, index - 2);
    /**
     * skip the current element and pick the adjacent
     */
    int notPick = 0 + findMaxSum_recursive(arr, index - 1);
    return Math.max(pick, notPick);
  }

  public int findMaxSum_memoization(int arr[], int n) {
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = arr[0];
    return findMaxSum_memoize(arr, n - 1, dp);
  }

  private int findMaxSum_memoize(int arr[], int index, int[] dp) {
    if (index == 0) {
      return dp[index];
    }
    if (index < 0) {
      return 0;
    }
    if (dp[index] != Integer.MAX_VALUE) {
      return dp[index];
    }
    int pick = arr[index] + findMaxSum_memoize(arr, index - 2, dp);
    int notPick = 0 + findMaxSum_memoize(arr, index - 1, dp);
    return dp[index] = Math.max(pick, notPick);
  }

  public int findMaxSum_tabulation(int arr[], int n) {
    if (n == 1) {
      return arr[0];
    }
    /**
     * Max Sum till i-th index
     */
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = arr[0];
    dp[1] = Math.max(arr[1], arr[0]);
//    int max = Math.max(dp[0], dp[1]);
    for (int i = 2; i < n; i++) {
      /**
       * pick
       */
      dp[i] = arr[i] + dp[i - 2];
      /**
       * not pick
       */
      dp[i] = Math.max(dp[i], dp[i - 1]);
//      max = Math.max(max, dp[i]);
    }
//    return max;
    return dp[n - 1];
  }

  public int findMaxSum_optimal(int arr[], int n) {
    if (n == 1) {
      return arr[0];
    }
    /**
     * Max Sum till i-2 element
     */
    int prev2 = arr[0];
    /**
     * Max Sum till i-1 element
     */
    int prev1 = Math.max(arr[1], arr[0]);
    /**
     * Max Sum
     */
//    int max = prev1;
    for (int i = 2, curr = 0; i < n; i++) {
      /**
       * pick + skip adjacent sum
       */
      curr = arr[i] + prev2;
      /**
       * not pick + pick adjacent sum
       */
      curr = Math.max(curr, prev1);
//      max = Math.max(max, curr);
      /**
       * max sum till previous 2 elements = max sum till previous element
       */
      prev2 = prev1;
      /**
       * max sum till previous element = max sum till current element
       */
      prev1 = curr;
    }
//    return max;
    return prev1;
  }

}
