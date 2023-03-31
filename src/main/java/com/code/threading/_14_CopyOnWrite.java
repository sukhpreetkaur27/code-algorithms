package com.code.threading;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class _14_CopyOnWrite {

  public static void main(String[] args) {
    List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
    for (Integer i : list) {
      System.out.print(i + ",");
      list.add(40);
    }
    System.out.println();
    System.out.println("size: " + list.size());

    Set<Integer> set = new CopyOnWriteArraySet<>(Arrays.asList(4, 3, 52));
    for (Integer i : set) {
      System.out.print(i + ",");
      set.add(40);
    }
    System.out.println();
    System.out.println("size: " + set.size());
  }

}
