package com.code.threading;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class _12_BlockingClass {

  public static void main(String[] args) throws InterruptedException {
    try {
      BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
      queue.offer(20, 2, TimeUnit.SECONDS);
      System.out.println(queue.poll());
      System.out.println(queue.poll(5, TimeUnit.MILLISECONDS));

      BlockingDeque<Integer> deque = new LinkedBlockingDeque<>();
      deque.offer(30);
      System.out.println(deque.offer(5, 2, TimeUnit.MINUTES));
      System.out.println(deque.offerFirst(47, 100, TimeUnit.MICROSECONDS));
      System.out.println(deque.offerLast(3, 4, TimeUnit.SECONDS));

      System.out.println(deque.poll());
      System.out.println(deque.poll(950, TimeUnit.MILLISECONDS));
      System.out.println(deque.pollFirst(200, TimeUnit.NANOSECONDS));
      System.out.println(deque.pollLast(1, TimeUnit.SECONDS));
    } catch (InterruptedException e) {
      throw e;
    }
  }

}
