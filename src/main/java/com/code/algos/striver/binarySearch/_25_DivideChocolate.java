package com.code.algos.striver.binarySearch;

/**
 * You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.

You want to share the chocolate with your k friends so you start cutting the chocolate bar into k + 1 pieces using k cuts, 
each piece consists of some consecutive chunks.

Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.

Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.

 

Example 1:

Input: sweetness = [1,2,3,4,5,6,7,8,9], k = 5
Output: 6
Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
Example 2:

Input: sweetness = [5,6,7,8,9,1,2,3,4], k = 8
Output: 1
Explanation: There is only one way to cut the bar into 9 pieces.
Example 3:

Input: sweetness = [1,2,2,1,2,2,1,2,2], k = 2
Output: 5
Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
 

Constraints:

0 <= k < sweetness.length <= 104
1 <= sweetness[i] <= 105
 * 
 * @author sukh
 *
 */
public class _25_DivideChocolate {

  /**
   * Time: O(n log k)<br>
   * k = sum(sweetness)/totalPeople<br>
   * Space: O(1)
   * @param sweetness
   * @param friends
   * @return
   */
  public int maximizeSelfSweetness(int[] sweetness, int friends) {
    int totalPeople = friends + 1;

    int n = sweetness.length;

    /**
     * lo = min(sweetness)
     */
    int lo = sweetness[0];
    /**
     * hi = equal division of sweetness i.e. average
     */
    int hi = sweetness[0];
    for (int i = 1; i < n; i++) {
      lo = Math.min(lo, sweetness[i]);
      hi += sweetness[i];
    }
    hi /= totalPeople;

    int mid, peopleWithChoco = 0;
    /**
     * we are not checking for value equality
     */
    while (lo < hi) {
      /**
       * if left = workable solution, right = unworkable solution <br>
       * mid = (left + right)/2 --> infinite loop as mid = left <br>
       * mid = (left + right + 1)/2 --> finite loop as mid = right
       */
      mid = (lo + hi + 1) / 2;

      peopleWithChoco = 0;

      for (int i = 0, currentSweetness = 0; i < n; i++) {
        currentSweetness += sweetness[i];
        if (currentSweetness >= mid) {
          peopleWithChoco++;
          currentSweetness = 0;
        }
      }

      if (peopleWithChoco >= totalPeople) {
        lo = mid;
      } else {
        hi = mid - 1;
      }
    }

    return lo;
  }

}
