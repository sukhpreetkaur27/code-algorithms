package com.code.algos.striver.recursion;

/**
 * Given an integer K. Task is Print All binary string of size K (Given number).

Examples: 

Input : K = 3  
Output : 000 , 001 , 010 , 100 , 101 

Input : K  = 4 
Output :0000 0001 0010 0100 0101 1000 1001 1010
 * 
 * @author sukh
 *
 */
public class _15_BinaryStringGenerator {

  /**
   * Time: O(2^n) <br>
   * Space: O(n)
   * @param n
   */
  public void generate(int n) {
    char[] ch = new char[n];
    /**
     * Binary String starting with 0
     */
    ch[0] = '0';
    generate(ch, n, 1);
    /**
     * Binary String starting with 1
     */
    ch[0] = '1';
    generate(ch, n, 1);
  }

  private void generate(char[] ch, int n, int k) {
    if (n == k) {
      print(ch);
      return;
    }
    /**
     * if previous char is '0'
     */
    if (ch[k - 1] == '0') {
      ch[k] = '0';
      generate(ch, n, k + 1);
      ch[k] = '1';
      generate(ch, n, k + 1);
    } /**
       * if previous char is '1'
       */
    else {
      ch[k] = '0';
      generate(ch, n, k + 1);
    }
  }

  private void print(char[] ch) {
    String s = new String(ch);
    System.out.print(s);
    System.out.println();
  }

}
