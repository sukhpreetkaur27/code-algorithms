package com.code.algos.striver.binarySearch;

/**
 * This is an interactive problem.

You have a sorted array of unique elements and an unknown size. 
You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:

returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
returns 231 - 1 if the i is out of the boundary of the array.
You are also given an integer target.

Return the index k of the hidden array where secret[k] == target or return -1 otherwise.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: secret = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in secret and its index is 4.
Example 2:

Input: secret = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in secret so return -1.
 

Constraints:

1 <= secret.length <= 104
-104 <= secret[i], target <= 104
secret is sorted in a strictly increasing order.
 * 
 * @author sukh
 *
 */
public class _38_SearchUnknownSizeArray {

  /**
   * Time: O(log k) <br>
   * Space: O(1)
   * @param reader
   * @param target
   * @return
   */
  public int search(ArrayReader reader, int target) {
    int lo = 0;
    int hi = 1;

    /**
     * Define search boundaries by multiplying by 2
     */
    while (reader.get(hi) < target) {
      hi <<= 1;
    }

    int mid, num;
    while (lo <= hi) {
      mid = lo + ((hi - lo) >> 1);

      num = reader.get(mid);

      if (num == target) {
        return mid;
      } else if (num < target) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return -1;
  }

}

class ArrayReader {

  int get(int index) {
    return 10;
  }

}
