package com.code.algos.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45
 * 
 * @author sukh
 *
 */
public class ClimbStairs_70 {

  Map<Integer, Integer> cache = new HashMap<>();

  public int climbStairs(int n) {
    return climbStairs(0, n);
  }

  public int climbStairs(int level, int top) {
    if (cache.containsKey(level)) {
      return cache.get(level);
    }
    if (level > top) {
      return 0;
    } else if (level == top) {
      return 1;
    }
    int counts = climbStairs(level + 1, top) + climbStairs(level + 2, top);
    cache.put(level, counts);
    return counts;
  }

}
