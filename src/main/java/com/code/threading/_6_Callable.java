package com.code.threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class _6_Callable {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService service = null;
    try {
      service = Executors.newSingleThreadExecutor();
      Future<Integer> result = service.submit(() -> {
        return 30 + 11;
      });
      System.out.println(result.get());
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }

}
