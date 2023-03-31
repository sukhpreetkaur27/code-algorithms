package com.code.algos.striver.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * 
 * @author sukh
 *
 */
public class _34_IntersectionArrays {

  /**
   * Note: <br>
   * What if nums1's size is small compared to nums2's size? Which algorithm is
   * better?
   * 
   * Approach 1 is a good choice here as we use a hash map for the smaller array.
   */

  /**
   * Time: O(n log n + m log m) <br>
   * Space: O(log n + log m) (or) O(n + m) <br>
   * depends on the sorting algo
   * @param arr1
   * @param arr2
   * @return
   */
  public int[] intersect(int[] arr1, int[] arr2) {
    int l1 = arr1.length;
    int l2 = arr2.length;
    if (l1 > l2) {
      return intersect(arr2, arr1);
    }
    /**
     * Time: O(log n)
     */
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    List<Integer> list = new ArrayList<>();
    int p1 = 0, p2 = 0;
    while (p1 < l1 && p2 < l2) {
      if (arr1[p1] == arr2[p2]) {
        list.add(arr1[p1]);
        p1++;
        p2++;
      } else if (arr1[p1] < arr2[p2]) {
        p1++;
      } else {
        p2++;
      }
    }
    return list.stream().mapToInt(Integer::intValue).toArray();
  }

}
