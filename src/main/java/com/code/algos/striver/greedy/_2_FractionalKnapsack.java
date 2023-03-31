package com.code.algos.striver.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item. 

 

Example 1:

Input:
N = 3, W = 50
values[] = {60,100,120}
weight[] = {10,20,30}
Output:
240.00
Explanation:Total maximum value of item
we can have is 240.00 from the given
capacity of sack. 
Example 2:

Input:
N = 2, W = 50
values[] = {60,100}
weight[] = {10,20}
Output:
160.00
Explanation:
Total maximum value of item
we can have is 160.00 from the given
capacity of sack.
 

Your Task :
Complete the function fractionalKnapsack() that receives maximum capacity , array of structure/class and size n and returns a double value representing the maximum value in knapsack.
Note: The details of structure/class is defined in the comments above the given function.


Expected Time Complexity : O(NlogN)
Expected Auxilliary Space: O(1)


Constraints:
1 <= N <= 105
1 <= W <= 105
 * 
 * @author sukh
 *
 */
public class _2_FractionalKnapsack {

  /**
   * Time: O(n log n + n) <br>
   * Space: O(1)
   * 
   * @param w
   * @param arr
   * @return
   */
  public double knapsack(int w, Item[] arr) {
    int n = arr.length;
    /**
     * Sort items as per value/weight in descending order
     */
    Arrays.sort(arr, new ItemComparator());

    double finalValue = 0.0;

    for (int i = 0, currWeight = 0; i < n; i++) {
      if (currWeight + arr[i].weight <= w) {
        currWeight += arr[i].weight;
        finalValue += arr[i].value;
      } else {
        int remainWeight = w - currWeight;
        finalValue += (double) (arr[i].value) / (double) (arr[i].weight)
            * (double) remainWeight;
        break;
      }
    }

    return finalValue;
  }

}

/**
 * Defining a Comparator in descending order
 */
class ItemComparator implements Comparator<Item> {
  @Override
  public int compare(Item a, Item b) {
    double a1 = (double) (a.value) / (double) (a.weight);
    double b1 = (double) (b.value) / (double) (b.weight);

    if (a1 == b1) {
      return 0;
    }
    if (a1 < b1) {
      return 1;
    }
    return -1;
  }
}

class Item {
  int value;
  int weight;

  Item(int value, int weight) {
    this.value = value;
    this.weight = weight;
  }
}