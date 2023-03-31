package com.code.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _14_Mapping {

  public static void main(String[] args) {
    /**
     * Returns: Collector
     */
    /**
     * mapping(Function f, Collector)
     * 
     * Collector minBy(Comparator) -> Optional<T>
     * 
     * Collector maxBy(Comparator) -> Optional<T>
     */
    Stream<String> s1 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy", "kp");
    Map<Integer, Optional<Character>> m1 = s1
        .collect(Collectors.groupingBy(String::length, Collectors
            .mapping(s -> s.charAt(0), Collectors.minBy(Comparator.naturalOrder()))));
    System.out.println(m1);

    Stream<String> s2 = Stream.of("sukh", "kp", "kanwar", "sp", "gavy", "kp");
    Map<Integer, List<Character>> m2 = s2.collect(Collectors.groupingBy(String::length,
        Collectors.mapping(s -> s.charAt(0), Collectors.toList())));
    System.out.println(m2);
  }

}
