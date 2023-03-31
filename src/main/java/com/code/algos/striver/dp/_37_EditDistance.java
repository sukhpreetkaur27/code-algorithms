package com.code.algos.striver.dp;

import java.util.Arrays;

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
 * 
 * @author sukh
 *
 */
public class _37_EditDistance {

  /**
   * Time: exponential <br>
   * Space: O(n + m)
   * 
   * @param word1
   * @param word2
   * @return
   */
  public int minDistance_recursion(String word1, String word2) {
    /**
     * Recursion: TLE
     */
    char[] s1 = word1.toCharArray();
    char[] s2 = word2.toCharArray();
    int l1 = s1.length;
    int l2 = s2.length;
    return minDistance(s1, s2, l1 - 1, l2 - 1);
  }

  private int minDistance(char[] s1, char[] s2, int index1, int index2) {
    if (index2 < 0) {
      if (index1 >= 0) {
        return index1 + 1;
      }
      return 0;
    } else if (index1 < 0) {
      return index2 + 1;
    }

    /**
     * if match --> 0 operations to be performed --> jump to next character of both
     * the strings
     */
    if (s1[index1] == s2[index2]) {
      return 0 + minDistance(s1, s2, index1 - 1, index2 - 1);
    }
    /**
     * if mismatch, 3 cases:
     * 
     * 1. insert: insert(hypothetically) the s2[index2] character, move to the next
     * character s2[index2-1] --> compare with the current s1[index1]
     * 
     * 2. delete: delete(hypothetically) the s1[index1] character, move to the next
     * character s1[index1-1] --> compare with the current s2[index2]
     * 
     * 3. replace: replace(hypothetically) the s1[index1] character with the
     * s2[index2] character, move to the next character s1[index1-1] --> compare
     * with the next s2[index2-1]
     */
    int insert = 1 + minDistance(s1, s2, index1, index2 - 1);
    int delete = 1 + minDistance(s1, s2, index1 - 1, index2);
    int replace = 1 + minDistance(s1, s2, index1 - 1, index2 - 1);

    /**
     * return the minimum of insert, delete, replace operations
     */
    return Math.min(insert, Math.min(delete, replace));
  }

  /**
   * Time: O(n * m) <br>
   * Sapce: O(n + m) + O(n * m)
   * 
   * @param word1
   * @param word2
   * @return
   */
  public int minDistance_memoization(String word1, String word2) {
    /**
     * Memoization
     */
    char[] s1 = word1.toCharArray();
    char[] s2 = word2.toCharArray();
    int l1 = s1.length;
    int l2 = s2.length;
    int[][] dp = new int[l1][l2];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return minDistance_memoize(s1, s2, l1 - 1, l2 - 1, dp);
  }

  private int minDistance_memoize(char[] s1, char[] s2, int index1, int index2,
      int[][] dp) {
    if (index2 < 0) {
      if (index1 >= 0) {
        return index1 + 1;
      }
      return 0;
    } else if (index1 < 0) {
      return index2 + 1;
    }
    if (dp[index1][index2] != -1) {
      return dp[index1][index2];
    }
    if (s1[index1] == s2[index2]) {
      return 0 + minDistance_memoize(s1, s2, index1 - 1, index2 - 1, dp);
    }
    int insert = 1 + minDistance(s1, s2, index1, index2 - 1);
    int delete = 1 + minDistance(s1, s2, index1 - 1, index2);
    int replace = 1 + minDistance(s1, s2, index1 - 1, index2 - 1);

    return dp[index1][index2] = Math.min(insert, Math.min(delete, replace));
  }

  /**
   * Time: O(n * m) <br>
   * Sapce: O(n * m)
   * 
   * @param word1
   * @param word2
   * @return
   */
  public int minDistance_tabulation(String word1, String word2) {
    /**
     * Tabulation
     */
    char[] s1 = word1.toCharArray();
    char[] s2 = word2.toCharArray();
    int l1 = s1.length;
    int l2 = s2.length;
    int[][] dp = new int[l1 + 1][l2 + 1];
    for (int i = 1; i <= l1; i++) {
      dp[i][0] = i;
    }
    for (int i = 1; i <= l2; i++) {
      dp[0][i] = i;
    }
    for (int index1 = 1, insert = 0, delete = 0, replace = 0; index1 <= l1; index1++) {
      for (int index2 = 1; index2 <= l2; index2++) {
        if (s1[index1 - 1] == s2[index2 - 1]) {
          dp[index1][index2] = 0 + dp[index1 - 1][index2 - 1];
        } else {
          insert = 1 + dp[index1][index2 - 1];
          delete = 1 + dp[index1 - 1][index2];
          replace = 1 + dp[index1 - 1][index2 - 1];
          dp[index1][index2] = Math.min(insert, Math.min(delete, replace));
        }
      }
    }
    return dp[l1][l2];
  }

  /**
   * Time: O(n * m) <br>
   * Sapce: O(2m)
   * 
   * @param word1
   * @param word2
   * @return
   */
  public int minDistance_spaceOptimization(String word1, String word2) {
    /**
     * Space Optimization
     */
    char[] s1 = word1.toCharArray();
    char[] s2 = word2.toCharArray();
    int l1 = s1.length;
    int l2 = s2.length;
    int[] dp = new int[l2 + 1];
    int[] curr = new int[l2 + 1];
    for (int i = 1; i <= l2; i++) {
      dp[i] = i;
    }
    for (int index1 = 1, insert = 0, delete = 0, replace = 0; index1 <= l1; index1++) {
      curr[0] = index1;
      for (int index2 = 1; index2 <= l2; index2++) {
        if (s1[index1 - 1] == s2[index2 - 1]) {
          curr[index2] = 0 + dp[index2 - 1];
        } else {
          insert = 1 + curr[index2 - 1];
          delete = 1 + dp[index2];
          replace = 1 + dp[index2 - 1];
          curr[index2] = Math.min(insert, Math.min(delete, replace));
        }
      }
      for (int index2 = 0; index2 <= l2; index2++) {
        dp[index2] = curr[index2];
      }
    }
    return dp[l2];
  }

}
