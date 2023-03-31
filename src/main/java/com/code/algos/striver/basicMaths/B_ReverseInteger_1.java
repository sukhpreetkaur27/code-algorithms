package com.code.algos.striver.basicMaths;

public class B_ReverseInteger_1 {

  /**
   * Time: O(log10(n))<br>
   * as there are log10(n) digits in a number.<br>
   * Space: O(1)
   * @param n
   * @return
   */
  public int reverse(int n) {
    int rev = 0;
    int d;
    while (n != 0) {
      d = n % 10;

      /**
       * NOTE: 32-bit integer range: -2147483648 to 2147483647
       */

      if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && d > 7)) {
        return 0;
      }
      if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && d < -8)) {
        return 0;
      }

      rev = (rev * 10) + d;
      n /= 10;
    }
    return rev;
  }

}
