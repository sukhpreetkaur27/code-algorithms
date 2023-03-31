package com.code.algos.striver.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]
 

Constraints:

1 <= n <= 5 * 104
 * 
 * @author sukh
 *
 */
public class _21_LexicographicalOrder {
  
  /**
   * Time: O() <br>
   * Space: O()
   * 
   * @param n
   * @return
   */
  public List<Integer> lexicalOrder(int n) {
    /**
     * DFS
     */
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= 9; i++) {
      order(list, n, i);
    }
    return list;
  }

  private void order(List<Integer> list, int n, int index) {
    if (index > n) {
      return;
    }
    list.add(index);
    for (int i = 0; i <= 9; i++) {
      order(list, n, index * 10 + i);
    }
  }

}
