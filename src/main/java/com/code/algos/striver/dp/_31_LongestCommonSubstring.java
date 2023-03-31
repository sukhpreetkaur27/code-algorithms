package com.code.algos.striver.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings. The task is to find the length of the longest common substring.


Example 1:

Input: S1 = "ABCDGH", S2 = "ACDGHR", n = 6, m = 6
Output: 4
Explanation: The longest common substring
is "CDGH" which has length 4.
Example 2:

Input: S1 = "ABC", S2 "ACB", n = 3, m = 3
Output: 1
Explanation: The longest common substrings
are "A", "B", "C" all having length 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestCommonSubstr() which takes the string S1, string S2 
and their length n and m as inputs and returns the length of the longest common substring in S1 and S2.


Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).


Constraints:
1<=n, m<=1000
 * 
 * @author sukh
 *
 */
public class _31_LongestCommonSubstring {

  /**
   * Time: O(n * m) <br>
   * Space: O(n * m)
   * 
   * @param str1
   * @param str2
   * @param n
   * @param m
   * @return
   */
  public int longestCommonSubstr_tabulation(String str1, String str2, int n, int m) {
    /**
     * Tabulation
     * 
     * Extension to com.code.algos.striver.dp._29_LCS
     * 
     * tabulation[i][j] = longest common substring length for string 1 [0,i] and
     * string 2 [0,j]
     * 
     * If match, +1 to the previous row and column [i-1,j-1]
     * 
     * For mismatch, put 0 as it as substring not subsequence so continuity matters
     * 
     * max of tabulation[][] = answer
     * 
     */
    int[][] dp = new int[n + 1][m + 1];
    char[] s1 = str1.toCharArray();
    char[] s2 = str2.toCharArray();
    int max = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s1[i - 1] == s2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          max = Math.max(max, dp[i][j]);
        }
      }
    }
    return max;
  }
  
  /**
   * Time: O(n * m) <br>
   * Space: O(2m)
   * 
   * @param str1
   * @param str2
   * @param n
   * @param m
   * @return
   */
  public int longestCommonSubstr_optimal(String str1, String str2, int n, int m) {
    /**
     * Space Optimization
     */
    int[] dp = new int[m + 1];
    int[] curr = new int[m + 1];
    char[] s1 = str1.toCharArray();
    char[] s2 = str2.toCharArray();
    int max = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s1[i - 1] == s2[j - 1]) {
          curr[j] = dp[j - 1] + 1;
          max = Math.max(max, curr[j]);
        } else {
          curr[j] = 0;
        }
      }
      for (int k = 1; k <= m; k++) {
        dp[k] = curr[k];
      }
    }
    return max;
  }

  /**
   * 
   * @param str1
   * @param str2
   * @param n
   * @param m
   * @return
   */
  public String printLongestCommonSubstr(String str1, String str2, int n, int m) {
    /**
     * NOTE: it prints only 1 longest common substring
     */
    int[][] dp = new int[n + 1][m + 1];
    char[] s1 = str1.toCharArray();
    char[] s2 = str2.toCharArray();
    int max = 0;
    int maxRow = 0;
    int maxCol = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s1[i - 1] == s2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          if (max < dp[i][j]) {
            max = dp[i][j];
            maxRow = i;
            maxCol = j;
          }
        }
      }
    }
    List<Character> list = new ArrayList<>();
    int i = maxRow;
    int j = maxCol;
    while (dp[i][j] > 0) {
      list.add(s1[j - 1]);
      i--;
      j--;
    }
    StringBuilder sb = new StringBuilder();
    for (int k = list.size() - 1; k >= 0; k--) {
      sb.append(list.get(k));
    }
    return sb.toString();
  }

}
