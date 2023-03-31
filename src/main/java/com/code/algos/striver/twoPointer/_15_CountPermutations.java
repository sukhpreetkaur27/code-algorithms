package com.code.algos.striver.twoPointer;

/**
 * Count permutations of s1 in s2
 * 
 * @author sukh
 *
 */
public class _15_CountPermutations {

  /**
   * Time: O(l1 * l2 * 26) <br>
   * Space: O(1)
   * 
   * @param s1
   * @param s2
   * @return
   */
  public int count(String s1, String s2) {
    /**
     * Sliding Window
     * 
     * slide the string to be compared(shorter string) on to the larger string
     */
    int s1_length = s1.length();
    int s2_length = s2.length();
    if (s1_length > s2_length) {
      return 0;
    }
    int permutation_count = 0;
    int[] s1_count = new int[26];
    char[] s1_chars = s1.toCharArray();
    for (char ch : s1_chars) {
      s1_count[ch - 'a']++;
    }

    char[] s2_chars = s2.toCharArray();
    int[] s2_count = new int[26];

    int left = 0;
    int right = 0;
    char ch;
    while (right < s2_length) {
      ch = s2_chars[right];
      s2_count[ch - 'a']++;
      if (right - left + 1 == s1_length) {
        if (matches(s1_count, s2_count)) {
          permutation_count++;
        }
        ch = s2_chars[left];
        s2_count[ch - 'a']--;
        left++;
        right++;
        continue;
      }
      right++;
    }
    return permutation_count;
  }

  private boolean matches(int[] s1_count, int[] s2_count) {
    for (int freq = 0; freq < 26; freq++) {
      if (s1_count[freq] != s2_count[freq]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    _15_CountPermutations obj = new _15_CountPermutations();
    String s2 = "cbabcacabca";
    String s1 = "abc";
    int count = obj.count(s1, s2);
    System.out.println(count);
    /**
     * count = 6
     */
  }

}
