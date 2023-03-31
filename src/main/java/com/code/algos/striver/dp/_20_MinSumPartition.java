package com.code.algos.striver.dp;

/**
 * Given an array arr of size n containing non-negative integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum 
 * and find the minimum difference


Example 1:

Input: N = 4, arr[] = {1, 6, 11, 5} 
Output: 1
Explanation: 
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11   
Example 2:
Input: N = 2, arr[] = {1, 4}
Output: 3
Explanation: 
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {4}, sum of Subset2 = 4

Your Task:  
You don't need to read input or print anything. Complete the function minDifference() which takes N and array arr as input parameters and returns the integer value


Expected Time Complexity: O(N*|sum of array elements|)
Expected Auxiliary Space: O(N*|sum of array elements|)


Constraints:
1 ≤ N*|sum of array elements| ≤ 106
0 < arr[i] <= 105
 * 
 * @author sukh
 *
 */
public class _20_MinSumPartition {

  /**
   * NOTE: This problem is an extension to com.code.algos.striver.dp._18_SubsetSum
   */

  public int minDifference(int arr[], int n) {
    int target = 0;
    for (int i = 0; i < n; i++) {
      target += arr[i];
    }
    /**
     * the last row in DP-Tabulation denotes the possible subset sum in the array
     * 
     * if we observe the last row TRUE values and find the other half of the subset
     * to make the complete array, we will find that half of the dp[] is a replica
     * of the other half
     * 
     * eg:
     * 
     * arr[] = [3, 2, 7]
     * 
     * total sum = 12
     * 
     * subset 1: (s1)               0, 2, 3, 5, 7, 9, 10, 12 <br>
     * subset 2: (total sum - s1): 12, 10, 9, 7, 5, 3, 2, 0
     */
    boolean[] dp = isSubsetSum_optimal(n, arr, target);
    int min = Integer.MAX_VALUE;
//    for (int i = 0; i <= target; i++) {
      for (int i = 0; i <= target/2; i++) {
      if (dp[i]) {
        min = Math.min(min, Math.abs(target - 2 * i));
      }
    }
    return min;
  }

  private boolean[] isSubsetSum_optimal(int N, int arr[], int target) {
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
    if (arr[0] <= target) {
      dp[target] = true;
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
    return dp;
  }

}
