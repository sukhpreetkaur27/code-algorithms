package com.code.algos.striver.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given two strings s and t. Now your task is to print all longest common sub-sequences in lexicographical order.

Example 1:

Input: s = abaaa, t = baabaca
Output: aaaa abaa baaa
Example 2:

Input: s = aaa, t = a
Output: a
Your Task:
You do not need to read or print anything. Your task is to complete the function all_longest_common_subsequences() 
which takes string a and b as first and second parameter respectively and returns a list of strings which contains all possible longest common subsequences in lexicographical order.
 

Expected Time Complexity: O(n4)
Expected Space Complexity: O(K * n) where K is a constant less than n.
 

Constraints:
1 ≤ Length of both strings ≤ 50


 * 
 * @author sukh
 *
 */
public class _30_PrintLCS {
  
  /**
   * NOTE: this doen't print in lexicographical order
   **/

  /**
   * Time: O(n + m) + O(n + m) <br>
   * Space: O(n * m)
   * @param text1
   * @param text2
   * @return
   */
  public String one_longest_common_subsequence(String text1, String text2) {
    /**
     * NOTE: if only 1 LCS exist follow this function, else follow the brute force
     * 
     * Refer NOTES
     */
    /**
     * Tabulation
     */
    int l1 = text1.length();
    int l2 = text2.length();
    int[][] dp = new int[l1 + 1][l2 + 1];
    /**
     * Base Case
     * 
     * 1-based indexing
     */
    for (int i = 0; i <= l2; i++) {
      dp[0][i] = 0;
    }
    for (int i = 0; i <= l1; i++) {
      dp[i][0] = 0;
    }
    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();
    for (int index1 = 1; index1 <= l1; index1++) {
      for (int index2 = 1; index2 <= l2; index2++) {
        if (s1[index1 - 1] == s2[index2 - 1]) {
          dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
        } else {
          dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    int index1 = l1;
    int index2 = l2;
    /**
     * Time: O(n + m)
     */
    while (index1 > 0 && index2 > 0) {
      if (s1[index1 - 1] == s2[index2 - 1]) {
        sb.append(s1[index1 - 1]);
        index1 = index1 - 1;
        index2 = index2 - 1;
      } else if (dp[index1 - 1][index2] > dp[index1][index2 - 1]) {
        index1 = index1 - 1;
      } else {
        index2 = index2 - 1;
      }
    }
    return sb.toString();
  }

  public List<String> all_longest_common_subsequences(String text1, String text2) {
    /**
     * Tabulation
     */
    int l1 = text1.length();
    int l2 = text2.length();
    int[][] dp = new int[l1 + 1][l2 + 1];
    /**
     * Base Case
     * 
     * 1-based indexing
     */
    for (int i = 0; i <= l2; i++) {
      dp[0][i] = 0;
    }
    for (int i = 0; i <= l1; i++) {
      dp[i][0] = 0;
    }
    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();
    for (int index1 = 1; index1 <= l1; index1++) {
      for (int index2 = 1; index2 <= l2; index2++) {
        if (s1[index1 - 1] == s2[index2 - 1]) {
          dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
        } else {
          dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
        }
      }
    }
    Set<String> list = new HashSet<>();
    printAll(s1, s2, l1, l2, l1, l2, dp, new ArrayList<Character>(), list);
    return new ArrayList<>(list);
  }

  /**
   * Print all LCS using Top-Down approach
   * 
   * NOTE: This doesn't print in lexicographical order
   */
  private void printAll(char[] s1, char[] s2, int l1, int l2, int index1, int index2,
      int[][] dp, List<Character> temp, Set<String> list) {

    if (index1 == 0 || index2 == 0) {
      StringBuilder sb = new StringBuilder();
      for (int i = temp.size() - 1; i >= 0; i--) {
        sb.append(temp.get(i));
      }
      list.add(sb.toString());
      return;
    }

    if (s1[index1 - 1] == s2[index2 - 1]) {
      temp.add(s1[index1 - 1]);
      printAll(s1, s2, l1, l2, index1 - 1, index2 - 1, dp, temp, list);
      temp.remove(temp.size() - 1);
    } else {

      if (dp[index1 - 1][index2] > dp[index1][index2 - 1]) {
        printAll(s1, s2, l1, l2, index1 - 1, index2, dp, temp, list);
      } else if (dp[index1 - 1][index2] < dp[index1][index2 - 1]) {
        printAll(s1, s2, l1, l2, index1, index2 - 1, dp, temp, list);
      } else {
        printAll(s1, s2, l1, l2, index1 - 1, index2, dp, temp, list);
        printAll(s1, s2, l1, l2, index1, index2 - 1, dp, temp, list);
      }
    }
  }

}
