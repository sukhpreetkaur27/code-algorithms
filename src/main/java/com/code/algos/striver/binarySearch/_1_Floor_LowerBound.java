package com.code.algos.striver.binarySearch;

/**
 * Given a sorted array arr[] of size N without duplicates, and given a value x. Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x. Find the index of K(0-based indexing).

Example 1:

Input:
N = 7, x = 0 
arr[] = {1,2,8,10,11,12,19}
Output: -1
Explanation: No element less 
than 0 is found. So output 
is "-1".
Example 2:

Input:
N = 7, x = 5 
arr[] = {1,2,8,10,11,12,19}
Output: 1
Explanation: Largest Number less than 5 is
2 (i.e K = 2), whose index is 1(0-based 
indexing).
Your Task:
The task is to complete the function findFloor() which returns an integer denoting the index value of K or return -1 if there isn't any such number.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).
 * 
 * @author sukh
 *
 */
public class _1_Floor_LowerBound {
  
  /**
   * NOTE:<br>
   * Floor of X is the largest element which is smaller than or equal to X. Floor of X doesn’t exist if X is smaller than smallest element of Arr[].
   */

  /**
   * Time: O(log n)<br>
   * Space: O(1)
   * @param arr
   * @param x
   * @return
   */
  public int floor(int[] arr, int x) {
    return floor(arr, 0, arr.length - 1, x);
  }

  public int floor(int[] arr, int lo, int hi, int x) {
    if (lo > hi) {
      return -1;
    }
    if (x < arr[lo]) {
      return -1;
    }
    if (x == arr[lo]) {
      return arr[lo];
    }
    if (x >= arr[hi]) {
      return hi;
    }

    int mid = lo + (hi - lo) / 2;
    if (arr[mid] == x) {
      return mid;
    } else if (mid > 0 && arr[mid - 1] <= x && x < arr[mid]) {
      return mid - 1;
    } else if (arr[mid] > x) {
      return floor(arr, lo, mid - 1, x);
    }
    return floor(arr, mid + 1, hi, x);
  }

}
