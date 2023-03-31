package com.code.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _4_ExecutorService {

  public static void main(String[] args) {
    ExecutorService service = null;
    try {
      service = Executors.newSingleThreadExecutor();

      System.out.println("begin");

      service.execute(() -> {
        System.out.println("Printing Hi 1");
      });

      service.execute(() -> {
        for (int i = 0; i < 3; i++) {
          System.out.println("Printing i: " + i);
        }
      });

      service.execute(() -> {
        System.out.println("Printing Hi 2");
      });

      System.out.println("end");
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }

}
