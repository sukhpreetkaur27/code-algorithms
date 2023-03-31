package com.code.algos.striver.twoPointer;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
 * 
 * @author sukh
 *
 */
public class _3_MaxConsecutiveOnes {

  /**
   * Time: O(n) <br>
   * worst case: O(2n)
   * Space: O(1)
   * @param nums
   * @param k
   * @return
   */
  public int longestOnes(int[] nums, int k) {
    int max = 0;

    int left = 0, right = 0, zero = 0;
    int n = nums.length;

    while (right < n) {
      if (nums[right] == 0) {
        zero++;
      }
      while (zero > k) {
        if (nums[left] == 0) {
          zero--;
        }
        left++;
      }
      max = Math.max(max, right - left + 1);
      right++;
    }

    return max;
  }

}
