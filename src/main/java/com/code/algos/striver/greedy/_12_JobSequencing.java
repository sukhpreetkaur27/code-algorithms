package com.code.algos.striver.greedy;

import java.util.Arrays;

/**
 * Given a set of N jobs where each jobi has a deadline and profit associated with it.

Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.


Example 1:

Input:
N = 4
Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
Output:
2 60
Explanation:
Job1 and Job3 can be done with
maximum profit of 60 (20+40).
Example 2:

Input:
N = 5
Jobs = {(1,2,100),(2,1,19),(3,2,27),
        (4,1,25),(5,1,15)}
Output:
2 127
Explanation:
2 jobs can be done with
maximum profit of 127 (100+27).

Your Task :
You don't need to read input or print anything. Your task is to complete the function JobScheduling() which takes an integer N and an array of 
Jobs(Job id, Deadline, Profit) as input and returns the count of jobs and maximum profit as a list or vector of 2 elements.


Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(N)


Constraints:
1 <= N <= 105
1 <= Deadline <= 100
1 <= Profit <= 500
 * 
 * @author sukh
 *
 */
public class _12_JobSequencing {

  class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
      this.id = x;
      this.deadline = y;
      this.profit = z;
    }
  }

  /**
   * Time: O(n log n + n * m) <br>
   * Space: O(m)
   * 
   * @param arr
   * @param n
   * @return
   */
  int[] JobScheduling(Job arr[], int n) {
    /**
     * To maximize profit, sort in descending order of profit
     */
    Arrays.sort(arr, (Job a, Job b) -> b.profit - a.profit);
    int count = 0;
    int profit = 0;
    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, arr[i].deadline);
    }
    int[] jobs = new int[max + 1];
    for (int i = 0, j = 0; i < n; i++) {
      /**
       * Complete the job on the last deadline in order to incorporate more jobs and
       * thus maximizing profit
       */
      j = arr[i].deadline;
      while (j > 0 && jobs[j] != 0) {
        j--;
      }
      if (j > 0) {
        jobs[j] = arr[i].id;
        count++;
        profit += arr[i].profit;
      }
    }
    return new int[] { count, profit };
  }

}
