package com.code.algos.striver.greedy;

import java.util.Arrays;

/**
 * Geek is a software engineer. He is assigned with a task of calculating average waiting time of all the processes by following shortest job first policy.

The shortest job first (SJF) or shortest job next, is a scheduling policy that selects the waiting process with the smallest execution time to execute next.

Given an arrays of integers bt of size n. Array bt denotes burst time of each process. Calculate average waiting time of all the processes 
and return the nearest integer which is smaller or equal to the output.

Example 1:

Input:
n = 5
bt = [4,3,7,1,2]
Output: 4
Explanation: After sorting burst times by shortest job policy, calculated average waiting time is 4.
Example 2:

Input:
n = 4
arr = [1,2,3,4]
Output: 2
Explanation: After sorting burst times by shortest job policy, calculated average waiting time is 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function solve() which takes bt[] as input parameter 
and returns the average waiting time of all the processes.

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 100
1 <= arr[i] <= 100


 * @author sukh
 *
 */
public class _14_ShortestJobFirst {
  
  /**
   * Example: <br>
   * 
   * Process ID     Burst Time      Wait Time     Turn Around Time
   * 
   *    4               3               0               3
   *    1               6               3               9
   *    3               7               9               16
   *    2               8               16              25
   *    
   *    
   *    Average Wait Time = total wait time / count = 28/4 = 7
   */

  /**
   * Time: O(n log n) <br>
   * Space: O(1)
   * 
   * @param bt
   * @return
   */
  public int solve(int bt[]) {
    int n = bt.length;
    Arrays.sort(bt);

    long sum = 0;
    long time = 0;
    for (int i = 0; i < n - 1; i++) {
      time += bt[i];
      sum += time;
    }
    return (int) (sum / n);
  }
  
  /**
   * Approach 2: Segment Tree
   */
  public int wait(int bt[]) {
    return 1;
  }
  
  public static void main(String[] args) {
    _14_ShortestJobFirst obj = new _14_ShortestJobFirst();
    int[] arr = { 4, 3, 7, 1, 2 };
    System.out.println(obj.solve(arr));
  }

}
