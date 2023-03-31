package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 


Example 1:

Input:
N = 6
arr[] = {3, 34, 4, 12, 5, 2}
sum = 9
Output: 1 
Explanation: Here there exists a subset with
sum = 9, 4+3+2 = 9.
Example 2:

Input:
N = 6
arr[] = {3, 34, 4, 12, 5, 2}
sum = 30
Output: 0 
Explanation: There is no subset with sum 30.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function isSubsetSum() which takes the array arr[], its size N 
and an integer sum as input parameters and returns boolean value true if there exists a subset with given sum and false otherwise.
The driver code itself prints 1, if returned value is true and prints 0 if returned value is false.
 

Expected Time Complexity: O(sum*N)
Expected Auxiliary Space: O(sum*N)
 

Constraints:
1 <= N <= 100
1<= arr[i] <= 100
1<= sum <= 105
 * 
 * @author sukh
 *
 */
public class _18_SubsetSum {

  /**
   * Time: O(2^n) <br>
   * for each index, 2 possibilities <br>
   * Space: O(n)
   * 
   * @param N
   * @param arr
   * @param sum
   * @return
   */
  public boolean isSubsetSum_recursion(int N, int arr[], int sum) {
    /**
     * Recursion: TLE
     */
    return isSubsetSum_recursive(arr, sum, N - 1);
  }

  /**
   * 
   * @param index --> till the index-th element, is the sum == target, i.e., can
   * we obtain a subsequence from [0, index] with sum = target
   * @return
   */
  private boolean isSubsetSum_recursive(int arr[], int target, int index) {
    /**
     * Base Case:
     * 
     * as we are decreasing the target --> if it reaches 0 --> return true;
     */
    if (target == 0) {
      return true;
    }
//    if (arr[index] == target) {
//      return true;
//    }
    /**
     * Edge Case:
     * 
     * we start from n-1 to 0 --> if we reach 0 --> check if target is found at the
     * 0-th index --> as we don't have any more values to pick or not pick
     */
    if (index == 0) {
      return arr[index] == target;
    }
    boolean notPick = isSubsetSum_recursive(arr, target, index - 1);
    boolean pick = false;
    /**
     * we cannot pick the current element if it is > the target --> as it will
     * result into negative value
     */
    if (target >= arr[index]) {
//    if (!notPick && target >= arr[index]) {
      pick = isSubsetSum_recursive(arr, target - arr[index], index - 1);
    }
    return notPick || pick;
  }

  /**
   * Time: O(n * target) <br>
   * Space: O(n * target) + O(n)
   * 
   * @param N
   * @param arr
   * @param sum
   * @return
   */
  public boolean isSubsetSum_memoization(int N, int arr[], int sum) {
    /**
     * Memoization
     */
    int[][] dp = new int[N][sum + 1];
    for (int i = 0; i < N; i++) {
      Arrays.fill(dp[i], -1);
    }
    return isSubsetSum_memoize(arr, sum, N - 1, dp);
  }

  private boolean isSubsetSum_memoize(int arr[], int target, int index, int[][] dp) {
    /**
     * Base Case:
     * 
     * as we are decreasing the target --> if it reaches 0 --> return true;
     */
    if (target == 0) {
      return true;
    }
//    if (arr[index] == target) {
//      return true;
//    }
    /**
     * Edge Case:
     * 
     * we start from n-1 to 0 --> if we reach 0 --> check if target is found at the
     * 0-th index --> as we don't have any more values to pick or not pick
     */
    if (index == 0) {
      return arr[index] == target;
    }
    /**
     * Time: O(n * target) <br>
     * as at max we will go till dp [n] [target]
     */
    if (dp[index][target] != -1) {
      return dp[index][target] == 1;
    }
    boolean notPick = isSubsetSum_memoize(arr, target, index - 1, dp);
    boolean pick = false;
    if (target >= arr[index]) {
//    if (!notPick && target >= arr[index]) {
      pick = isSubsetSum_memoize(arr, target - arr[index], index - 1, dp);
    }
    dp[index][target] = (notPick || pick) ? 1 : 0;
    return dp[index][target] == 1;
  }

  /**
   * Time: O(n * target) <br>
   * Space: O(n * target)
   * 
   * @param N
   * @param arr
   * @param sum
   * @return
   */
  public boolean isSubsetSum_tabulation(int N, int arr[], int target) {
    /**
     * Tabulation
     */
    boolean[][] dp = new boolean[N][target + 1];
    /**
     * Base Case
     **/
    for (int i = 0; i < N; i++) {
      /**
       * if (target == 0) { return true; }
       */
      dp[i][0] = true;
    }
    /**
     * Edge Case
     **/
    /**
     * if (index == 0) { return arr[index] == target; }
     */
    /**
     * the following check is mandatory to initialize the edge case
     */
    if(arr[0] <= target) {
      dp[0][arr[0]] = true;
    }
//    dp[0][arr[0]] = true;
    /**
     * index = 0 covered in base case
     * 
     * target = 0 covered in base case
     * 
     * go from index [1, N)
     * 
     * go from target [1, target]
     **/
    for (int i = 1; i < N; i++) {
      for (int j = 1; j <= target; j++) {
        /**
         * Copy recurrence
         **/
        boolean notPick = dp[i - 1][j];
        boolean pick = false;
        if (j >= arr[i]) {
          pick = dp[i - 1][j - arr[i]];
        }
        dp[i][j] = notPick || pick;
      }
    }
    return dp[N - 1][target];
  }

  /**
   * Time: O(n * target) <br>
   * Space: O(target)
   * 
   * @param N
   * @param arr
   * @param sum
   * @return
   */
  boolean isSubsetSum_optimal(int N, int arr[], int target) {
    /**
     * Space Optimization
     */
    boolean[] dp = new boolean[target + 1];
    /**
     * Base Case
     **/
    // for(int i=0;i<N;i++){
    // if(target==0) {
    // return true;
    // }
    dp[0] = true;
    // }
    /**
     * Edge Case
     **/
    // if(index==0){
    // return arr[index]==target;
    // }
    /**
     * the following check is mandatory to initialize the edge case
     */
    if(arr[0] <= target) {
      dp[arr[0]] = true;
    }
    boolean[] curr = new boolean[target + 1];
    /**
     * Base Case
     */
    curr[0] = true;
    /**
     * index = 0 covered in base case
     * 
     * target = 0 covered in base case
     * 
     * go from index [1, N)
     * 
     * go from target [1, target]
     **/
    for (int i = 1; i < N; i++) {
      for (int j = 1; j <= target; j++) {
        /**
         * Copy recurrence
         **/
        boolean notPick = dp[j];
        boolean pick = false;
        if (j >= arr[i]) {
          pick = dp[j - arr[i]];
        }
        curr[j] = notPick || pick;
      }
      for (int j = 1; j <= target; j++) {
        dp[j] = curr[j];
      }
    }
    return dp[target];
  }

}
