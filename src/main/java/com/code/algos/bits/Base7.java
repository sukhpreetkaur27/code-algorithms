package com.code.algos.bits;

/**
 * Given an integer num, return a string of its base 7 representation.

 

Example 1:

Input: num = 100
Output: "202"
Example 2:

Input: num = -7
Output: "-10"
 

Constraints:

-107 <= num <= 107
 * 
 * @author sukh
 *
 */
public class Base7 {
  
  /**
   * NOTE: <br>
   * To convert from binary to octal, divide the binary number into groups of 3
   * bits
   */

  /**
   * Time: O(log7 |num|) <br>
   * Divide num by 7 repeatedly during conversion will have up to log7 ​∣num∣
   * division operations at most. <br>
   * Space: O(log7 |num|)
   * @param num
   * @return
   */
  public String convertToBase7(int num) {
    if (num == 0) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    boolean isNegative = false;
    if (num < 0) {
      num = -num;
      isNegative = true;
    }
    while (num > 0) {
      sb.append(num % 7);
      num /= 7;
    }
    if (isNegative) {
      sb.append("-");
    }
    return sb.reverse().toString();
  }
  
  public String recursion(int n) {
    if (n < 0) {
      return "-" + recursion(-n);
    }
    if (n < 7) {
      return Integer.toString(n);
    }
    return recursion(n / 7) + Integer.toString(n % 7);
  }

}
