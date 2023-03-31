package com.code.algos.striver.binarySearch;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 * 
 * @author sukh
 *
 */
public class _7_FirstLastPosition {

  /**
   * Time: O(log n) <br>
   * Space: O(1)
   * @param arr
   * @param x
   * @return
   */
  public int[] searchRange(int[] arr, int x) {
    int first = binarySearch(arr, x, true);
    if (first == -1) {
      return new int[] { -1, -1 };
    }
    int last = binarySearch(arr, x, false);
    return new int[] { first, last };
  }

  private int binarySearch(int[] arr, int x, boolean isFirst) {
    int lo = 0;
    int hi = arr.length - 1;
    int mid;

    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;

      if (arr[mid] == x) {
        if (isFirst) {
          if (mid == lo || arr[mid - 1] != x) {
            return mid;
          }
          hi = mid - 1;
        } else {
          if (mid == hi || arr[mid + 1] != x) {
            return mid;
          }
          lo = mid + 1;
        }
      } else if (x < arr[mid]) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return -1;
  }

}
