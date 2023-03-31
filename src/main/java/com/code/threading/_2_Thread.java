package com.code.threading;

public class _2_Thread extends Thread {

  public void run() {
    System.out.println("hi _2_Thread");
  }

  public static void main(String[] args) {
    new _2_Thread().start();
  }

}
