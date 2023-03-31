package com.code.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class _6_Pipeline {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");

    withoutStreams(list);

    withStreams(list);
  }

  private static void withoutStreams(List<String> list) {
    List<String> filtered = new ArrayList<>();
    for (String name : list) {
      if (name.length() == 4) {
        filtered.add(name);
      }
    }
    Collections.sort(filtered);
    Iterator<String> it = filtered.listIterator();
    if (it.hasNext()) {
      System.out.println(it.next());
    }
    if (it.hasNext()) {
      System.out.println(it.next());
    }
  }

  private static void withStreams(List<String> list) {
    list.stream().filter(s -> s.length() == 4).limit(2).sorted()
        .forEach(System.out::println);
  }

}
