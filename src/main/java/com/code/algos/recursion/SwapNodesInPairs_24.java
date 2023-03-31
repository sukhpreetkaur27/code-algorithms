package com.code.algos.recursion;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
 * 
 * @author sukh
 *
 */
public class SwapNodesInPairs_24 {

  private class Node {
    int data;
    Node next;

    Node(int val) {
      data = val;
    }
  }

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param head
   * @return
   */
  public Node swap(Node head) {
    /**
     * Recurse till end of the Linked list.<br>
     * Then backtrack and swap.
     */
    if (head == null || head.next == null) {
      return head;
    }

    Node first = head;
    Node second = head.next;

    first.next = swap(second.next);
    second.next = first;

    return second;
  }

}
