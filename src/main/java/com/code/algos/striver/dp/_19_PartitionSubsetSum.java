package com.code.algos.striver.dp;

/**
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
 * 
 * @author sukh
 *
 */
public class _19_PartitionSubsetSum {

  /**
   * NOTE: This problem is an extension to com.code.algos.striver.dp._18_SubsetSum
   */

  /**
   * Time: O(n) + O(2^n) <br>
   * for each index, 2 possibilities <br>
   * Space: O(n)
   * 
   * @param nums
   * @return
   */
  public boolean canPartition_recursion(int[] nums) {
    /**
     * Recursion: TLE
     */
    int n = nums.length;
    int target = 0;
    for (int i = 0; i < n; i++) {
      target += nums[i];
    }
    /**
     * To divide into 2 subsets of equal sum
     * 
     * the total sum of the array must be even, else not possible
     */
    if ((target & 1) != 0) {
      return false;
    }
    return partition_recursive(nums, n - 1, target / 2);
  }

  private boolean partition_recursive(int[] nums, int index, int target) {
    if (target == 0) {
      return true;
    }
    if (index == 0) {
      return nums[0] == target;
    }
    boolean notPick = partition_recursive(nums, index - 1, target);
    boolean pick = false;
    if (!notPick && target >= nums[index]) {
      pick = partition_recursive(nums, index - 1, target - nums[index]);
    }
    return notPick || pick;
  }

  /**
   * Time: O(n) + O(n * target) <br>
   * Space: O(target)
   * 
   * @param arr
   * @return
   */
  public boolean canPartition_optimal(int[] arr) {
    int n = arr.length;
    int target = 0;
    for (int i = 0; i < n; i++) {
      target += arr[i];
    }
    if ((target & 1) != 0) {
      return false;
    }
    return isSubsetSum_optimal(n, arr, target / 2);
  }

  private boolean isSubsetSum_optimal(int N, int arr[], int target) {
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
