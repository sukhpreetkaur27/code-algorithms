package com.code.algos.striver.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * In operating systems that use paging for memory management, page replacement algorithm is needed to decide which page needs to be replaced when the new page comes in. 
 * Whenever a new page is referred and is not present in memory, the page fault occurs and Operating System replaces one of the existing pages with a newly needed page.

Given a sequence of pages in an array pages[] of length N and memory capacity C, find the number of page faults using Least Recently Used (LRU) Algorithm. 

Note:- Before solving this example revising the OS LRU cache mechanism is recommended.

Example 1:

Input: N = 9, C = 4
pages = {5, 0, 1, 3, 2, 4, 1, 0, 5}
Output: 8
Explanation: memory allocated with 4 pages 5, 0, 1, 
3: page fault = 4
page number 2 is required, replaces LRU 5: 
page fault = 4+1 = 5
page number 4 is required, replaces LRU 0: 
page fault = 5 + 1 = 6
page number 1 is required which is already present: 
page fault = 6 + 0 = 6
page number 0 is required which replaces LRU 3: 
page fault = 6 + 1 = 7
page number 5 is required which replaces LRU 2: 
page fault = 7 + 1  = 8.
Your Task:
You do not need to read input or print anything. Your task is to complete the function pageFaults() which takes N, C and pages[] as input parameters 
and returns the number of page faults.

Expected Time Complexity: O(N*C)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 1000
1 ≤ C ≤ 100
1 ≤ pages[i] ≤ 1000
 * 
 * @author sukh
 *
 */
public class _15_LRUPageFaults {

  class Page {
    int page;
    Page prev;
    Page next;

    Page() {

    }

    Page(int page) {
      this.page = page;
    }
  }

  private Page head;
  private Page tail;
  private Map<Integer, Page> map;

  _15_LRUPageFaults() {
    head = new Page();
    tail = new Page();
    head.next = tail;
    tail.prev = head;
  }

  private void addToHead(Page page) {
    page.prev = head;
    page.next = head.next;
    head.next.prev = page;
    head.next = page;
  }

  private Page popTail() {
    Page pop = tail.prev;
    pop.prev.next = tail;
    tail.prev = pop.prev;
    return pop;
  }

  private void removePage(Page page) {
    Page prev = page.prev;
    Page next = page.next;
    prev.next = next;
    next.prev = prev;
  }

  private void moveToHead(Page page) {
    removePage(page);
    addToHead(page);
  }

  /**
   * Time: O(n) <br>
   * Space: O(c)
   * 
   * @param N
   * @param C
   * @param pages
   * @return
   */
  public int pageFaults(int N, int C, int pages[]) {
    int fault = 0;
    map = new HashMap<>(C);
    for (int i : pages) {
      Page page = map.get(i);
      if (page == null) {
        fault++;
        page = new Page(i);
        addToHead(page);
        if (map.size() == C) {
          Page tail = popTail();
          map.remove(tail.page);
        }
        map.put(i, page);
      } else {
        moveToHead(page);
      }
    }
    return fault;
  }

}
