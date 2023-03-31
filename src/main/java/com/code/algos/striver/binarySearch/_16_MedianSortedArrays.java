package com.code.algos.striver.binarySearch;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation: merged array =
 * [1,2,3] and median is 2. Example 2:
 * 
 * Input: nums1 = [1,2], nums2 = [3,4] Output: 2.50000 Explanation: merged array
 * = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * 
 * Constraints:
 * 
 * nums1.length == m nums2.length == n 0 <= m <= 1000 0 <= n <= 1000 1 <= m + n
 * <= 2000 -106 <= nums1[i], nums2[i] <= 106
 * 
 * @author sukh
 *
 */
public class _16_MedianSortedArrays {

  /**
   * Time: O(log min(m,n))<br>
   * Space: O(1)
   * @param arr1
   * @param arr2
   * @return
   */
  public double median(int[] arr1, int[] arr2) {
    int n1 = arr1.length;
    int n2 = arr2.length;

    /**
     * NOTE: Always perform Binary Search on the smaller array.
     */
    if (n1 > n2) {
      return median(arr2, arr1);
    }

    /**
     * NOTE:<br>
     * If total length == odd, then LHS (of median) will have the max elements (i.e.
     * inclusive of the median)<br>
     * If total length == even, then also the int answer of the following is
     * same.<br>
     * 
     * Example:
     * 
     * 1. Even length<br>
     * n1=5, n2=5; medianPos=5
     * 
     * 2. Odd length<br>
     * n1=4, n2=5; medianPos=5
     */
    int medianPos = (n1 + n2 + 1) / 2;

    /**
     * Total Length is Odd or even
     */
    int totalLength = (n1 + n2) % 2;

    /**
     * NOTE:<br>
     * For Left Hand Side (on partitioning the whole lot on median)<br>
     * lo = 0, i.e., we can pick at least 0 elements from the first array<br>
     * hi = n1, i.e., we can pick at max all the elements from the first array
     */
    int lo = 0;
    int hi = n1;

    /**
     * LHS elements from arr1 and arr2 respectively;
     */
    int l1, l2;
    /**
     * RHS elements from arr1 and arr2 respectively;
     */
    int r1, r2;

    /**
     * NOTE:<br>
     * Partitioning for arr1 and arr2 respectively
     */
    int cut1;
    int cut2;

    while (lo <= hi) {
      /**
       * Applying BS on arr1
       */
      cut1 = lo + (hi - lo) / 2;
      /**
       * Remaining LHS elements are picked from arr2
       */
      cut2 = medianPos - cut1;

      /**
       * Based on partitioning
       */
      l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
      l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];

      r1 = cut1 == n1 ? Integer.MAX_VALUE : arr1[cut1];
      r2 = cut2 == n2 ? Integer.MAX_VALUE : arr2[cut2];

      /**
       * Check for partition validity
       */
      if (l1 <= r2 && l2 <= r1) {
        /**
         * Even length
         */
        if (totalLength == 0) {
          return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
        } else {
          return Math.max(l1, l2);
        }
      } else if (l1 > r2) {
        hi = cut1 - 1;
      } else {
        lo = cut1 + 1;
      }
    }
    return 0.0;
  }

}
