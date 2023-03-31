package com.code.algos.striver.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two positive integers L, R and a digit D, find out all the good numbers in the range [L, R], which do not contain the digit D.
A number is a good number if it's every digit is larger than the sum of digits which are on the right side of that digit. 
9620  is good as (2 > 0, 6 > 2+0, 9 > 6+2+0)

Example 1:

Input:
L=200
R=700
D=4
Output:
{210, 310, 320, 510, 520, 521, 530, 531,
610, 620, 621, 630, 631, 632, 650}
Explanation:
These are the only good numbers in the range
[200,700]
Example 2:

Input:
L=100
R=500
D=5
Output:
{210, 310, 320, 410, 420, 421, 430}
Explanation:
These are the only good numbers in the range
[100,500]
 * 
 * @author sukh
 *
 */
public class _12_GoodNumbers {

  /**
   * Time: O(n) <br>
   * Space: O(1)
   * @param l
   * @param r
   * @param d
   * @return
   */
  public List<Integer> goodNumbers(int l, int r, int d) {
    List<Integer> list = new ArrayList<>();
    for (int i = l; i <= r; i++) {
      if (isValid(l, d)) {
        list.add(i);
      }
    }
    return list;
  }

  private boolean isValid(int num, int digit) {
    int d = num % 10;
    if (d == digit) {
      return false;
    }
    int sum = d;
    num /= 10;
    while (num > 0) {
      d = num % 10;
      if (d == digit || d < sum) {
        return false;
      }
      sum += d;
      num /= 10;
    }
    return true;
  }

}
