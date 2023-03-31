package com.code.algos.striver.dp;

/**
 * Given an array arr, partition it into two subsets(possibly empty) such that their union is the original array. Let the sum of the element of these two subsets be S1 and S2. 

Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and the difference S1 and S2 is equal to d. 
since the answer may be large return it modulo 109 + 7.

Example 1:

Input:
n = 4, d = 3
arr[] =  { 5, 2, 6, 4}
Output:
1
Explanation:
There is only one possible partition of this array. Partition : {6, 4}, {5, 2}. The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.
Example 2:

Input:
n = 4, d = 0
arr[] = {1, 1, 1, 1}
Output:
6 
Your Task:
You don't have to read input or print anything. Your task is to complete the function countPartitions() which takes the integer n and d and array arr 
and returns the count of partitions.

Constraint:
1 <= n <= 50
0 <= d  <= 2500
0 <= arr[i] <= 50

Expected Time Complexity: O( N * MAX_SUM), where N and MAX_SUM denote the number of elements in the array and the maximum possible sum of array elements.
Expected Space Complexity: O( N * MAX_SUM), where N and MAX_SUM denote the number of elements in the array and the maximum possible sum of array elements.
 * 
 * @author sukh
 *
 */
public class _22_PartitionsWithGivenDifference {

  /**
   * NOTE: This problem is an extension to
   * com.code.algos.striver.dp._21_CountSubsetSum
   */

  /**
   * 
   * @param n
   * @param diff
   * @param arr
   * @return
   */
  public int countPartitions(int n, int diff, int arr[]) {
    int total = 0;
    for (int i = 0; i < n; i++) {
      total += arr[i];
    }
    /**
     * s1 + s2 = total --> A
     * 
     * s1 - s2 = diff --> B
     * 
     * A - B --> s2 = (total - diff) / 2
     * 
     * we don't do A + B --> s1 = (total + diff) / 2 --> as it will increase the TC
     **/

    /**
     * as we have integers (int[] arr), so we cannot have decimal as sum
     * 
     * therefor, (total - diff) should be exactly divisble by 2, i.e., even
     **/
    if (((total - diff) & 1) != 0) {
      return 0;
    }
    /**
     * As all numbers are positive, so sum cannot be negative
     **/
    if ((total - diff) < 0) {
      return 0;
    }
    int target = (total - diff) / 2;

    _21_CountSubsetSum obj = new _21_CountSubsetSum();
    return obj.perfectSum_optimal(arr, n, target);
  }

}
