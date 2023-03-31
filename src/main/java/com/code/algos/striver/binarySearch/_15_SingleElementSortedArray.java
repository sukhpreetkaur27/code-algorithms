package com.code.algos.striver.binarySearch;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
 * 
 * @author sukh
 *
 */
public class _15_SingleElementSortedArray {

  /**
   * NOTE:<br>
   * Array consists of odd # of elements.
   * 
   * On removing a pair, we pick the odd sub-array.
   */

  /**
   * Time: O(log n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public int single(int[] arr) {
    int l = 0;
    int r = arr.length - 1;
    int mid;

    while (l <= r) {
      mid = l + (r - l) / 2;

      boolean evenHalves = (r - mid) % 2 == 0;

      if (mid < r && arr[mid] == arr[mid + 1]) {
        if (evenHalves) {
          l = mid + 2;
        } else {
          r = mid - 1;
        }
      } else if (mid > l && arr[mid] == arr[mid - 1]) {
        if (evenHalves) {
          r = mid - 2;
        } else {
          l = mid + 1;
        }
      } else {
        return arr[mid];
      }
    }
    return -1;
  }

}
