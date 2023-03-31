package com.code.algos.striver.bits;

/**
 * Given an unsorted array, Arr[] of size N and that contains even number of occurrences for all numbers except two numbers. 
 * Find the two numbers in decreasing order which has odd occurrences.

Example 1:

Input:
N = 8
Arr = {4, 2, 4, 5, 2, 3, 3, 1}
Output: {5, 1} 
Explaination: 5 and 1 have odd occurrences.

Example 2:

Input:
N = 8
Arr = {1 7 5 7 5 4 7 4}
Output: {7, 1}
Explaination: 7 and 1 have odd occurrences.
 * 
 * @author sukh
 *
 */
public class _14_TwoOddNumbers {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param arr
   * @param n
   * @return
   */
  public int[] twoOddNum(int arr[], int n) {
    int xor = 0;
    for (int i : arr) {
      xor ^= i;
    }

    /**
     * Turn on the rightmost set bit
     */
    int setBit = xor & (-xor);
    int x = 0, y = 0;
    for (int i : arr) {
      if ((i & setBit) == 0) {
        x ^= i;
      } else {
        y ^= i;
      }
    }
    return new int[] { Math.max(x, y), Math.min(x, y) };
  }

}
