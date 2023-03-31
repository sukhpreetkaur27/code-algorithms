package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Geek is going for n days training program, he can perform any one of these three activities Running, Fighting, and Learning Practice. 
 * each activity has the same point on each day. as Geek wants to improve all his skills, he can't do the same activity on two consecutive days, 
 * help Geek to maximize his merit points as we were given a 2D array of n*3 points corresponding to each day and activity.

Example:
Input:
n = 3
point= [[1,2,5],[3,1,1],[3,3,3]]
Output:
11
Explanation:
Geek will learn a new move and earn 5 point then on second
day he will do running and earn 3 point and on third day
he will do fighting and earn 3 points so, maximum point is 11.
Your Task:
You don't have to read input or print anything. Your task is to complete the function maximumPoints() which takes the integer n and 2 D array points 
and returns the maximum point he can earn.

Expected Time Complexity: O(n)
Expected Space Complexity: O(n2)

Constraint:
1 <=  n <= 100000
1 <=  point[i] <= 100
 * 
 * @author sukh
 *
 */
public class _10_GeeksTraining {

  public int maximumPoints_recursion(int points[][], int N) {
    /**
     * Recursion: TLE
     */
    return maximumPoints_recursive(points, N - 1, 3);
  }

  public int maximumPoints_recursive(int points[][], int index, int last) {
    /**
     * index == day
     * 
     * last == the last task performed
     */
    if (index < 0) {
      return 0;
    }
    int max = 0;
    for (int i = 0; i < 3; i++) {
      if (i != last) {
        max = Math.max(max,
            points[index][i] + maximumPoints_recursive(points, index - 1, i));
      }
    }
    return max;
  }

  public int maximumPoints_memoization(int points[][], int N) {
    /**
     * Memoization
     */
    int[][] dp = new int[N][4];
    for (int i = 0; i < N; i++) {
      Arrays.fill(dp[i], -1);
    }
    return maximumPoints_memoize(points, N - 1, 3, dp);
  }

  public int maximumPoints_memoize(int points[][], int index, int last, int[][] dp) {
    if (index < 0) {
      return 0;
    }
    if (dp[index][last] != -1) {
      return dp[index][last];
    }
    int max = 0;
    for (int i = 0; i < 3; i++) {
      if (i != last) {
        max = Math.max(max,
            points[index][i] + maximumPoints_memoize(points, index - 1, i, dp));
      }
    }
    return dp[index][last] = max;
  }

  public int maximumPoints_tabulation(int points[][], int N) {
    /**
     * Tabulation
     */
    /**
     * Maximum till i-th day with j-th task on it
     * 
     * dp[index][3] = the maximum of all tasks till the index day
     */
    int[][] dp = new int[N][4];
    /**
     * Initialize 0-th day with the given points per task
     * 
     * Edge Case: N = 1 <br>
     * assign max to the maximum of all the points on the 0-th day
     */
    for (int i = 0; i < 3; i++) {
      dp[0][i] = points[0][i];
      dp[0][3] = Math.max(dp[0][3], dp[0][i]);
    }
    for (int i = 1; i < N; i++) {
      Arrays.fill(dp[i], -1);
    }

    for (int index = 1; index < N; index++) {
      for (int task = 0; task < 3; task++) {
        for (int last = 0; last < 3; last++) {
          if (task != last) {
            dp[index][task] = Math.max(dp[index][task],
                points[index][task] + dp[index - 1][last]);
          }
        }
        /**
         * pick the maximum of all tasks + last task combo
         */
        dp[index][3] = Math.max(dp[index][3], dp[index][task]);
      }
    }
    return dp[N - 1][3];
  }

  /**
   * Time: O(n * 3 * 3) <br>
   * Space: O(1)
   * 
   * @param points
   * @param N
   * @return
   */
  public int maximumPoints_optimal(int points[][], int N) {
    /**
     * Space Optimization
     */
    int[] prev = new int[4];
    for (int i = 0; i < 3; i++) {
      prev[i] = points[0][i];
      prev[3] = Math.max(prev[3], prev[i]);
    }
    int[] curr = new int[3];
    for (int index = 1; index < N; index++) {
      for (int task = 0; task < 3; task++) {
        for (int last = 0; last < 3; last++) {
          if (task != last) {
            curr[task] = Math.max(curr[task], points[index][task] + prev[last]);
          }
        }
        prev[3] = Math.max(prev[3], curr[task]);
      }
      for (int i = 0; i < 3; i++) {
        prev[i] = curr[i];
      }
    }
    return prev[3];
  }

}
