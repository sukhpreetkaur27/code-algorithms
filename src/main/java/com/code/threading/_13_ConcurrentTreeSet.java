package com.code.threading;

import java.util.NavigableSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class _13_ConcurrentTreeSet {

  public static void main(String[] args) {
    ConcurrentMap<Integer, String> map = new ConcurrentSkipListMap<>();
    map.put(20, "Sukh");
    map.put(30, "KP");

    NavigableSet<Integer> tree = new ConcurrentSkipListSet<>();
    tree.add(30);
    tree.add(40);
    System.out.println(tree.lower(30));
    System.out.println(tree.floor(30));
    System.out.println(tree.ceiling(30));
    System.out.println(tree.higher(30));
  }

}
