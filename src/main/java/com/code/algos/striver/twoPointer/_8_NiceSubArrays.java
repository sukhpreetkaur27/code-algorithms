package com.code.algos.striver.twoPointer;

/**
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There is no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
 * 
 * @author sukh
 *
 */
public class _8_NiceSubArrays {

  /**
   * Sliding Window Approach <br>
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param nums
   * @param k
   * @return
   */
  public int numberOfSubarrays_better(int[] nums, int k) {
    /**
     * NOTE: <br>
     * Exactly K times = at most K times - at most K - 1 times
     */
    return numberOfAtmost(nums, k) - numberOfAtmost(nums, k - 1);
  }

  public int numberOfAtmost(int[] nums, int k) {
    int n = nums.length;
    int l = 0;
    int r = 0;
    int odd = 0;
    int res = 0;

    while (r < n) {
      if ((nums[r] & 1) != 0) {
        odd++;
      }
      while (odd > k) {
        if ((nums[l] & 1) != 0) {
          odd--;
        }
        l++;
      }
      res += r - l + 1;
      r++;
    }
    return res;
  }

  /**
   * Sliding Window Approach - One pass<br>
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param nums
   * @param k
   * @return
   */
  public int numberOfSubarrays_optimized(int[] nums, int k) {
    int ans = 0;

    int n = nums.length;
    int l = 0;
    int r = 0;
    // count of even numbers
    int count = 0;

    while (r < n) {
      // count the odd numbers
      if ((nums[r] & 1) != 0) {
        k--;
        count = 0;
      }
      while (k == 0) {
        // count the odd numbers and shrink the left window
        k += nums[l++] & 1;
        /**
         * count of even numbers = # of sub-arrays with k odd numbers
         */
        count++;
      }
      ans = +count;
      r++;
    }

    return ans;
  }

}
