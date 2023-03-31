package com.code.algos.bits;

import java.math.BigInteger;

public class AddBinary_67 {

  /**
   * Time: O(n + m)<br>
   * Space: O(max(n,m))
   * @param a
   * @param b
   * @return
   */
  public String add(String a, String b) {
    BigInteger x = new BigInteger(a, 2);
    BigInteger y = new BigInteger(b, 2);

    BigInteger zero = new BigInteger("0", 2);
    BigInteger carry;
    BigInteger ans;
    while (y.compareTo(zero) != 0) {
      ans = x.xor(y);
      carry = x.and(y).shiftLeft(1);
      x = ans;
      y = carry;
    }

    return x.toString(2);
  }

}
