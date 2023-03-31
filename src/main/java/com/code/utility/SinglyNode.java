package com.code.utility;

public class SinglyNode {

  public int val;
  public SinglyNode next;

  public SinglyNode() {

  }

  public SinglyNode(int val) {
    this.val = val;
  }

  public SinglyNode(SinglyNode next) {
    this.next = next;
  }

  public SinglyNode(int val, SinglyNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    return "SinglyNode [val=" + val + ", next=" + next + "]";
  }

}
