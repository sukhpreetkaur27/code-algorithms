package com.code.algos.striver.recursion.backtrack;

public class _1_PrintNumbers_2 {

  /**
   * Backtracking by placing the print statement after the function call.
   * @param n
   */
  public static void print(int n) {
    if (n < 1) {
      return;
    }
    print(n - 1);
    System.out.print(n + ", ");
  }

  public static void main(String[] args) {
    print(5);
  }

}
