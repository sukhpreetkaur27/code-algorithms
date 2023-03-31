package com.code.algos.striver.bits;

/**
 * When we do XOR of numbers, we get 0 as the XOR value just before a multiple of 4. This keeps repeating before every multiple of 4. 
 
 * 
 * Number Binary-Repr  XOR-from-1-to-n
1         1           [0001]
2        10           [0011]
3        11           [0000]  <----- We get a 0
4       100           [0100]  <----- Equals to n
5       101           [0001]
6       110           [0111]
7       111           [0000]  <----- We get 0
8      1000           [1000]  <----- Equals to n
9      1001           [0001]
10     1010           [1011]
11     1011           [0000] <------ We get 0
12     1100           [1100] <------ Equals to n
 * 
 * @author sukh
 *
 */
public class _12_XorOneToN {

  /**
   * Time: O(1) <br>
   * Space: O(1)
   * @param n
   * @return
   */
  public int xor(int n) {
    if (n % 4 == 0) {
      return n;
    }
    if (n % 4 == 1) {
      return 1;
    }
    if (n % 4 == 2) {
      return n + 1;
    }
    return 0;
  }

}
