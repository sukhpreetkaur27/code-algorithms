package com.code.threading;

public class _3_Polling {

  private static int counter = 0;

  public static void main(String[] args) throws InterruptedException {
    new Thread(() -> {
      for (int i = 0; i < 500; i++) {
        _3_Polling.counter++;
      }
    }).start();

    while (_3_Polling.counter < 100) {
      System.out.println("Not Reached Yet!");
      Thread.sleep(1000); // 1000 milliseconds == 1 second
    }

    System.out.println("Reached");
  }

}
