package com.code.algos.striver.recursion;

import java.util.Stack;

/**
 * You are given a stack St. You have to reverse the stack using recursion.

Example 1:

Input:
St = {3,2,1,7,6}
Output:
{6,7,1,2,3}
Example 2:

Input:
St = {4,3,9,6}
Output:
{6,9,3,4}
Your Task:

You don't need to read input or print anything. Your task is to complete the function Reverse() which takes the stack St as input and returns the reversed stack.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


 * 
 * @author sukh
 *
 */
public class _14_ReverseStack {

  /**
   * Tail Recursion
   */
  
  /**
   * Time: O(n * n) <br>
   * Space: O(n)
   * @param stack
   * @return
   */
  public Stack<Integer> reverse(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return stack;
    }
    Integer pop = stack.pop();
    reverse(stack);
    push(stack, pop);
    return stack;
  }

  private Stack<Integer> push(Stack<Integer> stack, Integer element) {
    if (stack.isEmpty()) {
      stack.push(element);
    } else {
      Integer pop = stack.pop();
      push(stack, element);
      stack.push(pop);
    }
    return stack;
  }

}
