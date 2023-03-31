package com.code.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class _2_Map {

  public static void main(String[] args) {
    Map<Integer, String> map = new HashMap<>();
    map.put(20, "Sukh");
    map.put(2, "KP");
    map.put(3, "Kanwar");
    for (Integer i : map.keySet()) {
      System.out.print(i);
    }
    System.out.println();

    Map<Integer, String> ordered = new LinkedHashMap<>();
    ordered.put(20, "Sukh");
    ordered.put(2, "KP");
    ordered.put(3, "Kanwar");
    for (Integer i : ordered.keySet()) {
      System.out.print(i);
    }
    System.out.println();

    Map<Integer, String> tree = new TreeMap<>();
    tree.put(20, "Sukh");
    tree.put(2, "KP");
    tree.put(3, "Kanwar");
    for (Integer i : tree.keySet()) {
      System.out.print(i);
    }
    System.out.println();
  }

}
