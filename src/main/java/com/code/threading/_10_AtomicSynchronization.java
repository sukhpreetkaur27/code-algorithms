package com.code.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class _10_AtomicSynchronization {

  private AtomicInteger count = new AtomicInteger(0);

  private synchronized void increment() {
    count.incrementAndGet();
    System.out.println(count.get());
  }

  public static void main(String[] args) {
    ExecutorService service = null;
    try {
      service = Executors.newFixedThreadPool(20);
      _10_AtomicSynchronization obj = new _10_AtomicSynchronization();
      for (int i = 0; i < 10; i++) {
        service.submit(() -> obj.increment());
      }
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }

}
