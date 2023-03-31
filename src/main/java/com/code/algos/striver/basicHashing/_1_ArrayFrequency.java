package com.code.algos.striver.basicHashing;

import java.util.HashMap;
import java.util.Map;

public class _1_ArrayFrequency {

  public static void frequencyCount(int arr[], int N, int P) {
    Map<Integer, Integer> freq = new HashMap<>();
    // code here
    for (int i = 0; i < N; i++) {
      freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
    }
    for (int i = 1; i <= P; i++) {
      System.out.print(freq.getOrDefault(i, 0) + " ");
    }
  }

  public static void main(String[] args) {
    int N = 5;
    int arr[] = { 3, 2, 2, 2, 1 };
    int P = 3;
    frequencyCount(arr, N, P);
  }

}
