package com.code.algos.striver.binarySearch;

/**
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104
 

Follow up: This problem is similar to Search in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?
 * 
 * @author sukh
 *
 */
public class _12_SearchSortedRotatedArray_Duplicates {
  
  /**
   * NOTE:<br>
   * Complexity Analysis
   * 
   * Time complexity : O(N) worst case, O(logN) best case, where NN is the length
   * of the input array.
   * 
   * Worst case: This happens when all the elements are the same and we search for
   * some different element. At each step, we will only be able to reduce the
   * search space by 1 since arr[mid] equals arr[start] and it's not possible to
   * decide the relative position of target from arr[mid]. Example: [1, 1, 1, 1,
   * 1, 1, 1], target = 2.
   * 
   * Best case: This happens when all the elements are distinct. At each step, we
   * will be able to divide our search space into half just like a normal binary
   * search.
   * 
   * This also answers the following follow-up question:
   * 
   * Would this (having duplicate elements) affect the run-time complexity? How
   * and why? As we can see, by having duplicate elements in the array, we often
   * miss the opportunity to apply binary search in certain search spaces. Hence,
   * we get O(N) worst case (with duplicates) vs O(logN) best case complexity
   * (without duplicates).
   * 
   */

  /**
   * Time: O(log n)<br>
   * Space: O(1)
   * @param arr
   * @param target
   * @return
   */
  public boolean search(int[] arr, int target) {
    int l = 0;
    int r = arr.length - 1;
    int mid;

    while (l <= r) {
      while (l < r && arr[l] == arr[l + 1]) {
        l++;
      }
      while (l < r && arr[r] == arr[r - 1]) {
        r--;
      }

      mid = l + (r - l) / 2;

      if (arr[mid] == target) {
        return true;
      } else if (arr[l] <= arr[mid]) {
        if (arr[l] <= target && target < arr[mid]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      } else {
        if (arr[mid] < target && target <= arr[r]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
    }
    return false;
  }

}
