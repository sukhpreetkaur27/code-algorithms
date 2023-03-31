package com.code.algos.striver.twoPointer;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 * 
 * @author sukh
 *
 */
public class _1_TrappingRainwater {

  /**
   * Time: O(n^2) <br>
   * Space: O(1)
   * @param height
   * @return
   */
  public int trap_bruteForce(int[] height) {
    int res = 0;
    int n = height.length;
    for (int i = 0, leftMax = 0, rightMax = 0; i < n; i++) {
      rightMax = 0;
      for (int j = 0; j <= i; j++) {
        leftMax = Math.max(leftMax, height[j]);
      }
      for (int j = i; j < n; j++) {
        rightMax = Math.max(rightMax, height[j]);
      }
      res += Math.min(leftMax, rightMax) - height[i];
    }
    return res;
  }

  /**
   * Time: O(n) <br>
   * Space: O(n)
   * @param height
   * @return
   */
  public int trap_better(int[] height) {
    int res = 0;
    int n = height.length;

    int[] prefixMax = new int[n];
    int[] suffixMax = new int[n];

    prefixMax[0] = height[0];
    for (int j = 1; j < n; j++) {
      prefixMax[j] = Math.max(prefixMax[j - 1], height[j]);
    }
    suffixMax[n - 1] = height[n - 1];
    for (int j = n - 2; j >= 0; j--) {
      suffixMax[j] = Math.max(suffixMax[j + 1], height[j]);
    }

    for (int i = 0; i < n; i++) {
      res += Math.min(prefixMax[i], suffixMax[i]) - height[i];
    }
    return res;
  }

  /**
   * NOTE: Optimal Solution <br>
   * Time: O(n) <br>
   * Space: O(n)
   * @param height
   * @return
   */
  public int trap(int[] height) {
    /**
     * Two Pointer Approach
     */

    int res = 0;

    int n = height.length;
    int left = 0;
    int right = n - 1;

    int leftMax = 0;
    int rightMax = 0;

    while (left <= right) {
      if (height[left] <= height[right]) {
        if (height[left] >= leftMax) {
          leftMax = height[left];
        } else {
          /**
           * Intuition: <br>
           * we have a left boundary <= right boundary
           */
          res += leftMax - height[left];
        }
        left++;
      } else {
        if (height[right] >= rightMax) {
          rightMax = height[right];
        } else {
          /**
           * Intuition: <br>
           * we have a left boundary >= right boundary
           */
          res += rightMax - height[right];
        }
        right--;
      }
    }

    return res;
  }

}
