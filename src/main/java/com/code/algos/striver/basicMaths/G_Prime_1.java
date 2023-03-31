package com.code.algos.striver.basicMaths;

/**
 * Given a number, check whether it is prime or not. A prime number is a natural number that is only divisible by 1 and by itself.
 * 
 * Example 1:
Input: N = 3
Output: Prime
Explanation: 3 is a prime number

Example 2:
Input: N = 26
Output: Non-Prime
Explanation: 26 is not prime
 * 
 * @author sukh
 *
 */
public class G_Prime_1 {

  /**
   * Time: O(sqrt(n))<br>
   * Space: O(1)
   * @param n
   * @return
   */
  public boolean isPrime(int n) {
    for (int i = 2; i <= (int) Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

}
