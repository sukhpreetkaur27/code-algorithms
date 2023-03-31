package com.code.algos.striver.recursion;

import java.util.HashMap;
import java.util.Map;

public class _9_Fibonacci {

  Map<Integer, Integer> cache = new HashMap<>();

  /**
   * Time: O(n)<br>
   * Each number, starting at 2 up to and including N, is visited, computed and
   * then stored for O(1)O(1) access later on. Space: O(n)
   * @param n
   * @return
   */
  public int fib(int n) {
    if (cache.containsKey(n)) {
      return cache.get(n);
    }
    if (n < 2) {
      return n;
    }
    int res = fib(n - 1) + fib(n - 2);
    cache.put(n, res);
    return res;
  }

}
