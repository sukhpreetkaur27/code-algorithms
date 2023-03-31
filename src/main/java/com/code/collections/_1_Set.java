package com.code.collections;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class _1_Set {

  public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();
    set.add(66);
    set.add(10);
    set.add(66);
    set.add(8);

    for (Integer i : set) {
      System.out.println(i);
    }

    Set<Integer> tree = new TreeSet<>();
    tree.add(66);
    tree.add(10);
    tree.add(66);
    tree.add(8);

    for (Integer i : tree) {
      System.out.println(i);
    }

    NavigableSet<Integer> navigable = new TreeSet<>();
    for (int i = 1; i <= 20; i++) {
      navigable.add(i);
    }
    System.out.println(navigable.lower(10));
    System.out.println(navigable.floor(10));
    System.out.println(navigable.ceiling(20));
    System.out.println(navigable.higher(20));
  }

}
