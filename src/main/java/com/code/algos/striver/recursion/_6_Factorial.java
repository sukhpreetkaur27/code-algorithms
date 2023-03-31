package com.code.algos.striver.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * A number N is called a factorial number if it is the factorial of a positive integer. For example, the first few factorial numbers are 1, 2, 6, 24, 120,
Given a number N, the task is to return the list/vector of the factorial numbers smaller than or equal to N.

Example 1:

Input: N = 3
Output: 1 2
Explanation: The first factorial number is 
1 which is less than equal to N. The second 
number is 2 which is less than equal to N,
but the third factorial number is 6 which 
is greater than N. So we print only 1 and 2.
Example 2:

Input: N = 6
Output: 1 2 6
Explanation: The first three factorial 
numbers are less than equal to N but 
the fourth factorial number 24 is 
greater than N. So we print only first 
three factorial numbers.
 * 
 * @author sukh
 *
 */
public class _6_Factorial {

  public static List<Long> factorialNumbers(long N) {
    List<Long> list = new ArrayList<>();
    fact(N, list, 1l);
    return list;
  }

  private static void fact(long n, List<Long> facts, long i) {
    Long fact;
    if (facts.isEmpty()) {
      fact = 1l;
    } else {
      fact = i * facts.get(facts.size() - 1);
    }

    if (fact <= n) {
      facts.add(fact);
      fact(n, facts, i + 1l);
    } else {
      return;
    }
  }

}
