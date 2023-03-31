package com.code.threading;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

public class _11_ConcurrentClass {

  public static void main(String[] args) {
    ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();
    map.put(1, "zebra");
    map.put(2, "elephant");
    System.out.println(map.get(2));

    Queue<Integer> queue = new ConcurrentLinkedQueue<>();
    queue.offer(31);
    System.out.println(queue.peek());
    System.out.println(queue.poll());

    Deque<Integer> deque = new ConcurrentLinkedDeque<>();
    deque.offer(22);
    deque.push(2);
    System.out.println(deque.peek());
    System.out.println(deque.poll());
  }

}
