package com.code.algos.striver.binarySearch;

/**
 * You are given N number of books. Every ith book has Ai number of pages. 
You have to allocate contiguous books to M number of students. There can be many ways or permutations to do so. 
In each permutation, one of the M students will be allocated the maximum number of pages. 
Out of all these permutations, the task is to find that particular permutation in which 
the maximum number of pages allocated to a student is the minimum of those in all the other permutations and print this minimum value.

Each book will be allocated to exactly one student. Each student has to be allocated at least one book.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

 

Example 1:

Input:
N = 4
A[] = {12,34,67,90}
M = 2
Output:113
Explanation:Allocation can be done in 
following ways:{12} and {34, 67, 90} 
Maximum Pages = 191{12, 34} and {67, 90} 
Maximum Pages = 157{12, 34, 67} and {90} 
Maximum Pages =113. Therefore, the minimum 
of these cases is 113, which is selected 
as the output.

Example 2:

Input:
N = 3
A[] = {15,17,20}
M = 2
Output:32
Explanation: Allocation is done as
{15,17} and {20}
Your Task:
You don't need to read input or print anything. Your task is to complete the function findPages() which takes 2 Integers N, 
and m and an array A[] of length N as input and returns the expected answer.


Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(1)


Constraints:
1 <= N <= 105
1 <= A [ i ] <= 106
1 <= M <= 105
 * 
 * @author sukh
 *
 */
public class _28_MinOfMaxPages_II {

  /**
   * Time: O(n log k) <br>
   * k = sum(pages) <br>
   * Space: O(1)
   * @param pages
   * @param students
   * @return
   */
  public int findPages(int[] pages, int students) {
    int n = pages.length;

    /**
     * Since we have to find the minimum of the maximum pages <br>
     * therefore, lo = max(pages) <br>
     * hi = sum(pages)
     */
    int lo = pages[0];
    int hi = pages[0];
    for (int i = 0; i < n; i++) {
      lo = Math.max(lo, pages[i]);
      hi += pages[i];
    }

    int ans = -1;
    int mid;
    while (lo <= hi) {
      mid = (lo + hi) / 2;

      if (isPossible(mid, pages, students)) {
        /**
         * Minimum of maximum
         */
        ans = hi;
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return ans;
  }

  private boolean isPossible(int mid, int[] pages, int students) {
    int count = 0;
    for (int i = 0, sum = 0; i < pages.length; i++) {
      if ((sum + pages[i]) > mid) {
        sum = pages[i];
        if (++count > students) {
          return false;
        }
      } else {
        sum += pages[i];
      }
    }
    return true;
  }

}
