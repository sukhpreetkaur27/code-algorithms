package com.code.algos.striver.binarySearch;

/**
 * Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. 
 * The task is to find the element that would be at the k’th position of the final sorted array.
 

Example 1:

Input:
arr1[] = {2, 3, 6, 7, 9}
arr2[] = {1, 4, 8, 10}
k = 5
Output:
6
Explanation:
The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.
Example 2:
Input:
arr1[] = {100, 112, 256, 349, 770}
arr2[] = {72, 86, 113, 119, 265, 445, 892}
k = 7
Output:
256
Explanation:
Final sorted array is - 72, 86, 100, 112,
113, 119, 256, 265, 349, 445, 770, 892
7th element of this array is 256.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function kthElement() which takes the arrays arr1[], arr2[], 
its size N and M respectively and an integer K as inputs and returns the element at the Kth position.


Expected Time Complexity: O(Log(N) + Log(M))
Expected Auxiliary Space: O(Log (N))


Constraints:
1 <= N, M <= 106
1 <= arr1i, arr2i < INT_MAX
1 <= K <= N+M
 * 
 * @author sukh
 *
 */
public class _17_KthElementSortedArrays {

  /**
   * Time: O(log min(m,n))<br>
   * Space: O(1)
   * @param arr1
   * @param arr2
   * @param k
   * @return
   */
  public int kElement(int[] arr1, int[] arr2, int k) {
    int n1 = arr1.length;
    int n2 = arr2.length;

    if (n1 > n2) {
      return kElement(arr1, arr2, k);
    }

    /**
     * NOTE:<br>
     * We perform BS on the smaller array.
     */

    /**
     * NOTE:<br>
     * if n2<k, then we always need to pick some elements from arr1
     */
    int lo = Math.max(0, k - n2);
    /**
     * NOTE:<br>
     * if k<n1, then we need to pick at most k elements from arr1 > <br>
     * else, we can pick at most all the elements from arr1
     */
    int hi = Math.min(k, n1);

    /**
     * NOTE:<br>
     * Partitioning arr1 and arr2 respectively
     */
    int cut1, cut2;
    /**
     * LHS elements from arr1 and arr2 respectively;
     */
    int l1, l2;
    /**
     * RHS elements from arr1 and arr2 respectively;
     */
    int r1, r2;

    while (lo <= hi) {
      /**
       * mid of arr1
       */
      cut1 = lo + hi >> 1;
      cut2 = k - cut1;

      l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
      l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];

      r1 = cut1 == n1 ? Integer.MAX_VALUE : arr1[cut1];
      r2 = cut2 == n2 ? Integer.MAX_VALUE : arr2[cut2];

      /**
       * Check for partition validity
       */
      if (l1 <= r2 && l2 <= r1) {
        return Math.max(l1, l2);
      } else if (l1 > r2) {
        hi = cut1 - 1;
      } else {
        lo = cut1 + 1;
      }
    }
    return 0;
  }

}
