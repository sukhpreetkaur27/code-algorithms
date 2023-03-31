package com.code.algos.sorting.comparison.quicksort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 

Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 104
-104 < xi, yi < 104
 * @author sukh
 *
 */
public class KClosestPoints {

  /**
   * Average Time: O(n)<br>
   * Worst Time: O(n^2)<br>
   * Space: O(1)
   * @param points
   * @param k
   * @return
   */
  public int[][] kClosest(int[][] points, int k) {
    sortByDist(points, 0, points.length - 1, k);
    // 0 to k is our output list of points
    // as we have partially sorted our array
    return Arrays.copyOfRange(points, 0, k);
  }

  // Hoare's Selection Algo
  private void sortByDist(int[][] points, int left, int right, int k) {
    // Base case
    if (left >= right) {
      return;
    }

    // get pivot
    int pivotIndex = getPivotIndex(left, right);
    pivotIndex = partition(points, left, right, pivotIndex);

    if (k < pivotIndex) {
      sortByDist(points, left, pivotIndex - 1, k);
    } else if (pivotIndex < k) {
      sortByDist(points, pivotIndex + 1, right, k);
    }
  }

  // Lomuto Partition scheme
  private int partition(int[][] points, int left, int right, int pivotIndex) {
    int pivot = dist(points[pivotIndex]);
    swap(points, pivotIndex, right);

    // push the points with dist(point) <= dist(pivotIndex) to the left
    int index = left;
    for (int i = left; i <= right; i++) {
      if (dist(points[i]) <= pivot) {
        swap(points, index, i);
        index++;
      }
    }

    // push the pivotIndex point to its correct sorted position
    // such that:
    // LHS = points with dist(point) <= dist(pivotIndex)
    // RHS = points with dist(point) > dist(pivotIndex)
    swap(points, index, right);
    return index;
  }

  // calculate the distance from the origin
  private int dist(int[] point) {
    int dist = point[0] * point[0] + point[1] * point[1];
    return dist;
  }

  // Get a random pivot index
  private int getPivotIndex(int left, int right) {
    int pivotIndex = ThreadLocalRandom.current().nextInt(left, right);
    return pivotIndex;
  }

  // swap the points
  private void swap(int[][] points, int left, int right) {
    int[] temp = points[left];
    points[left] = points[right];
    points[right] = temp;
  }

}
