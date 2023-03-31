package com.code.algos.striver.recursion;

import java.util.Stack;

/**
 * Given a stack, the task is to sort it such that the top of the stack has the greatest element.

Example 1:

Input:
Stack: 3 2 1
Output: 3 2 1
Example 2:

Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
Your Task: 
You don't have to read input or print anything. 
Your task is to complete the function sort() which sorts the elements present in the given stack. 
(The sorted stack is printed by the driver's code by popping the elements of the stack.)

Expected Time Complexity: O(N*N)
Expected Auxilliary Space: O(N) recursive.
 * 
 * @author sukh
 *
 */
public class _13_SortStack {

  /**
   * Time: O(n * n) <br>
   * Space: O(n)
   * @param stack
   * @return
   */
  public Stack<Integer> sort(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return stack;
    }
    Integer top = stack.pop();
    sort(stack);
    sort(stack, top);
    return stack;
  }

  private Stack<Integer> sort(Stack<Integer> stack, Integer element) {
    if (stack.isEmpty() || element > stack.peek()) {
      stack.push(element);
    } else {
      Integer top = stack.pop();
      sort(stack, element);
      stack.push(top);
    }
    return stack;
  }

}
