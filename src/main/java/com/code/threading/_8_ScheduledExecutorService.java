package com.code.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class _8_ScheduledExecutorService {

  public static void main(String[] args) {
    ScheduledExecutorService service = null;
    try {
      service = Executors.newSingleThreadScheduledExecutor();

      Runnable run = () -> System.out.println("runnable task");

      Callable<Integer> call = () -> {
        System.out.println("callable task");
        return 30 + 1;
      };

      ScheduledFuture<?> runResult = service.schedule(run, 10, TimeUnit.SECONDS);

      ScheduledFuture<Integer> callResult = service.schedule(call, 0, TimeUnit.SECONDS);
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }

}
