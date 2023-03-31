package com.code.algos.striver.recursion;

public class _5_SumOfFirstNNumbers {

  public long sum(int n) {
    if (n < 1) {
      return 0;
    }
    return n + sum(n - 1);
  }

}
