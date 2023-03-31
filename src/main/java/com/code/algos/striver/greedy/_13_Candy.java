package com.code.algos.striver.greedy;

import java.util.Arrays;

/**
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104
 * 
 * @author sukh
 *
 */
public class _13_Candy {

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * 
   * @param ratings
   * @return
   */
  public int candy(int[] ratings) {
    int n = ratings.length;
    int candy = 0;
    int[] c = new int[n];
    /**
     * Assign 1 candy to each child
     */
    Arrays.fill(c, 1);
    /**
     * Assign candies as per left neighbor
     */
    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1]) {
        c[i] = c[i - 1] + 1;
      }
    }
    candy += c[n - 1];
    /**
     * Assign candies as per right neighbor
     */
    for (int i = n - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        c[i] = Math.max(c[i], c[i + 1] + 1);
      }
      candy += c[i];
    }
    return candy;
  }

}
