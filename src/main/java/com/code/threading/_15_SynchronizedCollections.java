package com.code.threading;

import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;

public class _15_SynchronizedCollections {

  public static void main(String[] args) {
    List<Integer> list = Collections.synchronizedList(Arrays.asList(4, 5, 2));

    try {
      for (Integer i : list) {
        System.out.println(i);
      }
    } catch (ConcurrentModificationException e) {
      System.out.println("ConcurrentModificationException");
    }

    list = Collections.synchronizedList(Arrays.asList(4, 5, 2));
    synchronized (list) {
      try {
        for (Integer i : list) {
          System.out.println(i);
          list.remove(i);
        }
      } catch (ConcurrentModificationException e) {
        System.out.println("ConcurrentModificationException");
      }
    }
  }

}
