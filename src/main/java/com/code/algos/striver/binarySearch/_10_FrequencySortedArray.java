package com.code.algos.striver.binarySearch;

/**
 * Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:

Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.
Example 2:

Input:
N = 7, X = 4
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 0
Explanation: 4 is not present in the
given array.
Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which takes the array of integers arr, n and x as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 106
1 ≤ X ≤ 106
 * 
 * @author sukh
 *
 */
public class _10_FrequencySortedArray {

  /**
   * Time: O(log n) <br>
   * Space: O(1)
   * @param arr
   * @param x
   * @return
   */
  public int frequency(int[] arr, int x) {
    int first = binarySearch(arr, x, true);
    if (first == -1) {
      return 0;
    }
    int last = binarySearch(arr, x, false);
    return last - first + 1;
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
