package com.code.threading;

public class _1_Runnable implements Runnable {

  public void run() {
    for (int i = 0; i < 3; i++) {
      System.out.println("Printing record: " + i);
    }
  }

  public static void main(String[] args) {
    new Thread(new _1_Runnable()).start();
  }

}
