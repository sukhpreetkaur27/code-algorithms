package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Assume you're looking to move, and have a set of amenities that you want to have easy access to from your new home. 
 * You have found a neighborhood you like, each block of which has zero or more amenities. 
 * How would you pick the block to live in such that the farthest distance to any amenity in your list is minimized?

Example:
Say your list contains {school, grocery}, and the blocks are as follows:
1: restaurant, grocery
2: movie theater
3: school
4:
5: school

The ideal choice would be block 2, such that the distances to the grocery and the nearest school are 1 each. 
Living on block 1 or 3 would make one of the distances zero, but the other one 2.
 * 
 * @author sukh
 *
 */
public class _60_MinDistanceBlock {

  /**
   * Time: O(m * n) <br>
   * Space: O(m * n)
   * 
   * @param requirements
   * @param blocks
   * @return
   */
  public int minDistance(int[] requirements, int[][] blocks) {
    /**
     * Requirements: <br>
     * Gym = 0, School = 1, Store = 2
     * 
     * Blocks: <br>
     * { <br>
     * [0, 1, 0], <br>
     * [1, 0, 0,], <br>
     * [1, 1, 0], <br>
     * [0, 1, 0], <br>
     * [0, 1, 1] <br>
     * }
     */
    int block = -1;
    int min = Integer.MAX_VALUE;
    int r = requirements.length;
    int b = blocks.length;
    /**
     * The last column stores the maximum distance per row
     */
    int[][] dp = new int[b][r + 1];
    for (int[] i : dp) {
      Arrays.fill(i, Integer.MAX_VALUE);
    }

    /**
     * for the 0-th block, minimum distance cannot be from the left
     * 
     * so initialize with the default values
     */
    dp[0][r] = 0;
    for (int i = 0; i < r; i++) {
      if (blocks[0][i] == 1) {
        dp[0][i] = 0;
      }
      dp[0][r] = Math.max(dp[0][r], dp[0][i]);
    }

    min = Math.min(min, dp[0][r]);
    /**
     * 0-th block has all the requirements
     */
    if (min == 0) {
      return 0;
    }

    /**
     * Traverse from Left
     */
    for (int i = 1; i < b; i++) {
      dp[i][r] = 0;
      for (int j = 0; j < r; j++) {
        if (blocks[i][j] == 1) {
          dp[i][j] = 0;
        } else if (dp[i - 1][j] != Integer.MAX_VALUE) {
          dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
        }
        dp[i][r] = Math.max(dp[i][r], dp[i][j]);
      }
    }

    /**
     * for the n-th block, minimum distance cannot be from the right
     * 
     * so consider its r-th column to be its maximum
     * 
     * hence update the minimum result
     */
    min = Math.min(min, dp[b - 1][r]);
    /**
     * n-th block has all the requirements
     */
    if (min == 0) {
      return b - 1;
    }

    /**
     * Traverse from Right
     */
    for (int i = b - 2; i >= 0; i--) {
      dp[i][r] = 0;
      for (int j = 0; j < r; j++) {
        /**
         * if(blocks[i][j] == 1) { dp[i][j]=0; }
         * 
         * this has already been done on the left traversal
         */
        if (blocks[i][j] != 1 && dp[i + 1][j] != Integer.MAX_VALUE) {
          dp[i][j] = Math.min(dp[i + 1][j] + 1, dp[i][j]);
        }
        dp[i][r] = Math.max(dp[i][r], dp[i][j]);
      }
      if (min > dp[i][r]) {
        min = dp[i][r];
        block = i;
      }
    }

//    for (int i = 0, dist = 0; i < b; i++) {
//      dist = 0;
//      for (int j = 0; j < r; j++) {
//        dist += min(blocks, i, requirements[j], dp);
//      }
//
//      if (dist < min) {
//        min = dist;
//        block = i;
//      }
//    }
    return block;
  }

  /**
   * NOTE: recursion is not optimal as for the n-th block we end traversing till
   * 0-th block in case --> exponential TC
   * 
   * instead if we traverse once left and remember it (dp) and then traverse from
   * right, we can calculate the min distance
   * 
   * NOTE: the following method isn't working
   */
  public int minDistance_recursion(int[] requirements, int[][] blocks) {
    /**
     * Requirements: <br>
     * Gym = 0, School = 1, Store = 2
     * 
     * Blocks: <br>
     * { <br>
     * [0, 1, 0], <br>
     * [1, 0, 0,], <br>
     * [1, 1, 0], <br>
     * [0, 1, 0], <br>
     * [0, 1, 1] <br>
     * }
     */
    int block = -1;
    int min = Integer.MAX_VALUE;
    int r = requirements.length;
    int b = blocks.length;
    /**
     * The last column stores the maximum distance per row
     */
    int[][] dp = new int[b][r + 1];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }

    for (int i = 0, dist = 0; i < b; i++) {
      dist = 0;
      for (int j = 0; j < r; j++) {
        dist += min(blocks, i, requirements[j], dp);
      }

      if (dist < min) {
        min = dist;
        block = i;
      }
    }
    return block;
  }

  private int min(int[][] blocks, int block, int requirement, int[][] dp) {
    if (block < 0 || block >= blocks.length) {
      return Integer.MAX_VALUE;
    }
    if (blocks[block][requirement] == 1) {
      return 0;
    }
    if (dp[block][requirement] != -1) {

    }
    int left = min(blocks, block - 1, requirement, dp);
    if (left != Integer.MAX_VALUE) {
      left += 1;
    }
    int right = min(blocks, block + 1, requirement, dp);
    if (right != Integer.MAX_VALUE) {
      right += 1;
    }
    return Math.min(right, left);
  }

  public static void main(String[] args) {
    _60_MinDistanceBlock obj = new _60_MinDistanceBlock();
    int[] requirements = { 0, 1, 2 };
//    int[][] blocks = { { 0, 1, 0 }, { 1, 0, 0 }, { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 1 } };
    int[][] blocks = { { 0, 1, 0 }, { 1, 0, 0 }, { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 1 } };
    int block = obj.minDistance(requirements, blocks);
    /**
     * answer = 3
     */
    System.out.println(block);
  }

}
