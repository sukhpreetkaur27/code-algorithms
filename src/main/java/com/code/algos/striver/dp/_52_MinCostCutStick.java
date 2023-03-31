package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:


Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.

You should perform the cuts in order, you can change the order of the cuts as you wish.

The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks 
(i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation.

Return the minimum total cost of the cuts.

 

Example 1:


Input: n = 7, cuts = [1,3,4,5]
Output: 16
Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the following scenario:

The first cut is done to a rod of length 7 so the cost is 7. The second cut is done to a rod of length 6 (i.e. the second part of the first cut), 
the third is done to a rod of length 4 and the last cut is to a rod of length 3. The total cost is 7 + 6 + 4 + 3 = 20.
Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a scenario with total cost = 16 (as shown in the example photo 7 + 4 + 3 + 2 = 16).
Example 2:

Input: n = 9, cuts = [5,6,1,4,2]
Output: 22
Explanation: If you try the given cuts ordering the cost will be 25.
There are much ordering with total cost <= 25, for example, the order [4, 6, 5, 2, 1] has total cost = 22 which is the minimum possible.
 

Constraints:

2 <= n <= 106
1 <= cuts.length <= min(n - 1, 100)
1 <= cuts[i] <= n - 1
All the integers in cuts array are distinct.
 * 
 * @author sukh
 *
 */
public class _52_MinCostCutStick {

  /**
   * Time: Exponential <br>
   * Space: O(n)
   * 
   * @param n
   * @param cuts
   * @return
   */
  public int minCost_recursion(int n, int[] cuts) {
    /**
     * Recursion: TLE
     */
    int[] cutss = new int[cuts.length + 2];
    int cuts_len = cutss.length;
    /**
     * Add dummy start and dummy end, which is equal to the actual start and end
     */
    cutss[0] = 0;
    cutss[cuts_len - 1] = n;
    int j = 1;
    for (int i : cuts) {
      cutss[j] = i;
      j++;
    }
    /**
     * sort the array to make the cuts uniform in fashion such that the partitions
     * are independent of each other
     */
    Arrays.sort(cutss);
    return minCost_recursive(cutss, 1, cuts_len - 2);
  }

  private int minCost_recursive(int[] cuts, int start, int end) {
    /**
     * NOTE: we don't consider =
     *
     * eg: start=3, end =3
     * 
     * then, length = cuts[end+1]-cuts[start-1]
     * 
     * at the least case it can be of length 1
     * 
     * hence, we consider the base case if start crosses end
     **/
    if (start > end) {
      return 0;
    }
    int min = (int) 1e9;
    for (int k = start, cost = 0; k <= end; k++) {
      cost = cuts[end + 1] - cuts[start - 1] + minCost_recursive(cuts, start, k - 1)
          + minCost_recursive(cuts, k + 1, end);
      min = Math.min(min, cost);
    }
    return min;
  }

  /**
   * Time: O(n * n * n) <br>
   * Space: O(n) + O(n * n)
   * 
   * @param n
   * @param cuts
   * @return
   */
  public int minCost_memoization(int n, int[] cuts) {
    /**
     * Memoization
     */
    int[] cutss = new int[cuts.length + 2];
    int cuts_len = cutss.length;
    cutss[0] = 0;
    cutss[cuts_len - 1] = n;
    int j = 1;
    for (int i : cuts) {
      cutss[j] = i;
      j++;
    }
    Arrays.sort(cutss);
    int[][] dp = new int[cuts_len][cuts_len];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return minCost_memoize(cutss, 1, cuts_len - 2, dp);
  }

  private int minCost_memoize(int[] cuts, int start, int end, int[][] dp) {
    /**
     * NOTE: we don't consider =
     *
     * eg: start=3, end =3
     * 
     * then, length = cuts[end+1]-cuts[start-1]
     * 
     * at the least case it can be of length 1
     * 
     * hence, we consider the base case if start crosses end
     **/
    if (start > end) {
      return 0;
    }
    if (dp[start][end] != -1) {
      return dp[start][end];
    }
    int min = (int) 1e9;
    for (int k = start, cost = 0; k <= end; k++) {
      cost = cuts[end + 1] - cuts[start - 1] + minCost_memoize(cuts, start, k - 1, dp)
          + minCost_memoize(cuts, k + 1, end, dp);
      min = Math.min(min, cost);
    }
    return dp[start][end] = min;
  }

  /**
   * Time: O(n * n * n) <br>
   * Space: O(n * n)
   * 
   * @param n
   * @param cuts
   * @return
   */
  public int minCost_tabulation(int n, int[] cuts) {
    /**
     * Tabulation
     */
    int[] cutss = new int[cuts.length + 2];
    int cuts_len = cutss.length;
    cutss[0] = 0;
    cutss[cuts_len - 1] = n;
    int j = 1;
    for (int i : cuts) {
      cutss[j] = i;
      j++;
    }
    Arrays.sort(cutss);
    int[][] dp = new int[cuts_len + 2][cuts_len + 2];
    for (int start = cuts_len - 2, min = 0; start > 0; start--) {
      for (int end = start; end <= cuts_len - 2; end++) {
        min = (int) 1e9;
        for (int k = start, cost = 0; k <= end; k++) {
          cost = cutss[end + 1] - cutss[start - 1] + dp[start][k - 1] + dp[k + 1][end];
          min = Math.min(min, cost);
        }
        dp[start][end] = min;
      }
    }
    return dp[1][cuts_len - 2];
  }

}
