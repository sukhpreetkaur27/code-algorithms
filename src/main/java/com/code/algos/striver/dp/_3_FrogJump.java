package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 *  Geek wants to climb from the 0th stair to the (n-1)th stair. At a time the Geek can climb either one or two steps. A height[N] array is also given. 
 *  Whenever the geek jumps from stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. 
 *  return the minimum energy that can be used by the Geek to jump from stair 0 to stair N-1.

Example:
Input:
n = 4
height = {10 20 30 10}
Output:
20
Explanation:
Geek jump from 1st to 2nd stair(|20-10| = 10 energy lost).
Then a jump from the 2nd to the last stair(|10-20| = 10 energy lost).
so, total energy lost is 20 which is the minimum.
Your Task:
You don't need to read input or print anything. Your task is to complete the function MinimumEnergy() which takes the array height, and integer n, 
and returns the minimum energy that is lost.

Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraint:
1<=n<=100000
1<=height[i]<=1000
 * 
 * @author sukh
 *
 */
public class _3_FrogJump {

  public int minimumEnergy_recursion(int arr[], int N) {
    /**
     * Recursion - TLE
     */
    /**
     * 0-based array
     */
    return minimumEnergy_recursive(arr, N - 1);
  }

  public int minimumEnergy_recursive(int arr[], int n) {
    /**
     * Recursion - TLE
     */
    /**
     * Base Case
     * 
     * n = 0, no energy required to jump
     */
    if (n == 0) {
      return 0;
    }
    /**
     * Edge Case
     * 
     * n = 1, 1-2 = -1 --> not possible
     */
    if (n == 1) {
      return Math.abs(arr[1] - arr[0]);
    }
    int energy = Math.abs(arr[n] - arr[n - 1]);
    /**
     * Total Left Energy with 1 step at a time
     */
    int left = energy + minimumEnergy_recursive(arr, n - 1);
    energy = Math.abs(arr[n] - arr[n - 2]);
    /**
     * Total Right Energy with 2 steps at a time
     */
    int right = energy + minimumEnergy_recursive(arr, n - 2);
    /**
     * Find the best i.e. path with minimum energy
     */
    return Math.min(left, right);
  }

  public int minimumEnergy_memoization(int arr[], int N) {
    /**
     * Memoization - TLE
     */
    int[] dp = new int[N];
    Arrays.fill(dp, -1);
    /**
     * 0-based array
     */
    return minimumEnergy_memoize(arr, N - 1, dp);
  }

  public int minimumEnergy_memoize(int arr[], int n, int[] dp) {
    /**
     * Memoization - TLE
     */
    /**
     * Base Case
     * 
     * n = 0, no energy required to jump
     */
    if (n == 0) {
      return dp[0] = 0;
    }
    /**
     * Edge Case
     * 
     * n = 1, 1-2 = -1 --> not possible
     */
    if (n == 1) {
      return dp[1] = Math.abs(arr[1] - arr[0]);
    }
    if (dp[n] != -1) {
      return dp[n];
    }
    int energy = Math.abs(arr[n] - arr[n - 1]);
    /**
     * Total Left Energy with 1 step at a time
     */
    int left = energy + minimumEnergy_memoize(arr, n - 1, dp);
    energy = Math.abs(arr[n] - arr[n - 2]);
    /**
     * Total Right Energy with 2 steps at a time
     */
    int right = energy + minimumEnergy_memoize(arr, n - 2, dp);
    /**
     * Find the best i.e. path with minimum energy
     */
    return dp[n] = Math.min(left, right);
  }

  public int minimumEnergy_tabulation(int arr[], int N) {
    /**
     * Tabulation
     */
    /**
     * Stores the energy
     */
    int[] dp = new int[N];
    Arrays.fill(dp, -1);
    /**
     * 0-based array
     */
    dp[0] = 0;
    dp[1] = Math.abs(arr[0] - arr[1]);
    for (int i = 2; i < N; i++) {
      /**
       * left + 1-step energy
       */
      dp[i] = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
      /**
       * right + 2-step energy
       * 
       * pick the minimum
       */
      dp[i] = Math.min(dp[i], dp[i - 2] + Math.abs(arr[i] - arr[i - 2]));
    }
    return dp[N - 1];
  }

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * 
   * @param arr
   * @param N
   * @return
   */
  public int minimumEnergy_optimal(int arr[], int N) {
    int prev2 = 0;
    int prev = Math.abs(arr[0] - arr[1]);
    for (int i = 2, curr = 0; i < N; i++) {
      curr = prev + Math.abs(arr[i] - arr[i - 1]);
      curr = Math.min(curr, prev2 + Math.abs(arr[i] - arr[i - 2]));
      prev2 = prev;
      prev = curr;
    }
    return prev;
  }

}
