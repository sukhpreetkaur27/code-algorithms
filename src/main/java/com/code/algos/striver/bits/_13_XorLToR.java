package com.code.algos.striver.bits;

/**
 * Find XOR of numbers from the range [L, R]
 * 
 * @author sukh
 *
 */
public class _13_XorLToR {

  /**
   * Time: O(1) <br>
   * Space: O(1)
   * @param start
   * @param end
   * @return
   */
  public int xor(int start, int end) {
    /**
     * find xor of elements from the range [1, L – 1] and from the range [1, R] and
     * then xor the respective answers again to get the xor of the elements from the
     * range [L, R]. This is because every element from the range [1, L – 1] will
     * get XORed twice in the result resulting in a 0 which when XORed with the
     * elements of the range [L, R] will give the result.
     */
    int xor1 = xor(start);
    int xor2 = xor(end);
    return xor1 ^ xor2;
  }

  private int xor(int n) {
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
