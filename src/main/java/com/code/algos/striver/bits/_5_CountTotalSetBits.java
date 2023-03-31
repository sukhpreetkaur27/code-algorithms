package com.code.algos.striver.bits;

/**
 * You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).

Example 1:

Input: N = 4
Output: 5
Explanation:
For numbers from 1 to 4.
For 1: 0 0 1 = 1 set bits
For 2: 0 1 0 = 1 set bits
For 3: 0 1 1 = 2 set bits
For 4: 1 0 0 = 1 set bits
Therefore, the total set bits is 5.
Example 2:

Input: N = 17
Output: 35
Explanation: From numbers 1 to 17(both inclusive), 
the total number of set bits is 35.

 * 
 * @author sukh
 *
 */
public class _5_CountTotalSetBits {

  /**
   * Time: O(log n) <br>
   * Space: O(log n)
   * @param n
   * @return
   */
  public int count(int n) {
    if (n == 0) {
      return 0;
    }
    int x = largestPowerOf2(n);
    int bitsTill2x = (1 << (x - 1)) * x;
    int b1 = n - (1 << x);
    int msb2xTon = b1 + 1;
    int c = count(b1);
    return bitsTill2x + msb2xTon + c;
  }

  private int largestPowerOf2(int n) {
    int x = 0;
    while ((1 << x) <= n) {
      x++;
    }
    /**
     * NOTE: <br>
     * Return (x-1) not x
     */
    return x - 1;
  }

  public static void main(String[] args) {
    _5_CountTotalSetBits obj = new _5_CountTotalSetBits();
    int count = obj.count(4);
    System.out.println(count);
  }

}
