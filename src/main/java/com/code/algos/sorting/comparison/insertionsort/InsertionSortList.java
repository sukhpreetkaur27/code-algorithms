package com.code.algos.sorting.comparison.insertionsort;

import com.code.utility.SinglyNode;

public class InsertionSortList {

  /**
   * Time: O(n^2)<br>
   * Space: O(1)
   * @param head
   * @return
   */
  public SinglyNode sort(SinglyNode head) {
    SinglyNode dummy = new SinglyNode();
    SinglyNode prev = dummy;
    SinglyNode curr = head;
    SinglyNode next;

    while (curr != null) {
      next = curr.next;

      while (prev.next != null && prev.next.val < curr.val) {
        prev = prev.next;
      }

      curr.next = prev.next;
      prev.next = curr;

      prev = dummy;
      curr = next;
    }

    return dummy.next;
  }

}
