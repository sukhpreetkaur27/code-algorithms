package com.code.algos.striver.binarySearch;

/**
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, 
 * divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer.

 

Example 1:

Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
Example 2:

Input: nums = [44,22,33,11,1], threshold = 5
Output: 44
 

Constraints:

1 <= nums.length <= 5 * 104
1 <= nums[i] <= 106
nums.length <= threshold <= 106
 * 
 * @author sukh
 *
 */
public class _22_SmallestDivisor {

  /**
   * Time: O(n log k)<br>
   * k = max(nums)<br>
   * Space: O(1)
   * @param nums
   * @param threshold
   * @return
   */
  public int divisor(int[] nums, int threshold) {
    int n = nums.length;
    int lo = 1;
    int hi = nums[0];
    for (int i = 1; i < n; i++) {
      hi = Math.max(hi, nums[i]);
    }

    int mid, sum;
    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;

      sum = 0;
      for (int i = 0; i < n; i++) {
        sum += Math.ceil((double) nums[i] / mid);
      }

      /**
       * If current divisor does not exceed threshold, then it can be our answer, but
       * also try smaller divisors thus change search space to left half.
       */
      if (sum <= threshold) {
        hi = mid - 1;
      } else {
        /**
         * Otherwise, we need a bigger divisor to reduce the result sum thus change
         * search space to right half.
         */
        lo = mid + 1;
      }
    }
    return lo;
  }

}
