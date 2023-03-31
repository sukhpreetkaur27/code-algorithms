package com.code.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class _9_ThreadPool {

  public static void main(String[] args) {
    System.out.println(Runtime.getRuntime().availableProcessors());

    ExecutorService service = Executors.newFixedThreadPool(3);
    ScheduledExecutorService s1 = Executors.newScheduledThreadPool(5);
  }

}
