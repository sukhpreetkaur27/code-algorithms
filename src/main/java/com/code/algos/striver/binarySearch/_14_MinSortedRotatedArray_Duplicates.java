package com.code.algos.striver.binarySearch;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [1,3,5]
Output: 1
Example 2:

Input: nums = [2,2,2,0,1]
Output: 0
 

Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
nums is sorted and rotated between 1 and n times.
 

Follow up: This problem is similar to Find Minimum in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?
 * 
 * @author sukh
 *
 */
public class _14_MinSortedRotatedArray_Duplicates {
  
  /**
   * NOTE:<br>
   * First of all, the problem of 153. Find Minimum in Rotated Sorted Array can be
   * considered as a specific case of this problem, where it just happens that the
   * array does not contain any duplicate. As a result, the very solutions of this
   * problem would work for the problem of #153 as well. It is just that we would
   * never come cross the case #3 (i.e. nums[pivot] == nums[high]) in the problem
   * of #153.
   * 
   * It is due to the fact that there might exist some duplicates in the array,
   * that we come up the case #3 which eventually render the time complexity of
   * the algorithm to be linear O(N), rather than
   * O(log​ N).
   * 
   * One might wonder that whether it works in case #3 if we move the lower
   * boundary (i.e. low += 1), rather than the upper boundary (i.e. high -= 1).
   * 
   * The short answer is that it could work for some cases, but not for all. For
   * instance, given the input [1, 3, 3], by moving the lower boundary, we would
   * skip the correct answer.
   * 
   * While we do low = pivot + 1 to reduce the search scope, then why not do high
   * = pivot - 1 instead of high = pivot? Or a similar question would be "why
   * don't we do check of low <= high rather than low < high"?
   * 
   * As a matter of fact, the binary search algorithm has several forms of
   * implementation, regarding how we set the boundaries and the loop conditions.
   * One can refer to the Explore card of Binary Search in LeetCode for more
   * details. As simple as the idea of binary search might seem to be, it is
   * tricky to make it work for all cases.
   * 
   * As one would discover from the card, the above implementation of binary
   * search complies with the template II of binary search. And by replacing high
   * = pivot with high = pivot - 1, the algorithm will not work.
   * 
   * As subtle as it looks like, the update of the pointers should be consistent
   * with the conditions of the loop. As a rule of thumb, it is advised to stick
   * with one form of binary search, and not to mix them up.
   * 
   * 
   */

  /**
   * NOTE:<br>
   * Template II
   */

  /**
   * Time: O(log n)<br>
   * Space: O(1)
   * @param arr
   * @return
   */
  public int min(int[] arr) {
    int l = 0;
    int r = arr.length - 1;
    int mid;

    while (l < r) {
      mid = l + (r - l) / 2;

      if (arr[mid] < arr[r]) {
        r = mid;
      } else if (arr[mid] > arr[r]) {
        l = mid + 1;
      } else {
        /**
         * arr[mid] == arr[r]
         */
        r--;
      }
    }
    return arr[l];
  }

}
