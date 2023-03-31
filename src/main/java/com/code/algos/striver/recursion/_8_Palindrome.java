package com.code.algos.striver.recursion;

public class _8_Palindrome {

  private int n;

  public boolean isPalindrom(String s) {
    n = s.length();
    return isPalindrome(s, 0);
  }

  private boolean isPalindrome(String s, int i) {
    if (i >= n / 2) {
      return true;
    }
    if (s.charAt(i) != s.charAt(n - i - 1)) {
      return false;
    }
    return isPalindrome(s, i + 1);
  }

}
