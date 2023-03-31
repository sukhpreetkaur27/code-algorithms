package com.code.algos.striver.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have a security system connected, and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,2] Output: 3 Explanation: You cannot rob house 1 (money =
 * 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * Example 2:
 * 
 * Input: nums = [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and
 * then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4. Example
 * 3:
 * 
 * Input: nums = [1,2,3] Output: 3
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100 0 <= nums[i] <= 1000
 * 
 * @author sukh
 *
 */
public class _9_HouseRobber_II {

  /**
   * NOTE: this problem is an extension to
   * com.code.algos.striver.dp._8_HouseRobber
   */

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param arr
   * @return
   */
  public int rob(int[] arr) {
    int n = arr.length;
    if (n == 1) {
      return arr[0];
    }
    if (n == 2) {
      return Math.max(arr[0], arr[1]);
    }
    /**
     * Max Sum from 0 to n-2 --> skipping the last element
     */
    /**
     * Max Sum from 1 to n-1 --> skipping the first element
     */
    /**
     * Return max of both the answers
     */
    return Math.max(rob(arr, 0, n - 1), rob(arr, 1, n));
  }

  public int rob(int[] arr, int start, int end) {
    /**
     * Max Sum till i-2 element
     */
    int prev2 = arr[start];
    /**
     * Max Sum till i-1 element
     */
    int prev1 = Math.max(arr[start + 1], arr[start]);
    /**
     * Max Sum from 0 to n-2 --> skipping the last element
     */
    for (int i = start + 2, curr = 0; i < end; i++) {
      /**
       * pick + skip adjacent sum
       */
      curr = arr[i] + prev2;
      /**
       * not pick + pick adjacent sum
       */
      curr = Math.max(curr, prev1);
      /**
       * max sum till previous 2 elements = max sum till previous element
       */
      prev2 = prev1;
      /**
       * max sum till previous element = max sum till current element
       */
      prev1 = curr;
    }
    return prev1;
  }

}
