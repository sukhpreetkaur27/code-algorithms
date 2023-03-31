package com.code.algos.sorting.comparison.quicksort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Average Time: O(n)<br>
 * Worst Time: O(n^2)<br>
 * Space: O(n)
 * @author sukh
 *
 */
public class TopKFrequent {

  private ThreadLocalRandom rand;
  private Map<Integer, Integer> numFreqMap;

  public TopKFrequent() {
    numFreqMap = new HashMap<>();
  }

  private int[] topKFrequent(int[] arr, int k) {
    int size = arr.length;

    /**
     * Num-Frequency map
     */
    for (int num : arr) {
      numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
    }

    /**
     * Array of unique nums
     */
    int[] unique = new int[numFreqMap.size()];
    int i = 0;
    for (int num : numFreqMap.keySet()) {
      unique[i] = num;
      i++;
    }

    topKFrequent(unique, 0, size - 1, size - k);

    int[] topK = Arrays.copyOfRange(unique, size - k, size);
    return topK;
  }

  private void topKFrequent(int[] arr, int left, int right, int k) {
    if (left >= right) {
      return;
    }

    int pivotIndex = getPivotIndex(left, right);
    pivotIndex = partition(arr, left, right, pivotIndex);

    if (pivotIndex == k) {
      return;
    } else if (k < pivotIndex) {
      topKFrequent(arr, left, pivotIndex - 1, k);
    } else {
      topKFrequent(arr, pivotIndex + 1, right, k);
    }
  }

  private int partition(int[] arr, int left, int right, int pivotIndex) {
    int pivot = numFreqMap.get(arr[pivotIndex]);

    swap(arr, pivotIndex, right);

    int index = left;
    for (int i = left; i < right; i++) {
      if (numFreqMap.get(arr[i]) <= pivot) {
        swap(arr, i, index);
        index++;
      }
    }

    swap(arr, index, right);

    return index;
  }

  private int getPivotIndex(int left, int right) {
    int pivotIndex = rand.current().nextInt(left, right);
    return pivotIndex;
  }

  private void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 1, 1, 2, 2, 3 };
    int k = 2;
    System.out.println(Arrays.toString(nums));
    TopKFrequent obj = new TopKFrequent();
    int[] topK = obj.topKFrequent(nums, k);
    System.out.println("Top " + k + " frequent elements are: " + topK);

  }

}
