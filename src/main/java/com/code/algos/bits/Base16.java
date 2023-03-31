package com.code.algos.bits;

/**
 * Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

Note: You are not allowed to use any built-in library method to directly solve this problem.

 

Example 1:

Input: num = 26
Output: "1a"
Example 2:

Input: num = -1
Output: "ffffffff"
 

Constraints:

-231 <= num <= 231 - 1
 * 
 * @author sukh
 *
 */
public class Base16 {

  public String convert(int n) {
    /**
     * NOTE: <br>
     * To convert from binary to hexadecimal, divide the binary number into groups
     * of 4 bits
     */
    if (n == 0) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
        'f' };
    while (n != 0) {
      /**
       * look at the last 4 digits
       */
      sb.append(hex[n & 15]);
      /**
       * remove the last 4 digits
       */
      n >>>= 4;
    }
    return sb.reverse().toString();
  }

}
