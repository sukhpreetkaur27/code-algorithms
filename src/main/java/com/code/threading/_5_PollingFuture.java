package com.code.threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class _5_PollingFuture {

  private static int counter = 0;

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService service = null;
    try {
      service = Executors.newSingleThreadExecutor();

      Future<?> result = service.submit(() -> {
        for (int i = 0; i < 500; i++) {
          _5_PollingFuture.counter++;
        }
      });

//      result.get(1, TimeUnit.NANOSECONDS);
      result.get(10, TimeUnit.SECONDS);
      System.out.println("Reached");
    } catch (TimeoutException e) {
      System.out.println("Not Reached in Time");
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }

}
