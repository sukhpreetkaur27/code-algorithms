package com.code.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _7_AwaitTermination {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService service = null;
    try {
      service = Executors.newSingleThreadExecutor();

      service.submit(() -> {
        for (int i = 0; i < 10000; i++) {
          System.out.println(i);
        }
      });
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
    if (service != null) {
      System.out.println("before");
      service.awaitTermination(1, TimeUnit.NANOSECONDS);
      System.out.println("after");
      if (service.isTerminated()) {
        System.out.println("Terminated");
      } else {
        System.out.println("At least one task is still running");
      }
    }
  }

}
