package com.code.algos.striver.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
 * 
 * @author sukh
 *
 */
public class _32_KClosestElements {

  /**
   * Time: O(k + log (n-k)) <br>
   * Space: O(1)
   * @param arr
   * @param k
   * @param x
   * @return
   */
  public List<Integer> kClosest(int[] arr, int k, int x) {
    int n = arr.length;
    int lo = 0;
    int hi = n - 1;
    int mid;

    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;

      if (mid + k < n && Math.abs(x - arr[mid]) > Math.abs(x - arr[mid + k])) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    List<Integer> res = new ArrayList<>();
    for (int i = lo; i < lo + k; i++) {
      res.add(arr[i]);
    }
    return res;
  }

}
