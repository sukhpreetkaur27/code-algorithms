package com.code.algos.recursion;

/**
 * You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 * 
 * @author sukh
 *
 */
public class MergeSortedLists_21 {

  private class Node {
    int val;
    Node next;

    Node(int val) {
      this.val = val;
    }
  }

  /**
   * Time: O(n+m)<br>
   * Space: O(n+m)
   * @param p1
   * @param p2
   * @return
   */
  public Node merge(Node p1, Node p2) {
    if (p1 == null) {
      return p2;
    } else if (p2 == null) {
      return p1;
    } else if (p1.val < p2.val) {
      p1.next = merge(p1.next, p2);
      return p1;
    } else {
      p2.next = merge(p1, p2.next);
      return p2;
    }
  }

}
