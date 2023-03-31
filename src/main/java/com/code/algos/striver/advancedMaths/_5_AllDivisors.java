package com.code.algos.striver.advancedMaths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer N, print all the divisors of N in the ascending order.
 

Example 1:

Input : 20
Output: 1 2 4 5 10 20
Explanation: 20 is completely 
divisible by 1, 2, 4, 5, 10 and 20.

Example 2:

Input: 21191
Output: 1 21191
Explanation: As 21191 is a prime number,
it has only 2 factors(1 and the number itself).

 * 
 * @author sukh
 *
 */
public class _5_AllDivisors {

  /**
   * Time: O(log n + sqrt(n)) <br>
   * Space: O(sqrt(n))
   * @param n
   */
  public void print_divisors(int n) {
    List<Integer> al = new ArrayList<>();
    int num = 2;
    al.add(1);
    if (n > 1) {
      al.add(n);
    }

    while (num * num <= n) {
      // find divisors
      if (n % num == 0) {
        al.add(num);
        if (num * num != n) {
          /*
           * n is the square of current num
           */
          al.add(n / num);
        }
      }
      num++;
    }
    Collections.sort(al);
    for (int i : al)
      System.out.print(i + " ");
  }

}
