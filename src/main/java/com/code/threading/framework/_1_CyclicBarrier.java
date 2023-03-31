package com.code.threading.framework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _1_CyclicBarrier {

  /**
   *
   * Remove Remove Remove Remove Clean Clean Clean Clean Cleaned Add Add Add Add
   * 
   */

  public static void main(String[] args) {
    ExecutorService service = null;
    try {
      service = Executors.newFixedThreadPool(4);
      CyclicBarrier barrier1 = new CyclicBarrier(4);
      CyclicBarrier barrier2 = new CyclicBarrier(4, () -> System.out.println("Cleaned"));

      _1_CyclicBarrier obj = new _1_CyclicBarrier();

      for (int i = 0; i < 4; i++) {
        service.submit(() -> obj.perform(barrier1, barrier2));
      }
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }

  private void perform(CyclicBarrier barrier1, CyclicBarrier barrier2) {
    try {
      remove();
      barrier1.await();
      clean();
      barrier2.await();
      add();
    } catch (InterruptedException | BrokenBarrierException ex) {
      System.out.println("InterruptedException");
      System.out.println("BrokenBarrierException");
    }
  }

  private void remove() {
    System.out.println("Remove");
  }

  private void clean() {
    System.out.println("Clean");
  }

  private void add() {
    System.out.println("Add");
  }

}
