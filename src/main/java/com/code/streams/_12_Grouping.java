package com.code.streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _12_Grouping {

  public static void main(String[] args) {
    /**
     * Returns: Map<K, List<T>>
     */
    /**
     * groupingBy(Function f)
     */
    Stream<String> s1 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy");
    Map<Integer, List<String>> m1 = s1.collect(Collectors.groupingBy(String::length));
    System.out.println(m1);

    /**
     * groupingBy(Function f, Collector c)
     */
    Stream<String> s2 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy");
    Map<Integer, Set<String>> m2 = s2
        .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    System.out.println(m2);

    /**
     * groupingBy(Function f, Supplier s, Collector c)
     */
    Stream<String> s3 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy");
    Map<Integer, Set<String>> m3 = s3
        .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
    System.out.println(m3);

    /**
     * groupingBy(Function f, Supplier s, Collector c)
     */
    Stream<String> s4 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy");
    Map<Integer, List<String>> m4 = s4.collect(
        Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
    System.out.println(m4);
  }

}
