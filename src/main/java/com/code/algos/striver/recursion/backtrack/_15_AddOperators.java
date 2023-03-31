package com.code.algos.striver.recursion.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators 
 * '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.

 

Example 1:

Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
Example 3:

Input: num = "3456237490", target = 9191
Output: []
Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
 

Constraints:

1 <= num.length <= 10
num consists of only digits.
-231 <= target <= 231 - 1
 * 
 * @author sukh
 *
 */
public class _15_AddOperators {

  private List<String> list;
  private char[] num;
  private int target;

  /**
   * Time: O(n * (3^n)) <br>
   * n = # of digits <br>
   * Space: O(n)
   * @param n
   * @param target
   * @return
   */
  public List<String> addOperators(String n, int target) {
    this.list = new ArrayList<>();
    this.num = n.toCharArray();
    this.target = target;

    backtrack(new StringBuilder(), 0, 0, 0);
    return list;
  }

  private void backtrack(StringBuilder temp, int index, long total, long prev) {
    if (index == num.length) {
      if (target == total) {
        list.add(temp.toString());
      }
      return;
    }

    long curr = 0;
    int len = temp.length();

    for (int i = index; i < num.length; i++) {

      /**
       * for strings with '0' like 505 <br>
       * when we run it for substrings starting with 0 <br>
       * we have to accept only one 0 only, if we accept multiple 0s, it will
       * accumulate the successive digits, like <br>
       * 
       * 1st loop: <br>
       * curr = 0 <br>
       * 
       * 2nd loop: <br>
       * curr = 5
       * 
       * 
       * eg: "505" , target = 10
       * 
       * output = "5 + 5"
       * 
       * it didn't pick the 0 in the operand due to above reason
       */
      if (i != index && num[index] == '0') {
        break;
      }

      curr = curr * 10 + num[i] - '0';

      if (index == 0) {
        /**
         * no operator call
         */
        /**
         * when beginning with num[0] <br>
         * don't append sign <br>
         * 
         * here, total = curr
         */
        temp.append(curr);
        backtrack(temp, i + 1, curr, curr);
        /**
         * this is equivalent to: temp.deleteCharAt(temp.length()-1);
         */
        temp.setLength(len);
      } else {
        /**
         * append sign for sub-strings
         */
        /**
         * for + operator, store the previous value as (curr) <br>
         * total = total + curr
         */
        temp.append("+");
        temp.append(curr);
        backtrack(temp, i + 1, total + curr, curr);
        temp.setLength(len);

        /**
         * for - operator, store the previous value as (-curr) <br>
         * total = total - curr
         */
        temp.append("-");
        temp.append(curr);
        backtrack(temp, i + 1, total - curr, -curr);
        temp.setLength(len);

        /**
         * for * operator, store the previous value as (prev * curr) <br>
         * 
         * for operator precedence <br>
         * remove the previous value from total and use it for the current
         * multiplication
         */
        temp.append("*");
        temp.append(curr);
        backtrack(temp, i + 1, total - prev + prev * curr, prev * curr);
        temp.setLength(len);
      }
    }
  }

}
